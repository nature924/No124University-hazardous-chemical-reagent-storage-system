package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 试剂
 *
 * @author 
 * @email
 */
@TableName("shiji")
public class ShijiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShijiEntity() {

	}

	public ShijiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 试剂名称
     */
    @ColumnInfo(comment="试剂名称",type="varchar(200)")
    @TableField(value = "shiji_name")

    private String shijiName;


    /**
     * 试剂编号
     */
    @ColumnInfo(comment="试剂编号",type="varchar(200)")
    @TableField(value = "shiji_uuid_number")

    private String shijiUuidNumber;


    /**
     * 试剂照片
     */
    @ColumnInfo(comment="试剂照片",type="varchar(200)")
    @TableField(value = "shiji_photo")

    private String shijiPhoto;


    /**
     * 试剂规格
     */
    @ColumnInfo(comment="试剂规格",type="varchar(200)")
    @TableField(value = "shiji_guige")

    private String shijiGuige;


    /**
     * 生产厂家
     */
    @ColumnInfo(comment="生产厂家",type="varchar(200)")
    @TableField(value = "shiji_changjia")

    private String shijiChangjia;


    /**
     * 生产批次
     */
    @ColumnInfo(comment="生产批次",type="int(11)")
    @TableField(value = "shiji_pici")

    private Integer shijiPici;


    /**
     * 生产日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="生产日期",type="date")
    @TableField(value = "shiji_time")

    private Date shijiTime;


    /**
     * 保质期/月
     */
    @ColumnInfo(comment="保质期/月",type="int(11)")
    @TableField(value = "shiji_baozhi")

    private Integer shijiBaozhi;


    /**
     * 试剂类型
     */
    @ColumnInfo(comment="试剂类型",type="int(11)")
    @TableField(value = "shiji_types")

    private Integer shijiTypes;


    /**
     * 试剂数量
     */
    @ColumnInfo(comment="试剂数量",type="int(11)")
    @TableField(value = "shiji_kucun_number")

    private Integer shijiKucunNumber;


    /**
     * 试剂介绍
     */
    @ColumnInfo(comment="试剂介绍",type="longtext")
    @TableField(value = "shiji_content")

    private String shijiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "shiji_delete")

    private Integer shijiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：试剂名称
	 */
    public String getShijiName() {
        return shijiName;
    }
    /**
	 * 设置：试剂名称
	 */

    public void setShijiName(String shijiName) {
        this.shijiName = shijiName;
    }
    /**
	 * 获取：试剂编号
	 */
    public String getShijiUuidNumber() {
        return shijiUuidNumber;
    }
    /**
	 * 设置：试剂编号
	 */

    public void setShijiUuidNumber(String shijiUuidNumber) {
        this.shijiUuidNumber = shijiUuidNumber;
    }
    /**
	 * 获取：试剂照片
	 */
    public String getShijiPhoto() {
        return shijiPhoto;
    }
    /**
	 * 设置：试剂照片
	 */

    public void setShijiPhoto(String shijiPhoto) {
        this.shijiPhoto = shijiPhoto;
    }
    /**
	 * 获取：试剂规格
	 */
    public String getShijiGuige() {
        return shijiGuige;
    }
    /**
	 * 设置：试剂规格
	 */

    public void setShijiGuige(String shijiGuige) {
        this.shijiGuige = shijiGuige;
    }
    /**
	 * 获取：生产厂家
	 */
    public String getShijiChangjia() {
        return shijiChangjia;
    }
    /**
	 * 设置：生产厂家
	 */

    public void setShijiChangjia(String shijiChangjia) {
        this.shijiChangjia = shijiChangjia;
    }
    /**
	 * 获取：生产批次
	 */
    public Integer getShijiPici() {
        return shijiPici;
    }
    /**
	 * 设置：生产批次
	 */

    public void setShijiPici(Integer shijiPici) {
        this.shijiPici = shijiPici;
    }
    /**
	 * 获取：生产日期
	 */
    public Date getShijiTime() {
        return shijiTime;
    }
    /**
	 * 设置：生产日期
	 */

    public void setShijiTime(Date shijiTime) {
        this.shijiTime = shijiTime;
    }
    /**
	 * 获取：保质期/月
	 */
    public Integer getShijiBaozhi() {
        return shijiBaozhi;
    }
    /**
	 * 设置：保质期/月
	 */

    public void setShijiBaozhi(Integer shijiBaozhi) {
        this.shijiBaozhi = shijiBaozhi;
    }
    /**
	 * 获取：试剂类型
	 */
    public Integer getShijiTypes() {
        return shijiTypes;
    }
    /**
	 * 设置：试剂类型
	 */

    public void setShijiTypes(Integer shijiTypes) {
        this.shijiTypes = shijiTypes;
    }
    /**
	 * 获取：试剂数量
	 */
    public Integer getShijiKucunNumber() {
        return shijiKucunNumber;
    }
    /**
	 * 设置：试剂数量
	 */

    public void setShijiKucunNumber(Integer shijiKucunNumber) {
        this.shijiKucunNumber = shijiKucunNumber;
    }
    /**
	 * 获取：试剂介绍
	 */
    public String getShijiContent() {
        return shijiContent;
    }
    /**
	 * 设置：试剂介绍
	 */

    public void setShijiContent(String shijiContent) {
        this.shijiContent = shijiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getShijiDelete() {
        return shijiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setShijiDelete(Integer shijiDelete) {
        this.shijiDelete = shijiDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Shiji{" +
            ", id=" + id +
            ", shijiName=" + shijiName +
            ", shijiUuidNumber=" + shijiUuidNumber +
            ", shijiPhoto=" + shijiPhoto +
            ", shijiGuige=" + shijiGuige +
            ", shijiChangjia=" + shijiChangjia +
            ", shijiPici=" + shijiPici +
            ", shijiTime=" + DateUtil.convertString(shijiTime,"yyyy-MM-dd") +
            ", shijiBaozhi=" + shijiBaozhi +
            ", shijiTypes=" + shijiTypes +
            ", shijiKucunNumber=" + shijiKucunNumber +
            ", shijiContent=" + shijiContent +
            ", shijiDelete=" + shijiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
