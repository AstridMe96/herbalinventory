
package herbalsisteminventory;

import audioPlayer.Player;
import controller.DataBaseOperation;
import java.awt.CardLayout;
import java.awt.Color;
import java.io.File;

/**
 *
 * @author HP
 */
public class LoginFrame extends javax.swing.JFrame {

    CardLayout canvas = null;
    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
    canvas = (CardLayout) this.getContentPane().getLayout();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        adminButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        karyawanButton = new javax.swing.JButton();
        panelLoginAdmin = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        signInAdminButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        textFieldUsernameAdmin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        buttonBackAdmin = new javax.swing.JButton();
        textFieldPasswordAdmin = new javax.swing.JPasswordField();
        panelLoginKaryawan = new javax.swing.JPanel();
        signInKaryawanButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        usernameKaryawanTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        divisiComboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        passwordKaryawanTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        buttonBackKaryawan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        panelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herbalsisteminventory/herbal.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        panelLogin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-330, -40, 850, 200));

        adminButton.setText("Admin");
        adminButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        adminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminButtonActionPerformed(evt);
            }
        });
        panelLogin.add(adminButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setText("MEMUDAHKAN PENCATATAN INVENTORY & PENJUALAN TOKO ANDA");
        panelLogin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 360, 50));

        jLabel1.setText("Login Sebagai :");
        panelLogin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        karyawanButton.setText("Karyawan");
        karyawanButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        karyawanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                karyawanButtonActionPerformed(evt);
            }
        });
        panelLogin.add(karyawanButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 90, -1));

        getContentPane().add(panelLogin, "LoginAwal");

        panelLoginAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("ADMIN");
        panelLoginAdmin.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 56, -1));

        signInAdminButton.setText("Sign in");
        signInAdminButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signInAdminButtonMouseClicked(evt);
            }
        });
        panelLoginAdmin.add(signInAdminButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 80, 30));

        jLabel6.setText("Password  :");
        panelLoginAdmin.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 70, 20));

        textFieldUsernameAdmin.setText("......");
        textFieldUsernameAdmin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldUsernameAdminFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldUsernameAdminFocusLost(evt);
            }
        });
        textFieldUsernameAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldUsernameAdminActionPerformed(evt);
            }
        });
        panelLoginAdmin.add(textFieldUsernameAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 130, 30));

        jLabel4.setText("Username  :");
        panelLoginAdmin.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 70, 20));

        buttonBackAdmin.setText("Back");
        buttonBackAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackAdminActionPerformed(evt);
            }
        });
        panelLoginAdmin.add(buttonBackAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        textFieldPasswordAdmin.setText("jPasswordField1");
        panelLoginAdmin.add(textFieldPasswordAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 130, 30));

        getContentPane().add(panelLoginAdmin, "LoginAdmin");

        panelLoginKaryawan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        signInKaryawanButton.setText("Sign in");
        signInKaryawanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInKaryawanButtonActionPerformed(evt);
            }
        });
        panelLoginKaryawan.add(signInKaryawanButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 198, -1, -1));

        jLabel7.setText("password :");
        panelLoginKaryawan.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 112, -1, -1));

        usernameKaryawanTextField.setText("......");
        panelLoginKaryawan.add(usernameKaryawanTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 68, 120, 30));

        jLabel8.setText("username :");
        panelLoginKaryawan.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 81, -1, -1));

        divisiComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Warehouse", "Sales" }));
        panelLoginKaryawan.add(divisiComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 123, -1));

        jLabel9.setText("divisi        :");
        panelLoginKaryawan.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        passwordKaryawanTextField.setText("......");
        panelLoginKaryawan.add(passwordKaryawanTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 121, 30));

        jLabel10.setText("KARYAWAN");
        panelLoginKaryawan.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 22, -1, -1));

        buttonBackKaryawan.setText("Back");
        buttonBackKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackKaryawanActionPerformed(evt);
            }
        });
        panelLoginKaryawan.add(buttonBackKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        getContentPane().add(panelLoginKaryawan, "LoginKaryawan");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminButtonActionPerformed
        // TODO add your handling code here:
        canvas.show(this.getContentPane(),"LoginAdmin");
    }//GEN-LAST:event_adminButtonActionPerformed

    private void textFieldUsernameAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldUsernameAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldUsernameAdminActionPerformed

    private void karyawanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_karyawanButtonActionPerformed
        // TODO add your handling code here:
        canvas.show(this.getContentPane(),"LoginKaryawan");
    }//GEN-LAST:event_karyawanButtonActionPerformed

    private void buttonBackAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackAdminActionPerformed
        // TODO add your handling code here:
        canvas.show(this.getContentPane(), "LoginAwal");
    }//GEN-LAST:event_buttonBackAdminActionPerformed

    private void buttonBackKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackKaryawanActionPerformed
        // TODO add your handling code here:
        canvas.show(this.getContentPane(), "LoginAwal");
    }//GEN-LAST:event_buttonBackKaryawanActionPerformed

    private void signInAdminButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signInAdminButtonMouseClicked
        // TODO add your handling code here:
        String username = textFieldUsernameAdmin.getText();
        String password = textFieldPasswordAdmin.getText();
        
        DataBaseOperation engine = new DataBaseOperation();
        
       
        
     if (engine.verifikasiUser(username, password) == true ){
         MainFrame window = new MainFrame();
         window.setVisible(true);
         window.setLoginFrameReferensi(this);
         window.setUsername(username);
         window.aktivasiPanelAdmin();
         
         String lokasi = System.getenv("LOCALAPPDATA") + "\\herbalInventory\\bell.wav";
         File fileaudio = new File(lokasi);
         
         System.out.println(lokasi);
         
         Player audio = new Player();
         audio.play(fileaudio);
         
         
         System.out.println("login berhasilmon");
         this.dispose();
     }else {
         System.out.println("username dan password tidak sesuai");
     }
        
        
    }//GEN-LAST:event_signInAdminButtonMouseClicked

    private void signInKaryawanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInKaryawanButtonActionPerformed
        // TODO add your handling code here:
        String username = usernameKaryawanTextField.getText();
        String password = passwordKaryawanTextField.getText();
        String divisi = divisiComboBox.getSelectedItem().toString();
        
        DataBaseOperation engine = new DataBaseOperation();
     if (engine.verifikasiUser(username, password) == true ){
         MainFrame window = new MainFrame();
         window.setVisible(true);
         window.setLoginFrameReferensi(this);
         
         
         if (divisi.equalsIgnoreCase("sales")){
             window.aktifasiPanelSales();
         }else if(divisi.equalsIgnoreCase("warehouse")){
             window.aktifasiPanelWarehouse();
         }
          
         System.out.println("login berhasilmon");
         this.dispose();
     }else {
         System.out.println("username dan password tidak sesuai");
     }
        
     
     if (usernameKaryawanTextField.getText().equals("")){
        usernameKaryawanTextField.setBackground(Color.red);
     }

     if (passwordKaryawanTextField.getText().equals("")){
         passwordKaryawanTextField.setBackground(Color.red);
         
     }
    }//GEN-LAST:event_signInKaryawanButtonActionPerformed

    private void textFieldUsernameAdminFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldUsernameAdminFocusGained
        // TODO add your handling code here:
        String text = textFieldUsernameAdmin.getText();
        if (text.equalsIgnoreCase("......")){
            textFieldUsernameAdmin.setText("");
        }
    }//GEN-LAST:event_textFieldUsernameAdminFocusGained

    private void textFieldUsernameAdminFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldUsernameAdminFocusLost
        // TODO add your handling code here:
       String text = textFieldUsernameAdmin.getText();
        if (text.equalsIgnoreCase("")){
            textFieldUsernameAdmin.setText("......");
        }
    }//GEN-LAST:event_textFieldUsernameAdminFocusLost

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminButton;
    private javax.swing.JButton buttonBackAdmin;
    private javax.swing.JButton buttonBackKaryawan;
    private javax.swing.JComboBox<String> divisiComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton karyawanButton;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelLoginAdmin;
    private javax.swing.JPanel panelLoginKaryawan;
    private javax.swing.JTextField passwordKaryawanTextField;
    private javax.swing.JButton signInAdminButton;
    private javax.swing.JButton signInKaryawanButton;
    private javax.swing.JPasswordField textFieldPasswordAdmin;
    private javax.swing.JTextField textFieldUsernameAdmin;
    private javax.swing.JTextField usernameKaryawanTextField;
    // End of variables declaration//GEN-END:variables
}