package com.nt.dao;

public interface ILoginDAO {

	public int Authenticate(String username,String pwd);
	public int Auth(int id, String name);
	public String Maha(int ide);
	public Double Transfer(int src, int dest);
}
