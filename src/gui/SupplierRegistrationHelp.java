/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.formdev.flatlaf.IntelliJTheme;
import java.awt.Image;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author User
 */
public class SupplierRegistrationHelp extends javax.swing.JFrame {

    GRN grn;
    /**
     * Creates new form h
     */
    public SupplierRegistrationHelp() {
        initComponents();
        loadSuppliers();
        ImageIcon icon = new ImageIcon("src/resources/icon_img.jpg");
        Image img = icon.getImage();
        setIconImage(img);
    }
    
    public SupplierRegistrationHelp(GRN grn) {
        initComponents();
        loadSuppliers();
        ImageIcon icon = new ImageIcon("src/resources/icon_img.jpg");
        Image img = icon.getImage();
        setIconImage(img);
        this.grn = grn;
    }
    
    public void loadSuppliers() {

        try {

            ResultSet rs = MySQL.search("SELECT supplier.id, supplier.name, supplier.contact_number, supplier.email, company.id, company.name, company.contact_number, address.line1, address.line2, city.name FROM supplier INNER JOIN company ON supplier.company_id = company.id INNER JOIN address ON company.address_id = address.id INNER JOIN city ON address.city_id = city.id ORDER BY supplier.id ASC");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("supplier.id"));
                v.add(rs.getString("supplier.name"));
                v.add(rs.getString("supplier.contact_number"));
                v.add(rs.getString("supplier.email"));
                v.add(rs.getString("company.id"));
                v.add(rs.getString("company.name"));
                v.add(rs.getString("company.contact_number"));
                v.add(rs.getString("address.line1"));
                v.add(rs.getString("address.line2"));
                v.add(rs.getString("city.name"));
                dtm.addRow(v);
            }

            jTable1.setModel(dtm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadSuppliers(String text) {

        try {

            ResultSet rs = MySQL.search("SELECT supplier.id, supplier.name, supplier.contact_number, supplier.email, company.id, company.name, company.contact_number, address.line1, address.line2, city.name FROM supplier INNER JOIN company ON supplier.company_id = company.id INNER JOIN address ON company.address_id = address.id INNER JOIN city ON address.city_id = city.id WHERE `supplier`.`name` LIKE '" + text + "%' OR `supplier`.`contact_number` LIKE '" + text + "%'  ORDER BY supplier.id ASC");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("supplier.id"));
                v.add(rs.getString("supplier.name"));
                v.add(rs.getString("supplier.contact_number"));
                v.add(rs.getString("supplier.email"));
                v.add(rs.getString("company.id"));
                v.add(rs.getString("company.name"));
                v.add(rs.getString("company.contact_number"));
                v.add(rs.getString("address.line1"));
                v.add(rs.getString("address.line2"));
                v.add(rs.getString("city.name"));
                dtm.addRow(v);
            }

            jTable1.setModel(dtm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetFields() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField2.setEditable(true);

        jLabel14.setText("None");
        jLabel3.setText("None");
        jLabel15.setText("None");
        jLabel8.setText("None");
        jLabel16.setText("None");
        jLabel18.setText("None");
        jTextField1.grabFocus();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 51,100));
        jPanel1.setPreferredSize(new java.awt.Dimension(203, 30));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Supplier Name");
        jLabel2.setPreferredSize(new java.awt.Dimension(203, 30));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 299, 135, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("None");
        jLabel3.setAlignmentX(0.5F);
        jLabel3.setOpaque(true);
        jLabel3.setPreferredSize(new java.awt.Dimension(203, 30));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(784, 149, 380, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Contact Number");
        jLabel4.setPreferredSize(new java.awt.Dimension(203, 30));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 299, 140, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Contact Number");
        jLabel5.setPreferredSize(new java.awt.Dimension(203, 30));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 185, 140, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("e-mail");
        jLabel6.setPreferredSize(new java.awt.Dimension(203, 30));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 350, 135, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Company Id");
        jLabel7.setPreferredSize(new java.awt.Dimension(203, 30));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 149, 140, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Company City");
        jLabel9.setPreferredSize(new java.awt.Dimension(203, 30));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 185, 135, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Company Name");
        jLabel11.setPreferredSize(new java.awt.Dimension(203, 30));
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 149, 135, -1));

        jLabel12.setFont(new java.awt.Font("Harrington", 1, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 204, 51));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/userreg.png"))); // NOI18N
        jLabel12.setText("Supplier Registration");
        jLabel12.setFocusable(false);
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 6, -1, 76));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Supplier Name", "Contact No", "Supplier e-mail", "Company ID", "Company Name", "Company Contact", "Address Line1", "Address Line2", "City"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 504, 1134, 324));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 302, 405, 30));

        jTextField2.setOpaque(true);
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(766, 302, 403, 30));
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 353, 405, 30));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Select Company");
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
        jButton1.setPreferredSize(new java.awt.Dimension(145, 32));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 100, 405, 40));

        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 462, 873, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Search Supplier");
        jLabel13.setPreferredSize(new java.awt.Dimension(203, 30));
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 135, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("Create Supplier Account");
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 401, 500, 46));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("None");
        jLabel14.setAlignmentX(0.5F);
        jLabel14.setAutoscrolls(true);
        jLabel14.setInheritsPopupMenu(false);
        jLabel14.setOpaque(true);
        jLabel14.setPreferredSize(new java.awt.Dimension(203, 30));
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 149, 380, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("None");
        jLabel15.setAlignmentX(0.5F);
        jLabel15.setOpaque(true);
        jLabel15.setPreferredSize(new java.awt.Dimension(203, 30));
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 185, 380, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("None");
        jLabel8.setAlignmentX(0.5F);
        jLabel8.setOpaque(true);
        jLabel8.setPreferredSize(new java.awt.Dimension(203, 30));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(784, 185, 380, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Address Line1");
        jLabel10.setPreferredSize(new java.awt.Dimension(203, 30));
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 221, 140, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("None");
        jLabel16.setAlignmentX(0.5F);
        jLabel16.setOpaque(true);
        jLabel16.setPreferredSize(new java.awt.Dimension(203, 30));
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 221, 380, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("Address Line2");
        jLabel17.setPreferredSize(new java.awt.Dimension(203, 30));
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 221, 135, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("None");
        jLabel18.setAlignmentX(0.5F);
        jLabel18.setOpaque(true);
        jLabel18.setPreferredSize(new java.awt.Dimension(203, 30));
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(784, 221, 380, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 900));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            jTextField2.setEditable(true);
            jTextField2.setText("");
            jTextField2.grabFocus();

        }
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
        if (jTextField2.getText().length() == 10) {
            jTextField2.setEditable(false);
        }
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
        String mobile = jTextField2.getText();
        String text = mobile + evt.getKeyChar();

        if (text.length() == 1) {
            if (!text.equals("0")) {
                evt.consume();
            }
        } else if (text.length() == 2) {
            if (!text.equals("07")) {
                evt.consume();
            }
        } else if (text.length() == 3) {
            if (!Pattern.compile("07[01245678]").matcher(text).matches()) {
                evt.consume();
            }
        } else if (text.length() <= 10) {
            if (!Pattern.compile("07[01245678][0-9]+").matcher(text).matches()) {
                evt.consume();
            }
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CompanyRegistration cr = new CompanyRegistration(this);
        cr.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        // TODO add your handling code here:
        String text = jTextField8.getText();
        loadSuppliers(text);
    }//GEN-LAST:event_jTextField8KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add yourString handling code here:
        String sname = jTextField1.getText();
        String scn = jTextField2.getText();
        String semail = jTextField3.getText();
        String cid = jLabel14.getText();

        if (cid.equals("None")) {
            JOptionPane.showMessageDialog(this, "Please select company", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (sname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter supplier name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!Pattern.compile("07[01245678][0-9]{7}").matcher(scn).matches()) {
            JOptionPane.showMessageDialog(this, "Please enter supplier contact number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$").matcher(semail).matches()) {
            JOptionPane.showMessageDialog(this, "Invalid email", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet rs = MySQL.search("SELECT * FROM `supplier` WHERE `email` = '" + semail + "' OR `contact_number` = '" + scn + "'");
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Supplier already exists", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {

                    MySQL.iud("INSERT INTO `supplier` (`name`,`contact_number`,`email`,`company_id`) VALUES ('" + sname + "','" + scn + "','" + semail + "','" + cid + "')");

                    resetFields();
                    loadSuppliers();

                    this.resize(1200, 900);

                    JOptionPane.showMessageDialog(this, "New supplier account created", "Success", JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int r = jTable1.getSelectedRow();
            if (r == -1) {
                JOptionPane.showMessageDialog(this, "Please select a supplier", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                
                if(grn != null){
                String sid = jTable1.getValueAt(r, 0).toString();
                String sname = jTable1.getValueAt(r, 1).toString();
                String smobile = jTable1.getValueAt(r, 2).toString();
                String branch = jTable1.getValueAt(r, 4).toString();
         
                grn.jLabel2.setText(sid);
                grn.jLabel4.setText(sname);
                grn.jLabel6.setText(smobile);
                grn.jLabel8.setText(branch);
                
                grn.jButton1.setText("Update Supplier");
                grn.jButton1.setEnabled(false);
                
                grn.resize(1200, 900);
                this.dispose();
                }

            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            InputStream is = (splash.class.getResourceAsStream("/resources/Cobalt_2.theme.json"));
            IntelliJTheme.setup(is);

        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupplierRegistrationHelp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    public javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
