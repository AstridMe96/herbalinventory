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
public class Penjualan extends Barang{
   
    private String tglTransaksi;
    private int ID;

    /**
     * @return the tglTransaksi
     */
    public String getTglTransaksi() {
        return tglTransaksi;
    }

    /**
     * @param tglTransaksi the tglTransaksi to set
     */
    public void setTglTransaksi(String tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
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
    
}
