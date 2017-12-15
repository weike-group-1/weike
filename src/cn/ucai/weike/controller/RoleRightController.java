package cn.ucai.weike.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ucai.weike.dto.UacRightDto;
import cn.ucai.weike.dto.UacRoleDto;
import cn.ucai.weike.pojo.UacRight;
import cn.ucai.weike.pojo.UacRole;
import cn.ucai.weike.pojo.UacRoleRight;
import cn.ucai.weike.service.UacRightService;
import cn.ucai.weike.service.UacRoleRightService;
import cn.ucai.weike.service.UacRoleService;
import cn.ucai.weike.utils.MyBeanUtils;
import cn.ucai.weike.utils.Result;

@Controller
@RequestMapping("/roleRight")
public class RoleRightController {

	@Resource
	UacRoleRightService roleRightService;

	@Resource
	UacRightService uacRightService;

	@Resource
	UacRoleService roleService;

	private UacRoleRight setUacRoleRight(Integer uacRoleId, Integer uacRightId) {
		UacRole uacRole=null;
		UacRight uacRight=null;
		// 获取uacRole
		UacRoleDto uacRoleDto = (UacRoleDto) roleService.getEntity(uacRoleId)
				.getRetData();
		if(uacRoleDto!=null){
			uacRole = (UacRole) MyBeanUtils.copyObjProperties(uacRoleDto,
					UacRole.class);
		}
		// 获取uacRight
		UacRightDto uacRightDto = (UacRightDto) uacRightService.getEntity(
				uacRightId).getRetData();
		if(uacRightDto!=null){
			uacRight = (UacRight) MyBeanUtils.copyObjProperties(
					uacRightDto, UacRight.class);
		}
		UacRoleRight urr = new UacRoleRight(uacRole, uacRight);
		return urr;
	}

	@RequestMapping("/getCount")
	@ResponseBody
	public Result getCount() {
		Result result = roleRightService.getEntityCount();
		System.out.println(result);
		return result;
	}

	@RequestMapping("/doAdd")
	@ResponseBody
	public Result doAdd(Integer uacRoleId, Integer uacRightId) {
		UacRoleRight urr = this.setUacRoleRight(uacRoleId,uacRightId);
		Result result = roleRightService.addEntity(urr);
		System.out.println(result);
		return result;
	}

	@RequestMapping("/doDelete")
	@ResponseBody
	public Result doDelete(UacRoleRight urr) {
		Result result = roleRightService.deleteEntity(urr);
		System.out.println(result);
		return result;
	}

	@RequestMapping("/doUpdate")
	@ResponseBody
	public Result doUpdate(UacRoleRight urr) {
		Result result = roleRightService.updateEntity(urr);
		System.out.println(result);
		return result;
	}

	@RequestMapping("/getAllByPage")
	@ResponseBody
	public Result getAllByPage(Integer pageNo, Integer pageSize,
			Integer uacRoleId, Integer uacRightId) {
		System.out.println("进来了");
		UacRoleRight urr = this.setUacRoleRight(uacRoleId,uacRightId);
		Result result = roleRightService.getAllEntityByPage(pageNo, pageSize,urr);
		System.out.println(result);
		return result;
	}

	@RequestMapping("/doGet")
	@ResponseBody
	public Result doGet(UacRoleRight urr) {
		Result result = roleRightService.getEntity(urr.getId());
		System.out.println(result);
		return result;
	}

}
