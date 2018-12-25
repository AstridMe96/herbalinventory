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
public class Barang {
    private String nama ;
    private String satuan;
    private double hargaJual;
    private double hargaBeli;
    private int qty;
    private int ID;

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the satuan
     */
    public String getSatuan() {
        return satuan;
    }

    /**
     * @param satuan the satuan to set
     */
    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    /**
     * @return the hargaJual
     */
    public double getHargaJual() {
        return hargaJual;
    }

    /**
     * @param hargaJual the hargaJual to set
     */
    public void setHargaJual(double hargaJual) {
        this.hargaJual = hargaJual;
    }

    /**
     * @return the hargaBeli
     */
    public double getHargaBeli() {
        return hargaBeli;
    }

    /**
     * @param hargaBeli the hargaBeli to set
     */
    public void setHargaBeli(double hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
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
