/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phanasorn.hotel.lib;

import com.phanasorn.hotel.ConfirmDialog;
import static com.phanasorn.hotel.Homepage.generateBookingReference;
import com.phanasorn.hotel.Login;
import static com.phanasorn.hotel.lib.HikariCPDataSource.dataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Phanasorn
 */
public class DatabaseUtils {
    
    
    Reservations reservation;
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static Connection con;
    
    public static void queryWithBookingRef(int operation,String BookingRef){
        //SQL for check-in
        String SQL_Query = "SELECT * FROM `reservations` WHERE `bookingref` = ? AND `checkin` = ? AND checkin_status = false";
        
        //SQL for check-out
        if(operation == 3){
            SQL_Query = "SELECT * FROM `reservations` WHERE `bookingref` = ? AND checkin_status = true AND checkout_status = false";
        }
        
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(SQL_Query);
                
            ps.setString(1, BookingRef);
            
            if(operation == 2){
                ps.setDate(2, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
            }
            
                
            rs = ps.executeQuery();
                
            while(rs.next()){
                
                Reservations reservation = new Reservations(rs.getString(1),
                            rs.getDate(2).toLocalDate(),
                            rs.getDate(3).toLocalDate(),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),rs.getInt(8),rs.getInt(9), rs.getBoolean(10),rs.getBoolean(11));
                
                ConfirmDialog cf = new ConfirmDialog(operation, reservation);
                cf.setVisible(true);
                return; 
            }
            
            JOptionPane.showMessageDialog(null, "Sorry, We can not find you Booking", "Alert",JOptionPane.WARNING_MESSAGE);
                
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void queryWithFirstName(int operation,String firstname){
        
        ArrayList<Reservations> bookingList = new ArrayList<>();
        
        String SQL_Query = "SELECT * FROM `reservations` WHERE `firstname` = ? AND `checkin` = ? AND checkin_status = false";
        
        //SQL for check-out
        if(operation == 3){
            SQL_Query = "SELECT * FROM `reservations` WHERE `firstname` = ? AND checkin_status = true AND checkout_status = false";
        }
        
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(SQL_Query);
                
            ps.setString(1, firstname);
            
            if(operation == 2){
                ps.setDate(2, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
            }
                
            rs = ps.executeQuery();
                
            while(rs.next()){
                
                bookingList.add(new Reservations(
                    rs.getString(1),
                    rs.getDate(2).toLocalDate(),
                    rs.getDate(3).toLocalDate(),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),rs.getInt(8),rs.getInt(9), rs.getBoolean(10),rs.getBoolean(11)
                    ));
            }
            
            if(bookingList.isEmpty() == true){
                JOptionPane.showMessageDialog(null, "Sorry, We can not find you Booking", "Alert",JOptionPane.WARNING_MESSAGE);
            }else{
                if(bookingList.size() == 1){
                    ConfirmDialog cf = new ConfirmDialog(operation, bookingList.get(0));
                    cf.setVisible(true);
                }else{
                    
                    int countRecord = bookingList.size();
                    ArrayList<String> itemTemp = new ArrayList<>(); 
                    
                    for(int i=0; i < countRecord; i++){
                        //System.out.println(bookingList.get(i).ToString());
                        itemTemp.add(bookingList.get(i).ToString());
                    }
                    
                    Object[] item = itemTemp.toArray(new String[0]);
                    
                    String s = (String)JOptionPane.showInputDialog(
                    null,"There are " + countRecord + " records.","Information",JOptionPane.INFORMATION_MESSAGE,null,item,null);
                    //int index = 0;
                    //If a string was returned, say so.
                    if ((s != null) && (s.length() > 0)) {
                        
                        for(int i=0; i < countRecord; i++){
                            if(bookingList.get(i).getBookingRef().equals(s.substring(0, 5))){
                                ConfirmDialog cf = new ConfirmDialog(operation, bookingList.get(i));
                                cf.setVisible(true);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void queryWithLastName(int operation,String lastname){
        
        ArrayList<Reservations> bookingList = new ArrayList<>();
        
        String SQL_Query = "SELECT * FROM `reservations` WHERE `lastname` = ? AND `checkin` = ? AND checkin_status = false";
        
        //SQL for check-out
        if(operation == 3){
            SQL_Query = "SELECT * FROM `reservations` WHERE `lastname` = ? AND checkin_status = true AND checkout_status = false";
        }
        
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(SQL_Query);
                
            ps.setString(1, lastname);
            
            if(operation == 2){
                ps.setDate(2, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
            }
                
            rs = ps.executeQuery();
                
            while(rs.next()){
                
                bookingList.add(new Reservations(
                    rs.getString(1),
                    rs.getDate(2).toLocalDate(),
                    rs.getDate(3).toLocalDate(),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),rs.getInt(8),rs.getInt(9), rs.getBoolean(10),rs.getBoolean(11)
                    ));
            }
            
            if(bookingList.isEmpty() == true){
                JOptionPane.showMessageDialog(null, "Sorry, We can not find you Booking", "Alert",JOptionPane.WARNING_MESSAGE);
            }else{
                if(bookingList.size() == 1){
                    ConfirmDialog cf = new ConfirmDialog(operation, bookingList.get(0));
                    cf.setVisible(true);
                }else{
                    
                    int countRecord = bookingList.size();
                    ArrayList<String> itemTemp = new ArrayList<>(); 
                    
                    for(int i=0; i < countRecord; i++){
                        //System.out.println(bookingList.get(i).ToString());
                        itemTemp.add(bookingList.get(i).ToString());
                    }
                    
                    Object[] item = itemTemp.toArray(new String[0]);
                    
                    String s = (String)JOptionPane.showInputDialog(
                    null,"There are " + countRecord + " records.","Information",JOptionPane.INFORMATION_MESSAGE,null,item,null);
                    //int index = 0;
                    //If a string was returned, say so.
                    if ((s != null) && (s.length() > 0)) {
                        
                        for(int i=0; i < countRecord; i++){
                            if(bookingList.get(i).getBookingRef().equals(s.substring(0, 5))){
                                ConfirmDialog cf = new ConfirmDialog(operation, bookingList.get(i));
                                cf.setVisible(true);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void queryWithPhone(int operation,String phone){
        
        ArrayList<Reservations> bookingList = new ArrayList<>();
        
        String SQL_Query = "SELECT * FROM `reservations` WHERE `phone` = ? AND `checkin` = ? AND checkin_status = false";
        
        //SQL for check-out
        if(operation == 3){
            SQL_Query = "SELECT * FROM `reservations` WHERE `phone` = ? AND checkin_status = true AND checkout_status = false";
        }
        
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(SQL_Query);
                
            ps.setString(1, phone);
            
            if(operation == 2){
                ps.setDate(2, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
            }
                
            rs = ps.executeQuery();
                
            while(rs.next()){
                
                bookingList.add(new Reservations(
                    rs.getString(1),
                    rs.getDate(2).toLocalDate(),
                    rs.getDate(3).toLocalDate(),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),rs.getInt(8),rs.getInt(9), rs.getBoolean(10),rs.getBoolean(11)
                    ));
            }
            
            if(bookingList.isEmpty() == true){
                JOptionPane.showMessageDialog(null, "Sorry, We can not find you Booking", "Alert",JOptionPane.WARNING_MESSAGE);
            }else{
                if(bookingList.size() == 1){
                    ConfirmDialog cf = new ConfirmDialog(operation, bookingList.get(0));
                    cf.setVisible(true);
                }else{
                    
                    int countRecord = bookingList.size();
                    ArrayList<String> itemTemp = new ArrayList<>(); 
                    
                    for(int i=0; i < countRecord; i++){
                        //System.out.println(bookingList.get(i).ToString());
                        itemTemp.add(bookingList.get(i).ToString());
                    }
                    
                    Object[] item = itemTemp.toArray(new String[0]);
                    
                    String s = (String)JOptionPane.showInputDialog(
                    null,"There are " + countRecord + " records.","Information",JOptionPane.INFORMATION_MESSAGE,null,item,null);
                    //int index = 0;
                    //If a string was returned, say so.
                    if ((s != null) && (s.length() > 0)) {
                        
                        for(int i=0; i < countRecord; i++){
                            if(bookingList.get(i).getBookingRef().equals(s.substring(0, 5))){
                                ConfirmDialog cf = new ConfirmDialog(operation, bookingList.get(i));
                                cf.setVisible(true);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void queryWithIDPass(int operation,String idpass){
        
        ArrayList<Reservations> bookingList = new ArrayList<>();
        
        String SQL_Query = "SELECT * FROM `reservations` WHERE `id_passport` = ? AND `checkin` = ? AND checkin_status = false";
        
        //SQL for check-out
        if(operation == 3){
            SQL_Query = "SELECT * FROM `reservations` WHERE `id_passport` = ? AND checkin_status = true AND checkout_status = false";
        }
        
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(SQL_Query);
                
            ps.setString(1, idpass);
            
            if(operation == 2){
                ps.setDate(2, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
            }
                
            rs = ps.executeQuery();
                
            while(rs.next()){
                
                bookingList.add(new Reservations(
                    rs.getString(1),
                    rs.getDate(2).toLocalDate(),
                    rs.getDate(3).toLocalDate(),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),rs.getInt(8),rs.getInt(9), rs.getBoolean(10),rs.getBoolean(11)
                    ));
            }
            
            if(bookingList.isEmpty() == true){
                JOptionPane.showMessageDialog(null, "Sorry, We can not find you Booking", "Alert",JOptionPane.WARNING_MESSAGE);
            }else{
                if(bookingList.size() == 1){
                    ConfirmDialog cf = new ConfirmDialog(operation, bookingList.get(0));
                    cf.setVisible(true);
                }else{
                    
                    int countRecord = bookingList.size();
                    ArrayList<String> itemTemp = new ArrayList<>(); 
                    
                    for(int i=0; i < countRecord; i++){
                        //System.out.println(bookingList.get(i).ToString());
                        itemTemp.add(bookingList.get(i).ToString());
                    }
                    
                    Object[] item = itemTemp.toArray(new String[0]);
                    
                    String s = (String)JOptionPane.showInputDialog(
                    null,"There are " + countRecord + " records.","Information",JOptionPane.INFORMATION_MESSAGE,null,item,null);
                    //int index = 0;
                    //If a string was returned, say so.
                    if ((s != null) && (s.length() > 0)) {
                        
                        for(int i=0; i < countRecord; i++){
                            if(bookingList.get(i).getBookingRef().equals(s.substring(0, 5))){
                                ConfirmDialog cf = new ConfirmDialog(operation, bookingList.get(i));
                                cf.setVisible(true);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void insertReservation(Reservations reservation){
        String SQL_Query = "INSERT INTO `reservations` (`bookingref`, `checkin`, `checkout`, `firstname`, `lastname`, `id_passport`, `phone`, `guest`, `room`, `status`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?);";
        
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(SQL_Query);
                
            ps.setString(1,reservation.getBookingRef());
            ps.setDate(2, Date.valueOf(reservation.getcheck_inDate()));
            ps.setDate(3, Date.valueOf(reservation.getcheck_outDate()));
            ps.setString(4, reservation.getFirstName());
            ps.setString(5, reservation.getLastName());
            ps.setString(6, reservation.getIDPass());
            ps.setString(7, reservation.getPhone());
            ps.setInt(8, reservation.getGuest());
            ps.setInt(9, reservation.getRoom());
            ps.setBoolean(10, false);
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Your Booking is booked, and This is your BookingRef: " + "reservation.getBookingRef()",
                    "Inforamtion",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateCheckIn(Reservations reservation){
        String SQL_Query = "UPDATE `reservations` SET `checkin_status` = 1 WHERE `reservations`.`bookingref` = ?;";
        
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(SQL_Query);
                
            ps.setString(1,reservation.getBookingRef());
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Check-in Completed",
                    "Inforamtion",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateCheckOut(Reservations reservation){
        String SQL_Query = "UPDATE `reservations` SET `checkout_status` = '1' WHERE `reservations`.`bookingref` = ?;";
        
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(SQL_Query);
                
            ps.setString(1,reservation.getBookingRef());
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Check-out Completed",
                    "Inforamtion",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Testbench
    public static void main(String[] args) {  
        
        //queryWithPhone(3,"0846159452");
        //updateCheckin
    }
    
    
}
