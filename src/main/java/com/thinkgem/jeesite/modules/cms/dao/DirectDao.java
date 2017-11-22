/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.cms.entity.Direct;

import java.util.List;

/**
 * 教官信息DAO接口
 * @author wl
 * @version 2017-11-22
 */
@MyBatisDao
public interface DirectDao extends CrudDao<Direct> {
    /**
     * 根据地区id获取该地区的教官
     * @param areaId
     * @return
     */
	public List<Direct> getDirectsByAddress(String areaId);
}