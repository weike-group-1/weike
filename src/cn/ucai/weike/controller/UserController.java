package cn.ucai.weike.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ucai.weike.service.UacUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	UacUserService userService;
	
	@RequestMapping("/getCount")
	public String getCount(){
		
		Integer i=userService.getUserCount();
		System.out.println(i);
		return "";
	}
}
