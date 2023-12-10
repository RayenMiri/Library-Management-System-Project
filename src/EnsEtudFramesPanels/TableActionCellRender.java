/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EnsEtudFramesPanels;

import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
import javax.swing.JTable;

/**
 *
 * @author GLADIATEUR-1650-8
 */
public class TableActionCellRender extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Call the super method to get the default rendering
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        // Assuming PanelAction is a class representing your button or action component
        ResActions action = new ResActions();
        return action;
    }
}
