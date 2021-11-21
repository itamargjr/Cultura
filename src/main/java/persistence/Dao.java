package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;

/**
 * Classe ancestral de acesso à base de dados
 * @author itamar
 *
 */

public class Dao {
	
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	CallableStatement cstmt;
	

//	private final String URL = "jdbc:mysql://151.106.110.4:3306/u145949539_sistemas"; // URL Hostinger

//	private final String USER = "u145949539_admin";
//	private final String PASS = "EducaNilopolis2021*/";
	
	private final String URL = "jdbc:mysql://207.244.230.138:3306/x2plataf_sistemas"; // URL Integrator
	
	private final String USER = "x2plataf_admin";
	private final String PASS = "EducaNilopolis2021*/";
	
	public String caminho(){
		return URL;
	}

	protected void open() throws Exception{
		
		Locale.setDefault(new Locale("pt", "BR"));
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(URL, USER, PASS);
	}
	
	protected void close() throws Exception{
		con.close();
	}

}
