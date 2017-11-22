/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import com.thinkgem.jeesite.modules.cms.dao.DirectDao;
import com.thinkgem.jeesite.modules.cms.entity.Direct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;


/**
 * 教官信息Service
 * @author wl
 * @version 2017-11-22
 */
@Service
@Transactional(readOnly = true)
public class DirectService extends CrudService<DirectDao, Direct> {

	public Direct get(String id) {
		return super.get(id);
	}
	
	public List<Direct> findList(Direct cmsDirect) {
		return super.findList(cmsDirect);
	}
	
	public Page<Direct> findPage(Page<Direct> page, Direct cmsDirect) {
		return super.findPage(page, cmsDirect);
	}
	public List<Direct> getDirectsByAddress(String areaId) {

		return dao.getDirectsByAddress(areaId);
	}

	
	@Transactional(readOnly = false)
	public void save(Direct cmsDirect) {
		super.save(cmsDirect);
	}
	
	@Transactional(readOnly = false)
	public void delete(Direct cmsDirect) {
		super.delete(cmsDirect);
	}
	
}