package com.root.dao;

import java.sql.SQLException;

import com.root.bean.LocationBean;
import com.root.bean.PropertyBean;
import com.root.bean.QuoteBean;

public interface QuoteDAO {

	int addQuote(LocationBean locationBean, QuoteBean quoteBean) throws ClassNotFoundException, SQLException;
	QuoteBean findQuoteById(int quoteID) throws ClassNotFoundException, SQLException;
	QuoteBean findQuoteByLocationId(int locationID)throws ClassNotFoundException, SQLException;
}
