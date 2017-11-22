/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.modules.cms.entity.Direct;
import com.thinkgem.jeesite.modules.cms.service.DirectService;
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
 * 教官信息Controller
 * @author wl
 * @version 2017-11-22
 */
@Controller
@RequestMapping(value = "${adminPath}/direct/cmsDirect")
public class DirectController extends BaseController {

	@Autowired
	private DirectService directService;
	
	@ModelAttribute
	public Direct get(@RequestParam(required=false) String id) {
		Direct entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = directService.get(id);
		}
		if (entity == null){
			entity = new Direct();
		}
		return entity;
	}
	
	@RequiresPermissions("direct:cmsDirect:view")
	@RequestMapping(value = {"list", ""})
	public String list(Direct cmsDirect, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Direct> page = directService.findPage(new Page<Direct>(request, response), cmsDirect);
		model.addAttribute("page", page);
		return "modules/direct/cmsDirectList";
	}

	@RequiresPermissions("direct:cmsDirect:view")
	@RequestMapping(value = "form")
	public String form(Direct cmsDirect, Model model) {
		model.addAttribute("cmsDirect", cmsDirect);
		return "modules/direct/cmsDirectForm";
	}

	@RequiresPermissions("direct:cmsDirect:edit")
	@RequestMapping(value = "save")
	public String save(Direct cmsDirect, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, cmsDirect)){
			return form(cmsDirect, model);
		}
		directService.save(cmsDirect);
		addMessage(redirectAttributes, "保存教官成功");
		return "redirect:"+Global.getAdminPath()+"/direct/cmsDirect/?repage";
	}
	
	@RequiresPermissions("direct:cmsDirect:edit")
	@RequestMapping(value = "delete")
	public String delete(Direct cmsDirect, RedirectAttributes redirectAttributes) {
		directService.delete(cmsDirect);
		addMessage(redirectAttributes, "删除教官成功");
		return "redirect:"+Global.getAdminPath()+"/direct/cmsDirect/?repage";
	}

}