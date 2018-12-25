/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import objekData.Barang;
import objekData.Pelanggan;
import objekData.Penjualan;
import objekData.User;

/**
 *
 * @author HP
 */
public class DataBaseOperation {

    static String myDriver = "com.mysql.jdbc.Driver";
    static String myUrl = "jdbc:mysql://localhost/herbalinventory";

    public static Connection connect() {
        try {
            Class.forName(myDriver);
            return DriverManager.getConnection(myUrl, "root", "");

        } catch (Exception ex) {
            System.out.println("Panggilan connect () method gagal!!");
        }
        return null;

    }
    
       public ArrayList<User> getAllUser() {
        String query = "SELECT * FROM data_user";

        ArrayList<User> namaUser = new ArrayList<User>();

        try {
            PreparedStatement preparedStmt = connect().prepareStatement(query);
            ResultSet hasil = preparedStmt.executeQuery();

            while (hasil.next()) {

                User userBaru = new User();
                // nama kolom getStrign sebenarnya dari table MySQL
                userBaru.setUsername(hasil.getString("username"));
                userBaru.setTglBuat(hasil.getString("tgl_buat"));
                userBaru.setUsertype(hasil.getString("user_type"));
                userBaru.setPassword(hasil.getString("password"));
                userBaru.setID(hasil.getInt("ID"));

                // disimpanlah kedalam array dibawah ini
                namaUser.add(userBaru);
            }

        } catch (Exception ex) {
            System.out.println("terjadi kesalahan saat GetAll User");
            ex.printStackTrace();
        }

        return namaUser;

    }
      
    public int getID(String usernameMasuk){
        int nomor = 0;
        
         String query = "SELECT * FROM data_user WHERE username = ?";

        try {
            PreparedStatement preparedStmt = connect().prepareStatement(query);
            preparedStmt.setString(1, usernameMasuk);
            ResultSet hasil = preparedStmt.executeQuery();

            while (hasil.next()) {
                nomor = hasil.getInt("id");

            }

        } catch (Exception ex) {
            System.out.println("terjadi kesalahan saat Get ID");
            ex.printStackTrace();
        }
        
        return nomor;
        
    }   
       
    public User getUser(int noID) {
        String query = "SELECT * FROM data_user WHERE id = ?";

        User userBaru = new User();

        try {
            PreparedStatement preparedStmt = connect().prepareStatement(query);
            preparedStmt.setInt(1, noID);
            ResultSet hasil = preparedStmt.executeQuery();

            while (hasil.next()) {

                
                // nama kolom getStrign sebenarnya dari table MySQL
                userBaru.setUsername(hasil.getString("username"));
                userBaru.setTglBuat(hasil.getString("tgl_buat"));
                userBaru.setUsertype(hasil.getString("user_type"));
                userBaru.setPassword(hasil.getString("password"));

            }

        } catch (Exception ex) {
            System.out.println("terjadi kesalahan saat Get User");
            ex.printStackTrace();
        }

        return userBaru;

    }

    public boolean verifikasiUser(String username, String pass) {
        String query = "SELECT * FROM data_user WHERE username = ? and password = ?";

       boolean valid = false;

        try {
            PreparedStatement preparedStmt = connect().prepareStatement(query);
            preparedStmt.setString(1, username);
            preparedStmt.setString(2, pass);
            ResultSet hasil = preparedStmt.executeQuery();

            while (hasil.next()) {

              valid= true;
            }

        } catch (Exception ex) {
            System.out.println("terjadi kesalahan saat Verifikasi User");
            ex.printStackTrace();
        }

        return valid;

    }
    
    public boolean removeUser(int noID) {
        String query = "DELETE FROM data_user WHERE id = ?";
        boolean operasi = false;
        

            try {
            PreparedStatement preparedStmt = connect().prepareStatement(query);
            preparedStmt.setInt(1, noID);
            preparedStmt.executeUpdate();
          
          operasi = true ;

        } catch (Exception ex) {
            System.out.println("terjadi kesalahan saat Remove User");
            ex.printStackTrace();
        }
            
            return operasi;
    }

    public void addDataUser(User orangBaru) {
        String query = "INSERT INTO data_user VALUES (null,?,?,?,?,?,?,?)";
        try {

            PreparedStatement preparedStmt = connect().prepareStatement(query);
            preparedStmt.setString(1, orangBaru.getUsername());
            preparedStmt.setString(2, orangBaru.getPassword());
            preparedStmt.setString(3, orangBaru.getTglBuat());
            preparedStmt.setString(4, orangBaru.getUsertype());
            
            int statusAksesBarang = (orangBaru.isAksesDataBarang()) ? 1:0;
            
            // code dibawah dipersingkat dgn code diatas 
//            if(orangBaru.isAksesDataBarang()==true){
//                statusAksesBarang = 1;
//            }else {
//                statusAksesBarang = 0;
//            }
            
            
            int statusAksesPenjualan = (orangBaru.isAksesDataPenjualan()) ? 1:0;
            int statusAksesPelanggan = (orangBaru.isAksesDataPelanggan()) ? 1:0;
            
            preparedStmt.setInt(5, statusAksesBarang);
            preparedStmt.setInt(6, statusAksesPelanggan);
            preparedStmt.setInt(7, statusAksesPenjualan);

            preparedStmt.execute();

        } catch (Exception ex) {

        }
    }
    
    public void updateDataUser(User userBaru, int noID) {
        String query = "UPDATE data_user SET username =?, password=?, tgl_buat=?, user_type=?, akses_data_barang =? , akses_data_penjualan=?, akses_data_pelanggan=? WHERE id=?";
        try {

            PreparedStatement preparedStmt = connect().prepareStatement(query);
            preparedStmt.setString(1, userBaru.getUsername());
            preparedStmt.setString(2, userBaru.getPassword());
            preparedStmt.setString(3, userBaru.getTglBuat());
            preparedStmt.setString(4, userBaru.getUsertype());
            preparedStmt.setInt(5, noID);
            
            int statusAksesBarang = (userBaru.isAksesDataBarang()) ? 1:0;
            int statusAksesPenjualan = (userBaru.isAksesDataPenjualan()) ? 1:0;
            int statusAksesPelanggan = (userBaru.isAksesDataPelanggan()) ? 1:0;
            
            
            preparedStmt.setInt(6, statusAksesBarang);
            preparedStmt.setInt(7, statusAksesPenjualan);
            preparedStmt.setInt(8, statusAksesPelanggan);
            
            

            preparedStmt.execute();

        } catch (Exception ex) {

        }

    }
    
    
    
    

    public ArrayList<Barang> getAllBarang() {
        String query = "SELECT * FROM data_barang";

        ArrayList<Barang> namaBarang = new ArrayList<Barang>();

        try {
            PreparedStatement preparedStmt = connect().prepareStatement(query);
            ResultSet hasil = preparedStmt.executeQuery();

            while (hasil.next()) {

                Barang barangBaru = new Barang();
                barangBaru.setNama(hasil.getString("nama"));
                barangBaru.setSatuan(hasil.getString("satuan"));
                barangBaru.setHargaJual(hasil.getDouble("harga_jual"));
                barangBaru.setHargaBeli(hasil.getDouble("harga_beli"));
                barangBaru.setQty(hasil.getInt("qty"));
                barangBaru.setID(hasil.getInt("ID"));

                // disimpanlah kedalam array dibawah ini
                namaBarang.add(barangBaru);
            }

        } catch (Exception ex) {
            System.out.println("terjadi kesalahan saat GetAll Barang");
            ex.printStackTrace();
        }

        return namaBarang;

    }

    public Barang getBarang(String nama) {
        String query = "SELECT * FROM data_barang WHERE nama = ?";
        Barang barangBaru = new Barang();

        try {
            PreparedStatement preparedStmt = connect().prepareStatement(query);
            preparedStmt.setString(1, nama);
            ResultSet hasil = preparedStmt.executeQuery();

            while (hasil.next()) {

                barangBaru.setNama(hasil.getString("nama"));
                barangBaru.setSatuan(hasil.getString("satuan"));
                barangBaru.setHargaJual(hasil.getDouble("harga_jual"));
                barangBaru.setHargaBeli(hasil.getDouble("harga_beli"));
                barangBaru.setQty(hasil.getInt("qty"));

            }

        } catch (Exception ex) {
            System.out.println("terjadi kesalahan saat Get Barang");
            ex.printStackTrace();
        }

        return barangBaru;

    }

    public void addDataBarang(Barang barangBaru) {
        String query = "INSERT INTO data_barang VALUES (null,?,?,?,?,?)";
        try {

            PreparedStatement preparedStmt = connect().prepareStatement(query);
            preparedStmt.setString(1, barangBaru.getNama());
            preparedStmt.setString(2, barangBaru.getSatuan());
            preparedStmt.setDouble(3, barangBaru.getHargaJual());
            preparedStmt.setDouble(4, barangBaru.getHargaBeli());
            preparedStmt.setInt(5, barangBaru.getQty());

            preparedStmt.execute();

        } catch (Exception ex) {

        }

    }

public boolean removeBarang(int noID) {
        String query = "DELETE FROM data_barang WHERE id = ?";
        boolean operasi = false;
        

            try {
            PreparedStatement preparedStmt = connect().prepareStatement(query);
            preparedStmt.setInt(1, noID);
            preparedStmt.executeUpdate();
          
          operasi = true ;

        } catch (Exception ex) {
            System.out.println("terjadi kesalahan saat Remove Barang");
            ex.printStackTrace();
        }
            
            return operasi;
    }
    
    public void updateDataBarang(Barang barangBaru, int noID) {
        String query = "UPDATE data_barang SET nama =?, satuan=?, qty=?, harga_jual=?, harga_beli=? WHERE id=?";
        try {

            PreparedStatement preparedStmt = connect().prepareStatement(query);
            preparedStmt.setString(1, barangBaru.getNama());
            preparedStmt.setString(2, barangBaru.getSatuan());
            preparedStmt.setInt(3, barangBaru.getQty());
            preparedStmt.setDouble(4, barangBaru.getHargaJual());
            preparedStmt.setDouble(5, barangBaru.getHargaBeli());
            preparedStmt.setInt(6, noID);
            
            

            preparedStmt.execute();

        } catch (Exception ex) {

        }

    }
    
     public void kurangiKuantitiBarang(Barang barangBaru) {
        String query = "UPDATE data_barang SET  qty=qty-? WHERE nama=?";
        try {

            PreparedStatement preparedStmt = connect().prepareStatement(query);
            preparedStmt.setInt(1, barangBaru.getQty());
            preparedStmt.setString(2, barangBaru.getNama());
            preparedStmt.execute();

        } catch (Exception ex) {

        }

    }


    public void deleteDataBarang() {

    }
    
       public ArrayList<Penjualan> getAllPenjualan() {
        String query = "SELECT * FROM data_penjualan";

        ArrayList<Penjualan> namaPenjualan = new ArrayList<Penjualan>();

        try {
            PreparedStatement preparedStmt = connect().prepareStatement(query);
            ResultSet hasil = preparedStmt.executeQuery();

            while (hasil.next()) {

                Penjualan penjualanBaru = new Penjualan();
                // nama kolom getStrign sebenarnya dari table MySQL
                penjualanBaru.setHargaBeli(hasil.getDouble("harga_beli"));
                penjualanBaru.setHargaJual(hasil.getDouble("harga_jual"));
                penjualanBaru.setNama(hasil.getString("nama"));
                penjualanBaru.setQty(hasil.getInt("qty"));
                penjualanBaru.setSatuan(hasil.getString("satuan"));
                penjualanBaru.setTglTransaksi(hasil.getString("tgl"));
                penjualanBaru.setID(hasil.getInt("ID"));

                // disimpanlah kedalam array dibawah ini
                namaPenjualan.add(penjualanBaru);
            }

        } catch (Exception ex) {
            System.out.println("terjadi kesalahan saat GetAll Penjualan");
            ex.printStackTrace();
        }

        return namaPenjualan;

    }


    public Penjualan getPenjualan(int noID) {
        String query = "SELECT * FROM data_penjualan WHERE id = ?";

        Penjualan penjualanBaru = new Penjualan();

        try {
            PreparedStatement preparedStmt = connect().prepareStatement(query);
            preparedStmt.setInt(1, noID);
            ResultSet hasil = preparedStmt.executeQuery();

            while (hasil.next()) {

                
                // nama kolom getStrign sebenarnya dari table MySQL
                penjualanBaru.setHargaBeli(hasil.getDouble("harga_beli"));
                penjualanBaru.setHargaJual(hasil.getDouble("harga_jual"));
                penjualanBaru.setNama(hasil.getString("nama"));
                penjualanBaru.setQty(hasil.getInt("qty"));
                penjualanBaru.setSatuan(hasil.getString("satuan"));
                penjualanBaru.setTglTransaksi(hasil.getString("tgl"));

            }

        } catch (Exception ex) {
            System.out.println("terjadi kesalahan saat Get Penjualan");
            ex.printStackTrace();
        }

        return penjualanBaru;

    }
    
    public boolean removePenjualan(int noID) {
        String query = "DELETE FROM data_penjualan WHERE id = ?";
        boolean operasi = false;
        

            try {
            PreparedStatement preparedStmt = connect().prepareStatement(query);
            preparedStmt.setInt(1, noID);
            preparedStmt.executeUpdate();
          
          operasi = true ;

        } catch (Exception ex) {
            System.out.println("terjadi kesalahan saat Remove Penjualan");
            ex.printStackTrace();
        }
            
            return operasi;
    }
    
    
    public void addDataPenjualan(Penjualan barJual) {
        String query = "INSERT INTO data_penjualan VALUES (null,?,?,?,?,?,?)";
        try {

            PreparedStatement preparedStmt = connect().prepareStatement(query);
            preparedStmt.setString(1, barJual.getNama());
            preparedStmt.setInt(2, barJual.getQty());
            preparedStmt.setString(3, barJual.getSatuan());
            preparedStmt.setDouble(4, barJual.getHargaBeli());
            preparedStmt.setDouble(5, barJual.getHargaJual());
            preparedStmt.setString(6, barJual.getTglTransaksi());

            preparedStmt.execute();

        } catch (Exception ex) {
            System.out.println("terjadi kesalahan saat add data penjualan");
            ex.printStackTrace();
        }

    }
    
        public void updateDataPenjualan(Penjualan penjualanBaru, int noID) {
        String query = "UPDATE data_penjualan SET nama =?, qty=?, satuan=?, harga_beli=?, harga_jual=?,tgl=? WHERE id=?";
        try {

            PreparedStatement preparedStmt = connect().prepareStatement(query);
            preparedStmt.setString(1, penjualanBaru.getNama());
            preparedStmt.setInt(2, penjualanBaru.getQty());
            preparedStmt.setString(3, penjualanBaru.getSatuan());
            preparedStmt.setDouble(4, penjualanBaru.getHargaBeli());
            preparedStmt.setDouble(5, penjualanBaru.getHargaJual());
            preparedStmt.setString(6, penjualanBaru.getTglTransaksi());
            preparedStmt.setInt(7, noID);
            
            

            preparedStmt.execute();

        } catch (Exception ex) {

        }

    }

    public void editDataPenjualan() {

    }

    public void deleteDataPenjualan() {

    }
    public ArrayList<Pelanggan> getAllPelanggan() {
        String query = "SELECT * FROM data_pelanggan";

        ArrayList<Pelanggan> namaPelanggan = new ArrayList<Pelanggan>();

        try {
            PreparedStatement preparedStmt = connect().prepareStatement(query);
            ResultSet hasil = preparedStmt.executeQuery();

            while (hasil.next()) {

                Pelanggan pelangganBaru = new Pelanggan();
                // nama kolom getStrign sebenarnya dari table MySQL
                pelangganBaru.setNama(hasil.getString("nama"));
                pelangganBaru.setMembership(hasil.getString("membership"));
                pelangganBaru.setNoKTP(hasil.getInt("no_ktp"));
                pelangganBaru.setTglBuat(hasil.getString("tgl_registrasi"));
                pelangganBaru.setID(hasil.getInt("ID"));

                // disimpanlah kedalam array dibawah ini
                namaPelanggan.add(pelangganBaru);
            }

        } catch (Exception ex) {
            System.out.println("terjadi kesalahan saat GetAll Pelanggan");
            ex.printStackTrace();
        }

        return namaPelanggan;

    }
    
    public Pelanggan getPelanggan(int noID) {
        String query = "SELECT * FROM data_pelanggan WHERE id = ?";

        Pelanggan pelangganBaru = new Pelanggan();
        

        try {
            PreparedStatement preparedStmt = connect().prepareStatement(query);
            preparedStmt.setInt(1, noID);
            ResultSet hasil = preparedStmt.executeQuery();

            while (hasil.next()) {

               
                // nama kolom getStrign sebenarnya dari table MySQL
                pelangganBaru.setNama(hasil.getString("nama"));
                pelangganBaru.setMembership(hasil.getString("membership"));
                pelangganBaru.setNoKTP(hasil.getInt("no_ktp"));
                pelangganBaru.setTglBuat(hasil.getString("tgl_registrasi"));

            }

        } catch (Exception ex) {
            System.out.println("terjadi kesalahan saat Get Pelanggan");
            ex.printStackTrace();
        }

        return pelangganBaru;

    }
    
    public boolean removePelanggan(int noID) {
        String query = "DELETE FROM data_pelanggan WHERE id = ?";
        boolean operasi = false;
        

            try {
            PreparedStatement preparedStmt = connect().prepareStatement(query);
            preparedStmt.setInt(1, noID);
            preparedStmt.executeUpdate();
          
          operasi = true ;

        } catch (Exception ex) {
            System.out.println("terjadi kesalahan saat Remove User");
            ex.printStackTrace();
        }
            
            return operasi;
    }

    public void addDataPelanggan(Pelanggan pelangganBaru) {
        String query = "INSERT INTO data_pelanggan VALUES (null,?,?,?,?)";
        try {

            PreparedStatement preparedStmt = connect().prepareStatement(query);
            preparedStmt.setString(1, pelangganBaru.getNama());
            preparedStmt.setString(2, pelangganBaru.getMembership());
            preparedStmt.setInt(3, pelangganBaru.getNoKTP());
            preparedStmt.setString(4, pelangganBaru.getTglBuat());

            preparedStmt.execute();

        } catch (Exception ex) {
            System.out.println("terjadi kesalahan saat add data pelanggan");
            ex.printStackTrace();
        }

    }
    
    public void updateDataPelanggan(Pelanggan pelangganBaru, int noID) {
        String query = "UPDATE data_pelanggan SET nama =?, membership=?, no_ktp=?, tgl_registrasi=? WHERE id=?";
        try {

            PreparedStatement preparedStmt = connect().prepareStatement(query);
            preparedStmt.setString(1, pelangganBaru.getNama());
            preparedStmt.setString(2, pelangganBaru.getMembership());
            preparedStmt.setInt(3, pelangganBaru.getNoKTP());
            preparedStmt.setString(4, pelangganBaru.getTglBuat());
            preparedStmt.setInt(5, noID);
            
            

            preparedStmt.execute();

        } catch (Exception ex) {

        }

    }
     
    
    

    public void editDataPelanggan() {

    }

    public void deleteDataPelanggan() {

    }

}
