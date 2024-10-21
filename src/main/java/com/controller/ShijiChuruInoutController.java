
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
 * 出入库
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shijiChuruInout")
public class ShijiChuruInoutController {
    private static final Logger logger = LoggerFactory.getLogger(ShijiChuruInoutController.class);

    private static final String TABLE_NAME = "shijiChuruInout";

    @Autowired
    private ShijiChuruInoutService shijiChuruInoutService;


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
    private ShijiService shijiService;//试剂
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
        CommonUtil.checkMap(params);
        PageUtils page = shijiChuruInoutService.queryPage(params);

        //字典表数据转换
        List<ShijiChuruInoutView> list =(List<ShijiChuruInoutView>)page.getList();
        for(ShijiChuruInoutView c:list){
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
        ShijiChuruInoutEntity shijiChuruInout = shijiChuruInoutService.selectById(id);
        if(shijiChuruInout !=null){
            //entity转view
            ShijiChuruInoutView view = new ShijiChuruInoutView();
            BeanUtils.copyProperties( shijiChuruInout , view );//把实体数据重构到view中
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
    public R save(@RequestBody ShijiChuruInoutEntity shijiChuruInout, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shijiChuruInout:{}",this.getClass().getName(),shijiChuruInout.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ShijiChuruInoutEntity> queryWrapper = new EntityWrapper<ShijiChuruInoutEntity>()
            .eq("shiji_churu_inout_name", shijiChuruInout.getShijiChuruInoutName())
            .eq("shiji_churu_inout_types", shijiChuruInout.getShijiChuruInoutTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShijiChuruInoutEntity shijiChuruInoutEntity = shijiChuruInoutService.selectOne(queryWrapper);
        if(shijiChuruInoutEntity==null){
            shijiChuruInout.setInsertTime(new Date());
            shijiChuruInout.setCreateTime(new Date());
            shijiChuruInoutService.insert(shijiChuruInout);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShijiChuruInoutEntity shijiChuruInout, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shijiChuruInout:{}",this.getClass().getName(),shijiChuruInout.toString());
        ShijiChuruInoutEntity oldShijiChuruInoutEntity = shijiChuruInoutService.selectById(shijiChuruInout.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(shijiChuruInout.getShijiChuruInoutContent()) || "null".equals(shijiChuruInout.getShijiChuruInoutContent())){
                shijiChuruInout.setShijiChuruInoutContent(null);
        }

            shijiChuruInoutService.updateById(shijiChuruInout);//根据id更新
            return R.ok();
    }


    /**
    * 出库
    */
    @RequestMapping("/outShijiChuruInoutList")
    public R outShijiChuruInoutList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("outShijiChuruInoutList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        String role = String.valueOf(request.getSession().getAttribute("role"));

        //取出入库名称并判断是否存在
        String shijiChuruInoutName = String.valueOf(params.get("shijiChuruInoutName"));
        Wrapper<ShijiChuruInoutEntity> queryWrapper = new EntityWrapper<ShijiChuruInoutEntity>()
            .eq("shiji_churu_inout_name", shijiChuruInoutName)
            ;
        ShijiChuruInoutEntity shijiChuruInoutSelectOne = shijiChuruInoutService.selectOne(queryWrapper);
        if(shijiChuruInoutSelectOne != null)
            return R.error(511,"出入库名称已被使用");



        Map<String, Integer> map = (Map<String, Integer>) params.get("map");
        if(map == null || map.size() == 0)
            return R.error(511,"列表内容不能为空");


        Set<String> ids = map.keySet();

        List<ShijiEntity> shijiList = shijiService.selectBatchIds(ids);
        if(shijiList == null || shijiList.size() == 0){
            return R.error(511,"查数据库查不到数据");
        }else{
            for(ShijiEntity w:shijiList){
                Integer value = w.getShijiKucunNumber()-map.get(String.valueOf(w.getId()));
                if(value <0){
                    return R.error(511,"出库数量大于库存数量");
                }
                w.setShijiKucunNumber(value);
            }
        }

        //当前表
        ShijiChuruInoutEntity shijiChuruInoutEntity = new ShijiChuruInoutEntity<>();
            shijiChuruInoutEntity.setShijiChuruInoutUuidNumber(String.valueOf(new Date().getTime()));
            shijiChuruInoutEntity.setShijiChuruInoutName(shijiChuruInoutName);
            shijiChuruInoutEntity.setShijiChuruInoutTypes(1);
            shijiChuruInoutEntity.setShijiChuruInoutContent("");
            shijiChuruInoutEntity.setInsertTime(new Date());
            shijiChuruInoutEntity.setCreateTime(new Date());

        boolean insertShijiChuruInout = shijiChuruInoutService.insert(shijiChuruInoutEntity);
        //list表
        ArrayList<ShijiChuruInoutListEntity> shijiChuruInoutLists = new ArrayList<>();
        if(insertShijiChuruInout){
            for(String id:ids){
                ShijiChuruInoutListEntity shijiChuruInoutListEntity = new ShijiChuruInoutListEntity();
                    shijiChuruInoutListEntity.setShijiChuruInoutId(shijiChuruInoutEntity.getId());
                    shijiChuruInoutListEntity.setShijiId(Integer.valueOf(id));
                    shijiChuruInoutListEntity.setShijiChuruInoutListNumber(map.get(id));
                    shijiChuruInoutListEntity.setInsertTime(new Date());
                    shijiChuruInoutListEntity.setCreateTime(new Date());
                shijiChuruInoutLists.add(shijiChuruInoutListEntity);
                shijiService.updateBatchById(shijiList);
            }
            shijiChuruInoutListService.insertBatch(shijiChuruInoutLists);
        }

        return R.ok();
    }

    /**
    *入库
    */
    @RequestMapping("/inShijiChuruInoutList")
    public R inShijiChuruInoutList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("inShijiChuruInoutList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        //params:{"map":{"1":2,"2":3},"wuziOutinName":"订单1"}

        String role = String.valueOf(request.getSession().getAttribute("role"));

        //取当前表名称并判断
        String shijiChuruInoutName = String.valueOf(params.get("shijiChuruInoutName"));
        Wrapper<ShijiChuruInoutEntity> queryWrapper = new EntityWrapper<ShijiChuruInoutEntity>()
            .eq("shiji_churu_inout_name", shijiChuruInoutName)
            ;
        ShijiChuruInoutEntity shijiChuruInoutSelectOne = shijiChuruInoutService.selectOne(queryWrapper);
        if(shijiChuruInoutSelectOne != null)
            return R.error(511,"出入库名称已被使用");


        Map<String, Integer> map = (Map<String, Integer>) params.get("map");
        if(map == null || map.size() == 0)
            return R.error(511,"列表内容不能为空");

        Set<String> ids = map.keySet();

        List<ShijiEntity> shijiList = shijiService.selectBatchIds(ids);
        if(shijiList == null || shijiList.size() == 0){
            return R.error(511,"查数据库查不到数据");
        }else{
            for(ShijiEntity w:shijiList){
                w.setShijiKucunNumber(w.getShijiKucunNumber()+map.get(String.valueOf(w.getId())));
            }
        }

        //当前表
        ShijiChuruInoutEntity shijiChuruInoutEntity = new ShijiChuruInoutEntity<>();
            shijiChuruInoutEntity.setShijiChuruInoutUuidNumber(String.valueOf(new Date().getTime()));
            shijiChuruInoutEntity.setShijiChuruInoutName(shijiChuruInoutName);
            shijiChuruInoutEntity.setShijiChuruInoutTypes(2);
            shijiChuruInoutEntity.setShijiChuruInoutContent("");
            shijiChuruInoutEntity.setInsertTime(new Date());
            shijiChuruInoutEntity.setCreateTime(new Date());


        boolean insertShijiChuruInout = shijiChuruInoutService.insert(shijiChuruInoutEntity);
        //list表
        ArrayList<ShijiChuruInoutListEntity> shijiChuruInoutLists = new ArrayList<>();
        if(insertShijiChuruInout){
            for(String id:ids){
                ShijiChuruInoutListEntity shijiChuruInoutListEntity = new ShijiChuruInoutListEntity();
                shijiChuruInoutListEntity.setShijiChuruInoutId(shijiChuruInoutEntity.getId());
                shijiChuruInoutListEntity.setShijiId(Integer.valueOf(id));
                shijiChuruInoutListEntity.setShijiChuruInoutListNumber(map.get(id));
                shijiChuruInoutListEntity.setInsertTime(new Date());
                shijiChuruInoutListEntity.setCreateTime(new Date());
                shijiChuruInoutLists.add(shijiChuruInoutListEntity);
                shijiService.updateBatchById(shijiList);
            }
            shijiChuruInoutListService.insertBatch(shijiChuruInoutLists);
        }

        return R.ok();
    }
    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShijiChuruInoutEntity> oldShijiChuruInoutList =shijiChuruInoutService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        shijiChuruInoutService.deleteBatchIds(Arrays.asList(ids));
        shijiChuruInoutListService.delete(new EntityWrapper<ShijiChuruInoutListEntity>().in("shiji_churu_inout_id",ids));

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
            List<ShijiChuruInoutEntity> shijiChuruInoutList = new ArrayList<>();//上传的东西
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
                            ShijiChuruInoutEntity shijiChuruInoutEntity = new ShijiChuruInoutEntity();
//                            shijiChuruInoutEntity.setShijiChuruInoutUuidNumber(data.get(0));                    //出入库流水号 要改的
//                            shijiChuruInoutEntity.setShijiChuruInoutName(data.get(0));                    //出入库名称 要改的
//                            shijiChuruInoutEntity.setShijiChuruInoutTypes(Integer.valueOf(data.get(0)));   //出入库类型 要改的
//                            shijiChuruInoutEntity.setShijiChuruInoutContent("");//详情和图片
//                            shijiChuruInoutEntity.setInsertTime(date);//时间
//                            shijiChuruInoutEntity.setCreateTime(date);//时间
                            shijiChuruInoutList.add(shijiChuruInoutEntity);


                            //把要查询是否重复的字段放入map中
                                //出入库流水号
                                if(seachFields.containsKey("shijiChuruInoutUuidNumber")){
                                    List<String> shijiChuruInoutUuidNumber = seachFields.get("shijiChuruInoutUuidNumber");
                                    shijiChuruInoutUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shijiChuruInoutUuidNumber = new ArrayList<>();
                                    shijiChuruInoutUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shijiChuruInoutUuidNumber",shijiChuruInoutUuidNumber);
                                }
                        }

                        //查询是否重复
                         //出入库流水号
                        List<ShijiChuruInoutEntity> shijiChuruInoutEntities_shijiChuruInoutUuidNumber = shijiChuruInoutService.selectList(new EntityWrapper<ShijiChuruInoutEntity>().in("shiji_churu_inout_uuid_number", seachFields.get("shijiChuruInoutUuidNumber")));
                        if(shijiChuruInoutEntities_shijiChuruInoutUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShijiChuruInoutEntity s:shijiChuruInoutEntities_shijiChuruInoutUuidNumber){
                                repeatFields.add(s.getShijiChuruInoutUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [出入库流水号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shijiChuruInoutService.insertBatch(shijiChuruInoutList);
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

