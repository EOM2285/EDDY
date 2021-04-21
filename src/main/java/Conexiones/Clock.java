/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;


import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import java.util.Date;

/**
 *
 * @author jdavi
 */
public class Clock extends Thread{
   
   private JLabel lbl;

    public Clock(JLabel lbl) {
        this.lbl = lbl;
    }
   
   public void run (){
   
       while (true) {

          Date hoy = new Date();
           SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
           lbl.setText(time.format(hoy));
           
           try {
              
               sleep(1000);
               
           } catch (Exception e) {
           }
           
       }
       
   
   } 
}
