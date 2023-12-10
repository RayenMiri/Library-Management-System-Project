/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BilbioFramesPanels;

import BilbioFramesPanels.NotifAction;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
import javax.swing.JTable;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;



/**
 *
 * @author GLADIATEUR-1650-8
 */
public class NotifTableActionCellRender extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        
        String column5Value = table.getValueAt(row, 5).toString(); 

        Date today = null;
        Date RetDay= null;
        String column4Value = table.getValueAt(row, 4).toString(); 
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            RetDay = formatter.parse(column4Value);
            today = formatter.parse(new java.sql.Date(new Date().getTime()).toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
       
        if ("En Cours".equals(column5Value)&& today.after(RetDay)){
            
            NotifAction action = new NotifAction();
            return action;
        } else {
            
            
                       

            return c;
        }
    }
}
