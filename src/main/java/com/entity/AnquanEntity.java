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
 * 安全
 *
 * @author 
 * @email
 */
@TableName("anquan")
public class AnquanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public AnquanEntity() {

	}

	public AnquanEntity(T t) {
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
     * 安全管理编号
     */
    @ColumnInfo(comment="安全管理编号",type="varchar(200)")
    @TableField(value = "anquan_uuid_number")

    private String anquanUuidNumber;


    /**
     * 安全管理照片
     */
    @ColumnInfo(comment="安全管理照片",type="varchar(200)")
    @TableField(value = "anquan_photo")

    private String anquanPhoto;


    /**
     * 危险程度
     */
    @ColumnInfo(comment="危险程度",type="int(11)")
    @TableField(value = "anquan_types")

    private Integer anquanTypes;


    /**
     * 安全管理库存
     */
    @ColumnInfo(comment="安全管理库存",type="int(11)")
    @TableField(value = "anquan_kucun_number")

    private Integer anquanKucunNumber;


    /**
     * 操作规范
     */
    @ColumnInfo(comment="操作规范",type="longtext")
    @TableField(value = "anquan_content")

    private String anquanContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "anquan_delete")

    private Integer anquanDelete;


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
	 * 获取：安全管理编号
	 */
    public String getAnquanUuidNumber() {
        return anquanUuidNumber;
    }
    /**
	 * 设置：安全管理编号
	 */

    public void setAnquanUuidNumber(String anquanUuidNumber) {
        this.anquanUuidNumber = anquanUuidNumber;
    }
    /**
	 * 获取：安全管理照片
	 */
    public String getAnquanPhoto() {
        return anquanPhoto;
    }
    /**
	 * 设置：安全管理照片
	 */

    public void setAnquanPhoto(String anquanPhoto) {
        this.anquanPhoto = anquanPhoto;
    }
    /**
	 * 获取：危险程度
	 */
    public Integer getAnquanTypes() {
        return anquanTypes;
    }
    /**
	 * 设置：危险程度
	 */

    public void setAnquanTypes(Integer anquanTypes) {
        this.anquanTypes = anquanTypes;
    }
    /**
	 * 获取：安全管理库存
	 */
    public Integer getAnquanKucunNumber() {
        return anquanKucunNumber;
    }
    /**
	 * 设置：安全管理库存
	 */

    public void setAnquanKucunNumber(Integer anquanKucunNumber) {
        this.anquanKucunNumber = anquanKucunNumber;
    }
    /**
	 * 获取：操作规范
	 */
    public String getAnquanContent() {
        return anquanContent;
    }
    /**
	 * 设置：操作规范
	 */

    public void setAnquanContent(String anquanContent) {
        this.anquanContent = anquanContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getAnquanDelete() {
        return anquanDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setAnquanDelete(Integer anquanDelete) {
        this.anquanDelete = anquanDelete;
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
        return "Anquan{" +
            ", id=" + id +
            ", shijiId=" + shijiId +
            ", anquanUuidNumber=" + anquanUuidNumber +
            ", anquanPhoto=" + anquanPhoto +
            ", anquanTypes=" + anquanTypes +
            ", anquanKucunNumber=" + anquanKucunNumber +
            ", anquanContent=" + anquanContent +
            ", anquanDelete=" + anquanDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
