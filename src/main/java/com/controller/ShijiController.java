
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
 * 试剂
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shiji")
public class ShijiController {
    private static final Logger logger = LoggerFactory.getLogger(ShijiController.class);

    private static final String TABLE_NAME = "shiji";

    @Autowired
    private ShijiService shijiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AnquanService anquanService;//安全
    @Autowired
    private CunchuService cunchuService;//存储
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告资讯
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
        params.put("shijiDeleteStart",1);params.put("shijiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = shijiService.queryPage(params);

        //字典表数据转换
        List<ShijiView> list =(List<ShijiView>)page.getList();
        for(ShijiView c:list){
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
        ShijiEntity shiji = shijiService.selectById(id);
        if(shiji !=null){
            //entity转view
            ShijiView view = new ShijiView();
            BeanUtils.copyProperties( shiji , view );//把实体数据重构到view中
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
    public R save(@RequestBody ShijiEntity shiji, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shiji:{}",this.getClass().getName(),shiji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ShijiEntity> queryWrapper = new EntityWrapper<ShijiEntity>()
            .eq("shiji_name", shiji.getShijiName())
            .eq("shiji_guige", shiji.getShijiGuige())
            .eq("shiji_changjia", shiji.getShijiChangjia())
            .eq("shiji_pici", shiji.getShijiPici())
            .eq("shiji_time", new SimpleDateFormat("yyyy-MM-dd").format(shiji.getShijiTime()))
            .eq("shiji_baozhi", shiji.getShijiBaozhi())
            .eq("shiji_types", shiji.getShijiTypes())
            .eq("shiji_kucun_number", shiji.getShijiKucunNumber())
            .eq("shiji_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShijiEntity shijiEntity = shijiService.selectOne(queryWrapper);
        if(shijiEntity==null){
            shiji.setShijiDelete(1);
            shiji.setInsertTime(new Date());
            shiji.setCreateTime(new Date());
            shijiService.insert(shiji);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShijiEntity shiji, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shiji:{}",this.getClass().getName(),shiji.toString());
        ShijiEntity oldShijiEntity = shijiService.selectById(shiji.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(shiji.getShijiPhoto()) || "null".equals(shiji.getShijiPhoto())){
                shiji.setShijiPhoto(null);
        }
        if("".equals(shiji.getShijiContent()) || "null".equals(shiji.getShijiContent())){
                shiji.setShijiContent(null);
        }

            shijiService.updateById(shiji);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShijiEntity> oldShijiList =shijiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ShijiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ShijiEntity shijiEntity = new ShijiEntity();
            shijiEntity.setId(id);
            shijiEntity.setShijiDelete(2);
            list.add(shijiEntity);
        }
        if(list != null && list.size() >0){
            shijiService.updateBatchById(list);
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
            List<ShijiEntity> shijiList = new ArrayList<>();//上传的东西
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
                            ShijiEntity shijiEntity = new ShijiEntity();
//                            shijiEntity.setShijiName(data.get(0));                    //试剂名称 要改的
//                            shijiEntity.setShijiUuidNumber(data.get(0));                    //试剂编号 要改的
//                            shijiEntity.setShijiPhoto("");//详情和图片
//                            shijiEntity.setShijiGuige(data.get(0));                    //试剂规格 要改的
//                            shijiEntity.setShijiChangjia(data.get(0));                    //生产厂家 要改的
//                            shijiEntity.setShijiPici(Integer.valueOf(data.get(0)));   //生产批次 要改的
//                            shijiEntity.setShijiTime(sdf.parse(data.get(0)));          //生产日期 要改的
//                            shijiEntity.setShijiBaozhi(Integer.valueOf(data.get(0)));   //保质期/月 要改的
//                            shijiEntity.setShijiTypes(Integer.valueOf(data.get(0)));   //试剂类型 要改的
//                            shijiEntity.setShijiKucunNumber(Integer.valueOf(data.get(0)));   //试剂数量 要改的
//                            shijiEntity.setShijiContent("");//详情和图片
//                            shijiEntity.setShijiDelete(1);//逻辑删除字段
//                            shijiEntity.setInsertTime(date);//时间
//                            shijiEntity.setCreateTime(date);//时间
                            shijiList.add(shijiEntity);


                            //把要查询是否重复的字段放入map中
                                //试剂编号
                                if(seachFields.containsKey("shijiUuidNumber")){
                                    List<String> shijiUuidNumber = seachFields.get("shijiUuidNumber");
                                    shijiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shijiUuidNumber = new ArrayList<>();
                                    shijiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shijiUuidNumber",shijiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //试剂编号
                        List<ShijiEntity> shijiEntities_shijiUuidNumber = shijiService.selectList(new EntityWrapper<ShijiEntity>().in("shiji_uuid_number", seachFields.get("shijiUuidNumber")).eq("shiji_delete", 1));
                        if(shijiEntities_shijiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShijiEntity s:shijiEntities_shijiUuidNumber){
                                repeatFields.add(s.getShijiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [试剂编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shijiService.insertBatch(shijiList);
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

