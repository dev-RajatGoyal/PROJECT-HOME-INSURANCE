package com.root.service;

import java.sql.SQLException;

import com.root.bean.LocationBean;
import com.root.bean.PropertyBean;
import com.root.bean.QuoteBean;
import com.root.entity.UserEntity;

public interface QuoteService {

	int addQuote(int LocationId) throws ClassNotFoundException, SQLException;
	QuoteBean findQuoteById(int quoteID) throws ClassNotFoundException, SQLException;
	
}
