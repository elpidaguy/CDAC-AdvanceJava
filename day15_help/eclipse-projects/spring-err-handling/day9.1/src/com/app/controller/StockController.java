package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IStockDao;
import com.app.pojos.Stock;

@RestController // @Controller + @ResponseBody on ret types of req handling methods
@RequestMapping("/stocks")
public class StockController {
	// dep
	@Autowired
	private IStockDao dao;

	public StockController() {
		System.out.println("in cnstr of " + getClass().getName());
	}
	//request handling method for sending stock details to the REST clnt
	@GetMapping("/{stock_id}")
	public Stock getStockDetails(@PathVariable int stock_id)
	{
		System.out.println("in get stock "+stock_id);
		return dao.getStockDetails(stock_id);
	}
	//req handling method to add a new stock
	@PostMapping
	public String addnewStock(@RequestBody @Valid Stock s)
	{
		System.out.println("in add stock "+s);
		return dao.addStock(s);
	}

}
