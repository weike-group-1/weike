package cn.ucai.weike.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ucai.weike.dao.UacUserRoleDao;
import cn.ucai.weike.dto.UacRoleDto;
import cn.ucai.weike.dto.UacUserDto;
import cn.ucai.weike.dto.UacUserRoleDto;
import cn.ucai.weike.pojo.UacUserRole;
import cn.ucai.weike.service.UacUserRoleService;
import cn.ucai.weike.utils.MyBeanUtils;
import cn.ucai.weike.utils.Result;

@Service("userRoleService")
public class UacUserRoleServiceImpl implements UacUserRoleService {

	@Resource
	UacUserRoleDao userRoleDao;
	
	@Override
	@Transactional
	public Result addEntity(UacUserRole t) {
		Result result = new Result();
		if(t.getUacUser()!=null&&t.getUacRole()!=null){
			userRoleDao.addEntity(t);
			result.setRetCode(0);
			result.setRetMsg(true);
			result.setRetData(1);
		}else{
			result.setRetMsg(false);
			result.setRetCode(2000);
			result.setRetData("请绑定用户和权限");
		}
		return result;
	}

	@Override
	@Transactional
	public Result deleteEntity(UacUserRole t) {
		Result result = new Result();
		t = userRoleDao.getEntity(UacUserRole.class, t.getId());
		if (t != null) {
			userRoleDao.deleteEntity(t);
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
	public Result updateEntity(UacUserRole t) {
		Result result = new Result();
		if (t != null) {
			userRoleDao.saveOrUpdateEntity(t);
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
		UacUserRole userRole = userRoleDao.getEntity(UacUserRole.class, id);
		if (userRole != null) {
			UacUserDto userDto=(UacUserDto) MyBeanUtils.copyObjProperties(userRole.getUacUser(), UacUserDto.class);
			UacRoleDto roleDto=(UacRoleDto) MyBeanUtils.copyObjProperties(userRole.getUacRole(), UacRoleDto.class);
			UacUserRoleDto userRoleDto=new UacUserRoleDto(userRole.getId(),userDto,roleDto);
			result.setRetCode(0);
			result.setRetMsg(true);
			result.setRetData(userRoleDto);
		}
		return result;
	}

	@Override
	public Result getAllEntityByPage(Integer pageNo, Integer pageSize,
			Object... objs) {
		UacUserRole userRole=(UacUserRole)objs[0];
		Result result=new Result();
		result.setRetCode(1001);
		result.setRetMsg(false);
		String hql="from UacUserRole";
		List<UacUserRole> list = null;
		if(userRole.getUacUser()!=null){
			hql=hql+" where uacUser=?";
			list=userRoleDao.getPageListByCondition(hql, pageNo, pageSize,userRole.getUacUser());
		}else if(userRole.getUacRole()!=null){
			hql=hql+" where uacRole=?";
			list=userRoleDao.getPageListByCondition(hql, pageNo, pageSize,userRole.getUacRole());
		}else{
			list=userRoleDao.getPageListByCondition(hql, pageNo, pageSize);
		}
		if (list != null) {
			List<UacUserRoleDto> listDto=new ArrayList<UacUserRoleDto>();
			
			for(int i=0;i<list.size();i++){
				UacUserRole uur=list.get(i);
				UacUserDto userDto=(UacUserDto) MyBeanUtils.copyObjProperties(userRole.getUacUser(), UacUserDto.class);
				UacRoleDto roleDto=(UacRoleDto) MyBeanUtils.copyObjProperties(userRole.getUacRole(), UacRoleDto.class);
				UacUserRoleDto userRoleDto=new UacUserRoleDto(userRole.getId(),userDto,roleDto);
				listDto.add(userRoleDto);
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
		String hql = "select count(*) from UacUserRole uur";
		Integer count=userRoleDao.getCount(hql);
		if(count!=null){
			result.setRetCode(0);
			result.setRetMsg(true);
			result.setRetData(count);
		}
		return result;
	}

}
