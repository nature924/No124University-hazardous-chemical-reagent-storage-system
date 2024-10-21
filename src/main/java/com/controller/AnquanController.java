
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 安全
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/anquan")
public class AnquanController {
    private static final Logger logger = LoggerFactory.getLogger(AnquanController.class);

    private static final String TABLE_NAME = "anquan";

    @Autowired
    private AnquanService anquanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private CunchuService cunchuService;//存储
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告资讯
    @Autowired
    private ShijiService shijiService;//试剂
    @Autowired
    private ShijiChuruInoutService shijiChuruInoutService;//出入库
    @Autowired
    private ShijiChuruInoutListService shijiChuruInoutListService;//出入库详情
    @Autowired
    private ShiyongService shiyongService;//使用记录
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("anquanDeleteStart",1);params.put("anquanDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = anquanService.queryPage(params);

        //字典表数据转换
        List<AnquanView> list =(List<AnquanView>)page.getList();
        for(AnquanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        AnquanEntity anquan = anquanService.selectById(id);
        if(anquan !=null){
            //entity转view
            AnquanView view = new AnquanView();
            BeanUtils.copyProperties( anquan , view );//把实体数据重构到view中
            //级联表 试剂
            //级联表
            ShijiEntity shiji = shijiService.selectById(anquan.getShijiId());
            if(shiji != null){
            BeanUtils.copyProperties( shiji , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setShijiId(shiji.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody AnquanEntity anquan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,anquan:{}",this.getClass().getName(),anquan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<AnquanEntity> queryWrapper = new EntityWrapper<AnquanEntity>()
            .eq("shiji_id", anquan.getShijiId())
            .eq("anquan_types", anquan.getAnquanTypes())
            .eq("anquan_kucun_number", anquan.getAnquanKucunNumber())
            .eq("anquan_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        AnquanEntity anquanEntity = anquanService.selectOne(queryWrapper);
        if(anquanEntity==null){
            anquan.setAnquanDelete(1);
            anquan.setInsertTime(new Date());
            anquan.setCreateTime(new Date());
            anquanService.insert(anquan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody AnquanEntity anquan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,anquan:{}",this.getClass().getName(),anquan.toString());
        AnquanEntity oldAnquanEntity = anquanService.selectById(anquan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(anquan.getAnquanPhoto()) || "null".equals(anquan.getAnquanPhoto())){
                anquan.setAnquanPhoto(null);
        }
        if("".equals(anquan.getAnquanContent()) || "null".equals(anquan.getAnquanContent())){
                anquan.setAnquanContent(null);
        }

            anquanService.updateById(anquan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<AnquanEntity> oldAnquanList =anquanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<AnquanEntity> list = new ArrayList<>();
        for(Integer id:ids){
            AnquanEntity anquanEntity = new AnquanEntity();
            anquanEntity.setId(id);
            anquanEntity.setAnquanDelete(2);
            list.add(anquanEntity);
        }
        if(list != null && list.size() >0){
            anquanService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<AnquanEntity> anquanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            AnquanEntity anquanEntity = new AnquanEntity();
//                            anquanEntity.setShijiId(Integer.valueOf(data.get(0)));   //试剂 要改的
//                            anquanEntity.setAnquanUuidNumber(data.get(0));                    //安全管理编号 要改的
//                            anquanEntity.setAnquanPhoto("");//详情和图片
//                            anquanEntity.setAnquanTypes(Integer.valueOf(data.get(0)));   //危险程度 要改的
//                            anquanEntity.setAnquanKucunNumber(Integer.valueOf(data.get(0)));   //安全管理库存 要改的
//                            anquanEntity.setAnquanContent("");//详情和图片
//                            anquanEntity.setAnquanDelete(1);//逻辑删除字段
//                            anquanEntity.setInsertTime(date);//时间
//                            anquanEntity.setCreateTime(date);//时间
                            anquanList.add(anquanEntity);


                            //把要查询是否重复的字段放入map中
                                //安全管理编号
                                if(seachFields.containsKey("anquanUuidNumber")){
                                    List<String> anquanUuidNumber = seachFields.get("anquanUuidNumber");
                                    anquanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> anquanUuidNumber = new ArrayList<>();
                                    anquanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("anquanUuidNumber",anquanUuidNumber);
                                }
                        }

                        //查询是否重复
                         //安全管理编号
                        List<AnquanEntity> anquanEntities_anquanUuidNumber = anquanService.selectList(new EntityWrapper<AnquanEntity>().in("anquan_uuid_number", seachFields.get("anquanUuidNumber")).eq("anquan_delete", 1));
                        if(anquanEntities_anquanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(AnquanEntity s:anquanEntities_anquanUuidNumber){
                                repeatFields.add(s.getAnquanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [安全管理编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        anquanService.insertBatch(anquanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




}

