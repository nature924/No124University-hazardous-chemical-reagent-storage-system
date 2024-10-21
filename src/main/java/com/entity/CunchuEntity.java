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
 * 存储
 *
 * @author 
 * @email
 */
@TableName("cunchu")
public class CunchuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CunchuEntity() {

	}

	public CunchuEntity(T t) {
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
     * 存储编号
     */
    @ColumnInfo(comment="存储编号",type="varchar(200)")
    @TableField(value = "cunchu_uuid_number")

    private String cunchuUuidNumber;


    /**
     * 存储照片
     */
    @ColumnInfo(comment="存储照片",type="varchar(200)")
    @TableField(value = "cunchu_photo")

    private String cunchuPhoto;


    /**
     * 存储地点
     */
    @ColumnInfo(comment="存储地点",type="varchar(200)")
    @TableField(value = "cunchu_address")

    private String cunchuAddress;


    /**
     * 存储类型
     */
    @ColumnInfo(comment="存储类型",type="int(11)")
    @TableField(value = "cunchu_types")

    private Integer cunchuTypes;


    /**
     * 存储介绍
     */
    @ColumnInfo(comment="存储介绍",type="longtext")
    @TableField(value = "cunchu_content")

    private String cunchuContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "cunchu_delete")

    private Integer cunchuDelete;


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
	 * 获取：存储编号
	 */
    public String getCunchuUuidNumber() {
        return cunchuUuidNumber;
    }
    /**
	 * 设置：存储编号
	 */

    public void setCunchuUuidNumber(String cunchuUuidNumber) {
        this.cunchuUuidNumber = cunchuUuidNumber;
    }
    /**
	 * 获取：存储照片
	 */
    public String getCunchuPhoto() {
        return cunchuPhoto;
    }
    /**
	 * 设置：存储照片
	 */

    public void setCunchuPhoto(String cunchuPhoto) {
        this.cunchuPhoto = cunchuPhoto;
    }
    /**
	 * 获取：存储地点
	 */
    public String getCunchuAddress() {
        return cunchuAddress;
    }
    /**
	 * 设置：存储地点
	 */

    public void setCunchuAddress(String cunchuAddress) {
        this.cunchuAddress = cunchuAddress;
    }
    /**
	 * 获取：存储类型
	 */
    public Integer getCunchuTypes() {
        return cunchuTypes;
    }
    /**
	 * 设置：存储类型
	 */

    public void setCunchuTypes(Integer cunchuTypes) {
        this.cunchuTypes = cunchuTypes;
    }
    /**
	 * 获取：存储介绍
	 */
    public String getCunchuContent() {
        return cunchuContent;
    }
    /**
	 * 设置：存储介绍
	 */

    public void setCunchuContent(String cunchuContent) {
        this.cunchuContent = cunchuContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getCunchuDelete() {
        return cunchuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setCunchuDelete(Integer cunchuDelete) {
        this.cunchuDelete = cunchuDelete;
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
        return "Cunchu{" +
            ", id=" + id +
            ", shijiId=" + shijiId +
            ", cunchuUuidNumber=" + cunchuUuidNumber +
            ", cunchuPhoto=" + cunchuPhoto +
            ", cunchuAddress=" + cunchuAddress +
            ", cunchuTypes=" + cunchuTypes +
            ", cunchuContent=" + cunchuContent +
            ", cunchuDelete=" + cunchuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
