package com.entity.vo;

import com.entity.AnquanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 安全
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("anquan")
public class AnquanVO implements Serializable {
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
     * 安全管理编号
     */

    @TableField(value = "anquan_uuid_number")
    private String anquanUuidNumber;


    /**
     * 安全管理照片
     */

    @TableField(value = "anquan_photo")
    private String anquanPhoto;


    /**
     * 危险程度
     */

    @TableField(value = "anquan_types")
    private Integer anquanTypes;


    /**
     * 安全管理库存
     */

    @TableField(value = "anquan_kucun_number")
    private Integer anquanKucunNumber;


    /**
     * 操作规范
     */

    @TableField(value = "anquan_content")
    private String anquanContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "anquan_delete")
    private Integer anquanDelete;


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
	 * 设置：安全管理编号
	 */
    public String getAnquanUuidNumber() {
        return anquanUuidNumber;
    }


    /**
	 * 获取：安全管理编号
	 */

    public void setAnquanUuidNumber(String anquanUuidNumber) {
        this.anquanUuidNumber = anquanUuidNumber;
    }
    /**
	 * 设置：安全管理照片
	 */
    public String getAnquanPhoto() {
        return anquanPhoto;
    }


    /**
	 * 获取：安全管理照片
	 */

    public void setAnquanPhoto(String anquanPhoto) {
        this.anquanPhoto = anquanPhoto;
    }
    /**
	 * 设置：危险程度
	 */
    public Integer getAnquanTypes() {
        return anquanTypes;
    }


    /**
	 * 获取：危险程度
	 */

    public void setAnquanTypes(Integer anquanTypes) {
        this.anquanTypes = anquanTypes;
    }
    /**
	 * 设置：安全管理库存
	 */
    public Integer getAnquanKucunNumber() {
        return anquanKucunNumber;
    }


    /**
	 * 获取：安全管理库存
	 */

    public void setAnquanKucunNumber(Integer anquanKucunNumber) {
        this.anquanKucunNumber = anquanKucunNumber;
    }
    /**
	 * 设置：操作规范
	 */
    public String getAnquanContent() {
        return anquanContent;
    }


    /**
	 * 获取：操作规范
	 */

    public void setAnquanContent(String anquanContent) {
        this.anquanContent = anquanContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getAnquanDelete() {
        return anquanDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setAnquanDelete(Integer anquanDelete) {
        this.anquanDelete = anquanDelete;
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
