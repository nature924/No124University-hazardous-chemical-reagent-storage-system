package com.entity.vo;

import com.entity.ShiyongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 使用记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shiyong")
public class ShiyongVO implements Serializable {
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
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 使用记录名称
     */

    @TableField(value = "shiyong_name")
    private String shiyongName;


    /**
     * 使用记录编号
     */

    @TableField(value = "shiyong_uuid_number")
    private String shiyongUuidNumber;


    /**
     * 使用记录照片
     */

    @TableField(value = "shiyong_photo")
    private String shiyongPhoto;


    /**
     * 使用记录类型
     */

    @TableField(value = "shiyong_types")
    private Integer shiyongTypes;


    /**
     * 使用数量
     */

    @TableField(value = "shiyong_shuliang")
    private Integer shiyongShuliang;


    /**
     * 使用时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shiyong_time")
    private Date shiyongTime;


    /**
     * 用途
     */

    @TableField(value = "shiyong_content")
    private String shiyongContent;


    /**
     * 申请状态
     */

    @TableField(value = "shiyong_yesno_types")
    private Integer shiyongYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "shiyong_yesno_text")
    private String shiyongYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shiyong_shenhe_time")
    private Date shiyongShenheTime;


    /**
     * 逻辑删除
     */

    @TableField(value = "shiyong_delete")
    private Integer shiyongDelete;


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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：使用记录名称
	 */
    public String getShiyongName() {
        return shiyongName;
    }


    /**
	 * 获取：使用记录名称
	 */

    public void setShiyongName(String shiyongName) {
        this.shiyongName = shiyongName;
    }
    /**
	 * 设置：使用记录编号
	 */
    public String getShiyongUuidNumber() {
        return shiyongUuidNumber;
    }


    /**
	 * 获取：使用记录编号
	 */

    public void setShiyongUuidNumber(String shiyongUuidNumber) {
        this.shiyongUuidNumber = shiyongUuidNumber;
    }
    /**
	 * 设置：使用记录照片
	 */
    public String getShiyongPhoto() {
        return shiyongPhoto;
    }


    /**
	 * 获取：使用记录照片
	 */

    public void setShiyongPhoto(String shiyongPhoto) {
        this.shiyongPhoto = shiyongPhoto;
    }
    /**
	 * 设置：使用记录类型
	 */
    public Integer getShiyongTypes() {
        return shiyongTypes;
    }


    /**
	 * 获取：使用记录类型
	 */

    public void setShiyongTypes(Integer shiyongTypes) {
        this.shiyongTypes = shiyongTypes;
    }
    /**
	 * 设置：使用数量
	 */
    public Integer getShiyongShuliang() {
        return shiyongShuliang;
    }


    /**
	 * 获取：使用数量
	 */

    public void setShiyongShuliang(Integer shiyongShuliang) {
        this.shiyongShuliang = shiyongShuliang;
    }
    /**
	 * 设置：使用时间
	 */
    public Date getShiyongTime() {
        return shiyongTime;
    }


    /**
	 * 获取：使用时间
	 */

    public void setShiyongTime(Date shiyongTime) {
        this.shiyongTime = shiyongTime;
    }
    /**
	 * 设置：用途
	 */
    public String getShiyongContent() {
        return shiyongContent;
    }


    /**
	 * 获取：用途
	 */

    public void setShiyongContent(String shiyongContent) {
        this.shiyongContent = shiyongContent;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getShiyongYesnoTypes() {
        return shiyongYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setShiyongYesnoTypes(Integer shiyongYesnoTypes) {
        this.shiyongYesnoTypes = shiyongYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getShiyongYesnoText() {
        return shiyongYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setShiyongYesnoText(String shiyongYesnoText) {
        this.shiyongYesnoText = shiyongYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getShiyongShenheTime() {
        return shiyongShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setShiyongShenheTime(Date shiyongShenheTime) {
        this.shiyongShenheTime = shiyongShenheTime;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getShiyongDelete() {
        return shiyongDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setShiyongDelete(Integer shiyongDelete) {
        this.shiyongDelete = shiyongDelete;
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
