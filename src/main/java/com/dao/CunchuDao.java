package com.dao;

import com.entity.CunchuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.CunchuView;

/**
 * 存储 Dao 接口
 *
 * @author 
 */
public interface CunchuDao extends BaseMapper<CunchuEntity> {

   List<CunchuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
