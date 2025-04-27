/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inf;

import java.sql.Connection;
import codes.DBconnect;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class mainframe extends javax.swing.JFrame {
    Connection conn = null;
    PreparedStatement pst= null;
    ResultSet rs = null;

    
    public mainframe() {
        initComponents();
        conn = (Connection) DBconnect.connect();
        tableload();
    }

   public void tableload(){
   
       try {
           String sql = "SELECT id AS ID,sname AS Name,sage AS Age ,sgrade AS Grade FROM student";
           pst = conn.prepareStatement(sql);
           rs = pst.executeQuery(); 
           table1.setModel(DbUtils.resultSetToTableModel(rs));
           
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
       }
       
      
   }
     
    public void tabledata(){
        int r = table1.getSelectedRow();
        
        String id = table1.getValueAt(r,0).toString();
        String name = table1.getValueAt(r,1).toString();
        String age = table1.getValueAt(r,2).toString();
        String grade = table1.getValueAt(r,3).toString();
        
        idbox .setText(id);
        namebox.setText(name);
        agebox.setText(age);
        gradebox.setSelectedItem(grade);
}
    
    public void search(){
        String srch = searchbox.getText();
        
        try {
            String sql = "SELECT * FROM student WHERE sname LIKE'%"+srch+"%' OR id LIKE '%" +srch+ "%' ";
            pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void update(){
        String id = idbox.getText();
        String name = namebox.getText();
        String age = agebox.getText();
        String grade = gradebox.getSelectedItem().toString();
        
        try {
            String sql = "UPDATE student SET sname='"+name+"', sage='"+age+"',sgrade='"+grade+"'WHERE id='"+id+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "error!");
        }
        
        
    
    }
    
    public void clear(){
        searchbox.setText("");
        idbox.setText("ID");
        namebox.setText("");
        agebox.setText("");
        gradebox.setSelectedIndex(0);
        
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        searchbox = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        namebox = new javax.swing.JTextField();
        agebox = new javax.swing.JTextField();
        gradebox = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        insertbtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        idbox = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();

        jTable1.setBackground(new java.awt.Color(0, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });
        jPanel3.add(searchbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 190, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 60));

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField2.setBackground(new java.awt.Color(255, 204, 204));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField2.setText("Name");
        jPanel4.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, -1));

        jTextField3.setBackground(new java.awt.Color(255, 204, 204));
        jTextField3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField3.setText("Age");
        jPanel4.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 60, -1));

        jTextField4.setBackground(new java.awt.Color(255, 204, 204));
        jTextField4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField4.setText("Grade");
        jPanel4.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 60, -1));

        namebox.setToolTipText("Enter your name");
        jPanel4.add(namebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 120, -1));
        jPanel4.add(agebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 120, -1));

        gradebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" }));
        jPanel4.add(gradebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 100, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 220, 150));

        jPanel5.setBackground(new java.awt.Color(204, 51, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        insertbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        insertbtn.setText("Insert");
        insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtnActionPerformed(evt);
            }
        });
        jPanel5.add(insertbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, -1));

        updatebtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        updatebtn.setText("Update");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        jPanel5.add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 80, -1));

        deletebtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        jPanel5.add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, -1));

        clearbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        clearbtn.setText("Clear");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });
        jPanel5.add(clearbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 80, -1));

        exitbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        exitbtn.setText("Exit");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });
        jPanel5.add(exitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 90, 20));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 220, 100));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("ID");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        idbox.setText("ID");
        jPanel2.add(idbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 20, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 380));

        table1.setBackground(new java.awt.Color(0, 204, 204));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table1KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(table1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 470, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtnActionPerformed
        String name;
        int age;
        int grade;
        
        name = namebox.getText();
        age = Integer.parseInt(agebox.getText()) ;
        grade = Integer.parseInt(gradebox.getSelectedItem().toString());
        
        try {
            String sql = "INSERT INTO student(sname,sage,sgrade)VALUES('"+name+"','"+age+"','"+grade+"')";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Inserted");
            
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null,e);
        }
        tableload();
    }//GEN-LAST:event_insertbtnActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
                    // TODO add your handling code here:
                    tabledata();
    }//GEN-LAST:event_table1MouseClicked

    private void table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyReleased
        // TODO add your handling code here:
        tabledata();
    }//GEN-LAST:event_table1KeyReleased

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased
                  // TODO add your handling code here:
                  search();
                  
    }//GEN-LAST:event_searchboxKeyReleased

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        // TODO add your handling code here:
        update();
        tableload();
    }//GEN-LAST:event_updatebtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        // TODO add your handling code here:
        int check = JOptionPane.showConfirmDialog(null,"Do you want to delete");
        
        if(check==0){
            String id = idbox.getText();
            
            try {
                String sql = "DELETE FROM student WHERE id='"+id+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Deleted!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Cannot Delete!");
                
                
            }
        
        }
        tableload();
        clear();
    }//GEN-LAST:event_deletebtnActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearbtnActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitbtnActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agebox;
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton exitbtn;
    private javax.swing.JComboBox<String> gradebox;
    private javax.swing.JLabel idbox;
    private javax.swing.JButton insertbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField namebox;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTable table1;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
