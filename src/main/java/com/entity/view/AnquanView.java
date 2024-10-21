package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.AnquanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 安全
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("anquan")
public class AnquanView extends AnquanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 危险程度的值
	*/
	@ColumnInfo(comment="危险程度的字典表值",type="varchar(200)")
	private String anquanValue;

	//级联表 试剂
		/**
		* 试剂名称
		*/

		@ColumnInfo(comment="试剂名称",type="varchar(200)")
		private String shijiName;
		/**
		* 试剂编号
		*/

		@ColumnInfo(comment="试剂编号",type="varchar(200)")
		private String shijiUuidNumber;
		/**
		* 试剂照片
		*/

		@ColumnInfo(comment="试剂照片",type="varchar(200)")
		private String shijiPhoto;
		/**
		* 试剂规格
		*/

		@ColumnInfo(comment="试剂规格",type="varchar(200)")
		private String shijiGuige;
		/**
		* 生产厂家
		*/

		@ColumnInfo(comment="生产厂家",type="varchar(200)")
		private String shijiChangjia;
		/**
		* 生产批次
		*/

		@ColumnInfo(comment="生产批次",type="int(11)")
		private Integer shijiPici;
		/**
		* 生产日期
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
		@DateTimeFormat
		@ColumnInfo(comment="生产日期",type="date")
		private Date shijiTime;
		/**
		* 保质期/月
		*/

		@ColumnInfo(comment="保质期/月",type="int(11)")
		private Integer shijiBaozhi;
		/**
		* 试剂类型
		*/
		@ColumnInfo(comment="试剂类型",type="int(11)")
		private Integer shijiTypes;
			/**
			* 试剂类型的值
			*/
			@ColumnInfo(comment="试剂类型的字典表值",type="varchar(200)")
			private String shijiValue;
		/**
		* 试剂数量
		*/

		@ColumnInfo(comment="试剂数量",type="int(11)")
		private Integer shijiKucunNumber;
		/**
		* 试剂介绍
		*/

		@ColumnInfo(comment="试剂介绍",type="longtext")
		private String shijiContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer shijiDelete;



	public AnquanView() {

	}

	public AnquanView(AnquanEntity anquanEntity) {
		try {
			BeanUtils.copyProperties(this, anquanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 危险程度的值
	*/
	public String getAnquanValue() {
		return anquanValue;
	}
	/**
	* 设置： 危险程度的值
	*/
	public void setAnquanValue(String anquanValue) {
		this.anquanValue = anquanValue;
	}


	//级联表的get和set 试剂

		/**
		* 获取： 试剂名称
		*/
		public String getShijiName() {
			return shijiName;
		}
		/**
		* 设置： 试剂名称
		*/
		public void setShijiName(String shijiName) {
			this.shijiName = shijiName;
		}

		/**
		* 获取： 试剂编号
		*/
		public String getShijiUuidNumber() {
			return shijiUuidNumber;
		}
		/**
		* 设置： 试剂编号
		*/
		public void setShijiUuidNumber(String shijiUuidNumber) {
			this.shijiUuidNumber = shijiUuidNumber;
		}

		/**
		* 获取： 试剂照片
		*/
		public String getShijiPhoto() {
			return shijiPhoto;
		}
		/**
		* 设置： 试剂照片
		*/
		public void setShijiPhoto(String shijiPhoto) {
			this.shijiPhoto = shijiPhoto;
		}

		/**
		* 获取： 试剂规格
		*/
		public String getShijiGuige() {
			return shijiGuige;
		}
		/**
		* 设置： 试剂规格
		*/
		public void setShijiGuige(String shijiGuige) {
			this.shijiGuige = shijiGuige;
		}

		/**
		* 获取： 生产厂家
		*/
		public String getShijiChangjia() {
			return shijiChangjia;
		}
		/**
		* 设置： 生产厂家
		*/
		public void setShijiChangjia(String shijiChangjia) {
			this.shijiChangjia = shijiChangjia;
		}

		/**
		* 获取： 生产批次
		*/
		public Integer getShijiPici() {
			return shijiPici;
		}
		/**
		* 设置： 生产批次
		*/
		public void setShijiPici(Integer shijiPici) {
			this.shijiPici = shijiPici;
		}

		/**
		* 获取： 生产日期
		*/
		public Date getShijiTime() {
			return shijiTime;
		}
		/**
		* 设置： 生产日期
		*/
		public void setShijiTime(Date shijiTime) {
			this.shijiTime = shijiTime;
		}

		/**
		* 获取： 保质期/月
		*/
		public Integer getShijiBaozhi() {
			return shijiBaozhi;
		}
		/**
		* 设置： 保质期/月
		*/
		public void setShijiBaozhi(Integer shijiBaozhi) {
			this.shijiBaozhi = shijiBaozhi;
		}
		/**
		* 获取： 试剂类型
		*/
		public Integer getShijiTypes() {
			return shijiTypes;
		}
		/**
		* 设置： 试剂类型
		*/
		public void setShijiTypes(Integer shijiTypes) {
			this.shijiTypes = shijiTypes;
		}


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

		/**
		* 获取： 试剂数量
		*/
		public Integer getShijiKucunNumber() {
			return shijiKucunNumber;
		}
		/**
		* 设置： 试剂数量
		*/
		public void setShijiKucunNumber(Integer shijiKucunNumber) {
			this.shijiKucunNumber = shijiKucunNumber;
		}

		/**
		* 获取： 试剂介绍
		*/
		public String getShijiContent() {
			return shijiContent;
		}
		/**
		* 设置： 试剂介绍
		*/
		public void setShijiContent(String shijiContent) {
			this.shijiContent = shijiContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getShijiDelete() {
			return shijiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setShijiDelete(Integer shijiDelete) {
			this.shijiDelete = shijiDelete;
		}


	@Override
	public String toString() {
		return "AnquanView{" +
			", anquanValue=" + anquanValue +
			", shijiName=" + shijiName +
			", shijiUuidNumber=" + shijiUuidNumber +
			", shijiPhoto=" + shijiPhoto +
			", shijiGuige=" + shijiGuige +
			", shijiChangjia=" + shijiChangjia +
			", shijiPici=" + shijiPici +
			", shijiTime=" + DateUtil.convertString(shijiTime,"yyyy-MM-dd") +
			", shijiBaozhi=" + shijiBaozhi +
			", shijiKucunNumber=" + shijiKucunNumber +
			", shijiContent=" + shijiContent +
			", shijiDelete=" + shijiDelete +
			"} " + super.toString();
	}
}
