/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 相册信息Entity
 * @author wl
 * @version 2017-11-22
 */
public class Album extends DataEntity<Album> {
	
	private static final long serialVersionUID = 1L;
	private String categoryId;		// 栏目编号
	private String imageAddress;		// 图片地址  一个数组
	private String albumName;		// 相册名称
	private String description;		// 描述信息
	private String hits;		// 点击量
	
	public Album() {
		super();
	}

	public Album(String id){
		super(id);
	}

	@Length(min=1, max=64, message="栏目编号长度必须介于 1 和 64 之间")
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@Length(min=0, max=255, message="图片地址  一个数组长度必须介于 0 和 255 之间")
	public String getImageAddress() {
		return imageAddress;
	}

	public void setImageAddress(String imageAddress) {
		this.imageAddress = imageAddress;
	}
	
	@Length(min=0, max=255, message="相册名称长度必须介于 0 和 255 之间")
	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
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