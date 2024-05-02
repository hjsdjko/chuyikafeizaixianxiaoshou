package com.entity.model;

import com.entity.YonghutoushuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 用户投诉
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YonghutoushuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 投诉标题
     */
    private String yonghutoushuName;


    /**
     * 投诉图片
     */
    private String yonghutoushuPhoto;


    /**
     * 投诉类型
     */
    private Integer yonghutoushuTypes;


    /**
     * 投诉状态
     */
    private Integer yonghutoushuStatusTypes;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 投诉商家
     */
    private Integer shangjiaId;


    /**
     * 投诉详情
     */
    private String yonghutoushuContent;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 获取：投诉标题
	 */
    public String getYonghutoushuName() {
        return yonghutoushuName;
    }


    /**
	 * 设置：投诉标题
	 */
    public void setYonghutoushuName(String yonghutoushuName) {
        this.yonghutoushuName = yonghutoushuName;
    }
    /**
	 * 获取：投诉图片
	 */
    public String getYonghutoushuPhoto() {
        return yonghutoushuPhoto;
    }


    /**
	 * 设置：投诉图片
	 */
    public void setYonghutoushuPhoto(String yonghutoushuPhoto) {
        this.yonghutoushuPhoto = yonghutoushuPhoto;
    }
    /**
	 * 获取：投诉类型
	 */
    public Integer getYonghutoushuTypes() {
        return yonghutoushuTypes;
    }


    /**
	 * 设置：投诉类型
	 */
    public void setYonghutoushuTypes(Integer yonghutoushuTypes) {
        this.yonghutoushuTypes = yonghutoushuTypes;
    }
    /**
	 * 获取：投诉状态
	 */
    public Integer getYonghutoushuStatusTypes() {
        return yonghutoushuStatusTypes;
    }


    /**
	 * 设置：投诉状态
	 */
    public void setYonghutoushuStatusTypes(Integer yonghutoushuStatusTypes) {
        this.yonghutoushuStatusTypes = yonghutoushuStatusTypes;
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
	 * 获取：投诉商家
	 */
    public Integer getShangjiaId() {
        return shangjiaId;
    }


    /**
	 * 设置：投诉商家
	 */
    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }
    /**
	 * 获取：投诉详情
	 */
    public String getYonghutoushuContent() {
        return yonghutoushuContent;
    }


    /**
	 * 设置：投诉详情
	 */
    public void setYonghutoushuContent(String yonghutoushuContent) {
        this.yonghutoushuContent = yonghutoushuContent;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
