package com.entity.model;

import com.entity.CunchuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 存储
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CunchuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 试剂
     */
    private Integer shijiId;


    /**
     * 存储编号
     */
    private String cunchuUuidNumber;


    /**
     * 存储照片
     */
    private String cunchuPhoto;


    /**
     * 存储地点
     */
    private String cunchuAddress;


    /**
     * 存储类型
     */
    private Integer cunchuTypes;


    /**
     * 存储介绍
     */
    private String cunchuContent;


    /**
     * 逻辑删除
     */
    private Integer cunchuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
