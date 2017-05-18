package com.snore.dao;

import java.util.List;

import com.snore.entity.User;

public interface UserDao {
	

	/**
	 * 根据id查询用户信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User selectUserById(int id) throws Exception;
	
	/**
	 * 根据日期查询用户信息
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public List<User> selectUserByDate(String date) throws Exception;

	/**
	 * 查询所有的用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<User> selectAllUser() throws Exception;
	
	/**
	 * 删除某天的数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public void deleteData(String date);
	
	
}
