/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herbalsisteminventory;

import controller.DataBaseOperation;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import objekData.Barang;
import objekData.Pelanggan;
import objekData.Penjualan;
import objekData.User;

/**
 *
 * @author HP
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        renderDataTable();
    }
    
   LoginFrame loginFrameref = null;
   String username;
   
   public void setLoginFrameReferensi(LoginFrame frameMasuk){
       loginFrameref = frameMasuk;
       
       
   }
    
    public void aktivasiPanelAdmin (){
       panelDataBarang.setVisible(true);
       panelDataPelanggan.setVisible(true);
       panelDataPenjualan.setVisible(true);
       panelDataUser.setVisible(true);
       panelSetting.setVisible(true);
       System.out.println("login sebagai admin");
       
       showDataProfile();
       
    }
    
    public void setUsername(String usernameMasuk){
        username  = usernameMasuk;
    }
    
    public void showDataProfile (){
        DataBaseOperation engine = new DataBaseOperation();
        int nomorID = engine.getID(username);
        
        User dataUser = engine.getUser(nomorID);
        UsernameSettingTextField.setText(dataUser.getUsername());
        passwordSettingTextField.setText(dataUser.getPassword());
        tangalBuatTextField.setText(dataUser.getTglBuat());
        
    }
    
    public void aktifasiPanelSales(){
        panelTabbed.setEnabledAt(0, true); // muncul tab barang
        panelTabbed.setEnabledAt(1, true); // muncul tab penjualan
        panelTabbed.setEnabledAt(2, true); // muncul tab pelanggan
        panelTabbed.setEnabledAt(3, false); // muncul tab user
        panelTabbed.setEnabledAt(4, true); // muncul setting
  
        System.out.println("login sebagai sales");
    }
    
    public void aktifasiPanelWarehouse(){
       
        panelTabbed.setEnabledAt(0, true); // muncul tab barang
        panelTabbed.setEnabledAt(1, false); // muncul tab penjualan
        panelTabbed.setEnabledAt(2, false); // muncul tab pelanggan
        panelTabbed.setEnabledAt(3, false); // muncul tab user
        panelTabbed.setEnabledAt(4, true); // muncul setting
    
        System.out.println("login sebagai warehouse");
    }
    
    public void renderDataTable (){
        DataBaseOperation engine = new DataBaseOperation();
        ArrayList<Barang> DataBarangArray = engine.getAllBarang();
        ArrayList<User> DataUserArray = engine.getAllUser();
        ArrayList<Penjualan> DataPenjualanArray = engine.getAllPenjualan();
        ArrayList<Pelanggan> DataPelangganArray = engine.getAllPelanggan();
        
        DefaultTableModel kerangkaTableBarang = (DefaultTableModel)DataBarangTabel.getModel();
        DefaultTableModel kerangkaTableUser = (DefaultTableModel)DataUserTabel.getModel();
        DefaultTableModel kerangkaTablePenjualan = (DefaultTableModel)DataPenjualanTabel.getModel();
        DefaultTableModel kerangkaTablePelanggan = (DefaultTableModel)DataPelangganTtabel.getModel();
        
        kerangkaTableBarang.setRowCount(0);
        kerangkaTablePelanggan.setRowCount(0);
        kerangkaTablePenjualan.setRowCount(0);
        kerangkaTableUser.setRowCount(0);
        
        for (int i = 0;  i < DataBarangArray.size() ;i ++){
            Barang satuan = DataBarangArray.get(i);
            Object dataBaru [] = {satuan.getID()+"", satuan.getNama(),satuan.getQty(), satuan.getSatuan(),satuan.getHargaBeli(), satuan.getHargaJual()};
            kerangkaTableBarang.addRow(dataBaru);
        }
        
         for (int i = 0;  i < DataUserArray.size() ;i ++){
            User satuan = DataUserArray.get(i);
            Object dataBaru [] = {satuan.getID()+"", satuan.getUsername(),satuan.getPassword(), satuan.getTglBuat(),satuan.getUsertype()};
            kerangkaTableUser.addRow(dataBaru);
        }
        
         for (int i = 0;  i < DataPenjualanArray.size() ;i ++){
            Penjualan satuan = DataPenjualanArray.get(i);
            Object dataBaru [] = {satuan.getID()+"", satuan.getNama(),satuan.getQty(), satuan.getSatuan(),satuan.getHargaBeli(), satuan.getHargaJual(), satuan.getTglTransaksi()};
            kerangkaTablePenjualan.addRow(dataBaru);
        }
         
            for (int i = 0;  i < DataPelangganArray.size() ;i ++){
            Pelanggan satuan = DataPelangganArray.get(i);
            Object dataBaru [] = {satuan.getID()+"", satuan.getNama(),satuan.getMembership(), satuan.getNoKTP(),satuan.getTglBuat()};
            kerangkaTablePelanggan.addRow(dataBaru);
        }
        
    }
    public void refreshTabel() {
        renderDataTable();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelLogout = new javax.swing.JLabel();
        panelTabbed = new javax.swing.JTabbedPane();
        panelDataBarang = new javax.swing.JPanel();
        label_AddBarang = new javax.swing.JLabel();
        EditLabel = new javax.swing.JLabel();
        deleteLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DataBarangTabel = new javax.swing.JTable();
        panelDataPenjualan = new javax.swing.JPanel();
        add_DataPenjualan = new javax.swing.JLabel();
        editLabel = new javax.swing.JLabel();
        deletePenjualanLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DataPenjualanTabel = new javax.swing.JTable();
        panelDataPelanggan = new javax.swing.JPanel();
        label_DataPelanggan = new javax.swing.JLabel();
        editPelangganLabel = new javax.swing.JLabel();
        deletePelangganLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        DataPelangganTtabel = new javax.swing.JTable();
        panelDataUser = new javax.swing.JPanel();
        label_DataUser = new javax.swing.JLabel();
        editDataUserLabel = new javax.swing.JLabel();
        deleteDataUserLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        DataUserTabel = new javax.swing.JTable();
        panelSetting = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        UsernameSettingTextField = new javax.swing.JTextField();
        passwordSettingTextField = new javax.swing.JTextField();
        tangalBuatTextField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        resetButtonSetting = new javax.swing.JButton();
        saveButtonSetting = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("User :");

        jLabel6.setText("Username");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel7.setText("Settings");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelLogout.setText("Logout");
        labelLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelLogoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(42, 42, 42)
                .addComponent(jLabel7)
                .addGap(46, 46, 46)
                .addComponent(labelLogout)
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(labelLogout))
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 11, -1, -1));

        panelTabbed.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        label_AddBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herbalsisteminventory/add-icon.png"))); // NOI18N
        label_AddBarang.setText("Add");
        label_AddBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_AddBarangMouseClicked(evt);
            }
        });

        EditLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herbalsisteminventory/Actions-document-edit-icon.png"))); // NOI18N
        EditLabel.setText("Edit");
        EditLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditLabelMouseClicked(evt);
            }
        });

        deleteLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herbalsisteminventory/Actions-edit-delete-icon.png"))); // NOI18N
        deleteLabel.setText("Delete");
        deleteLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteLabelMouseClicked(evt);
            }
        });

        DataBarangTabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        DataBarangTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Qty", "Satuan", "Harga Beli", "Harga Jual"
            }
        ));
        jScrollPane1.setViewportView(DataBarangTabel);

        javax.swing.GroupLayout panelDataBarangLayout = new javax.swing.GroupLayout(panelDataBarang);
        panelDataBarang.setLayout(panelDataBarangLayout);
        panelDataBarangLayout.setHorizontalGroup(
            panelDataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataBarangLayout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addGroup(panelDataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDataBarangLayout.createSequentialGroup()
                        .addComponent(label_AddBarang)
                        .addGap(28, 28, 28)
                        .addComponent(EditLabel)
                        .addGap(28, 28, 28)
                        .addComponent(deleteLabel)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDataBarangLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        panelDataBarangLayout.setVerticalGroup(
            panelDataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_AddBarang)
                    .addComponent(EditLabel)
                    .addComponent(deleteLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTabbed.addTab("Data Barang", panelDataBarang);

        add_DataPenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herbalsisteminventory/add-icon.png"))); // NOI18N
        add_DataPenjualan.setText("Add");
        add_DataPenjualan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add_DataPenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_DataPenjualanMouseClicked(evt);
            }
        });

        editLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herbalsisteminventory/Actions-document-edit-icon.png"))); // NOI18N
        editLabel.setText("Edit");
        editLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editLabelMouseClicked(evt);
            }
        });

        deletePenjualanLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herbalsisteminventory/Actions-edit-delete-icon.png"))); // NOI18N
        deletePenjualanLabel.setText("Delete");
        deletePenjualanLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deletePenjualanLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deletePenjualanLabelMouseClicked(evt);
            }
        });

        DataPenjualanTabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        DataPenjualanTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Qty", "Satuan", "Harga Beli", "Harga Jual", "Tgl"
            }
        ));
        jScrollPane2.setViewportView(DataPenjualanTabel);

        javax.swing.GroupLayout panelDataPenjualanLayout = new javax.swing.GroupLayout(panelDataPenjualan);
        panelDataPenjualan.setLayout(panelDataPenjualanLayout);
        panelDataPenjualanLayout.setHorizontalGroup(
            panelDataPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDataPenjualanLayout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addGroup(panelDataPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDataPenjualanLayout.createSequentialGroup()
                        .addComponent(add_DataPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editLabel)
                        .addGap(29, 29, 29)
                        .addComponent(deletePenjualanLabel)))
                .addGap(39, 39, 39))
        );
        panelDataPenjualanLayout.setVerticalGroup(
            panelDataPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataPenjualanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDataPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_DataPenjualan)
                    .addComponent(editLabel)
                    .addComponent(deletePenjualanLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelTabbed.addTab("Data Penjualan", panelDataPenjualan);

        label_DataPelanggan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herbalsisteminventory/add-icon.png"))); // NOI18N
        label_DataPelanggan.setText("Add");
        label_DataPelanggan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_DataPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_DataPelangganMouseClicked(evt);
            }
        });

        editPelangganLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herbalsisteminventory/Actions-document-edit-icon.png"))); // NOI18N
        editPelangganLabel.setText("Edit");
        editPelangganLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editPelangganLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editPelangganLabelMouseClicked(evt);
            }
        });

        deletePelangganLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herbalsisteminventory/Actions-edit-delete-icon.png"))); // NOI18N
        deletePelangganLabel.setText("Delete");
        deletePelangganLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deletePelangganLabelMouseClicked(evt);
            }
        });

        DataPelangganTtabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Membership", "No KTP", "Tgl Registrasi"
            }
        ));
        jScrollPane3.setViewportView(DataPelangganTtabel);

        javax.swing.GroupLayout panelDataPelangganLayout = new javax.swing.GroupLayout(panelDataPelanggan);
        panelDataPelanggan.setLayout(panelDataPelangganLayout);
        panelDataPelangganLayout.setHorizontalGroup(
            panelDataPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataPelangganLayout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addGroup(panelDataPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDataPelangganLayout.createSequentialGroup()
                        .addComponent(label_DataPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editPelangganLabel)
                        .addGap(36, 36, 36)
                        .addComponent(deletePelangganLabel)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDataPelangganLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );
        panelDataPelangganLayout.setVerticalGroup(
            panelDataPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataPelangganLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDataPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_DataPelanggan)
                    .addComponent(editPelangganLabel)
                    .addComponent(deletePelangganLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelTabbed.addTab("Data Pelanggan", panelDataPelanggan);

        label_DataUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herbalsisteminventory/add-icon.png"))); // NOI18N
        label_DataUser.setText("Add");
        label_DataUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_DataUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_DataUserMouseClicked(evt);
            }
        });

        editDataUserLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herbalsisteminventory/Actions-document-edit-icon.png"))); // NOI18N
        editDataUserLabel.setText("Edit");
        editDataUserLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editDataUserLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editDataUserLabelMouseClicked(evt);
            }
        });

        deleteDataUserLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herbalsisteminventory/Actions-edit-delete-icon.png"))); // NOI18N
        deleteDataUserLabel.setText("Delete");
        deleteDataUserLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteDataUserLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteDataUserLabelMouseClicked(evt);
            }
        });

        DataUserTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Username", "Password", "Tgl Dibuat", "User Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(DataUserTabel);

        javax.swing.GroupLayout panelDataUserLayout = new javax.swing.GroupLayout(panelDataUser);
        panelDataUser.setLayout(panelDataUserLayout);
        panelDataUserLayout.setHorizontalGroup(
            panelDataUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDataUserLayout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addGroup(panelDataUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDataUserLayout.createSequentialGroup()
                        .addComponent(label_DataUser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editDataUserLabel)
                        .addGap(30, 30, 30)
                        .addComponent(deleteDataUserLabel)))
                .addGap(41, 41, 41))
        );
        panelDataUserLayout.setVerticalGroup(
            panelDataUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDataUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_DataUser)
                    .addComponent(editDataUserLabel)
                    .addComponent(deleteDataUserLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelTabbed.addTab("Data User", panelDataUser);

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel18.setText("Username :");

        jLabel19.setText("Password  :");

        jLabel20.setText("Tanggal Buat :");

        UsernameSettingTextField.setEditable(false);
        UsernameSettingTextField.setText("......");
        UsernameSettingTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameSettingTextFieldActionPerformed(evt);
            }
        });

        passwordSettingTextField.setText("......");

        tangalBuatTextField.setText(".....");
        tangalBuatTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tangalBuatTextFieldActionPerformed(evt);
            }
        });

        jLabel21.setText("Profil");

        resetButtonSetting.setText("Reset");
        resetButtonSetting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetButtonSettingMouseClicked(evt);
            }
        });

        saveButtonSetting.setText("Save");
        saveButtonSetting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveButtonSettingMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelSettingLayout = new javax.swing.GroupLayout(panelSetting);
        panelSetting.setLayout(panelSettingLayout);
        panelSettingLayout.setHorizontalGroup(
            panelSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSettingLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(panelSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelSettingLayout.createSequentialGroup()
                            .addGroup(panelSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel20)
                                .addComponent(jLabel19)
                                .addGroup(panelSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel18)))
                            .addGap(27, 27, 27)
                            .addGroup(panelSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(UsernameSettingTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                .addComponent(passwordSettingTextField)
                                .addComponent(tangalBuatTextField))))
                    .addGroup(panelSettingLayout.createSequentialGroup()
                        .addComponent(resetButtonSetting)
                        .addGap(18, 18, 18)
                        .addComponent(saveButtonSetting)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        panelSettingLayout.setVerticalGroup(
            panelSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSettingLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(UsernameSettingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordSettingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(panelSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(tangalBuatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addGroup(panelSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetButtonSetting)
                    .addComponent(saveButtonSetting))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        panelTabbed.addTab("Settings", panelSetting);

        getContentPane().add(panelTabbed, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 81, -1, 332));
        panelTabbed.getAccessibleContext().setAccessibleName("Data Barang");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tangalBuatTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tangalBuatTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tangalBuatTextFieldActionPerformed

    private void UsernameSettingTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameSettingTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameSettingTextFieldActionPerformed

    private void label_AddBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_AddBarangMouseClicked
        // TODO add your handling code here:
        DataBarangFrame window = new DataBarangFrame();
        window.setMainFrame(this);
        window.setVisible(true);
    }//GEN-LAST:event_label_AddBarangMouseClicked

    private void add_DataPenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_DataPenjualanMouseClicked
        // TODO add your handling code here:
        DataPenjualanFrame window = new DataPenjualanFrame();
        window.setMainFrame(this);
        window.setVisible(true);
    }//GEN-LAST:event_add_DataPenjualanMouseClicked

    private void label_DataPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_DataPelangganMouseClicked
        // TODO add your handling code here:
        DataPelangganFrame window = new DataPelangganFrame();
        window.setMainFrame(this);
        window.setVisible(true);
        
    }//GEN-LAST:event_label_DataPelangganMouseClicked

    private void label_DataUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_DataUserMouseClicked
        // TODO add your handling code here:
        DataUserFrame window = new DataUserFrame();
        window.setMainFrame(this);
        window.setVisible(true);
    }//GEN-LAST:event_label_DataUserMouseClicked

    private void EditLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditLabelMouseClicked
        // ambil index terpilih dr table
        int indeksTerpilih = DataBarangTabel.getSelectedRow();
        if (indeksTerpilih != -1){
            // mengambil nilai kolom ke-1 yaitu (nama) dr table
            String nilaiNama = DataBarangTabel.getValueAt(indeksTerpilih, 1).toString();
            int nilaiID = Integer.parseInt(DataBarangTabel.getValueAt(indeksTerpilih, 0).toString());
      
            // memdapatkan nilai objek barang dari database operation berdasarkan nama barag 
            DataBaseOperation engine = new DataBaseOperation();
            Barang dataBarang =  engine.getBarang(nilaiNama);
            
            //memunculkan frame
            DataBarangFrame frameBaru = new DataBarangFrame();
            frameBaru.setMainFrame(this);
            frameBaru.setVisible(true);
            //menyerahkan object data barang ke dalam frame barang
            frameBaru.terimaData(dataBarang, nilaiID);
        }
    }//GEN-LAST:event_EditLabelMouseClicked

    private void editLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editLabelMouseClicked
        // TODO add your handling code here:
        int indeksTerpilih = DataPenjualanTabel.getSelectedRow();
        if (indeksTerpilih != -1){
           
            // mengambil nilai kolom ke-0 yaitu (id) dr table
        int nilaiID = Integer.parseInt(DataPenjualanTabel.getValueAt(indeksTerpilih, 0).toString());
    
            // memdapatkan nilai objek barang dari database operation berdasarkan nama barag 
            DataBaseOperation engine = new DataBaseOperation();
            Penjualan dataPenjualan =  engine.getPenjualan(nilaiID);
            
            //memunculkan frame
            DataPenjualanFrame frameBaru = new DataPenjualanFrame();
            frameBaru.setMainFrame(this);
            frameBaru.setVisible(true);
            //menyerahkan object data barang ke dalam frame barang
            frameBaru.terimaData(dataPenjualan, nilaiID);
        }
                                          

    }//GEN-LAST:event_editLabelMouseClicked

    private void deleteLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteLabelMouseClicked
        // mengambil index terpilih dari table
         int indeksTerpilih = DataBarangTabel.getSelectedRow();
        if (indeksTerpilih != -1){
           
            int nilaiID = Integer.parseInt(DataBarangTabel.getValueAt(indeksTerpilih, 0).toString());
      
            // menghapus data barang berdasarkan ID
            DataBaseOperation engine = new DataBaseOperation();
            engine.removeBarang(nilaiID);
            
            refreshTabel();
          
        }
    }//GEN-LAST:event_deleteLabelMouseClicked

    private void deleteDataUserLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteDataUserLabelMouseClicked
        // TODO add your handling code here:
        int indeksTerpilih = DataUserTabel.getSelectedRow();
        if (indeksTerpilih != -1){
           
            int nilaiID = Integer.parseInt(DataUserTabel.getValueAt(indeksTerpilih, 0).toString());
      
            // menghapus data barang berdasarkan ID
            DataBaseOperation engine = new DataBaseOperation();
            engine.removeUser(nilaiID);
            
            refreshTabel();
          
        }
           
    }//GEN-LAST:event_deleteDataUserLabelMouseClicked

    private void deletePenjualanLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletePenjualanLabelMouseClicked
        // TODO add your handling code here:
        int indeksTerpilih = DataPenjualanTabel.getSelectedRow();
        if (indeksTerpilih != -1){
           
            int nilaiID = Integer.parseInt(DataPenjualanTabel.getValueAt(indeksTerpilih, 0).toString());
      
            // menghapus data barang berdasarkan ID
            DataBaseOperation engine = new DataBaseOperation();
            engine.removePenjualan(nilaiID);
            
            refreshTabel();
          
        }
    }//GEN-LAST:event_deletePenjualanLabelMouseClicked

    private void deletePelangganLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletePelangganLabelMouseClicked
        // TODO add your handling code here:
        int indeksTerpilih = DataPelangganTtabel.getSelectedRow();
        if (indeksTerpilih != -1){
           
            int nilaiID = Integer.parseInt(DataPelangganTtabel.getValueAt(indeksTerpilih, 0).toString());
      
            // menghapus data barang berdasarkan ID
            DataBaseOperation engine = new DataBaseOperation();
            engine.removePelanggan(nilaiID);
            
            refreshTabel();
          
        }
    }//GEN-LAST:event_deletePelangganLabelMouseClicked

    private void editPelangganLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editPelangganLabelMouseClicked
        // TODO add your handling code here:
        int indeksTerpilih = DataPelangganTtabel.getSelectedRow();
        if (indeksTerpilih != -1){
           
            // mengambil nilai kolom ke-0 yaitu (id) dr table
        int nilaiID = Integer.parseInt(DataPelangganTtabel.getValueAt(indeksTerpilih, 0).toString());
    
            // memdapatkan nilai objek barang dari database operation berdasarkan nama barag 
            DataBaseOperation engine = new DataBaseOperation();
            Pelanggan dataPelanggan =  engine.getPelanggan(nilaiID);
            
            //memunculkan frame
            DataPelangganFrame frameBaru = new DataPelangganFrame();
            frameBaru.setMainFrame(this);
            frameBaru.setVisible(true);
            //menyerahkan object data barang ke dalam frame barang
            frameBaru.terimaData(dataPelanggan, nilaiID);
        }
    }//GEN-LAST:event_editPelangganLabelMouseClicked

    private void editDataUserLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editDataUserLabelMouseClicked
        // TODO add your handling code here:
        int indeksTerpilih = DataUserTabel.getSelectedRow();
        if (indeksTerpilih != -1){
           
            // mengambil nilai kolom ke-0 yaitu (id) dr table
        int nilaiID = Integer.parseInt(DataUserTabel.getValueAt(indeksTerpilih, 0).toString());
    
            // memdapatkan nilai objek barang dari database operation berdasarkan nama barag 
            DataBaseOperation engine = new DataBaseOperation();
            User dataUser =  engine.getUser(nilaiID);
            
            //memunculkan frame
            DataUserFrame frameBaru = new DataUserFrame();
            frameBaru.setMainFrame(this);
            frameBaru.setVisible(true);
            //menyerahkan object data barang ke dalam frame barang
            frameBaru.terimaData(dataUser, nilaiID);
        }
    }//GEN-LAST:event_editDataUserLabelMouseClicked

    private void labelLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLogoutMouseClicked
        // TODO add your handling code here:
        loginFrameref.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_labelLogoutMouseClicked

    private void resetButtonSettingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetButtonSettingMouseClicked
        // TODO add your handling code here:
        UsernameSettingTextField.setText("");
        passwordSettingTextField.setText("");
        tangalBuatTextField.setText("");
      
    }//GEN-LAST:event_resetButtonSettingMouseClicked

    private void saveButtonSettingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonSettingMouseClicked
        // TODO add your handling code here:
        int noID;
        User dataUser ;
        
        DataBaseOperation engine = new DataBaseOperation();
        noID = engine.getID(UsernameSettingTextField.getText());
        dataUser = engine.getUser(noID);
        
        dataUser.setUsername(UsernameSettingTextField.getText());
        dataUser.setPassword(passwordSettingTextField.getText());
        dataUser.setTglBuat(tangalBuatTextField.getText());
        
        engine.updateDataUser(dataUser, noID);
    }//GEN-LAST:event_saveButtonSettingMouseClicked

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DataBarangTabel;
    private javax.swing.JTable DataPelangganTtabel;
    private javax.swing.JTable DataPenjualanTabel;
    private javax.swing.JTable DataUserTabel;
    private javax.swing.JLabel EditLabel;
    private javax.swing.JTextField UsernameSettingTextField;
    private javax.swing.JLabel add_DataPenjualan;
    private javax.swing.JLabel deleteDataUserLabel;
    private javax.swing.JLabel deleteLabel;
    private javax.swing.JLabel deletePelangganLabel;
    private javax.swing.JLabel deletePenjualanLabel;
    private javax.swing.JLabel editDataUserLabel;
    private javax.swing.JLabel editLabel;
    private javax.swing.JLabel editPelangganLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelLogout;
    private javax.swing.JLabel label_AddBarang;
    private javax.swing.JLabel label_DataPelanggan;
    private javax.swing.JLabel label_DataUser;
    private javax.swing.JPanel panelDataBarang;
    private javax.swing.JPanel panelDataPelanggan;
    private javax.swing.JPanel panelDataPenjualan;
    private javax.swing.JPanel panelDataUser;
    private javax.swing.JPanel panelSetting;
    private javax.swing.JTabbedPane panelTabbed;
    private javax.swing.JTextField passwordSettingTextField;
    private javax.swing.JButton resetButtonSetting;
    private javax.swing.JButton saveButtonSetting;
    private javax.swing.JTextField tangalBuatTextField;
    // End of variables declaration//GEN-END:variables
}
