/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pack;
 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
 
public class DBUtil {
	private static DataSource dataSource;
	private static final String  JNDI_LOOKUP_SERVICE = "java:/comp/env/jdbc/empDB";
	static{
		try {
			Context context = new InitialContext();
			Object lookup = context.lookup(JNDI_LOOKUP_SERVICE);
			if(lookup != null){
				dataSource =(DataSource)lookup;
			}else{
				new RuntimeException("JNDI look up issue.");
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public static DataSource getDataSource(){
		return dataSource;
	}
}