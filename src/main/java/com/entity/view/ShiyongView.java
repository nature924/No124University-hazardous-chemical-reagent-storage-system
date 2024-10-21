package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShiyongEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 使用记录
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shiyong")
public class ShiyongView extends ShiyongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 使用记录类型的值
	*/
	@ColumnInfo(comment="使用记录类型的字典表值",type="varchar(200)")
	private String shiyongValue;
	/**
	* 申请状态的值
	*/
	@ColumnInfo(comment="申请状态的字典表值",type="varchar(200)")
	private String shiyongYesnoValue;

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
	//级联表 用户
		/**
		* 用户编号
		*/

		@ColumnInfo(comment="用户编号",type="varchar(200)")
		private String yonghuUuidNumber;
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;



	public ShiyongView() {

	}

	public ShiyongView(ShiyongEntity shiyongEntity) {
		try {
			BeanUtils.copyProperties(this, shiyongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 使用记录类型的值
	*/
	public String getShiyongValue() {
		return shiyongValue;
	}
	/**
	* 设置： 使用记录类型的值
	*/
	public void setShiyongValue(String shiyongValue) {
		this.shiyongValue = shiyongValue;
	}
	//当前表的
	/**
	* 获取： 申请状态的值
	*/
	public String getShiyongYesnoValue() {
		return shiyongYesnoValue;
	}
	/**
	* 设置： 申请状态的值
	*/
	public void setShiyongYesnoValue(String shiyongYesnoValue) {
		this.shiyongYesnoValue = shiyongYesnoValue;
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
	//级联表的get和set 用户

		/**
		* 获取： 用户编号
		*/
		public String getYonghuUuidNumber() {
			return yonghuUuidNumber;
		}
		/**
		* 设置： 用户编号
		*/
		public void setYonghuUuidNumber(String yonghuUuidNumber) {
			this.yonghuUuidNumber = yonghuUuidNumber;
		}

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "ShiyongView{" +
			", shiyongValue=" + shiyongValue +
			", shiyongYesnoValue=" + shiyongYesnoValue +
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
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
