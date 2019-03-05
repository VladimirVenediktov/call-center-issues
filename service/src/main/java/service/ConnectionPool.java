package service;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariDataSource;

/** 
 * Класс ConnectionPool обеспечивает соединение с БД
 * посредством connection pool
 * 
 * @autor Venediktov V.S.
 * @version 1.0
*/
public class ConnectionPool {

    static Properties property = new Properties();
	
	/** 
     * Метод для соединения с БД через HikariCP (connection pool)
     * 
     * @return возвращает connection
	 * @throws SQLException
     */
	public static Connection getConnection() throws SQLException {
		
		HikariDataSource ds = new HikariDataSource();

        try (FileInputStream fis = new FileInputStream("src/main/resources/application.properties")) {
        	property.load(fis);
		} catch (IOException e) {
			System.err.println("ОШИБКА: Файл свойств отсуствует!");
		}
        
        String dbURL = property.getProperty("db.URL");
        String dbUserName = property.getProperty("db.login");
        String dbPassword = property.getProperty("db.password");
	
        ds.setJdbcUrl(dbURL);
		ds.setUsername(dbUserName);
		ds.setPassword(dbPassword);
		
		return ds.getConnection();
	}

}
