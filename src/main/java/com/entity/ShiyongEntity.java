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
 * 使用记录
 *
 * @author 
 * @email
 */
@TableName("shiyong")
public class ShiyongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShiyongEntity() {

	}

	public ShiyongEntity(T t) {
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
     * 试剂
     */
    @ColumnInfo(comment="试剂",type="int(11)")
    @TableField(value = "shiji_id")

    private Integer shijiId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 使用记录名称
     */
    @ColumnInfo(comment="使用记录名称",type="varchar(200)")
    @TableField(value = "shiyong_name")

    private String shiyongName;


    /**
     * 使用记录编号
     */
    @ColumnInfo(comment="使用记录编号",type="varchar(200)")
    @TableField(value = "shiyong_uuid_number")

    private String shiyongUuidNumber;


    /**
     * 使用记录照片
     */
    @ColumnInfo(comment="使用记录照片",type="varchar(200)")
    @TableField(value = "shiyong_photo")

    private String shiyongPhoto;


    /**
     * 使用记录类型
     */
    @ColumnInfo(comment="使用记录类型",type="int(11)")
    @TableField(value = "shiyong_types")

    private Integer shiyongTypes;


    /**
     * 使用数量
     */
    @ColumnInfo(comment="使用数量",type="int(11)")
    @TableField(value = "shiyong_shuliang")

    private Integer shiyongShuliang;


    /**
     * 使用时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="使用时间",type="date")
    @TableField(value = "shiyong_time")

    private Date shiyongTime;


    /**
     * 用途
     */
    @ColumnInfo(comment="用途",type="longtext")
    @TableField(value = "shiyong_content")

    private String shiyongContent;


    /**
     * 申请状态
     */
    @ColumnInfo(comment="申请状态",type="int(11)")
    @TableField(value = "shiyong_yesno_types")

    private Integer shiyongYesnoTypes;


    /**
     * 审核意见
     */
    @ColumnInfo(comment="审核意见",type="longtext")
    @TableField(value = "shiyong_yesno_text")

    private String shiyongYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "shiyong_shenhe_time")

    private Date shiyongShenheTime;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "shiyong_delete")

    private Integer shiyongDelete;


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
	 * 获取：试剂
	 */
    public Integer getShijiId() {
        return shijiId;
    }
    /**
	 * 设置：试剂
	 */

    public void setShijiId(Integer shijiId) {
        this.shijiId = shijiId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：使用记录名称
	 */
    public String getShiyongName() {
        return shiyongName;
    }
    /**
	 * 设置：使用记录名称
	 */

    public void setShiyongName(String shiyongName) {
        this.shiyongName = shiyongName;
    }
    /**
	 * 获取：使用记录编号
	 */
    public String getShiyongUuidNumber() {
        return shiyongUuidNumber;
    }
    /**
	 * 设置：使用记录编号
	 */

    public void setShiyongUuidNumber(String shiyongUuidNumber) {
        this.shiyongUuidNumber = shiyongUuidNumber;
    }
    /**
	 * 获取：使用记录照片
	 */
    public String getShiyongPhoto() {
        return shiyongPhoto;
    }
    /**
	 * 设置：使用记录照片
	 */

    public void setShiyongPhoto(String shiyongPhoto) {
        this.shiyongPhoto = shiyongPhoto;
    }
    /**
	 * 获取：使用记录类型
	 */
    public Integer getShiyongTypes() {
        return shiyongTypes;
    }
    /**
	 * 设置：使用记录类型
	 */

    public void setShiyongTypes(Integer shiyongTypes) {
        this.shiyongTypes = shiyongTypes;
    }
    /**
	 * 获取：使用数量
	 */
    public Integer getShiyongShuliang() {
        return shiyongShuliang;
    }
    /**
	 * 设置：使用数量
	 */

    public void setShiyongShuliang(Integer shiyongShuliang) {
        this.shiyongShuliang = shiyongShuliang;
    }
    /**
	 * 获取：使用时间
	 */
    public Date getShiyongTime() {
        return shiyongTime;
    }
    /**
	 * 设置：使用时间
	 */

    public void setShiyongTime(Date shiyongTime) {
        this.shiyongTime = shiyongTime;
    }
    /**
	 * 获取：用途
	 */
    public String getShiyongContent() {
        return shiyongContent;
    }
    /**
	 * 设置：用途
	 */

    public void setShiyongContent(String shiyongContent) {
        this.shiyongContent = shiyongContent;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getShiyongYesnoTypes() {
        return shiyongYesnoTypes;
    }
    /**
	 * 设置：申请状态
	 */

    public void setShiyongYesnoTypes(Integer shiyongYesnoTypes) {
        this.shiyongYesnoTypes = shiyongYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getShiyongYesnoText() {
        return shiyongYesnoText;
    }
    /**
	 * 设置：审核意见
	 */

    public void setShiyongYesnoText(String shiyongYesnoText) {
        this.shiyongYesnoText = shiyongYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getShiyongShenheTime() {
        return shiyongShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setShiyongShenheTime(Date shiyongShenheTime) {
        this.shiyongShenheTime = shiyongShenheTime;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getShiyongDelete() {
        return shiyongDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setShiyongDelete(Integer shiyongDelete) {
        this.shiyongDelete = shiyongDelete;
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
        return "Shiyong{" +
            ", id=" + id +
            ", shijiId=" + shijiId +
            ", yonghuId=" + yonghuId +
            ", shiyongName=" + shiyongName +
            ", shiyongUuidNumber=" + shiyongUuidNumber +
            ", shiyongPhoto=" + shiyongPhoto +
            ", shiyongTypes=" + shiyongTypes +
            ", shiyongShuliang=" + shiyongShuliang +
            ", shiyongTime=" + DateUtil.convertString(shiyongTime,"yyyy-MM-dd") +
            ", shiyongContent=" + shiyongContent +
            ", shiyongYesnoTypes=" + shiyongYesnoTypes +
            ", shiyongYesnoText=" + shiyongYesnoText +
            ", shiyongShenheTime=" + DateUtil.convertString(shiyongShenheTime,"yyyy-MM-dd") +
            ", shiyongDelete=" + shiyongDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
