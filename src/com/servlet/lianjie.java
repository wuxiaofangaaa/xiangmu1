package com.servlet;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class lianjie {
	public static void main(String[] a){
		//step 2   ����������
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("���سɹ�");
			//step 3 �������ݿ�
			con=(Connection)DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/zhucedb","root","");
			System.out.println("connect�����ɹ�");
			
			//ִ����ɾ�Ĳ�
			Statement sta=(Statement)con.createStatement();
			//sta.executeUpdate ֻ�ܽ�����ɾ��
			//insert studentinfo values ('100001','���Ѿ�',19) ���һ����
//			int n=sta.executeUpdate("insert studentinfo values ('100001','���Ѿ�',19)");
//			if(n>0){
//				System.out.println("��ӳɹ�");
//			}
			/**int b=sta.executeUpdate("update studentinfo set age=23 where stuid=100001");
			if(b>0){
				System.out.println("�޸ĳɹ�");
			}**/
			/**int n=sta.executeUpdate("delete from studentinfo where stuid=100001");
			if(n>0){
				System.out.println("ɾ���ɹ�");
			}**/
			//��ѯ
			
			
			ResultSet rs=(ResultSet) sta.executeQuery("select*from yizhuce");
			while(rs.next()){
				String name=rs.getString(1);
				String password=rs.getString(2);
				
				System.out.println("�û���:\t"+name+"\t����:\t"+password);
			}
		}catch(ClassNotFoundException e){
			System.out.println("�Ҳ�������");
		} catch (SQLException sqle) {
			System.out.println("�����쳣");
		}
		/**finally{
			System.out.println("����Ҫ����");
		}**/
	}
}
