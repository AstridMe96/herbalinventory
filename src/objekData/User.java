/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objekData;

/**
 *
 * @author HP
 */
public class User {
    private String username ;
    private String password;
    private String usertype;
    private String tglBuat;
    private int ID;
    private boolean aksesDataBarang;
    private boolean aksesDataPenjualan;
    private boolean aksesDataPelanggan;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the usertype
     */
    public String getUsertype() {
        return usertype;
    }

    /**
     * @param usertype the usertype to set
     */
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    /**
     * @return the tglBuat
     */
    public String getTglBuat() {
        return tglBuat;
    }

    /**
     * @param tglBuat the tglBuat to set
     */
    public void setTglBuat(String tglBuat) {
        this.tglBuat = tglBuat;
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the aksesDataBarang
     */
    public boolean isAksesDataBarang() {
        return aksesDataBarang;
    }

    /**
     * @param aksesDataBarang the aksesDataBarang to set
     */
    public void setAksesDataBarang(boolean aksesDataBarang) {
        this.aksesDataBarang = aksesDataBarang;
    }

    /**
     * @return the aksesDataPenjualan
     */
    public boolean isAksesDataPenjualan() {
        return aksesDataPenjualan;
    }

    /**
     * @param aksesDataPenjualan the aksesDataPenjualan to set
     */
    public void setAksesDataPenjualan(boolean aksesDataPenjualan) {
        this.aksesDataPenjualan = aksesDataPenjualan;
    }

    /**
     * @return the aksesDataPelanggan
     */
    public boolean isAksesDataPelanggan() {
        return aksesDataPelanggan;
    }

    /**
     * @param aksesDataPelanggan the aksesDataPelanggan to set
     */
    public void setAksesDataPelanggan(boolean aksesDataPelanggan) {
        this.aksesDataPelanggan = aksesDataPelanggan;
    }
    
}
