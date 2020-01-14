package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Stock;
import org.hibernate.*;

@Repository
@Transactional
public class StockDaoImpl implements IStockDao {
	@Autowired
	private SessionFactory factory;

	@Override
	public Stock getStockDetails(int id) {
		// TODO Auto-generated method stub
		return factory.getCurrentSession().get(Stock.class, id);
	}

	@Override
	public String addStock(Stock s) {
		factory.getCurrentSession().save(s);
		return "Stock added with ID " + s.getId();
	}

}
