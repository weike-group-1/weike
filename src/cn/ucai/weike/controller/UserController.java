package cn.ucai.weike.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ucai.weike.pojo.UacUser;
import cn.ucai.weike.service.UacUserService;
import cn.ucai.weike.utils.Result;

@Controller
@RequestMapping("/uacUser")
public class UserController {

	@Resource
	UacUserService userService;

	@RequestMapping("/getCount")
	@ResponseBody
	public Result getCount() {
		Result result = userService.getEntityCount();
		
		return result;
	}

	@RequestMapping("/doAdd")
	@ResponseBody
	public Result doAdd(UacUser user) {
		Result result = userService.addEntity(user);
		
		return result;
	}

	@RequestMapping("/doDelete")
	@ResponseBody
	public Result doDelete(UacUser user) {
		Result result = userService.deleteEntity(user);
		
		return result;
	}

	@RequestMapping("/doUpdate")
	@ResponseBody
	public Result doUpdate(UacUser user) {
		Result result = userService.updateEntity(user);
		
		return result;
	}

	@RequestMapping("/getAllByPage")
	@ResponseBody
	public Result getAllByPage(Integer pageNo, Integer pageSize,
			UacUser user) {
		Result result = userService.getAllEntityByPage(pageNo, pageSize, user);
		
		return result;
	}
	
	@RequestMapping("/doGet")
	@ResponseBody
	public Result doGet(UacUser user){
		Result result=userService.getEntity(user.getId());
		
		return result;	
	}
}
