package com.entity.model;

import com.entity.AnquanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 安全
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class AnquanModel implements Serializable {
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
     * 安全管理编号
     */
    private String anquanUuidNumber;


    /**
     * 安全管理照片
     */
    private String anquanPhoto;


    /**
     * 危险程度
     */
    private Integer anquanTypes;


    /**
     * 安全管理库存
     */
    private Integer anquanKucunNumber;


    /**
     * 操作规范
     */
    private String anquanContent;


    /**
     * 逻辑删除
     */
    private Integer anquanDelete;


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
