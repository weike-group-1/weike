package cn.ucai.weike.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

	// 添加实体
	void addEntity(T t);

	// 删除实体
	void deleteEntity(T t);

	// 修改实体
	void updateEntity(T t);

	// 更新实体
	void saveOrUpdateEntity(T t);
	
	//根据id查找单条数据
	T getEntity(Class clazz,Serializable id);
	
	//根据条件查找数据列表
	List<T> getListByCondition(String hql,Object...objects);
	
	//根据条件，页码，查询长度查找数据列表
	List<T> getPageListByCondition(String hql,Integer pageNo,Integer pageSize,Object...objects);

}
