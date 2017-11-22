/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.modules.cms.entity.Video;
import com.thinkgem.jeesite.modules.cms.service.VideoService;
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
 * 视频信息Controller
 * @author wl
 * @version 2017-11-22
 */
@Controller
@RequestMapping(value = "${adminPath}/video/cmsVideo")
public class VideoController extends BaseController {

	@Autowired
	private VideoService videoService;
	
	@ModelAttribute
	public Video get(@RequestParam(required=false) String id) {
		Video entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = videoService.get(id);
		}
		if (entity == null){
			entity = new Video();
		}
		return entity;
	}
	
	@RequiresPermissions("video:video:view")
	@RequestMapping(value = {"list", ""})
	public String list(Video video, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Video> page = videoService.findPage(new Page<Video>(request, response), video);
		model.addAttribute("page", page);
		return "modules/video/cmsVideoList";
	}

	@RequiresPermissions("video:video:view")
	@RequestMapping(value = "form")
	public String form(Video video, Model model) {
		model.addAttribute("cmsVideo", video);
		return "modules/video/cmsVideoForm";
	}

	@RequiresPermissions("video:video:edit")
	@RequestMapping(value = "save")
	public String save(Video video, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, video)){
			return form(video, model);
		}
		videoService.save(video);
		addMessage(redirectAttributes, "保存视频成功");
		return "redirect:"+Global.getAdminPath()+"/video/video/?repage";
	}
	
	@RequiresPermissions("video:video:edit")
	@RequestMapping(value = "delete")
	public String delete(Video video, RedirectAttributes redirectAttributes) {
		videoService.delete(video);
		addMessage(redirectAttributes, "删除视频成功");
		return "redirect:"+Global.getAdminPath()+"/video/video/?repage";
	}

}