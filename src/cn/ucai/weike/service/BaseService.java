package cn.ucai.weike.service;

import java.io.Serializable;

import cn.ucai.weike.utils.Result;

public interface BaseService<T> {

    Result addEntity(T t);
	
    Result deleteEntity(T t);
	
    Result updateEntity(T t);
	
	Result getEntity(Serializable id);
	
	Result getAllEntityByPage(Integer pageNo,Integer pageSize,Object... objs);
	
	Result getEntityCount();
}
