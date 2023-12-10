/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package BilbioFramesPanels;

import MyClasses.*;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.sql.*;
import MyFrames.*;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JTable;

/**
 *
 * @author GLADIATEUR-1650-8
 */
public class RetLivre extends javax.swing.JPanel {
    private static RetLivre instance;
    public  Utilisateur user;
    /**
     * Creates new form ConsulterCatalogue
     */
    public RetLivre(Utilisateur user) {
        initComponents();
        this.user= user;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        ArrayList<Map<String, String>> demands = getAllDemands();
        for(Map<String, String> demand : demands){
            model.addRow(new Object[]{
            demand.get("id_demande"),
            demand.get("id_livre"),
            demand.get("id_utilisateur")
            });                   
        }
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTable1.getSelectedRow();
                    if (selectedRow != -1) {
                        displaySelectedRowData(selectedRow);
                    }
                }
            }
        });

            // Add the document listener to the RechTit JTextField
            RechTit.getDocument().addDocumentListener(new DocumentListener() {
                public void changedUpdate(DocumentEvent e) {
                    search();
                }
                public void removeUpdate(DocumentEvent e) {
                    search();
                }
                public void insertUpdate(DocumentEvent e) {
                    search();
                }

                public void search(){
                    String searchTerm = RechTit.getText();

                    ArrayList<Map<String, String>> allDemands = getAllDemands();
                    ArrayList<Map<String, String>> searchResults = searchBooksByTitle(searchTerm, allDemands);

                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.setRowCount(0);

                    for(Map<String, String> demand : searchResults){
                        System.out.println("working");
                        model.addRow(new Object[]{
                        demand.get("id_demande"),
                        demand.get("id_livre"),
                        demand.get("id_utilisateur")
                        });                   
                    }
                }
            });


            if (jTable1.getRowCount() > 0) {
                displaySelectedRowData(0);
            }
        }
        public ArrayList<Map<String, String>> searchBooksByTitle(String searchTerm, ArrayList<Map<String, String>> allDemands) {
            ArrayList<Map<String, String>> searchResults = new ArrayList<>();

            for (Map<String, String> demand : allDemands) {
                if (demand.get("id_livre").toLowerCase().contains(searchTerm.toLowerCase())) {
                    searchResults.add(demand);
                }
            }

                return searchResults;
        }
        public ArrayList<Map<String, String>> getAllDemands() {
            ArrayList<Map<String, String>> allDemands = new ArrayList<>();
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                conn = DBConnection.openConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM demretliv"); 

                while (rs.next()) {
                    Map<String, String> demand = new HashMap<>();
                    demand.put("id_demande", rs.getString("id_demande"));
                    demand.put("id_livre", rs.getString("id_livre"));
                    demand.put("id_utilisateur", rs.getString("id_utilisateur"));

                    allDemands.add(demand);
                }

                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }

            return allDemands;
        }    
    public static RetLivre getInstance(Utilisateur user){
        if(instance!=null){
            return instance;
        }else{
            return new RetLivre(user);
        }
    }
    private void displaySelectedRowData(int selectedRow) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // Get data from the selected row
        Object idDemData = model.getValueAt(selectedRow, 0);
        Object idLivreData = model.getValueAt(selectedRow, 1);
        Object idUtilData = model.getValueAt(selectedRow, 2);
        

        // Set data to corresponding text fields
        idDem.setText(String.valueOf(idDemData));
        idLivre.setText(String.valueOf(idLivreData));
        idUtil.setText(String.valueOf(idUtilData));
        
    }
    public static void deleteRowByValue(JTable table, String value, int columnIndex) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        

        
        for (int row = 0; row < model.getRowCount(); row++) {
            String cellValue = model.getValueAt(row, columnIndex).toString();

            
            if (cellValue != null && cellValue.equals(value)) {
                
                model.removeRow(row);
                break;
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        RechTit = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        Retourner = new javax.swing.JButton();
        jOptionPane1 = new javax.swing.JOptionPane();
        jPanel3 = new javax.swing.JPanel();
        idDem = new javax.swing.JTextField();
        idLivre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        idUtil = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RechTit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jPanel4.add(RechTit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 231, 34));

        jButton5.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton5.setText("Quitter");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 590, -1, 30));

        Retourner.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        Retourner.setText("Retourner le livre");
        Retourner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetournerActionPerformed(evt);
            }
        });
        jPanel4.add(Retourner, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 150, -1));

        jOptionPane1.setEnabled(false);
        jOptionPane1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jPanel4.add(jOptionPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 0, 0));

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 490, 250));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        idDem.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        idDem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idDemActionPerformed(evt);
            }
        });

        idLivre.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        idLivre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idLivreActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID Livre");

        idUtil.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        idUtil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idUtilActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID Demande");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ID Utilisateur");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idLivre, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addComponent(idDem)
                    .addComponent(idUtil))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 77, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idLivre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idUtil, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idDem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 250));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_demande", "id_livre", "id_utilisateur"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(40);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 1000, 340));
    }// </editor-fold>//GEN-END:initComponents

    private void idUtilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idUtilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idUtilActionPerformed

    private void idLivreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idLivreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idLivreActionPerformed

    private void RetournerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetournerActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        user.RetourLivre(idLivre.getText(),idDem.getText());
        deleteRowByValue(jTable1, idLivre.getText() ,1);
    }//GEN-LAST:event_RetournerActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void idDemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idDemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idDemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField RechTit;
    private javax.swing.JButton Retourner;
    private javax.swing.JTextField idDem;
    private javax.swing.JTextField idLivre;
    private javax.swing.JTextField idUtil;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
