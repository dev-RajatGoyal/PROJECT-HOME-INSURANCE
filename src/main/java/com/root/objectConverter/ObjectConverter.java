package com.root.objectConverter;

import org.apache.log4j.Logger;

import com.root.bean.HomeOwnerBean;
import com.root.bean.LocationBean;
import com.root.bean.PolicyBean;
import com.root.bean.PropertyBean;
import com.root.bean.QuoteBean;
import com.root.bean.UserBean;
import com.root.entity.HomeOwnerEntity;
import com.root.entity.LocationEntity;
import com.root.entity.PolicyEntity;
import com.root.entity.PropertyEntity;
import com.root.entity.QuoteEntity;
import com.root.entity.UserEntity;
/**
 * This is ObjectConverter Class by this class we convert entity class to Bean and bean class to entity
 */
public class ObjectConverter {
	static final Logger LOGGER = Logger.getLogger(ObjectConverter.class);

	/**
	 * this method convert HomeOwnerBean to HomeOwnerEntity
	 */
	public HomeOwnerEntity convertHomeBenasToEntity(HomeOwnerBean home) {
		LOGGER.info("Inside the convertHomeBeanToEntity Method");
		HomeOwnerEntity entity = new HomeOwnerEntity();

		entity.setDob(home.getDob());
		entity.setEmail(home.getEmail());
		entity.setFname(home.getFname());
		entity.setLname(home.getLname());
		entity.setOwnerId(home.getOwnerId());
		entity.setRetired(home.getRetired());
		entity.setSocialSocietyNumber(home.getSocialSocietyNumber());
		LOGGER.info("Convert HomeBean to HomeEntity Successfully");
		return entity;

	}

	/**
	 * this method convert LocationBean to LocationEntity
	 */
	public LocationEntity convertLocationBeansToEntity(LocationBean bean) {
		LOGGER.info("Inside the convertLocationBeansToEntity Method");
		LocationEntity entity = new LocationEntity();

		entity.setLocation_id(bean.getLocation_id());
		entity.setAddress_line_1(bean.getAddress_line_1());
		entity.setAddress_line_2(bean.getAddress_line_2());
		entity.setCity(bean.getCity());
		entity.setLocation_state(bean.getLocation_state());
		entity.setResidence_type(bean.getResidence_type());
		entity.setResidence_use(bean.getResidence_use());
		entity.setZip_code(bean.getZip_code());
		LOGGER.info("Convert LocationBean to LocationEntity Successfully");
		return entity;

	}

	
	/**
	 * this method convert LocationEntity to LocationBean
	 */
	public LocationBean convertLocationEntityToBean(LocationEntity entity) {
		LOGGER.info("Inside the convertLocationEntityToBean Method");
		LocationBean bean = new LocationBean();

		bean.setLocation_id(entity.getLocation_id());
		bean.setAddress_line_1(entity.getAddress_line_1());
		bean.setAddress_line_2(entity.getAddress_line_2());
		bean.setCity(entity.getCity());
		bean.setLocation_state(entity.getLocation_state());
		bean.setResidence_type(entity.getResidence_type());
		bean.setResidence_use(entity.getResidence_use());
		bean.setZip_code(entity.getZip_code());
		LOGGER.info("Convert LocationEntity to LocationBean Successfully");
		return bean;

	}
	
	/**
	 * this method convert UserBean to UserEntity
	 */
	public UserEntity convertUserBeansToEntity(UserBean bean) {
		LOGGER.info("Inside the convertUserBeansToEntity Method");
		UserEntity entity = new UserEntity();

		entity.setUser_id(bean.getuserid());
		entity.setUser_name(bean.getUsername());
		entity.setPassword(bean.getPassword());
		entity.setConfirmPassword(bean.getCpassword());
		entity.setRole(bean.getRole());
		entity.setEmail(bean.getEmail());
		LOGGER.info("Convert UserBean to UserEntity Successfully");
		return entity;

	}
	
	/**
	 * this method convert UserEntity to UserBean
	 */
	public UserBean convertUserEntityToBean(UserEntity entity) {
		LOGGER.info("Inside the convertUserEntityToBean Method");
		UserBean bean = new UserBean();

		bean.setuserid(entity.getUser_id());
		bean.setUsername(entity.getUser_name());
		bean.setPassword(entity.getPassword());
		bean.setCpassword(entity.getConfirmPassword());
		bean.setRole(entity.getRole());
		bean.setEmail(entity.getEmail());
		LOGGER.info("Convert UserEntity to UserBean Successfully");
		return bean;

	}

	/**
	 * this method convert PropertyBean to PropertyEntity
	 */
	public PropertyEntity convertPropertyBeanToEntity(PropertyBean propertyBean) {
		LOGGER.info("Inside the convertPropertyBeanToEntity Method");
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
		LOGGER.info("Convert PropertyBean to PropertyEntity Successfully");
		return propertyEntity;

	}
	
	
	/**
	 * this method convert PropertyEntity to PropertyBean
	 */
	public PropertyBean convertPropertyEntityToBean(PropertyEntity entity) {
		LOGGER.info("Inside the convertPropertyEntityToBean Method");
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
		LOGGER.info("Inside the Convery PropertyEntity To PropertyBean Method");
		return bean;

	}
	
	/**
	 * this method convert QuoteEntity to QuoteBean
	 */
	public QuoteBean convertQuoteEntityToBean(QuoteEntity entity)
	{
		QuoteBean bean = new QuoteBean();
		
		bean.setQuote_id(entity.getQuote_id());
		bean.setMonthly_premium(entity.getMonthly_premium());
		bean.setDwelling_coverage(entity.getDwelling_coverage());
		bean.setDetached_structures(entity.getDetached_structures());
		bean.setPersonal_property(entity.getPersonal_property());
		bean.setAdd_living_exp(entity.getAdd_living_exp());
		bean.setMedical_expense(entity.getMedical_expense());
		bean.setDeductible(entity.getDeductible());
		
		return bean;
	}
	
	/**
	 * this method convert QuoteBean to QuoteEntity
	 */
	public QuoteEntity convertQuoteBeanToEntity(QuoteBean bean)
	{
		QuoteEntity entity = new QuoteEntity();
		
		entity.setQuote_id(bean.getQuote_id());
		entity.setMonthly_premium(bean.getMonthly_premium());
		entity.setDwelling_coverage(bean.getDwelling_coverage());
		entity.setDetached_structures(bean.getDetached_structures());
		entity.setPersonal_property(bean.getPersonal_property());
		entity.setAdd_living_exp(bean.getAdd_living_exp());
		entity.setMedical_expense(bean.getMedical_expense());
		entity.setDeductible(bean.getDeductible());
		
		return entity;
	}
	
	/**
	 * this method convert PolicyBean to PolicyEntity
	 */
	public PolicyEntity convertPolicyBeanToEntity(PolicyBean policyBean)
	{
		PolicyEntity policyEntity = new PolicyEntity();
		
		policyEntity.setPolicy_id(policyBean.getPolicyId());
		policyEntity.setEffective_date(policyBean.getEffectiveDate());
		policyEntity.setEnd_date(policyBean.getEndDate());
		policyEntity.setPolicy_status(policyBean.getPolicyStatus());
		policyEntity.setTerm(policyBean.getPolicyTerm());
		
		return policyEntity;
	}
	
	/**
	 * this method convert PolicyEntity to PolicyBean
	 */
	public PolicyBean convertPolicyEntityToBean(PolicyEntity policyEntity)
	{
		PolicyBean policyBean=new PolicyBean();
		
		policyBean.setEffectiveDate(policyEntity.getEffective_date());
		policyBean.setEndDate(policyEntity.getEnd_date());
		policyBean.setPolicyId(policyEntity.getPolicy_id());
		policyBean.setPolicyStatus(policyEntity.getPolicy_status());
		policyBean.setPolicyTerm(policyEntity.getPolicy_id());
		
		
		return policyBean;
	}
	
	/**
	 * this method convert HomeEntity to HomeBean
	 */
	public HomeOwnerBean convertHomeEntityToBean(HomeOwnerEntity entity) {
		LOGGER.info("Inside the convertHomeEntityToBean Method");
		HomeOwnerBean bean = new HomeOwnerBean();

		bean.setDob(entity.getDob());
		bean.setEmail(entity.getEmail());
		bean.setFname(entity.getFname());
		bean.setLname(entity.getLname());
		bean.setOwnerId(entity.getOwnerId());
		bean.setRetired(entity.getRetired());
		bean.setSocialSocietyNumber(entity.getSocialSocietyNumber());
		
		LOGGER.info("Convert HomeOwnerEntity to HomeOwnerBean Successfully");
		return bean;

	}
	
}