/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.modules.cms.entity.Album;
import com.thinkgem.jeesite.modules.cms.service.AlbumService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;

/**
 * 相册信息Controller
 * @author wl
 * @version 2017-11-22
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/picture")
public class AlbumController extends BaseController {

	@Autowired
	private AlbumService albumService;
	
	@ModelAttribute
	public Album get(@RequestParam(required=false) String id) {
		Album entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = albumService.get(id);
		}
		if (entity == null){
			entity = new Album();
		}
		return entity;
	}
	
	@RequiresPermissions("album:album:view")
	@RequestMapping(value = {"list", ""})
	public String list(Album album, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Album> page = albumService.findPage(new Page<Album>(request, response), album);
		model.addAttribute("page", page);
		return "modules/cms/cmsAlbumList";
	}

	@RequiresPermissions("album:album:view")
	@RequestMapping(value = "form")
	public String form(Album album, Model model) {
		model.addAttribute("album", album);
		return "modules/cms/cmsAlbumForm";
	}

	@RequiresPermissions("album:album:edit")
	@RequestMapping(value = "save")
	public String save(Album album, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, album)){
			return form(album, model);
		}
		albumService.save(album);
		addMessage(redirectAttributes, "保存相册成功");
		return "redirect:"+Global.getAdminPath()+"/cms/picture/?repage";
	}
	
	@RequiresPermissions("album:album:edit")
	@RequestMapping(value = "delete")
	public String delete(Album album, RedirectAttributes redirectAttributes) {
		albumService.delete(album);
		addMessage(redirectAttributes, "删除相册成功");
		return "redirect:"+Global.getAdminPath()+"/cms/picture/?repage";
	}

}