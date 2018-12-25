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
public class Pelanggan {
    private String nama ;
    private String membership;
    private int noKTP;
    private String tglBuat;
    private int ID;

    /**
     * @return the username
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param username the username to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the membership
     */
    public String getMembership() {
        return membership;
    }

    /**
     * @param membership the membership to set
     */
    public void setMembership(String membership) {
        this.membership = membership;
    }

    /**
     * @return the noKTP
     */
    public int getNoKTP() {
        return noKTP;
    }

    /**
     * @param noKTP the noKTP to set
     */
    public void setNoKTP(int noKTP) {
        this.noKTP = noKTP;
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
}
