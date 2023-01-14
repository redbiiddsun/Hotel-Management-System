/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phanasorn.hotel.lib;

import java.time.LocalDate;

/**
 *
 * @author Phanasorn
 */
public class Reservations {
    
    private String bookingRef;
    private LocalDate check_inDate;
    private LocalDate check_outDate;
    private String firstName;
    private String lastName;
    private String id_passport;
    private String phone;
    private int guest;
    private int room;
    private boolean checkinStatus;
    private boolean checkoutStatus;
    
    public Reservations(String bookingRef, 
            LocalDate check_inDate, 
            LocalDate check_outDate, 
            String firstName, 
            String lastName, 
            String id_passport, 
            String phone, 
            int guest, 
            int room,
            boolean checkinStatus,
            boolean checkoutStatus){
        
        this.bookingRef = bookingRef;
        this.check_inDate = check_inDate;
        this.check_outDate = check_outDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id_passport = id_passport;
        this.phone = phone;
        this.guest = guest;
        this.room = room;
        this.checkinStatus = checkinStatus;
        this.checkinStatus = checkoutStatus;
    }
    
    public Reservations(){
        
        
    }
    
    public String getBookingRef(){
        return this.bookingRef;
    }
    
    public LocalDate getcheck_inDate(){
        return this.check_inDate;
    }
    
    public LocalDate getcheck_outDate(){
        return this.check_outDate;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public String getIDPass(){
        return this.id_passport;
    }
    
    public String getPhone(){
        return this.phone;
    }
    
    public int getRoom(){
        return this.room;
    }
    
    public int getGuest(){
        return this.guest;
    }
    
    public boolean getCheckinStatus(){
        return this.checkinStatus;
    }
    
    public boolean getCheckoutStatus(){
        return this.checkoutStatus;
    }
    
    public String ToString(){
        
        return bookingRef + " / " + firstName + " / " + lastName + " Guest: " + 
                Integer.toString(guest) + "/ Room: "  + Integer.toString(room) +
                "/ Check-in: Today" + "/ Check-out: " + check_outDate;
    }
}
