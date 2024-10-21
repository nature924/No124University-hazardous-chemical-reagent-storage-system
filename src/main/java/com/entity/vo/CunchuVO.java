package com.entity.vo;

import com.entity.CunchuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 存储
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("cunchu")
public class CunchuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 试剂
     */

    @TableField(value = "shiji_id")
    private Integer shijiId;


    /**
     * 存储编号
     */

    @TableField(value = "cunchu_uuid_number")
    private String cunchuUuidNumber;


    /**
     * 存储照片
     */

    @TableField(value = "cunchu_photo")
    private String cunchuPhoto;


    /**
     * 存储地点
     */

    @TableField(value = "cunchu_address")
    private String cunchuAddress;


    /**
     * 存储类型
     */

    @TableField(value = "cunchu_types")
    private Integer cunchuTypes;


    /**
     * 存储介绍
     */

    @TableField(value = "cunchu_content")
    private String cunchuContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "cunchu_delete")
    private Integer cunchuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：试剂
	 */
    public Integer getShijiId() {
        return shijiId;
    }


    /**
	 * 获取：试剂
	 */

    public void setShijiId(Integer shijiId) {
        this.shijiId = shijiId;
    }
    /**
	 * 设置：存储编号
	 */
    public String getCunchuUuidNumber() {
        return cunchuUuidNumber;
    }


    /**
	 * 获取：存储编号
	 */

    public void setCunchuUuidNumber(String cunchuUuidNumber) {
        this.cunchuUuidNumber = cunchuUuidNumber;
    }
    /**
	 * 设置：存储照片
	 */
    public String getCunchuPhoto() {
        return cunchuPhoto;
    }


    /**
	 * 获取：存储照片
	 */

    public void setCunchuPhoto(String cunchuPhoto) {
        this.cunchuPhoto = cunchuPhoto;
    }
    /**
	 * 设置：存储地点
	 */
    public String getCunchuAddress() {
        return cunchuAddress;
    }


    /**
	 * 获取：存储地点
	 */

    public void setCunchuAddress(String cunchuAddress) {
        this.cunchuAddress = cunchuAddress;
    }
    /**
	 * 设置：存储类型
	 */
    public Integer getCunchuTypes() {
        return cunchuTypes;
    }


    /**
	 * 获取：存储类型
	 */

    public void setCunchuTypes(Integer cunchuTypes) {
        this.cunchuTypes = cunchuTypes;
    }
    /**
	 * 设置：存储介绍
	 */
    public String getCunchuContent() {
        return cunchuContent;
    }


    /**
	 * 获取：存储介绍
	 */

    public void setCunchuContent(String cunchuContent) {
        this.cunchuContent = cunchuContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getCunchuDelete() {
        return cunchuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setCunchuDelete(Integer cunchuDelete) {
        this.cunchuDelete = cunchuDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
