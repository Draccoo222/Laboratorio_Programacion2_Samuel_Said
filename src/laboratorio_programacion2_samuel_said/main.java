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
        tablaBotones tb = new tablaBotones();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(null);
        JLabel a = new JLabel();
        a.setBounds(225, 0, 150, 20);
        a.setText("PALINDROME AIRLINES");
        

       
        
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
