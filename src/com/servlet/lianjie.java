package com.servlet;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class lianjie {
	public static void main(String[] a){
		//step 2   加载驱动类
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载成功");
			//step 3 连接数据库
			con=(Connection)DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/zhucedb","root","");
			System.out.println("connect创建成功");
			
			//执行增删改查
			Statement sta=(Statement)con.createStatement();
			//sta.executeUpdate 只能进行增删改
			//insert studentinfo values ('100001','季佳京',19) 添加一个人
//			int n=sta.executeUpdate("insert studentinfo values ('100001','季佳京',19)");
//			if(n>0){
//				System.out.println("添加成功");
//			}
			/**int b=sta.executeUpdate("update studentinfo set age=23 where stuid=100001");
			if(b>0){
				System.out.println("修改成功");
			}**/
			/**int n=sta.executeUpdate("delete from studentinfo where stuid=100001");
			if(n>0){
				System.out.println("删除成功");
			}**/
			//查询
			
			
			ResultSet rs=(ResultSet) sta.executeQuery("select*from yizhuce");
			while(rs.next()){
				String name=rs.getString(1);
				String password=rs.getString(2);
				
				System.out.println("用户名:\t"+name+"\t密码:\t"+password);
			}
		}catch(ClassNotFoundException e){
			System.out.println("找不到……");
		} catch (SQLException sqle) {
			System.out.println("连接异常");
		}
		/**finally{
			System.out.println("就是要出现");
		}**/
	}
}
