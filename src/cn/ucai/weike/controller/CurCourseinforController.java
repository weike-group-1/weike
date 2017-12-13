package cn.ucai.weike.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ucai.weike.service.CurCourseinforService;

@Controller
@RequestMapping("/curCourseinfor")
public class CurCourseinforController {

	@Resource
	CurCourseinforService curCourseinforService;
	
	
}
