package com.entity.vo;

import com.entity.YonghutoushuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 用户投诉
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yonghutoushu")
public class YonghutoushuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 投诉标题
     */

    @TableField(value = "yonghutoushu_name")
    private String yonghutoushuName;


    /**
     * 投诉图片
     */

    @TableField(value = "yonghutoushu_photo")
    private String yonghutoushuPhoto;


    /**
     * 投诉类型
     */

    @TableField(value = "yonghutoushu_types")
    private Integer yonghutoushuTypes;


    /**
     * 投诉状态
     */

    @TableField(value = "yonghutoushu_status_types")
    private Integer yonghutoushuStatusTypes;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 投诉商家
     */

    @TableField(value = "shangjia_id")
    private Integer shangjiaId;


    /**
     * 投诉详情
     */

    @TableField(value = "yonghutoushu_content")
    private String yonghutoushuContent;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 设置：投诉标题
	 */
    public String getYonghutoushuName() {
        return yonghutoushuName;
    }


    /**
	 * 获取：投诉标题
	 */

    public void setYonghutoushuName(String yonghutoushuName) {
        this.yonghutoushuName = yonghutoushuName;
    }
    /**
	 * 设置：投诉图片
	 */
    public String getYonghutoushuPhoto() {
        return yonghutoushuPhoto;
    }


    /**
	 * 获取：投诉图片
	 */

    public void setYonghutoushuPhoto(String yonghutoushuPhoto) {
        this.yonghutoushuPhoto = yonghutoushuPhoto;
    }
    /**
	 * 设置：投诉类型
	 */
    public Integer getYonghutoushuTypes() {
        return yonghutoushuTypes;
    }


    /**
	 * 获取：投诉类型
	 */

    public void setYonghutoushuTypes(Integer yonghutoushuTypes) {
        this.yonghutoushuTypes = yonghutoushuTypes;
    }
    /**
	 * 设置：投诉状态
	 */
    public Integer getYonghutoushuStatusTypes() {
        return yonghutoushuStatusTypes;
    }


    /**
	 * 获取：投诉状态
	 */

    public void setYonghutoushuStatusTypes(Integer yonghutoushuStatusTypes) {
        this.yonghutoushuStatusTypes = yonghutoushuStatusTypes;
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
	 * 设置：投诉商家
	 */
    public Integer getShangjiaId() {
        return shangjiaId;
    }


    /**
	 * 获取：投诉商家
	 */

    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }
    /**
	 * 设置：投诉详情
	 */
    public String getYonghutoushuContent() {
        return yonghutoushuContent;
    }


    /**
	 * 获取：投诉详情
	 */

    public void setYonghutoushuContent(String yonghutoushuContent) {
        this.yonghutoushuContent = yonghutoushuContent;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
