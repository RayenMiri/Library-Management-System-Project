package MyFrames;

public class Login extends javax.swing.JFrame {

 
    public Login() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        EEUser = new javax.swing.JButton();
        LUser = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library Management System Login");
        setMinimumSize(new java.awt.Dimension(1161, 672));
        setResizable(false);
        setSize(new java.awt.Dimension(1161, 672));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(54, 123, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Système de gestion de bibliothèque");
        jLabel1.setAlignmentX(0.5F);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 450, 70));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/library.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 510, 510));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 680));

        jPanel2.setBackground(new java.awt.Color(16, 16, 16));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EEUser.setBackground(new java.awt.Color(16, 16, 16));
        EEUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/reading.png"))); // NOI18N
        EEUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EEUserActionPerformed(evt);
            }
        });
        jPanel2.add(EEUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 220, 220));

        LUser.setBackground(new java.awt.Color(16, 16, 16));
        LUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/librarian.png"))); // NOI18N
        LUser.setPreferredSize(new java.awt.Dimension(250, 519));
        LUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LUserActionPerformed(evt);
            }
        });
        jPanel2.add(LUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 220, 220));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Etudiant/Enseignant");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 260, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Se Connecter ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 170, 50));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Bibliothécaire");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 180, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Bienvenue!");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 140, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 610, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void EEUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EEUserActionPerformed
        EELogin loglib = new EELogin();
        loglib.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_EEUserActionPerformed

    private void LUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LUserActionPerformed
        BilbioLogin bibliologin = new BilbioLogin();
        bibliologin.setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_LUserActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EEUser;
    private javax.swing.JButton LUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
