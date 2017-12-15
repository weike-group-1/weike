package cn.ucai.weike.service;

import cn.ucai.weike.pojo.UacRoleRight;

public interface UacRoleRightService extends BaseService<UacRoleRight>{

	//删除角色时在UacRoleRight表中删除绑定的权限
	
	//删除权限时在UacRoleRight表中删除绑定的角色
	
	//hibernate-spring-springMVC框架默认设置级联操作，以上操作在在删除关联对象时自动删除
}
