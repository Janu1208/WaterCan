package com.janu.wms.controller;

import java.util.List;

import com.janu.wms.dao.StockDAO;
import com.janu.wms.dao.StockDAOImp;
import com.janu.wms.exception.DBException;
import com.janu.wms.model.Stock;

public class ViewStock {
	public static void stockView() {

		StockDAOImp dao = new StockDAO();
		List<Stock> list;
		try {
			list = dao.viewStock();
			for (Stock stock : list) {

				System.out.println("Available cans are:" + Stock.getCans_avail() + " ON " + stock.getDate());

			}
		} catch (DBException e) {

			e.printStackTrace();
		}

		System.out.println();
	}

}
