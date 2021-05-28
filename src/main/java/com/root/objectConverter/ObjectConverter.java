package com.root.objectConverter;

import com.root.bean.HomeOwnerBean;
import com.root.bean.LocationBean;
import com.root.bean.PropertyBean;
import com.root.bean.UserBean;
import com.root.entity.HomeOwnerEntity;
import com.root.entity.LocationEntity;
import com.root.entity.PropertyEntity;
import com.root.entity.UserEntity;

public class ObjectConverter {

	public HomeOwnerEntity convertHomeBenasToEntity(HomeOwnerBean home) {

		HomeOwnerEntity entity = new HomeOwnerEntity();

		entity.setDob(home.getDob());
		entity.setEmail(home.getEmail());
		entity.setFname(home.getFname());
		entity.setLname(home.getLname());
		entity.setOwnerId(home.getOwnerId());
		entity.setRetired(home.getRetired());
		entity.setSocialSocietyNumber(home.getSocialSocietyNumber());

		return entity;

	}

	public LocationEntity convertLocationBeansToEntity(LocationBean bean) {
		LocationEntity entity = new LocationEntity();

		entity.setLocation_id(bean.getLocation_id());
		entity.setAddress_line_1(bean.getAddress_line_1());
		entity.setAddress_line_2(bean.getAddress_line_2());
		entity.setCity(bean.getCity());
		entity.setLocation_state(bean.getLocation_state());
		entity.setResidence_type(bean.getResidence_type());
		entity.setResidence_use(bean.getResidence_use());
		entity.setZip_code(bean.getZip_code());

		return entity;

	}

	

	public LocationBean convertLocationEntityToBean(LocationEntity entity) {
		
		LocationBean bean = new LocationBean();

		bean.setLocation_id(entity.getLocation_id());
		bean.setAddress_line_1(entity.getAddress_line_1());
		bean.setAddress_line_2(entity.getAddress_line_2());
		bean.setCity(entity.getCity());
		bean.setLocation_state(entity.getLocation_state());
		bean.setResidence_type(entity.getResidence_type());
		bean.setResidence_use(entity.getResidence_use());
		bean.setZip_code(entity.getZip_code());

		return bean;

	}
	
	public UserEntity convertUserBeansToEntity(UserBean bean) {
		UserEntity entity = new UserEntity();

		entity.setUser_id(bean.getuserid());
		entity.setUser_name(bean.getUsername());
		entity.setPassword(bean.getPassword());
		entity.setConfirmPassword(bean.getCpassword());
		entity.setRole(bean.getRole());
		entity.setEmail(bean.getEmail());
		return entity;

	}
	public UserBean convertUserEntityToBean(UserEntity entity) {
		UserBean bean = new UserBean();

		bean.setuserid(entity.getUser_id());
		bean.setUsername(entity.getUser_name());
		bean.setPassword(entity.getPassword());
		bean.setCpassword(entity.getConfirmPassword());
		bean.setRole(entity.getRole());
		bean.setEmail(entity.getEmail());
		return bean;

	}


	public PropertyEntity convertPropertyBeanToEntity(PropertyBean propertyBean) {
		PropertyEntity propertyEntity = new PropertyEntity();

		propertyEntity.setDwelling_type(propertyBean.getDwelling_type());
		propertyEntity.setFull_baths(propertyBean.getFull_baths());
		propertyEntity.setGarage_type(propertyBean.getGarage_type());
		propertyEntity.setHalf_baths(propertyBean.getHalf_baths());
		propertyEntity.setMarket_value(propertyBean.getMarket_value());
		propertyEntity.setPool(propertyBean.getPool());
		propertyEntity.setProperty_id(propertyBean.getProperty_id());
		propertyEntity.setRoof_material(propertyBean.getRoof_material());
		propertyEntity.setSquare_footage(propertyBean.getSquare_footage());
		propertyEntity.setYear_built(propertyBean.getYear_built());

		return propertyEntity;

	}
	
	
	
	public PropertyBean convertPropertyEntityToBean(PropertyEntity entity) {
		PropertyBean bean= new PropertyBean();

		bean.setDwelling_type(entity.getDwelling_type());
		bean.setFull_baths(entity.getFull_baths());
		bean.setGarage_type(entity.getGarage_type());
		bean.setHalf_baths(entity.getHalf_baths());
		bean.setMarket_value(entity.getMarket_value());
		bean.setPool(entity.getPool());
		bean.setProperty_id(entity.getProperty_id());
		bean.setRoof_material(entity.getRoof_material());
		bean.setSquare_footage(entity.getSquare_footage());
		bean.setYear_built(entity.getYear_built());

		return bean;

	}
	

}
