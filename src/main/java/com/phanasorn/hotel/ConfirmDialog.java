/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phanasorn.hotel;

import static com.phanasorn.hotel.lib.DatabaseUtils.insertReservation;
import static com.phanasorn.hotel.lib.DatabaseUtils.updateCheckIn;
import static com.phanasorn.hotel.lib.DatabaseUtils.updateCheckOut;
import static com.phanasorn.hotel.lib.HikariCPDataSource.dataSource;
import com.phanasorn.hotel.lib.Reservations;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phanasorn
 */
public class ConfirmDialog extends javax.swing.JFrame {

    /**
     * Creates new form ConfirmDialog
     */
    
    
    Reservations reservation;
    private int index = 1;
    
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection con;
    
    public ConfirmDialog(int index,Reservations reservation) {
        initComponents();
        this.reservation = reservation;
        this.index = index;
        
        //Set the title of the form
        switch (index) {
            case 1:
                
                break;
            case 2:
                titlelbl.setText("Confirm Check-in");
                break;
            case 3:
                titlelbl.setText("Confirm Check-out");
                break;
            default:
                break;
        }
        
        bookingReflbl.setText(reservation.getBookingRef());
        namelbl.setText(reservation.getFirstName());
        lastlbl.setText(reservation.getLastName());
        phonelbl.setText(reservation.getPhone());
        IDPasslbl.setText(reservation.getIDPass());
        checkinlbl.setText(reservation.getcheck_inDate().toString());
        checkoutlbl.setText(reservation.getcheck_outDate().toString());
        roomlbl.setText(Integer.toString(reservation.getRoom()));
        guestlbl.setText(Integer.toString(reservation.getGuest()));
    }

    private ConfirmDialog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlelbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        namelbl = new javax.swing.JLabel();
        lastlbl = new javax.swing.JLabel();
        phonelbl = new javax.swing.JLabel();
        IDPasslbl = new javax.swing.JLabel();
        checkinlbl = new javax.swing.JLabel();
        checkoutlbl = new javax.swing.JLabel();
        roomlbl = new javax.swing.JLabel();
        guestlbl = new javax.swing.JLabel();
        cancleBtn = new javax.swing.JButton();
        confirmBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bookingReflbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titlelbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titlelbl.setText("Confirm Booking");

        jLabel2.setText("Name");

        jLabel3.setText("Lastname");

        jLabel4.setText("Phone");

        jLabel5.setText("ID/Passport");

        jLabel6.setText("Check-in");

        jLabel7.setText("Check-out");

        jLabel8.setText("Room");

        jLabel9.setText("Guest");

        namelbl.setText("jLabel10");

        lastlbl.setText("jLabel10");

        phonelbl.setText("jLabel11");

        IDPasslbl.setText("jLabel12");

        checkinlbl.setText("jLabel13");

        checkoutlbl.setText("jLabel14");

        roomlbl.setText("jLabel15");

        guestlbl.setText("jLabel16");

        cancleBtn.setText("Cancle");
        cancleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancleBtnActionPerformed(evt);
            }
        });

        confirmBtn.setText("Confirm");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("BookingRef.");

        bookingReflbl.setText("jLabel10");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titlelbl)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(guestlbl)
                                .addComponent(roomlbl)
                                .addComponent(checkoutlbl)
                                .addComponent(checkinlbl, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(IDPasslbl)
                                .addComponent(phonelbl)
                                .addComponent(lastlbl)
                                .addComponent(bookingReflbl)
                                .addComponent(namelbl)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cancleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(titlelbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(bookingReflbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(namelbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lastlbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phonelbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(IDPasslbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(checkinlbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(checkoutlbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(roomlbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(guestlbl))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    private void cancleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancleBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        // TODO add your handling code here:
        switch(index){
            case(1):
                insertReservation(reservation);
                this.dispose();
                break;
            case(2):
                updateCheckIn(reservation);
                this.dispose();
                break;
            case(3):
                updateCheckOut(reservation);
                this.dispose();
                break;
            default:
                break;
            
        }
    }//GEN-LAST:event_confirmBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConfirmDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfirmDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfirmDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfirmDialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDPasslbl;
    private javax.swing.JLabel bookingReflbl;
    private javax.swing.JButton cancleBtn;
    private javax.swing.JLabel checkinlbl;
    private javax.swing.JLabel checkoutlbl;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JLabel guestlbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lastlbl;
    private javax.swing.JLabel namelbl;
    private javax.swing.JLabel phonelbl;
    private javax.swing.JLabel roomlbl;
    private javax.swing.JLabel titlelbl;
    // End of variables declaration//GEN-END:variables
}