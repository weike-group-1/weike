package cn.ucai.weike.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ucai.weike.pojo.UacRight;
import cn.ucai.weike.service.UacRightService;
import cn.ucai.weike.utils.Result;

@Controller
@RequestMapping("/uacRight")
public class UacRightController {

	@Resource
	UacRightService uacRightService;
	
	@RequestMapping("/getCount")
	@ResponseBody
	public Result getCount(){
		Result result=uacRightService.getEntityCount();
		System.out.println(result);
		return result;
	}
	@RequestMapping("/doAdd")
	@ResponseBody
	public Result doAdd(UacRight right) {
		Result result = uacRightService.addEntity(right);
		System.out.println(result);
		return result;
	}

	@RequestMapping("/doDelete")
	@ResponseBody
	public Result doDelete(UacRight right) {
		Result result = uacRightService.deleteEntity(right);
		System.out.println(result);
		return result;
	}

	@RequestMapping("/doUpdate")
	@ResponseBody
	public Result doUpdate(UacRight right) {
		Result result = uacRightService.updateEntity(right);
		System.out.println(result);
		return result;
	}

	@RequestMapping("/getAllByPage")
	@ResponseBody
	public Result getAllByPage(Integer pageNo, Integer pageSize,
			UacRight right) {
		Result result = uacRightService.getAllEntityByPage(pageNo, pageSize, right);
		System.out.println(result);
		return result;
	}
	
	@RequestMapping("/doGet")
	@ResponseBody
	public Result doGet(UacRight right){
		Result result=uacRightService.getEntity(right.getId());
		System.out.println(result);
		return result;	
	}
}
