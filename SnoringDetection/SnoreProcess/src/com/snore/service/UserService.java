package com.snore.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.snore.dao.UserDao;
import com.snore.entity.User;
import com.snore.util.DBTools;
import com.snore.util.Data;

public class UserService {

	public static void main(String[] args) throws ParseException{
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString="2017-05-18";
		
		List<Data> datas=queryData(dateString);
		for (Data data : datas) {
			System.out.println(
					"id: "+data.getId()+"\n"+
					"duration: "+data.getDuration()+"s\n"+
					"startTime: "+dateFormat.format(data.getStartTime())+"\n"+
					"endTime: "+dateFormat.format(data.getEndTime())+"\n"+
					"dateTime: "+dateFormat.format(data.getDateTime())+"\n"+
					"meanValue: "+data.getMeanValue()+"\n"+
					"maxValue："+data.getMaximumValue()+"\n"+
					"timePoint: "+(data.getStartTime().getTime()-
							data.getDateTime().getTime())/1000/60+"min"
							+(data.getStartTime().getTime()-
							data.getDateTime().getTime())/1000%60+"s\n\n\n"
					);
		}
		
		//删除测试
//		deleteUser("2017-05-18 00:00:00");
		
	}

	
	/**
	 * 根据id查询用户
	 */
	private static User selectUserById(int id) {
		SqlSession session = DBTools.getSession();
		UserDao mapper = session.getMapper(UserDao.class);
		try {
			User user = mapper.selectUserById(id);
			session.commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
			return null;
		}
	}

	/**
	 * 根据日期查询
	 */
	public static List<User> selectUserByDate(String date) {
		SqlSession session = DBTools.getSession();
		UserDao mapper = session.getMapper(UserDao.class);
		try {
			List<User> users = mapper.selectUserByDate(date);
			session.commit();
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
			return null;
		}
	}
	
	/**
	 * 查询所有的用户
	 */
	private static List<User> selectAllUser() {
		SqlSession session = DBTools.getSession();
		UserDao mapper = session.getMapper(UserDao.class);
		try {
			List<User> users = mapper.selectAllUser();
			session.commit();
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
			return null;
		}
	}
	
	/**
	 * 将根据日期查询的结果集合进行简单的数据分析，返回新的集合
	 */
	public static List<Data> queryData(String date){
		List<User> users=selectUserByDate(date);
		List<Data> datas=new ArrayList<>();
		for (User user : users) {
			Data data=new Data();
			data.setId(user.getId());
			data.setDuration((double)user.getDuration()/8000);
			data.setMaximumValue(user.getMaximumValue());
			data.setMeanValue(user.getMeanValue());
			data.setDateTime(user.getDateTime());
			
			//日期推算
			Date startTime=new Date(user.getDateTime().getTime()
					+user.getStartTime()/8);
			Date endTime=new Date(user.getDateTime().getTime()
					+user.getEndTime()/8);
			
			data.setStartTime(startTime);
			data.setEndTime(endTime);
			
			datas.add(data);
			
		}
		return datas;
	}

	
	private static void deleteUser(String date) {
		SqlSession session = DBTools.getSession();
		UserDao mapper = session.getMapper(UserDao.class);
		try {
			mapper.deleteData(date);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}
}