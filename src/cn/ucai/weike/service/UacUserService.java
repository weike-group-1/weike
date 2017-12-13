package cn.ucai.weike.service;

import java.io.Serializable;

import cn.ucai.weike.pojo.UacUser;
import cn.ucai.weike.utils.Result;

public interface UacUserService {

	Result addUser(UacUser t);
	
	Result deleteUser(UacUser t);
	
	Result updateUser(UacUser t);
	
	Result getUser(Serializable id);
	
	Result getAllUserByPage(Integer pageNo,Integer pageSize,UacUser user);
	
	Result getUserCount();

}
