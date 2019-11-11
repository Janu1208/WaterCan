package com.janu.wms.dao;
import com.janu.wms.exception.DBException;
import com.janu.wms.model.Admin;

public interface AdminDAO {
	public Admin login(String name, String setPassword) throws DBException;
}