/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SuppliesManagerRole;

import userinterface.SupOrderManagerRole.*;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Harshitha
 */

    
 public class Renderer1 extends DefaultTableCellRenderer  {
  JLabel lbl = new JLabel();

 //ImageIcon icon = new ImageIcon(getClass().getResource("sample.png"));

 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
  boolean hasFocus, int row, int column) {
     System.out.println("val"+ value);
     
     JLabel label = new JLabel();
 
        if (value!=null) {
        label.setHorizontalAlignment(JLabel.CENTER);
        //value is parameter which filled by byteOfImage
        label.setIcon(new ImageIcon((byte[])value));
        }
 
        return label;
//lbl.setText("hello");
//lbl.setIcon(icon);
//return lbl;
}
}
 

