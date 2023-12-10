/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package EnsEtudFramesPanels;

import MyClasses.*;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.sql.*;
import MyFrames.*;

/**
 *
 * @author GLADIATEUR-1650-8
 */
public class EEConsCatalogue extends javax.swing.JPanel {
    private static EEConsCatalogue instance;
    public  Utilisateur user;
    /**
     * Creates new form ConsulterCatalogue
     */
    public EEConsCatalogue(Utilisateur user) {
    initComponents();
    this.user= user;
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    ArrayList<Livre> livres = Livre.ConsulterCatalgoue();
    for(Livre livre : livres){
        model.addRow(new Object[]{
        livre.getidLivre(),
        livre.getTitre(),
        livre.getAuteur(),
        livre.getGenre(),
        livre.getDispo()
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

                ArrayList<Livre> allBooks = getAllBooks();
                ArrayList<Livre> searchResults = searchBooksByTitle(searchTerm, allBooks);

                
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);

                
                for(Livre livre : searchResults){
                    System.out.println("working");
                    model.addRow(new Object[]{
                    livre.getidLivre(),
                    livre.getTitre(),
                    livre.getAuteur(),
                    livre.getGenre(),
                    livre.getDispo()
                    });                   
                }
            }
        });

        
        if (jTable1.getRowCount() > 0) {
            displaySelectedRowData(0);
        }
    }
    public ArrayList<Livre> searchBooksByTitle(String searchTerm, ArrayList<Livre> allBooks) {
        ArrayList<Livre> searchResults = new ArrayList<>();

        for (Livre livre : allBooks) {
            if (livre.getTitre().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchResults.add(livre);
            }
        }

        return searchResults;
    }
    public ArrayList<Livre> getAllBooks() {
        ArrayList<Livre> allBooks = new ArrayList<>();
        Connection conn = null;

        
        Statement stmt = null;

       
        ResultSet rs = null;
        try {
            
            conn = DBConnection.openConnection();


            stmt = conn.createStatement();


            rs = stmt.executeQuery("SELECT * FROM livre");


            while (rs.next()) {
                String idLivre = rs.getString("id_livre");
                String titre = rs.getString("titre");
                String auteur = rs.getString("auteur");
                String genre = rs.getString("genre");
                String dispo = rs.getString("dispo");


                allBooks.add(new Livre(idLivre, titre, auteur, genre, dispo));
            }


            conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }

        return allBooks;
    }
    public static EEConsCatalogue getInstance(Utilisateur user){
        if(instance!=null){
            return instance;
        }else{
            return new EEConsCatalogue(user);
        }
    }
    private void displaySelectedRowData(int selectedRow) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        
        Object idLivreData = model.getValueAt(selectedRow, 0);
        Object titreData = model.getValueAt(selectedRow, 1);
        Object auteurData = model.getValueAt(selectedRow, 2);
        Object genreData = model.getValueAt(selectedRow, 3);
        Object dispoData = model.getValueAt(selectedRow, 4);

       
        idLivre.setText(String.valueOf(idLivreData));
        Titre.setText(String.valueOf(titreData));
        Auteur.setText(String.valueOf(auteurData));
        Genre.setText(String.valueOf(genreData));
        Dispo.setText(String.valueOf(dispoData));
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
        Reserver = new javax.swing.JButton();
        jOptionPane1 = new javax.swing.JOptionPane();
        jPanel3 = new javax.swing.JPanel();
        idLivre = new javax.swing.JTextField();
        Titre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Genre = new javax.swing.JTextField();
        Dispo = new javax.swing.JTextField();
        Auteur = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RechTit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jPanel4.add(RechTit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 231, 34));

        jButton5.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton5.setText("Quitter");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 590, -1, 30));

        Reserver.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        Reserver.setText("Reserver le livre");
        Reserver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReserverActionPerformed(evt);
            }
        });
        jPanel4.add(Reserver, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 160, -1));

        jOptionPane1.setEnabled(false);
        jOptionPane1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jPanel4.add(jOptionPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 0, 0));

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 490, 250));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        idLivre.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        Titre.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        Titre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TitreActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID Livre");

        Genre.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        Genre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenreActionPerformed(evt);
            }
        });

        Dispo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        Dispo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DispoActionPerformed(evt);
            }
        });

        Auteur.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        Auteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuteurActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Titre");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Auteur");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Genre");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Disponibilité");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Titre, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addComponent(idLivre)
                    .addComponent(Auteur)
                    .addComponent(Genre)
                    .addComponent(Dispo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLivre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Titre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Auteur, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Genre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Dispo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 250));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_livre", "titre", "auteur", "genre", "dispo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

    private void AuteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AuteurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AuteurActionPerformed

    private void DispoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DispoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DispoActionPerformed

    private void GenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GenreActionPerformed

    private void TitreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TitreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TitreActionPerformed

    private void ReserverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReserverActionPerformed
        // TODO add your handling code here:
        if (user.LivreEstReserve(idLivre.getText())){
            jOptionPane1.showMessageDialog(null, "Vous avez déja reservé ce livre !");
        }else{
            user.ReservationLivreEnLigne(idLivre.getText());
        }
        
    }//GEN-LAST:event_ReserverActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Auteur;
    private javax.swing.JTextField Dispo;
    private javax.swing.JTextField Genre;
    private javax.swing.JTextField RechTit;
    private javax.swing.JButton Reserver;
    private javax.swing.JTextField Titre;
    private javax.swing.JTextField idLivre;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
