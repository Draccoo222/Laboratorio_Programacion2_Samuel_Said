/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio_programacion2_samuel_said;
import javax.swing.*;
import java.awt.*;
      
/**
 *
 * @author unwir
 */
public class main extends JFrame{
    private JButton sellT      = new JButton("Sell Ticket");
    private JButton cancelT    = new JButton("Cancel Ticket");
    private JButton dispatch   = new JButton("Dispatch");
    private JButton printP     = new JButton("Print Passangers");
    private JButton income     = new JButton("Income");
    private JButton searchPass = new JButton("Search Pass");
    
    public main(){
        components();
    }
    
    private void components(){
        tablaBotones tb = new tablaBotones();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(null);
        JLabel a = new JLabel();
        a.setBounds(270, 0, 300, 50);
        a.setText("PALINDROME AIRLINES");
        a.setFont(new Font("Arial Black", Font.BOLD , 20));
        
        tb.setBounds(10, 55, 500, 500);
        
        sellT.setBounds(550, 60 + 35, 150, 40);
        cancelT.setBounds(550, 120 + 35, 150, 40);
        dispatch.setBounds(550, 180 + 35, 150, 40);
        printP.setBounds(550, 240 + 35, 150, 40);
        income.setBounds(550, 300 + 35, 150, 40);
        searchPass.setBounds(550, 360 + 35, 150, 40);
        
        add(a);
        add(tb);
        add(sellT);
        add(cancelT);
        add(dispatch);
        add(printP);
        add(income);
        add(searchPass);
    
    
    }
    
    
    public static void main(String[] args){
        main b = new main();
        b.setVisible(true);
    } 
}
