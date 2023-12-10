package BilbioFramesPanels;

import BilbioFramesPanels.NotifAction;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;


public class NotifActionsEditor extends AbstractCellEditor implements TableCellEditor {
    private NotifAction nActionsPanel;
    private String idUser;
    private int Selectedrow;
    private JTable CurrTable;

    public NotifActionsEditor() {
        nActionsPanel = new NotifAction();

        // Add action listener to handle button click
        nActionsPanel.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click action here
                DefaultTableModel model = (DefaultTableModel) CurrTable.getModel();
                new MyClasses.Utilisateur(null,null,null,null,null,null).NotifierUtilisateur("Veuiller Retourner le livre " + model.getValueAt(Selectedrow, 2).toString()+"SVP !",idUser);
                
                
                    
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        idUser = (String)table.getValueAt(row, 1);
        Selectedrow = row;
        CurrTable = table;
        return nActionsPanel;
    }

    @Override
    public Object getCellEditorValue() {
        // You can return some value if needed
        return null;
    }
}
