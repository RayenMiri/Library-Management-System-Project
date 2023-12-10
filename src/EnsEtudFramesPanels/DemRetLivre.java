package EnsEtudFramesPanels;
import MyClasses.*;
import MyFrames.DBConnection;
import java.sql.*;
/**
 *
 * @author GLADIATEUR-1650-8
 */
public class DemRetLivre extends javax.swing.JPanel {
    private Utilisateur user;
    private static DemRetLivre instance;
    
    /**
     * Creates new form HistEmpr
     */
    public DemRetLivre(Utilisateur user) {
        initComponents();
        this.user = user;
        System.out.println(user.getNom());
    }
    public static DemRetLivre getInstance(Utilisateur user){
        if(instance == null){
            return new DemRetLivre(user);
        }
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idLivre = new javax.swing.JTextField();
        Retourner = new javax.swing.JButton();
        livreinex = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jOptionPane1 = new javax.swing.JOptionPane();

        setBackground(new java.awt.Color(102, 102, 102));

        idLivre.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        Retourner.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        Retourner.setText("Retourner");
        Retourner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetournerActionPerformed(evt);
            }
        });

        livreinex.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        livreinex.setForeground(new java.awt.Color(255, 0, 0));
        livreinex.setText(" ");

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID Livre");

        jOptionPane1.setEnabled(false);
        jOptionPane1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(idLivre, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(387, 387, 387)
                        .addComponent(livreinex, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(444, 444, 444)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(403, 403, 403)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Retourner, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jOptionPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(343, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(idLivre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(livreinex)
                .addGap(68, 68, 68)
                .addComponent(Retourner)
                .addGap(121, 121, 121)
                .addComponent(jOptionPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RetournerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetournerActionPerformed
        // TODO add your handling code here:
        Connection connection = null;
        PreparedStatement pst = null;
        
        ResultSet res = null;
        try{
            
            connection = DBConnection.openConnection();
            pst = connection.prepareStatement("SELECT * FROM emprunt WHERE id_utilisateur = ? and id_livre = ? and statut = 'En Cours'");
            pst.setString(1,user.getId());
            pst.setString(2,idLivre.getText());
            System.out.println(user.getId());
            res = pst.executeQuery();
            if(res.next()){
                
                user.DemandeRetourLivre(idLivre.getText());
                jOptionPane1.showMessageDialog(null, "Demande de retour a été envoyé avec succé!");
                
                
            }else{
                
                jOptionPane1.showMessageDialog(null, "Vous n'avez pas emprunter ce livre !");
            }
            
        }catch(SQLException e){
            e.getMessage();
        }finally{
            try{
                if(pst!=null&&res!=null){
                    DBConnection.closeConnection();
                    pst.close();
                    res.close();
                }
               
                
            }catch(SQLException e){
                e.getMessage();
            }
        }
       
    }//GEN-LAST:event_RetournerActionPerformed
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Retourner;
    private javax.swing.JTextField idLivre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JLabel livreinex;
    // End of variables declaration//GEN-END:variables
}