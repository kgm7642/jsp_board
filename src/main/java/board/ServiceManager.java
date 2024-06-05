package board;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class ServiceManager {
	protected Connection getConnection() {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		InputStream is =  ServiceManager.class.getResourceAsStream("/board.properties");
		Properties props = new Properties();

	    //mariaDB 연결
	    try {
	    	// InputStream을 사용해 파일내용 로드
	    	props.load(is);
	    	
	    	String driver = props.getProperty("database.driver");
	    	String url = props.getProperty("database.url");
	    	String user = props.getProperty("database.user");
	    	String password = props.getProperty("database.password");
	    	Class.forName(driver);
	    	conn = DriverManager.getConnection(url, user, password);	
	    } catch(Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	if(is != null) {
	    		try {
	    			is.close();
	    		} catch (Exception e) {
					e.printStackTrace();
				}
	    	}
	    }
	    return conn;
	}
}
