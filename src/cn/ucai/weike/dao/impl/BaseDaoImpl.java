package cn.ucai.weike.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.ucai.weike.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	// HibernateDaoSupport需要依赖于sessionFactory对象
	@Resource(name="sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
	
	@Override
	public void addEntity(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(t);
		
	}

	@Override
	public void deleteEntity(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public void updateEntity(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void saveOrUpdateEntity(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().saveOrUpdate(t);
	}

	@Override
	public T getEntity(Class clazz,Serializable id) {
		T t=(T) this.getHibernateTemplate().get(clazz, id);
		
		return t;
	}

	@Override
	public List<T> getListByCondition(String hql, Object... objects) {
		Session session=this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql);
		if(objects!=null){
			for(int i=0;i<objects.length;i++){
				query.setParameter(i, objects[i]);
			}
		}
		List<T> list=query.list();
		session.close();
		
		return list;
	}

	@Override
	public List<T> getPageListByCondition(String hql, Integer pageNo,
			Integer pageSize, Object... objects) {
		Session session=this.getHibernateTemplate().getSessionFactory().openSession();
		Query query=session.createQuery(hql);
		if(objects!=null){
			for(int i=0;i<objects.length;i++){
				query.setParameter(i, objects[i]);
			}
		}
		query.setFirstResult((pageNo-1)*pageSize);
		query.setMaxResults(pageSize);
		List<T> list=query.list();
		session.close();
		
		return list;
	}

}
