package com.nt.service;

import com.nt.dao.ILoginDAO;

public class IloginmangmntServiceImpl implements ILoginmangmntService{

	private ILoginDAO loginDao;
	
	
	public IloginmangmntServiceImpl(ILoginDAO loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public boolean login(String username, String password) {
		
		if(username.equals("") || password.equals(""))
			throw new IllegalArgumentException("Empty Credintial");
		
		//use login dao
		int count=loginDao.Authenticate(username, password);
		
		System.out.println("LOGIN"+count);
		if(count==0)
			return false;
		else
			return true;
	
	}


}
