/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phanasorn.hotel.lib;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Phanasorn
 */
public class HikariCPDataSource {
    
    public static HikariDataSource dataSource;

	static {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/hotel_management_system");
		config.setUsername("root");
		config.setPassword("");
		config.addDataSourceProperty("minimumIdle", "5");
		config.addDataSourceProperty("maximumPoolSize", "25");

		dataSource = new HikariDataSource(config);
	}
    
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    
    //private HikariCPDataSource(){}
}
