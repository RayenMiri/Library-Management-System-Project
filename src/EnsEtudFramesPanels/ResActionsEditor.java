package EnsEtudFramesPanels;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;


public class ResActionsEditor extends AbstractCellEditor implements TableCellEditor {
    private ResActions resActionsPanel;
    private String idReservation;
    private int Selectedrow;
    private JTable CurrTable;

    public ResActionsEditor() {
        resActionsPanel = new ResActions();

        // Add action listener to handle button click
        resActionsPanel.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click action here
                MyClasses.Reservation.AnnulerReservation(idReservation);
                DefaultTableModel model = (DefaultTableModel) CurrTable.getModel();
                model.removeRow(Selectedrow);      
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        idReservation = (String)table.getValueAt(row, 0);
        Selectedrow = row;
        CurrTable = table;
        return resActionsPanel;
    }

    @Override
    public Object getCellEditorValue() {
        // You can return some value if needed
        return null;
    }
}
