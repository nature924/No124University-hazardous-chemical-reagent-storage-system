package com.dao;

import com.entity.AnquanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.AnquanView;

/**
 * 安全 Dao 接口
 *
 * @author 
 */
public interface AnquanDao extends BaseMapper<AnquanEntity> {

   List<AnquanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
