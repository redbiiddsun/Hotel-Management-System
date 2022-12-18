/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phanasorn.erp.student.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Phanasorn
 */
public class DBconnection {
    
    public static Connection con = null;
    //public static int ID;
    
    
     public static Connection getConnection() throws SQLException{
     
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/erp-student", "root", "");
            
            if(con != null){
                System.out.println("Database Connection Sucesses");
            }else{
                System.out.println("Database Connection Failed");
                JOptionPane.showMessageDialog(null, "Database Connection Failure, Please try again later,", "Alert",JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null,ex);
            //JOptionPane.showMessageDialog(null, "Database Connection Failure, Please try again later,", "Alert",JOptionPane.WARNING_MESSAGE);
        }
         catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null,ex);
            //JOptionPane.showMessageDialog(null, "Database Connection Failure, Please try again later,", "Alert",JOptionPane.WARNING_MESSAGE);
        }
        
        return con;
    }
    
}
