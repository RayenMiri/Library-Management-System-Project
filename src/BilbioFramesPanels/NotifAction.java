/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package BilbioFramesPanels;
import MyClasses.*;
import javax.swing.JButton;

/**
 *
 * @author GLADIATEUR-1650-8
 */
public class NotifAction extends javax.swing.JPanel {

    /**
     * Creates new form ResActions
     */
    public NotifAction() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        NotifierUtil = new javax.swing.JButton();

        NotifierUtil.setBackground(new java.awt.Color(255, 51, 0));
        NotifierUtil.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        NotifierUtil.setForeground(new java.awt.Color(255, 255, 255));
        NotifierUtil.setText("Retour Notification");
        NotifierUtil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotifierUtilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NotifierUtil, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NotifierUtil, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void NotifierUtilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotifierUtilActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_NotifierUtilActionPerformed
    public JButton getButton(){
        return this.NotifierUtil;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NotifierUtil;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
