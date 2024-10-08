/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.formdev.flatlaf.IntelliJTheme;
import java.awt.Image;
import java.io.InputStream;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class splash extends javax.swing.JFrame {

    /**
     * Creates new form splash
     */
    public splash() {
        initComponents();
        ImageIcon icon = new ImageIcon("src/resources/icon_img.jpg");
        Image img = icon.getImage();
        setIconImage(img);
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
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 51));
        jLabel2.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 40)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(244, 136, 45));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        jLabel2.setFocusable(false);
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 310, 50));

        jLabel3.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(244, 136, 45));
        jLabel3.setText(" ");
        jLabel3.setToolTipText("");
        jLabel3.setFocusable(false);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 640, 300, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cover_img.jpg"))); // NOI18N
        jLabel1.setMinimumSize(new java.awt.Dimension(1200, 800));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, -1, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
                splash s = new splash();
                s.setVisible(true);

                Thread t = new Thread(() -> {

                    for (int i = 0; i <= 100; i++) {
                        String l1;
                        s.jProgressBar1.setValue(i);
                        s.jLabel3.setText("Loading.." + i + "%");

                        try {
                            Thread.sleep(65);
                            switch (i) {
                                case 10:
                                    s.jLabel2.setText("W");
                                    break;
                                case 20:
                                    l1 = s.jLabel2.getText();
                                    s.jLabel2.setText(l1 + "E");
                                    break;
                                case 30:
                                    l1 = s.jLabel2.getText();
                                    s.jLabel2.setText(l1 + "L");
                                    break;
                                case 40:
                                    l1 = s.jLabel2.getText();
                                    s.jLabel2.setText(l1 + "L");
                                    break;
                                case 50:
                                    l1 = s.jLabel2.getText();
                                    s.jLabel2.setText(l1 + "C");
                                    break;
                                case 60:
                                    l1 = s.jLabel2.getText();
                                    s.jLabel2.setText(l1 + "O");
                                    break;
                                case 70:
                                    l1 = s.jLabel2.getText();
                                    s.jLabel2.setText(l1 + "M");
                                    break;
                                case 80:
                                    l1 = s.jLabel2.getText();
                                    s.jLabel2.setText(l1 + "E");
                                    break;
                                default:
                                    break;
                            }
                        } catch (Exception e) {
                        }
                    }

                    signIn s1 = new signIn();
                    s1.setVisible(true);
                    s.dispose();

                });

                t.start();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
