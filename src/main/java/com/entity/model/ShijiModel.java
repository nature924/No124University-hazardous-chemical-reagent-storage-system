package com.entity.model;

import com.entity.ShijiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 试剂
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShijiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 试剂名称
     */
    private String shijiName;


    /**
     * 试剂编号
     */
    private String shijiUuidNumber;


    /**
     * 试剂照片
     */
    private String shijiPhoto;


    /**
     * 试剂规格
     */
    private String shijiGuige;


    /**
     * 生产厂家
     */
    private String shijiChangjia;


    /**
     * 生产批次
     */
    private Integer shijiPici;


    /**
     * 生产日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shijiTime;


    /**
     * 保质期/月
     */
    private Integer shijiBaozhi;


    /**
     * 试剂类型
     */
    private Integer shijiTypes;


    /**
     * 试剂数量
     */
    private Integer shijiKucunNumber;


    /**
     * 试剂介绍
     */
    private String shijiContent;


    /**
     * 逻辑删除
     */
    private Integer shijiDelete;


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
