package com.entity.view;

import com.entity.KafeiLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 商品留言
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("kafei_liuyan")
public class KafeiLiuyanView extends KafeiLiuyanEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 kafei
			/**
			* 商品 的 商家
			*/
			private Integer kafeiShangjiaId;
			/**
			* 商品名称
			*/
			private String kafeiName;
			/**
			* 商品照片
			*/
			private String kafeiPhoto;
			/**
			* 商品类型
			*/
			private Integer kafeiTypes;
				/**
				* 商品类型的值
				*/
				private String kafeiValue;
			/**
			* 商品库存
			*/
			private Integer kafeiKucunNumber;
			/**
			* 商品原价
			*/
			private Double kafeiOldMoney;
			/**
			* 现价
			*/
			private Double kafeiNewMoney;
			/**
			* 点击次数
			*/
			private Integer kafeiClicknum;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer kafeiDelete;
			/**
			* 商品简介
			*/
			private String kafeiContent;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;
			/**
			* 余额
			*/
			private Double newMoney;

	public KafeiLiuyanView() {

	}

	public KafeiLiuyanView(KafeiLiuyanEntity kafeiLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, kafeiLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
















				//级联表的get和set kafei
					/**
					* 获取：商品 的 商家
					*/
					public Integer getKafeiShangjiaId() {
						return kafeiShangjiaId;
					}
					/**
					* 设置：商品 的 商家
					*/
					public void setKafeiShangjiaId(Integer kafeiShangjiaId) {
						this.kafeiShangjiaId = kafeiShangjiaId;
					}

					/**
					* 获取： 商品名称
					*/
					public String getKafeiName() {
						return kafeiName;
					}
					/**
					* 设置： 商品名称
					*/
					public void setKafeiName(String kafeiName) {
						this.kafeiName = kafeiName;
					}
					/**
					* 获取： 商品照片
					*/
					public String getKafeiPhoto() {
						return kafeiPhoto;
					}
					/**
					* 设置： 商品照片
					*/
					public void setKafeiPhoto(String kafeiPhoto) {
						this.kafeiPhoto = kafeiPhoto;
					}
					/**
					* 获取： 商品类型
					*/
					public Integer getKafeiTypes() {
						return kafeiTypes;
					}
					/**
					* 设置： 商品类型
					*/
					public void setKafeiTypes(Integer kafeiTypes) {
						this.kafeiTypes = kafeiTypes;
					}


						/**
						* 获取： 商品类型的值
						*/
						public String getKafeiValue() {
							return kafeiValue;
						}
						/**
						* 设置： 商品类型的值
						*/
						public void setKafeiValue(String kafeiValue) {
							this.kafeiValue = kafeiValue;
						}
					/**
					* 获取： 商品库存
					*/
					public Integer getKafeiKucunNumber() {
						return kafeiKucunNumber;
					}
					/**
					* 设置： 商品库存
					*/
					public void setKafeiKucunNumber(Integer kafeiKucunNumber) {
						this.kafeiKucunNumber = kafeiKucunNumber;
					}
					/**
					* 获取： 商品原价
					*/
					public Double getKafeiOldMoney() {
						return kafeiOldMoney;
					}
					/**
					* 设置： 商品原价
					*/
					public void setKafeiOldMoney(Double kafeiOldMoney) {
						this.kafeiOldMoney = kafeiOldMoney;
					}
					/**
					* 获取： 现价
					*/
					public Double getKafeiNewMoney() {
						return kafeiNewMoney;
					}
					/**
					* 设置： 现价
					*/
					public void setKafeiNewMoney(Double kafeiNewMoney) {
						this.kafeiNewMoney = kafeiNewMoney;
					}
					/**
					* 获取： 点击次数
					*/
					public Integer getKafeiClicknum() {
						return kafeiClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setKafeiClicknum(Integer kafeiClicknum) {
						this.kafeiClicknum = kafeiClicknum;
					}
					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getKafeiDelete() {
						return kafeiDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setKafeiDelete(Integer kafeiDelete) {
						this.kafeiDelete = kafeiDelete;
					}
					/**
					* 获取： 商品简介
					*/
					public String getKafeiContent() {
						return kafeiContent;
					}
					/**
					* 设置： 商品简介
					*/
					public void setKafeiContent(String kafeiContent) {
						this.kafeiContent = kafeiContent;
					}

























				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}
					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}






}
