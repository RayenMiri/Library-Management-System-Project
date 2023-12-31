/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package EnsEtudFramesPanels;
import java.sql.*;
import MyFrames.*;
/**
 *
 * @author GLADIATEUR-1650-8
 */
public class Dashboard extends javax.swing.JPanel {
    private static Dashboard instance;
    /**
     * Creates new form Home
     */
    public Dashboard() {
        initComponents();
        loadData();
    }
    public static Dashboard getInstance(){
        if(instance !=null){
            return instance;
        }else{
            return new Dashboard();
        }
    }
    private void loadData() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBConnection.openConnection();
            statement = connection.createStatement();
            
           
            ResultSet resultSet = statement.executeQuery("SELECT u.nom , u.prenom, count(*)  as count FROM emprunt as e ,"
                                                        + "utilisateur as u WHERE e.id_utilisateur=u.id_utilisateur GROUP BY e.id_utilisateur "
                                                        + "ORDER BY count DESC LIMIT 1;");
            if (resultSet.next()) {
                String user = resultSet.getString("nom")+" "+resultSet.getString("prenom");
                jLabel1.setText("L'utilisateur qui a le plus emprunts est : " + user);
            }

            
            resultSet = statement.executeQuery("SELECT COUNT(*) as count FROM livre");
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                jLabel2.setText("Nombre totale des livres : " + count);
            }

            
            resultSet = statement.executeQuery("SELECT COUNT(*) as count FROM emprunt");
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                jLabel3.setText("Nombre des livres indisponible: " + count);
            }

            
            resultSet = statement.executeQuery("SELECT COUNT(*) as count FROM livre WHERE id_livre NOT IN (SELECT id_livre FROM emprunt)");
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                jLabel4.setText("Nombre des livres disponible: " + count);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if (statement != null ) {
                    statement.close();
                    
                }
                if (connection != null) {
                    DBConnection.closeConnection();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("Statistiques");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(426, 426, 426)
                        .addComponent(jLabel5)))
                .addContainerGap(320, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
