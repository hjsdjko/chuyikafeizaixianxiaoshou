package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 用户投诉
 *
 * @author 
 * @email
 */
@TableName("yonghutoushu")
public class YonghutoushuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YonghutoushuEntity() {

	}

	public YonghutoushuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Yonghutoushu{" +
            "id=" + id +
            ", yonghutoushuName=" + yonghutoushuName +
            ", yonghutoushuPhoto=" + yonghutoushuPhoto +
            ", yonghutoushuTypes=" + yonghutoushuTypes +
            ", yonghutoushuStatusTypes=" + yonghutoushuStatusTypes +
            ", yonghuId=" + yonghuId +
            ", shangjiaId=" + shangjiaId +
            ", yonghutoushuContent=" + yonghutoushuContent +
            ", createTime=" + createTime +
        "}";
    }
}
