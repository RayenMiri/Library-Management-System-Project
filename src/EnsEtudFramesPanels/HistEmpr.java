package EnsEtudFramesPanels;

import MyClasses.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class HistEmpr extends javax.swing.JPanel {
    private static HistEmpr instance;
    public static Utilisateur user;
    public HistEmpr(Utilisateur user) {
        initComponents();
        this.user = user;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        ArrayList<Emprunt> emps = user.HistoriqueEmprunts();
        for(Emprunt emp : emps){
            model.addRow(new Object[]{
            emp.getIdEmprunt(),
            emp.getIdUtilisateur(),
            emp.getIdLivre(),
            emp.getDateEmprunt(),
            emp.getDateRetour(),
            emp.getStatut()
           
            });                   
        }
       
        

    }
    public static HistEmpr getInstance(Utilisateur user) {
        if (instance != null) {
            return instance;
        }
        return new HistEmpr(user);
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(102, 102, 102));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_emprunt", "id_utilisateur", "id_livre", "date_emprunt", "date_retour", "statut", "action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
