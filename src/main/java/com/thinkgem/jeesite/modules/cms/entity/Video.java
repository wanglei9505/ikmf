/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 视频信息Entity
 * @author wl
 * @version 2017-11-22
 */
public class Video extends DataEntity<Video> {
	
	private static final long serialVersionUID = 1L;
	private String categoryId;		// 栏目编号
	private String videoAddress;		// 视频链接地址
	private String videoName;		// 视频名称
	private String description;		// 描述信息
	private String hits;		// 点击量
	
	public Video() {
		super();
	}

	public Video(String id){
		super(id);
	}

	@Length(min=1, max=64, message="栏目编号长度必须介于 1 和 64 之间")
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@Length(min=0, max=255, message="视频链接地址长度必须介于 0 和 255 之间")
	public String getVideoAddress() {
		return videoAddress;
	}

	public void setVideoAddress(String videoAddress) {
		this.videoAddress = videoAddress;
	}
	
	@Length(min=0, max=255, message="视频名称长度必须介于 0 和 255 之间")
	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	
	@Length(min=0, max=255, message="描述信息长度必须介于 0 和 255 之间")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Length(min=0, max=11, message="点击量长度必须介于 0 和 11 之间")
	public String getHits() {
		return hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
	}
	
}