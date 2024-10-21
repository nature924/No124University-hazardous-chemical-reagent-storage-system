package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShijiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 试剂
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shiji")
public class ShijiView extends ShijiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 试剂类型的值
	*/
	@ColumnInfo(comment="试剂类型的字典表值",type="varchar(200)")
	private String shijiValue;




	public ShijiView() {

	}

	public ShijiView(ShijiEntity shijiEntity) {
		try {
			BeanUtils.copyProperties(this, shijiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 试剂类型的值
	*/
	public String getShijiValue() {
		return shijiValue;
	}
	/**
	* 设置： 试剂类型的值
	*/
	public void setShijiValue(String shijiValue) {
		this.shijiValue = shijiValue;
	}




	@Override
	public String toString() {
		return "ShijiView{" +
			", shijiValue=" + shijiValue +
			"} " + super.toString();
	}
}
