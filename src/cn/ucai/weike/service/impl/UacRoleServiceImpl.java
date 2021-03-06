package cn.ucai.weike.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ucai.weike.dao.UacRoleDao;
import cn.ucai.weike.dto.UacRoleDto;
import cn.ucai.weike.pojo.UacRole;
import cn.ucai.weike.service.UacRoleService;
import cn.ucai.weike.utils.MyBeanUtils;
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
			UacRoleDto roleDto=(UacRoleDto)MyBeanUtils.copyObjProperties(role, UacRoleDto.class);
			result.setRetCode(0);
			result.setRetMsg(true);
			result.setRetData(roleDto);
		}
		return result;
	}

	@Override
	public Result getAllEntityByPage(Integer pageNo, Integer pageSize,
			Object... objs) {
		UacRole role = (UacRole) objs[0];

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
			List<UacRoleDto> listDto=MyBeanUtils.copyProperties(list, UacRoleDto.class);
			result.setRetCode(0);
			result.setRetData(listDto);
			result.setRetMsg(true);
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
