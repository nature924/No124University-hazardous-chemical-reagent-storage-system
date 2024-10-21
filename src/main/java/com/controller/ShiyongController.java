
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
 * 使用记录
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shiyong")
public class ShiyongController {
    private static final Logger logger = LoggerFactory.getLogger(ShiyongController.class);

    private static final String TABLE_NAME = "shiyong";

    @Autowired
    private ShiyongService shiyongService;


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
    private ShijiChuruInoutService shijiChuruInoutService;//出入库
    @Autowired
    private ShijiChuruInoutListService shijiChuruInoutListService;//出入库详情
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
        params.put("shiyongDeleteStart",1);params.put("shiyongDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = shiyongService.queryPage(params);

        //字典表数据转换
        List<ShiyongView> list =(List<ShiyongView>)page.getList();
        for(ShiyongView c:list){
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
        ShiyongEntity shiyong = shiyongService.selectById(id);
        if(shiyong !=null){
            //entity转view
            ShiyongView view = new ShiyongView();
            BeanUtils.copyProperties( shiyong , view );//把实体数据重构到view中
            //级联表 试剂
            //级联表
            ShijiEntity shiji = shijiService.selectById(shiyong.getShijiId());
            if(shiji != null){
            BeanUtils.copyProperties( shiji , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setShijiId(shiji.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(shiyong.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody ShiyongEntity shiyong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shiyong:{}",this.getClass().getName(),shiyong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            shiyong.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ShiyongEntity> queryWrapper = new EntityWrapper<ShiyongEntity>()
            .eq("shiji_id", shiyong.getShijiId())
            .eq("yonghu_id", shiyong.getYonghuId())
            .eq("shiyong_name", shiyong.getShiyongName())
            .eq("shiyong_types", shiyong.getShiyongTypes())
            .eq("shiyong_shuliang", shiyong.getShiyongShuliang())
            .eq("shiyong_time", new SimpleDateFormat("yyyy-MM-dd").format(shiyong.getShiyongTime()))
            .in("shiyong_yesno_types", new Integer[]{1,2})
            .eq("shiyong_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShiyongEntity shiyongEntity = shiyongService.selectOne(queryWrapper);
        if(shiyongEntity==null){
            shiyong.setShiyongYesnoTypes(1);
            shiyong.setShiyongDelete(1);
            shiyong.setInsertTime(new Date());
            shiyong.setCreateTime(new Date());
            shiyongService.insert(shiyong);
            return R.ok();
        }else {
            if(shiyongEntity.getShiyongYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(shiyongEntity.getShiyongYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShiyongEntity shiyong, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shiyong:{}",this.getClass().getName(),shiyong.toString());
        ShiyongEntity oldShiyongEntity = shiyongService.selectById(shiyong.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            shiyong.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(shiyong.getShiyongPhoto()) || "null".equals(shiyong.getShiyongPhoto())){
                shiyong.setShiyongPhoto(null);
        }
        if("".equals(shiyong.getShiyongContent()) || "null".equals(shiyong.getShiyongContent())){
                shiyong.setShiyongContent(null);
        }
        if("".equals(shiyong.getShiyongYesnoText()) || "null".equals(shiyong.getShiyongYesnoText())){
                shiyong.setShiyongYesnoText(null);
        }

            shiyongService.updateById(shiyong);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody ShiyongEntity shiyongEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,shiyongEntity:{}",this.getClass().getName(),shiyongEntity.toString());

        ShiyongEntity oldShiyong = shiyongService.selectById(shiyongEntity.getId());//查询原先数据
        ShijiEntity shijiEntity = shijiService.selectById(oldShiyong.getShijiId());
        if(shiyongEntity.getShiyongYesnoTypes() == 2){//通过
            
            ShijiChuruInoutEntity<Object> objectShijiChuruInoutEntity = new ShijiChuruInoutEntity<>();
            objectShijiChuruInoutEntity.setShijiChuruInoutUuidNumber(String.valueOf(new Date().getTime()));
            objectShijiChuruInoutEntity.setShijiChuruInoutName(oldShiyong.getShiyongName());
            objectShijiChuruInoutEntity.setShijiChuruInoutTypes(1);
            objectShijiChuruInoutEntity.setShijiChuruInoutContent(oldShiyong.getShiyongContent());
            objectShijiChuruInoutEntity.setInsertTime(new Date());
            objectShijiChuruInoutEntity.setCreateTime(new Date());
            shijiChuruInoutService.insert(objectShijiChuruInoutEntity);
            ShijiChuruInoutListEntity shijiChuruInoutListEntity = new ShijiChuruInoutListEntity();
            shijiChuruInoutListEntity.setShijiChuruInoutId(objectShijiChuruInoutEntity.getId());
            shijiChuruInoutListEntity.setShijiId(shijiEntity.getId());
            shijiChuruInoutListEntity.setShijiChuruInoutListNumber(oldShiyong.getShiyongShuliang());
            shijiChuruInoutListEntity.setInsertTime(new Date());
            shijiChuruInoutListEntity.setCreateTime(new Date());
            shijiEntity.setShijiKucunNumber(shijiEntity.getShijiKucunNumber()-oldShiyong.getShiyongShuliang());
            shijiService.updateById(shijiEntity);
            shijiChuruInoutListService.insert(shijiChuruInoutListEntity);

//            shiyongEntity.setShiyongTypes();
        }else if(shiyongEntity.getShiyongYesnoTypes() == 3){//拒绝
//            shiyongEntity.setShiyongTypes();
        }
        shiyongEntity.setShiyongShenheTime(new Date());//审核时间
        shiyongService.updateById(shiyongEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShiyongEntity> oldShiyongList =shiyongService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ShiyongEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ShiyongEntity shiyongEntity = new ShiyongEntity();
            shiyongEntity.setId(id);
            shiyongEntity.setShiyongDelete(2);
            list.add(shiyongEntity);
        }
        if(list != null && list.size() >0){
            shiyongService.updateBatchById(list);
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
            List<ShiyongEntity> shiyongList = new ArrayList<>();//上传的东西
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
                            ShiyongEntity shiyongEntity = new ShiyongEntity();
//                            shiyongEntity.setShijiId(Integer.valueOf(data.get(0)));   //试剂 要改的
//                            shiyongEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            shiyongEntity.setShiyongName(data.get(0));                    //使用记录名称 要改的
//                            shiyongEntity.setShiyongUuidNumber(data.get(0));                    //使用记录编号 要改的
//                            shiyongEntity.setShiyongPhoto("");//详情和图片
//                            shiyongEntity.setShiyongTypes(Integer.valueOf(data.get(0)));   //使用记录类型 要改的
//                            shiyongEntity.setShiyongShuliang(Integer.valueOf(data.get(0)));   //使用数量 要改的
//                            shiyongEntity.setShiyongTime(sdf.parse(data.get(0)));          //使用时间 要改的
//                            shiyongEntity.setShiyongContent("");//详情和图片
//                            shiyongEntity.setShiyongYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            shiyongEntity.setShiyongYesnoText(data.get(0));                    //审核意见 要改的
//                            shiyongEntity.setShiyongShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            shiyongEntity.setShiyongDelete(1);//逻辑删除字段
//                            shiyongEntity.setInsertTime(date);//时间
//                            shiyongEntity.setCreateTime(date);//时间
                            shiyongList.add(shiyongEntity);


                            //把要查询是否重复的字段放入map中
                                //使用记录编号
                                if(seachFields.containsKey("shiyongUuidNumber")){
                                    List<String> shiyongUuidNumber = seachFields.get("shiyongUuidNumber");
                                    shiyongUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shiyongUuidNumber = new ArrayList<>();
                                    shiyongUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shiyongUuidNumber",shiyongUuidNumber);
                                }
                        }

                        //查询是否重复
                         //使用记录编号
                        List<ShiyongEntity> shiyongEntities_shiyongUuidNumber = shiyongService.selectList(new EntityWrapper<ShiyongEntity>().in("shiyong_uuid_number", seachFields.get("shiyongUuidNumber")).eq("shiyong_delete", 1));
                        if(shiyongEntities_shiyongUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShiyongEntity s:shiyongEntities_shiyongUuidNumber){
                                repeatFields.add(s.getShiyongUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [使用记录编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shiyongService.insertBatch(shiyongList);
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

