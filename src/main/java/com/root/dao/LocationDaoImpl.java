package com.root.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.root.bean.LocationBean;
import com.root.bean.PropertyBean;
import com.root.entity.LocationEntity;
import com.root.entity.PropertyEntity;
import com.root.entity.UserEntity;

public class LocationDaoImpl implements LocationDao {

	public void addLocationWithProperty(LocationBean locationBean, PropertyBean propertyBean, UserEntity userEntity) {

		EntityManager entityManager = null;

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			entityManager = entityManagerFactory.createEntityManager();

			LocationEntity locationEntity = new LocationEntity();
			PropertyEntity propertyEntity = new PropertyEntity();
			
			
			System.out.println("dao "+locationBean +""+ propertyBean+""+userEntity);

			/**
			 * convert propertyBean object to propertyEntity because we need to give entity
			 * object to our database
			 */

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

			/**
			 * convert LocationBean object to LocationEntity because we need to give entity
			 * object to our database
			 */

			locationEntity.setAddress_line_1(locationBean.getAddress_line_1());
			locationEntity.setAddress_line_2(locationBean.getAddress_line_2());
			locationEntity.setCity(locationBean.getCity());
			locationEntity.setLocation_id(locationBean.getLocation_id());
			locationEntity.setLocation_state(locationBean.getLocation_state());
			locationEntity.setResidence_type(locationBean.getResidence_type());
			locationEntity.setResidence_use(locationBean.getResidence_use());
			locationEntity.setZip_code(locationBean.getZip_code());
			
			
			locationEntity.setPropertyEntity(propertyEntity);
			locationEntity.setUserEntity(userEntity);

			entityManager.getTransaction().begin();
			entityManager.persist(locationEntity);
			System.out.println("location and property add successfully");
			entityManager.getTransaction().commit();

		} catch (Exception e) {

		} finally {

			if (entityManager != null) {
				entityManager.close();
			}

		}

	}

	public void removeLoactionAndProperty(LocationBean location) {

		EntityManager entityManager = null;
		int id = 0;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			entityManager = entityManagerFactory.createEntityManager();

			entityManager.getTransaction().begin();

			/**
			 * getLocationId what we need to delete find details from database which we need
			 * to delete
			 * 
			 */
			id = location.getLocation_id();
			LocationEntity locationEntity = entityManager.find(LocationEntity.class, id);

			System.out.println("location id " + locationEntity.getLocation_id());
			System.out.println("property id " + locationEntity.getPropertyEntity().getProperty_id());

			entityManager.remove(locationEntity);
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			throw e;

		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}

	}

	public static LocationEntity convertBeanToEntity(LocationBean bean) {
		LocationEntity entity = new LocationEntity();
		entity.setLocation_id(bean.getLocation_id());
		return entity;
	}

	public static LocationBean convertEntityToBean(LocationEntity entity) {
		LocationBean bean = new LocationBean();
		bean.setLocation_id(entity.getLocation_id());
		return bean;
	}

}
