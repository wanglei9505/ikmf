/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import com.thinkgem.jeesite.modules.cms.dao.AlbumDao;
import com.thinkgem.jeesite.modules.cms.entity.Album;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;

/**
 * 相册信息Service
 * @author wl
 * @version 2017-11-22
 */
@Service
@Transactional(readOnly = true)
public class AlbumService extends CrudService<AlbumDao, Album> {

	public Album get(String id) {
		return super.get(id);
	}
	
	public List<Album> findList(Album album) {
		return super.findList(album);
	}
	
	public Page<Album> findPage(Page<Album> page, Album album) {
		return super.findPage(page, album);
	}
	
	@Transactional(readOnly = false)
	public void save(Album album) {
		super.save(album);
	}
	
	@Transactional(readOnly = false)
	public void delete(Album album) {
		super.delete(album);
	}
	
}