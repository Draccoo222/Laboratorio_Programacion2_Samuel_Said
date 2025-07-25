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
public class tablaBotones extends JPanel{
    botonsito[] asientosVisuales = new botonsito[30];
  
    public tablaBotones() {
    setLayout(new GridLayout(5,6,5,5));
    asientosVisuales = new botonsito[30];
    for (int i = 0; i < asientosVisuales.length; i++) {
      botonsito b = new botonsito("Asiento " + (i+1));
      b.setOpaque(true);
      b.setContentAreaFilled(true);
      b.setBackground(Color.GREEN);   
      asientosVisuales[i] = b;
      add(b);
    }
  }
    public void setColorAsiento(int idx, Color c) {
    asientosVisuales[idx].setBackground(c);
    asientosVisuales[idx].repaint();
  }

}
