package cn.ucai.weike.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ucai.weike.pojo.UacRole;
import cn.ucai.weike.service.UacRoleService;
import cn.ucai.weike.utils.Result;

@Controller
@RequestMapping("/uacRole")
public class RoleController {

	@Resource
	UacRoleService roleService;
	
	@RequestMapping("/doAdd")
	@ResponseBody
	public Result doAdd(UacRole role){
		Result result=roleService.addEntity(role);
		
		return result;
	}
	
	@RequestMapping("/doUpdate")
	@ResponseBody
	public Result doUpdate(UacRole role){
		Result result=roleService.updateEntity(role);
		
		return result;
	}
	
	@RequestMapping("/doDelete")
	@ResponseBody
	public Result doDelete(UacRole role){
		Result result=roleService.deleteEntity(role);
		
		return result;
	}
	
	@RequestMapping("/doGet")
	@ResponseBody
	public Result doGet(UacRole role){
		Result result=roleService.getEntity(role.getId());
		
		return result;
	}
	
	@RequestMapping("/getCount")
	@ResponseBody
	public Result getCount(){
		Result result=roleService.getEntityCount();
		
		return result;
	}
	
	@RequestMapping("/getAllByPage")
	@ResponseBody
	public Result getAllByPage(Integer pageNo, Integer pageSize,
			UacRole role){
		Result result=roleService.getAllEntityByPage(pageNo, pageSize, role);
		return result;
	}
}
