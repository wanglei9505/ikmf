/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import com.thinkgem.jeesite.modules.cms.dao.VideoDao;
import com.thinkgem.jeesite.modules.cms.entity.Video;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;

/**
 * 视频信息Service
 * @author wl
 * @version 2017-11-22
 */
@Service
@Transactional(readOnly = true)
public class VideoService extends CrudService<VideoDao, Video> {

	public Video get(String id) {
		return super.get(id);
	}
	
	public List<Video> findList(Video video) {
		return super.findList(video);
	}
	
	public Page<Video> findPage(Page<Video> page, Video video) {
		return super.findPage(page, video);
	}
	
	@Transactional(readOnly = false)
	public void save(Video video) {
		super.save(video);
	}
	
	@Transactional(readOnly = false)
	public void delete(Video video) {
		super.delete(video);
	}
	
}