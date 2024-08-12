/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author User
 */
public class Budget extends javax.swing.JPanel {

    /**
     * Creates new form PopupMsg
     */
    public Budget() {
        initComponents();
        loadbudget();
        dailyBudget();
        this.resize(1400, 900);
    }

    String final_daily_budget;

    public void Updatebudget() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dNow = sdf.format(new Date());

        try {

            ResultSet result = MySQL.search("SELECT * FROM `invoice` WHERE `date_time` LIKE '" + dNow + "%'");
            double invoice_budget;
            if (result.next()) {

                ResultSet rs1 = MySQL.search("SELECT SUM(invoice_payment.payment)AS `ipayment`,SUM( invoice_payment.balance)AS `ibalance` FROM invoice_payment INNER JOIN invoice ON invoice.id = invoice_payment.invoice_id WHERE `date_time` LIKE '" + dNow + "%' ");
                rs1.next();
                String payment = rs1.getString("ipayment");
                String balance = rs1.getString("ibalance");
                double i = Double.parseDouble(balance);

                if (i < 0) {
                    double i1 = i * -1;
                    invoice_budget = Double.parseDouble(payment) - i1;

                } else {
                    invoice_budget = Double.parseDouble(payment);

                }
            } else {
                invoice_budget = 0;
            }

            ResultSet result1 = MySQL.search("SELECT * FROM `membership_invoice` WHERE `date_time` LIKE '" + dNow + "%'");
            double membership_budget;
            if (result1.next()) {

                ResultSet rs2 = MySQL.search("SELECT SUM(membership_payment.payment)AS `mpayment`,SUM( membership_payment.balance)AS `mbalance` FROM membership_payment INNER JOIN membership_invoice ON membership_invoice.id = membership_payment.membership_invoice_id WHERE membership_invoice.date_time  LIKE '" + dNow + "%' ");
                rs2.next();
                String membership_payment = rs2.getString("mpayment");
                String membership_balance = rs2.getString("mbalance");
                double m = Double.parseDouble(membership_balance);

                if (m < 0) {
                    double m1 = m * -1;
                    membership_budget = Double.parseDouble(membership_payment) - m1;

                } else {
                    membership_budget = Double.parseDouble(membership_payment);

                }
            } else {
                membership_budget = 0;
            }

            ResultSet result2 = MySQL.search("SELECT * FROM `grn` WHERE `date_time` LIKE '" + dNow + "%'");
            double grn_budget;
            if (result2.next()) {

                ResultSet rs3 = MySQL.search("SELECT SUM(grn_payment.payment)AS `gpayment`,SUM( grn_payment.balance)AS `gbalance` FROM grn_payment INNER JOIN grn ON grn.id = grn_payment.grn_id WHERE grn.date_time LIKE '" + dNow + "%' ");
                rs3.next();
                String grn_payment = rs3.getString("gpayment");
                String grn_balance = rs3.getString("gbalance");
                double g = Double.parseDouble(grn_balance);

                if (g < 0) {
                    double g1 = g * -1;
                    grn_budget = Double.parseDouble(grn_payment) - g1;

                } else {
                    grn_budget = Double.parseDouble(grn_payment);

                }
            } else {
                grn_budget = 0;
            }

            double oneday_salary;

            ResultSet rs = MySQL.search("SELECT SUM(`payment_plan`.`monthly_payment`)AS `full_salary`  FROM `payment_plan` ");
            rs.next();
            String fsalary = rs.getString("full_salary");

            //one_day_salary
            oneday_salary = Double.parseDouble(fsalary) / 30;
            //one_day_salary

            double daily_budget = (invoice_budget + membership_budget) - (grn_budget + oneday_salary);
            final_daily_budget = String.format("%.0f", daily_budget);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadbudget() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dNow = sdf.format(new Date());

        try {

            ResultSet rs5 = MySQL.search("SELECT * FROM `budget` WHERE `date`='" + dNow + "'");
            if (rs5.next()) {

                Updatebudget();

                MySQL.iud("UPDATE `budget` SET `budgets` = '" + final_daily_budget + "' WHERE `date`='" + dNow + "'");
                dailyBudget();
                this.resize(1400, 900);

            } else {

                Updatebudget();

                MySQL.iud("INSERT INTO `budget`(`budgets`,`date`) VALUES ('" + final_daily_budget + "','" + dNow + "')");
                dailyBudget();
                this.resize(1400, 900);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dailyBudget() {
        try {
            ResultSet rs = MySQL.search("SELECT * FROM `budget`");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("budgets"));
                v.add(rs.getString("date"));
                dtm.addRow(v);
                this.resize(1400, 900);
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(600, 610));

        jPanel1.setBackground(new java.awt.Color(51, 0, 51,100));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 610));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Budget", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Harrington", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 51));
        jLabel1.setText("Budget");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
