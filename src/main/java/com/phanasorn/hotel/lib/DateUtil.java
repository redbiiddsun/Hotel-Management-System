/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phanasorn.hotel.lib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Phanasorn
 */
public class DateUtil {
    
    
    
    /**
     *
     * @param date
     * @return
     */
    public static Date toDate(String date){
        
        SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/yyyy");
        Date convertDate = null;
        
        try {
            convertDate = sdformat.parse(date);
        } catch (ParseException e) {
            return null;
        }
        
        return convertDate;
    }
    
    public static LocalDate toLocalDate(String date){
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate localDate;
        
        try {
            localDate = LocalDate.parse(date, formatter);
        }catch (Exception e) {
            return null;
        }
        
        return localDate;
    }
    
    public static Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }
    
    /*public static boolean compareDates(Date date1,Date date2)
    {
        if(date2.after(date1)){
            System.out.println("Date1 is after Date2");
            return true;
        }else{
            return false;
        }
        
    }*/
    
    public static boolean compareDates(LocalDate date1,LocalDate date2)
    {
        if(date2.isAfter(date1)){
            //System.out.println("Date1 is after Date2");
            return true;
        }else{
            return false;
        }
        
    }
    
    //This function is use to check that the input date is less than today date or not if it is not so booking can be happen
    public static boolean compareTodayDates(LocalDate inputDate)
    {
        LocalDate todayDate = LocalDate.now();
        
        if(inputDate.isAfter(todayDate)){
            return true;
        }else if(inputDate.equals(todayDate) == true){
            return true;
        }else{
            return false;
       }
    }
    
    
    public static boolean conditionDate(LocalDate checkin, LocalDate checkout){
        //Check Null
        if((checkin != null && checkout != null)){
            //Validate checkin is less than checkout
            if(compareDates(checkin, checkout) != false){
                //Validate checkin is greater or equal today date
                return compareTodayDates(checkin) == true;
            }else{
                JOptionPane.showMessageDialog(null, "Check-in date is greater than Check-out date", "Alert",JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Check-in or Check-out box are require to fill in the format of (DD/MM/YYYY)", "Alert",JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    //Testbench
    /*public static void main(String[] args) {  
        
        LocalDate date1 = toLocalDate("31/12/2022");
        LocalDate date2 = toLocalDate("02/01/2023");
        
        System.out.println(conditionDate(date1,date2));
        
        
    }*/  
}

