package cn.ucai.weike.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ucai.weike.dao.UacRightDao;
import cn.ucai.weike.dto.UacRightDto;
import cn.ucai.weike.pojo.UacRight;
import cn.ucai.weike.service.UacRightService;
import cn.ucai.weike.utils.MyBeanUtils;
import cn.ucai.weike.utils.Result;

@Service("uacRightService")
public class UacRightServiceImpl implements UacRightService {

	@Resource
	UacRightDao uacRightDao;

	@Override
	@Transactional
	public Result addEntity(UacRight t) {
		Result result = new Result();
		if (t.getCode() != null && t.getName() != null) {
			uacRightDao.addEntity(t);
			result.setRetCode(0);
			result.setRetMsg(true);
			result.setRetData(1);
		} else {
			result.setRetMsg(false);
			result.setRetCode(2000);
			result.setRetData("编码和名称不能为空");
		}
		return result;
	}

	@Override
	@Transactional
	public Result deleteEntity(UacRight t) {
		Result result = new Result();
		t = uacRightDao.getEntity(UacRight.class, t.getId());
		if (t != null) {
			uacRightDao.deleteEntity(t);
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
	public Result updateEntity(UacRight t) {
		Result result = new Result();
		if (t != null) {
			uacRightDao.saveOrUpdateEntity(t);
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
		UacRight right = uacRightDao.getEntity(UacRight.class, id);
		if (right != null) {
			UacRightDto rightDto=(UacRightDto)MyBeanUtils.copyObjProperties(right, UacRightDto.class);
			result.setRetCode(0);
			result.setRetMsg(true);
			result.setRetData(rightDto);
		}
		return result;
	}

	@Override
	public Result getAllEntityByPage(Integer pageNo, Integer pageSize,
			Object... objs) {
		UacRight right = (UacRight) objs[0];
		Result result = new Result();
		result.setRetCode(1001);
		result.setRetMsg(false);
		String hql = "from UacRight";
		Object objects = null;
		List<UacRight> list = null;
		if (right.getName() != null) {
			hql = hql + " where name like ?";
			objects = "%" + right.getName() + "%";
		}
		if (objects != null) {
			list = uacRightDao.getPageListByCondition(hql, pageNo, pageSize);
		}else{
			list=uacRightDao.getPageListByCondition(hql, pageNo, pageSize, objects);
		}
		if(list!=null){
			List<UacRightDto> listDto=MyBeanUtils.copyProperties(list, UacRightDto.class);
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
		String hql = "select count(*) from UacRight ur";
		Integer count=uacRightDao.getCount(hql);
		if(count!=null){
			result.setRetCode(0);
			result.setRetMsg(true);
			result.setRetData(count);
		}
		return result;
	}

}
