package cn.ucai.weike.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ucai.weike.dto.UacRoleDto;
import cn.ucai.weike.dto.UacUserDto;
import cn.ucai.weike.pojo.UacRole;
import cn.ucai.weike.pojo.UacUser;
import cn.ucai.weike.pojo.UacUserRole;
import cn.ucai.weike.service.UacRoleService;
import cn.ucai.weike.service.UacUserRoleService;
import cn.ucai.weike.service.UacUserService;
import cn.ucai.weike.utils.MyBeanUtils;
import cn.ucai.weike.utils.Result;

@Controller
@RequestMapping("/userRole")
public class UserRoleController {

	@Resource
	UacUserRoleService userRoleService;

	@Resource
	UacUserService userService;

	@Resource
	UacRoleService roleService;

	private UacUserRole setUacUserRole(Integer uacUserId, Integer uacRoleId) {
		UacUser user = null;
		UacRole role = null;
		// 获取User
		UacUserDto userDto = (UacUserDto) userService.getEntity(uacUserId)
				.getRetData();
		if (userDto != null) {
			user = (UacUser) MyBeanUtils.copyObjProperties(userDto,
					UacUser.class);
		}
		// 获取uacRight
		UacRoleDto roleDto = (UacRoleDto) roleService.getEntity(uacRoleId)
				.getRetData();
		if (roleDto != null) {
			role = (UacRole) MyBeanUtils.copyObjProperties(roleDto,
					UacRole.class);
		}

		UacUserRole uur = new UacUserRole(user, role);
		return uur;
	}

	@RequestMapping("/getCount")
	@ResponseBody
	public Result getCount() {
		Result result = userRoleService.getEntityCount();
		return result;
	}

	@RequestMapping("/doAdd")
	@ResponseBody
	public Result doAdd(Integer uacUserId, Integer uacRoleId) {
		UacUserRole uur = this.setUacUserRole(uacUserId, uacRoleId);
		Result result = userRoleService.addEntity(uur);
		return result;
	}

	@RequestMapping("/doDelete")
	@ResponseBody
	public Result doDelete(UacUserRole uur) {
		Result result = userRoleService.deleteEntity(uur);
		return result;
	}

	@RequestMapping("/doUpdate")
	@ResponseBody
	public Result doUpdate(Integer id, Integer uacUserId, Integer uacRoleId) {
		UacUserRole uur = this.setUacUserRole(uacUserId, uacRoleId);
		uur.setId(id);
		Result result = userRoleService.updateEntity(uur);
		return result;
	}

	@RequestMapping("/getAllByPage")
	@ResponseBody
	public Result getAllByPage(Integer pageNo, Integer pageSize,
			Integer uacUserId, Integer uacRoleId) {
		UacUserRole uur = this.setUacUserRole(uacUserId, uacRoleId);
		Result result = userRoleService.getAllEntityByPage(pageNo, pageSize,
				uur);
		return result;
	}
	
	@RequestMapping("/doGet")
	@ResponseBody
	public Result doGet(Integer id){
		Result result=userRoleService.getEntity(id);
		return result;
	}
}
