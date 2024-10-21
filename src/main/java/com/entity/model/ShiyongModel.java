package com.entity.model;

import com.entity.ShiyongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 使用记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShiyongModel implements Serializable {
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
     * 用户
     */
    private Integer yonghuId;


    /**
     * 使用记录名称
     */
    private String shiyongName;


    /**
     * 使用记录编号
     */
    private String shiyongUuidNumber;


    /**
     * 使用记录照片
     */
    private String shiyongPhoto;


    /**
     * 使用记录类型
     */
    private Integer shiyongTypes;


    /**
     * 使用数量
     */
    private Integer shiyongShuliang;


    /**
     * 使用时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shiyongTime;


    /**
     * 用途
     */
    private String shiyongContent;


    /**
     * 申请状态
     */
    private Integer shiyongYesnoTypes;


    /**
     * 审核意见
     */
    private String shiyongYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shiyongShenheTime;


    /**
     * 逻辑删除
     */
    private Integer shiyongDelete;


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
