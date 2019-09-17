/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdOrderManagerRole;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Harshitha
 */

    


   public class ComboRenderer extends DefaultCellEditor
{
    public ComboRenderer()
    {
        super(new JComboBox());
    }
  
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
    {
        JComboBox combo = (JComboBox)super.getTableCellEditorComponent(table, value, isSelected, row, column);
        combo.removeAllItems();
        Object[] items = {"Approve","Reject"}; // you'll need to implement this method yourself
        for (Object item: items)
        {
            combo.addItem(item);
        }
        return combo;
    }
}



 


    

