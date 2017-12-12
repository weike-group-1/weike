package cn.ucai.weike.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ucai.weike.dao.UacUserDao;
import cn.ucai.weike.pojo.UacUser;
import cn.ucai.weike.service.UacUserService;
import cn.ucai.weike.utils.Result;

@Service("userService")
public class UacUserServiceImpl implements UacUserService {

	@Resource
	UacUserDao userDao; 
	
	@Override
	@Transactional
	public void addUser(UacUser t) {
		// TODO Auto-generated method stub
		userDao.addEntity(t);
	}

	@Override
	@Transactional
	public void deleteUser(UacUser t) {
		// TODO Auto-generated method stub
		userDao.deleteEntity(t);
	}

	@Override
	@Transactional
	public void updateUser(UacUser t) {
		// TODO Auto-generated method stub
		userDao.updateEntity(t);
	}

	@Override
	public Result getUser(Serializable id) {
		Result result=new Result();
		result.setRetCode(1001);
		result.setRetMsg(false);
		UacUser user=userDao.getEntity(UacUser.class, id);
		if(user!=null){
			result.setRetCode(0);
			result.setRetMsg(true);
			result.setRetData(user);
		}
		return result;
	}

	@Override
	public Result getAllUserByPage(Integer pageNo, Integer pageSize,
			Object... objects) {
		Result result =new Result();
		result.setRetCode(1001);
		result.setRetMsg(false);
		String hql="from UacUser";
		List<UacUser> list=userDao.getPageListByCondition(hql, pageNo, pageSize, null);
		return result;
	}

	@Override
	public Result getUserCount() {
		Result result =new Result();
		result.setRetCode(1001);
		result.setRetMsg(false);
		String hql="select count(*) from UacUser u";
		Integer count=userDao.getCount(hql);
		if(count!=null){
			result.setRetCode(0);
			result.setRetMsg(true);
			result.setRetData(count);
		}
		return result;
	}
	

	
}
