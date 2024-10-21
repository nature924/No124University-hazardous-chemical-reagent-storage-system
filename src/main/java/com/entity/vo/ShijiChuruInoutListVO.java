package com.entity.vo;

import com.entity.ShijiChuruInoutListEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 出入库详情
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shiji_churu_inout_list")
public class ShijiChuruInoutListVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 出入库
     */

    @TableField(value = "shiji_churu_inout_id")
    private Integer shijiChuruInoutId;


    /**
     * 试剂
     */

    @TableField(value = "shiji_id")
    private Integer shijiId;


    /**
     * 操作数量
     */

    @TableField(value = "shiji_churu_inout_list_number")
    private Integer shijiChuruInoutListNumber;


    /**
     * 操作时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
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
	 * 设置：出入库
	 */
    public Integer getShijiChuruInoutId() {
        return shijiChuruInoutId;
    }


    /**
	 * 获取：出入库
	 */

    public void setShijiChuruInoutId(Integer shijiChuruInoutId) {
        this.shijiChuruInoutId = shijiChuruInoutId;
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
	 * 设置：操作数量
	 */
    public Integer getShijiChuruInoutListNumber() {
        return shijiChuruInoutListNumber;
    }


    /**
	 * 获取：操作数量
	 */

    public void setShijiChuruInoutListNumber(Integer shijiChuruInoutListNumber) {
        this.shijiChuruInoutListNumber = shijiChuruInoutListNumber;
    }
    /**
	 * 设置：操作时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：操作时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
