package cn.ucai.weike.service;

import java.io.Serializable;

import cn.ucai.weike.pojo.UacUser;
import cn.ucai.weike.utils.Result;

public interface UacUserService {

	void addUser(UacUser t);
	
	void deleteUser(UacUser t);
	
	void updateUser(UacUser t);
	
	Result getUser(Serializable id);
	
	Result getAllUserByPage(Integer pageNo,Integer pageSize,Object...objects);
	
	Result getUserCount();

}
