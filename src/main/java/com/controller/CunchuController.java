
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
 * 存储
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/cunchu")
public class CunchuController {
    private static final Logger logger = LoggerFactory.getLogger(CunchuController.class);

    private static final String TABLE_NAME = "cunchu";

    @Autowired
    private CunchuService cunchuService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AnquanService anquanService;//安全
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
        params.put("cunchuDeleteStart",1);params.put("cunchuDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = cunchuService.queryPage(params);

        //字典表数据转换
        List<CunchuView> list =(List<CunchuView>)page.getList();
        for(CunchuView c:list){
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
        CunchuEntity cunchu = cunchuService.selectById(id);
        if(cunchu !=null){
            //entity转view
            CunchuView view = new CunchuView();
            BeanUtils.copyProperties( cunchu , view );//把实体数据重构到view中
            //级联表 试剂
            //级联表
            ShijiEntity shiji = shijiService.selectById(cunchu.getShijiId());
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
    public R save(@RequestBody CunchuEntity cunchu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,cunchu:{}",this.getClass().getName(),cunchu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<CunchuEntity> queryWrapper = new EntityWrapper<CunchuEntity>()
            .eq("shiji_id", cunchu.getShijiId())
            .eq("cunchu_address", cunchu.getCunchuAddress())
            .eq("cunchu_types", cunchu.getCunchuTypes())
            .eq("cunchu_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CunchuEntity cunchuEntity = cunchuService.selectOne(queryWrapper);
        if(cunchuEntity==null){
            cunchu.setCunchuDelete(1);
            cunchu.setInsertTime(new Date());
            cunchu.setCreateTime(new Date());
            cunchuService.insert(cunchu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CunchuEntity cunchu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,cunchu:{}",this.getClass().getName(),cunchu.toString());
        CunchuEntity oldCunchuEntity = cunchuService.selectById(cunchu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(cunchu.getCunchuPhoto()) || "null".equals(cunchu.getCunchuPhoto())){
                cunchu.setCunchuPhoto(null);
        }
        if("".equals(cunchu.getCunchuContent()) || "null".equals(cunchu.getCunchuContent())){
                cunchu.setCunchuContent(null);
        }

            cunchuService.updateById(cunchu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<CunchuEntity> oldCunchuList =cunchuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<CunchuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            CunchuEntity cunchuEntity = new CunchuEntity();
            cunchuEntity.setId(id);
            cunchuEntity.setCunchuDelete(2);
            list.add(cunchuEntity);
        }
        if(list != null && list.size() >0){
            cunchuService.updateBatchById(list);
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
            List<CunchuEntity> cunchuList = new ArrayList<>();//上传的东西
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
                            CunchuEntity cunchuEntity = new CunchuEntity();
//                            cunchuEntity.setShijiId(Integer.valueOf(data.get(0)));   //试剂 要改的
//                            cunchuEntity.setCunchuUuidNumber(data.get(0));                    //存储编号 要改的
//                            cunchuEntity.setCunchuPhoto("");//详情和图片
//                            cunchuEntity.setCunchuAddress(data.get(0));                    //存储地点 要改的
//                            cunchuEntity.setCunchuTypes(Integer.valueOf(data.get(0)));   //存储类型 要改的
//                            cunchuEntity.setCunchuContent("");//详情和图片
//                            cunchuEntity.setCunchuDelete(1);//逻辑删除字段
//                            cunchuEntity.setInsertTime(date);//时间
//                            cunchuEntity.setCreateTime(date);//时间
                            cunchuList.add(cunchuEntity);


                            //把要查询是否重复的字段放入map中
                                //存储编号
                                if(seachFields.containsKey("cunchuUuidNumber")){
                                    List<String> cunchuUuidNumber = seachFields.get("cunchuUuidNumber");
                                    cunchuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> cunchuUuidNumber = new ArrayList<>();
                                    cunchuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("cunchuUuidNumber",cunchuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //存储编号
                        List<CunchuEntity> cunchuEntities_cunchuUuidNumber = cunchuService.selectList(new EntityWrapper<CunchuEntity>().in("cunchu_uuid_number", seachFields.get("cunchuUuidNumber")).eq("cunchu_delete", 1));
                        if(cunchuEntities_cunchuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CunchuEntity s:cunchuEntities_cunchuUuidNumber){
                                repeatFields.add(s.getCunchuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [存储编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        cunchuService.insertBatch(cunchuList);
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

