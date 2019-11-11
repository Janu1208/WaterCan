package com.janu.wms.UI;

import java.util.List;

import com.janu.wms.dao.StockDAO;
import com.janu.wms.dao.StockDAOImp;
import com.janu.wms.exception.DBException;
import com.janu.wms.model.Stock;

public class ViewStock {
	public void stockView() {

		StockDAOImp dao = new StockDAO();
		List<Stock> list;
		try {
			list = dao.viewStock();
			for (Stock stocks : list) {

				System.out.println("Available cans are:" + stocks.getCansAvail() + " ON " + stocks.getDate());

			}
		} catch (DBException e) {

			e.printStackTrace();
		}
	}

}
