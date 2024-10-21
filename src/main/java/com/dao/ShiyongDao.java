package com.dao;

import com.entity.ShiyongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShiyongView;

/**
 * 使用记录 Dao 接口
 *
 * @author 
 */
public interface ShiyongDao extends BaseMapper<ShiyongEntity> {

   List<ShiyongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
