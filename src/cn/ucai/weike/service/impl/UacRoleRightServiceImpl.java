package cn.ucai.weike.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ucai.weike.dao.UacRoleRightDao;
import cn.ucai.weike.dto.UacRightDto;
import cn.ucai.weike.dto.UacRoleDto;
import cn.ucai.weike.dto.UacRoleRightDto;
import cn.ucai.weike.pojo.UacRoleRight;
import cn.ucai.weike.service.UacRoleRightService;
import cn.ucai.weike.utils.MyBeanUtils;
import cn.ucai.weike.utils.Result;

@Service("roleRightService")
public class UacRoleRightServiceImpl implements UacRoleRightService {

	@Resource
	UacRoleRightDao roleRightDao;
	
	@Override
	@Transactional
	public Result addEntity(UacRoleRight t) {
		Result result = new Result();
		if(t.getUacRight()!=null&&t.getUacRole()!=null){
			roleRightDao.addEntity(t);
			result.setRetCode(0);
			result.setRetMsg(true);
			result.setRetData(1);
		}else{
			result.setRetMsg(false);
			result.setRetCode(2000);
			result.setRetData("请绑定角色和权限");
		}
		return result;
	}

	@Override
	@Transactional
	public Result deleteEntity(UacRoleRight t) {
		Result result = new Result();
		t = roleRightDao.getEntity(UacRoleRight.class, t.getId());
		if (t != null) {
			roleRightDao.deleteEntity(t);
			result.setRetCode(0);
			result.setRetMsg(true);
			result.setRetData(1);
		} else {
			result.setRetMsg(false);
			result.setRetCode(1001);
		}
		return result;
	}

	@Override
	@Transactional
	public Result updateEntity(UacRoleRight t) {
		Result result = new Result();
		if (t != null) {
			roleRightDao.saveOrUpdateEntity(t);
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
		UacRoleRight right = roleRightDao.getEntity(UacRoleRight.class, id);
		if (right != null) {
			result.setRetCode(0);
			result.setRetMsg(true);
			result.setRetData(right);
		}
		return result;
	}

	@Override
	public Result getAllEntityByPage(Integer pageNo, Integer pageSize,
			Object... objs) {
		UacRoleRight urr=(UacRoleRight)objs[0];
		Result result=new Result();
		result.setRetCode(1001);
		result.setRetMsg(false);
		String hql="from UacRoleRight";
		List<UacRoleRight> list = null;
		if(urr.getUacRight()!=null){
			hql=hql+" where uacRight=?";
			list=roleRightDao.getPageListByCondition(hql, pageNo, pageSize,urr.getUacRight());
		}else if(urr.getUacRole()!=null){
			hql=hql+" where uacRole=?";
			list=roleRightDao.getPageListByCondition(hql, pageNo, pageSize,urr.getUacRole());
		}else{
			list=roleRightDao.getPageListByCondition(hql, pageNo, pageSize);
		}
		if (list != null) {
			List<UacRoleRightDto> listDto=new ArrayList<UacRoleRightDto>();
			
			for(int i=0;i<list.size();i++){
				UacRoleRight roleRight=list.get(i);
				UacRoleDto roleDto=(UacRoleDto) MyBeanUtils.copyObjProperties(roleRight.getUacRole(), UacRoleDto.class);
				UacRightDto rightDto=(UacRightDto) MyBeanUtils.copyObjProperties(roleRight.getUacRight(), UacRightDto.class);
				UacRoleRightDto urrDto=new UacRoleRightDto(roleRight.getId(),roleDto,rightDto);
				listDto.add(urrDto);
				/************/
			}	
			
			result.setRetCode(0);
			result.setRetData(listDto);
			result.setRetMsg(true);
		}
		return result;
	}

	@Override
	public Result getEntityCount() {
		Result result =new Result();
		result.setRetCode(1001);
		result.setRetMsg(false);
		String hql = "select count(*) from UacRoleRight urr";
		Integer count=roleRightDao.getCount(hql);
		if(count!=null){
			result.setRetCode(0);
			result.setRetMsg(true);
			result.setRetData(count);
		}
		return result;
	}


}
