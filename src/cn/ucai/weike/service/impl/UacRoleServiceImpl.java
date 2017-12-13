package cn.ucai.weike.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ucai.weike.dao.UacRoleDao;
import cn.ucai.weike.pojo.UacRole;
import cn.ucai.weike.service.UacRoleService;
import cn.ucai.weike.utils.Result;

@Service("roleService")
public class UacRoleServiceImpl implements UacRoleService {

	@Resource
	UacRoleDao roleDao;

	@Override
	@Transactional
	public Result addEntity(UacRole t) {
		Result result = new Result();
		roleDao.addEntity(t);
		result.setRetCode(0);
		result.setRetMsg(true);
		result.setRetData(1);

		return result;
	}

	@Override
	@Transactional
	public Result deleteEntity(UacRole t) {
		Result result = new Result();
		t = roleDao.getEntity(UacRole.class, t.getId());
		if (t != null) {
			roleDao.deleteEntity(t);
			result.setRetCode(0);
			result.setRetMsg(true);
			result.setRetData(1);
		} else {
			result.setRetCode(1001);
			result.setRetMsg(false);
		}
		return result;
	}

	@Override
	@Transactional
	public Result updateEntity(UacRole t) {
		Result result = new Result();
		if (t!= null) {
			System.out.println(t);
			roleDao.saveOrUpdateEntity(t);
			result.setRetCode(0);
			result.setRetMsg(true);
			result.setRetData(1);
		} else {
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
		UacRole role = roleDao.getEntity(UacRole.class, id);
		if (role != null) {
			result.setRetCode(0);
			result.setRetMsg(true);
			result.setRetData(role);
		}
		return result;
	}

	@Override
	public Result getAllEntityByPage(Integer pageNo, Integer pageSize,
			Object obj) {
		UacRole role = (UacRole) obj;

		Result result = new Result();
		result.setRetCode(1001);
		result.setRetMsg(false);
		String hql = "from UacRole";
		String objects = null;
		List<UacRole> list = null;
		if(role.getRoleName()!=null){
			hql = hql + " where roleName like ?";
			objects = "%" + role.getRoleName() + "%";
		}
		if (objects != null) {
			list = roleDao.getPageListByCondition(hql, pageNo, pageSize,objects);
		} else {
			list = roleDao.getPageListByCondition(hql, pageNo, pageSize);
		}
		if (list != null) {
			result.setRetCode(0);
			result.setRetData(list);
		}
		return result;
	}

	@Override
	public Result getEntityCount() {
		Result result = new Result();
		result.setRetCode(1001);
		result.setRetMsg(false);
		String hql = "select count(*) from UacRole r";
		Integer count = roleDao.getCount(hql);
		if (count != null) {
			result.setRetCode(0);
			result.setRetMsg(true);
			result.setRetData(count);
		}
		return result;
	}

}
