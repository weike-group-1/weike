package cn.ucai.weike.dao.impl;

import org.springframework.stereotype.Repository;

import cn.ucai.weike.dao.UacUserDao;
import cn.ucai.weike.pojo.UacUser;

@Repository("userDao")
public class UacUserDaoImpl extends BaseDaoImpl<UacUser> implements UacUserDao {
	
	public UacUserDaoImpl(){
		System.out.println("jinlai");
	}

}
