package cn.ucai.weike.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

public class MyBeanUtils {
	
	
	/**
	 * 将对象从一个类型的list转换成另一种类型的list，拷贝他们的属性值。
	 * @param originList
	 * @param targetType
	 * @return
	 */
	public static List copyProperties(List originList,Class targetType){
		
		List targetList =  new ArrayList();
		try {    
			for(Object fromObj:originList){
				Object targetObj = targetType.newInstance();
				
				BeanUtils.copyProperties(fromObj, targetObj);
				targetList.add(targetObj);
			}			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return targetList;
	}
	
	public static Object copyObjProperties(Object origin,Class targetType){
		Object targetObj=null;
		try {
			   targetObj = targetType.newInstance();
				BeanUtils.copyProperties(origin, targetObj);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return targetObj;
	}
}
