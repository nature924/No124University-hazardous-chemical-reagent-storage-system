package com.entity.vo;

import com.entity.ShijiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 试剂
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shiji")
public class ShijiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 试剂名称
     */

    @TableField(value = "shiji_name")
    private String shijiName;


    /**
     * 试剂编号
     */

    @TableField(value = "shiji_uuid_number")
    private String shijiUuidNumber;


    /**
     * 试剂照片
     */

    @TableField(value = "shiji_photo")
    private String shijiPhoto;


    /**
     * 试剂规格
     */

    @TableField(value = "shiji_guige")
    private String shijiGuige;


    /**
     * 生产厂家
     */

    @TableField(value = "shiji_changjia")
    private String shijiChangjia;


    /**
     * 生产批次
     */

    @TableField(value = "shiji_pici")
    private Integer shijiPici;


    /**
     * 生产日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shiji_time")
    private Date shijiTime;


    /**
     * 保质期/月
     */

    @TableField(value = "shiji_baozhi")
    private Integer shijiBaozhi;


    /**
     * 试剂类型
     */

    @TableField(value = "shiji_types")
    private Integer shijiTypes;


    /**
     * 试剂数量
     */

    @TableField(value = "shiji_kucun_number")
    private Integer shijiKucunNumber;


    /**
     * 试剂介绍
     */

    @TableField(value = "shiji_content")
    private String shijiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "shiji_delete")
    private Integer shijiDelete;


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
	 * 设置：试剂名称
	 */
    public String getShijiName() {
        return shijiName;
    }


    /**
	 * 获取：试剂名称
	 */

    public void setShijiName(String shijiName) {
        this.shijiName = shijiName;
    }
    /**
	 * 设置：试剂编号
	 */
    public String getShijiUuidNumber() {
        return shijiUuidNumber;
    }


    /**
	 * 获取：试剂编号
	 */

    public void setShijiUuidNumber(String shijiUuidNumber) {
        this.shijiUuidNumber = shijiUuidNumber;
    }
    /**
	 * 设置：试剂照片
	 */
    public String getShijiPhoto() {
        return shijiPhoto;
    }


    /**
	 * 获取：试剂照片
	 */

    public void setShijiPhoto(String shijiPhoto) {
        this.shijiPhoto = shijiPhoto;
    }
    /**
	 * 设置：试剂规格
	 */
    public String getShijiGuige() {
        return shijiGuige;
    }


    /**
	 * 获取：试剂规格
	 */

    public void setShijiGuige(String shijiGuige) {
        this.shijiGuige = shijiGuige;
    }
    /**
	 * 设置：生产厂家
	 */
    public String getShijiChangjia() {
        return shijiChangjia;
    }


    /**
	 * 获取：生产厂家
	 */

    public void setShijiChangjia(String shijiChangjia) {
        this.shijiChangjia = shijiChangjia;
    }
    /**
	 * 设置：生产批次
	 */
    public Integer getShijiPici() {
        return shijiPici;
    }


    /**
	 * 获取：生产批次
	 */

    public void setShijiPici(Integer shijiPici) {
        this.shijiPici = shijiPici;
    }
    /**
	 * 设置：生产日期
	 */
    public Date getShijiTime() {
        return shijiTime;
    }


    /**
	 * 获取：生产日期
	 */

    public void setShijiTime(Date shijiTime) {
        this.shijiTime = shijiTime;
    }
    /**
	 * 设置：保质期/月
	 */
    public Integer getShijiBaozhi() {
        return shijiBaozhi;
    }


    /**
	 * 获取：保质期/月
	 */

    public void setShijiBaozhi(Integer shijiBaozhi) {
        this.shijiBaozhi = shijiBaozhi;
    }
    /**
	 * 设置：试剂类型
	 */
    public Integer getShijiTypes() {
        return shijiTypes;
    }


    /**
	 * 获取：试剂类型
	 */

    public void setShijiTypes(Integer shijiTypes) {
        this.shijiTypes = shijiTypes;
    }
    /**
	 * 设置：试剂数量
	 */
    public Integer getShijiKucunNumber() {
        return shijiKucunNumber;
    }


    /**
	 * 获取：试剂数量
	 */

    public void setShijiKucunNumber(Integer shijiKucunNumber) {
        this.shijiKucunNumber = shijiKucunNumber;
    }
    /**
	 * 设置：试剂介绍
	 */
    public String getShijiContent() {
        return shijiContent;
    }


    /**
	 * 获取：试剂介绍
	 */

    public void setShijiContent(String shijiContent) {
        this.shijiContent = shijiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getShijiDelete() {
        return shijiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setShijiDelete(Integer shijiDelete) {
        this.shijiDelete = shijiDelete;
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
