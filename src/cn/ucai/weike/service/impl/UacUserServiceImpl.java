package cn.ucai.weike.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ucai.weike.dao.UacUserDao;
import cn.ucai.weike.dto.UacUserDto;
import cn.ucai.weike.pojo.UacUser;
import cn.ucai.weike.service.UacUserService;
import cn.ucai.weike.utils.MyBeanUtils;
import cn.ucai.weike.utils.Result;

@Service("userService")
public class UacUserServiceImpl implements UacUserService {

	@Resource
	UacUserDao userDao;

	@Override
	@Transactional
	public Result addEntity(UacUser t) {
		Result result = new Result();
		if (t.getAccount() != null && t.getPassword() != null
				&& t.getEmail() != null) {
			userDao.addEntity(t);
			result.setRetCode(0);
			result.setRetMsg(true);
			result.setRetData(1);
		} else {
			result.setRetMsg(false);
			result.setRetCode(2000);
			result.setRetData("账号，密码，邮箱不能为空");
		}

		return result;
	}

	@Override
	@Transactional
	public Result deleteEntity(UacUser t) {
		// TODO Auto-generated method stub
		Result result = new Result();
		t = userDao.getEntity(UacUser.class, t.getId());
		if(t!=null){
			userDao.deleteEntity(t);
			result.setRetCode(0);
			result.setRetMsg(true);
			result.setRetData(1);
		}else{
			result.setRetCode(1001);
			result.setRetMsg(false);
		}
		return result;
	}

	@Override
	@Transactional
	public Result updateEntity(UacUser t) {
		Result result = new Result();
		if(t!=null){
			userDao.saveOrUpdateEntity(t);;
			result.setRetCode(0);
			result.setRetMsg(true);
			result.setRetData(1);
		}else{
			result.setRetCode(1001);
			result.setRetMsg(false);
		}
		
		return result;
	}

	@Override
	public Result getEntity(Serializable id) {
		Result result = new Result();
		result.setRetCode(1001);
		result.setRetMsg(false);
		UacUser user = userDao.getEntity(UacUser.class, id);
		if (user != null) {
			UacUserDto userDto=(UacUserDto)MyBeanUtils.copyObjProperties(user, UacUserDto.class);
			result.setRetCode(0);
			result.setRetMsg(true);
			result.setRetData(userDto);
		}
		return result;
	}

	@Override
	public Result getAllEntityByPage(Integer pageNo, Integer pageSize,
			Object...objs) {
		UacUser user=(UacUser)objs[0];
		Result result = new Result();
		result.setRetCode(1001);
		result.setRetMsg(false);
		String hql = "from UacUser";
		String objects = null;
		if (user.getAccount() != null) {
			hql = hql + " where account like ?";
			objects = "%" + user.getAccount() + "%";
		} else if (user.getUsername() != null) {
			hql = hql + " where username like ?";
			objects = "%" + user.getUsername() + "%";
		}
		List<UacUser> list =null;
		if(objects!=null){
			list = userDao.getPageListByCondition(hql, pageNo,
					pageSize,objects);
		}else{
			list = userDao.getPageListByCondition(hql, pageNo,
					pageSize);
		}
		if (list != null) {
			List<UacUserDto> listDto=MyBeanUtils.copyProperties(list, UacUserDto.class);
			result.setRetCode(0);
			result.setRetMsg(true);
			result.setRetData(listDto);
		}
		return result;
	}

	@Override
	public Result getEntityCount() {
		Result result = new Result();
		result.setRetCode(1001);
		result.setRetMsg(false);
		String hql = "select count(*) from UacUser u";
		Integer count = userDao.getCount(hql);
		if (count != null) {
			result.setRetCode(0);
			result.setRetMsg(true);
			result.setRetData(count);
		}
		return result;
	}

}
