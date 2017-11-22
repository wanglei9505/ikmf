/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 教官信息Entity
 * @author wl
 * @version 2017-11-22
 */
public class Direct extends DataEntity<Direct> {
	
	private static final long serialVersionUID = 1L;
	private String directName;		// 教官名字
	private String directTitle;		// 教官头衔简介
	private String directInfo;		// 教官个人简介
	private String directMobile;		// 教官电话
	private String directEmail;		// 教官邮箱
	private String directPhoto;		// 教官头像
	private String directAddress;	//教官所在地区

	public String getDirectAddress() {
		return directAddress;
	}

	public void setDirectAddress(String directAddress) {
		this.directAddress = directAddress;
	}

	public Direct() {
		super();
	}

	public Direct(String id){
		super(id);
	}

	@Length(min=0, max=100, message="教官名字长度必须介于 0 和 100 之间")
	public String getDirectName() {
		return directName;
	}

	public void setDirectName(String directName) {
		this.directName = directName;
	}
	
	@Length(min=0, max=255, message="教官头衔简介长度必须介于 0 和 255 之间")
	public String getDirectTitle() {
		return directTitle;
	}

	public void setDirectTitle(String directTitle) {
		this.directTitle = directTitle;
	}
	
	public String getDirectInfo() {
		return directInfo;
	}

	public void setDirectInfo(String directInfo) {
		this.directInfo = directInfo;
	}
	
	@Length(min=0, max=200, message="教官电话长度必须介于 0 和 200 之间")
	public String getDirectMobile() {
		return directMobile;
	}

	public void setDirectMobile(String directMobile) {
		this.directMobile = directMobile;
	}
	
	@Length(min=0, max=200, message="教官邮箱长度必须介于 0 和 200 之间")
	public String getDirectEmail() {
		return directEmail;
	}

	public void setDirectEmail(String directEmail) {
		this.directEmail = directEmail;
	}
	
	@Length(min=0, max=1000, message="教官头像长度必须介于 0 和 1000 之间")
	public String getDirectPhoto() {
		return directPhoto;
	}

	public void setDirectPhoto(String directPhoto) {
		this.directPhoto = directPhoto;
	}
	
}