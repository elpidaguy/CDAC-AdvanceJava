package com.app.dao;

import com.app.pojos.Stock;

public interface IStockDao {
	Stock getStockDetails(int id);
	String addStock(Stock s);
}
