package com.investasi.model;

public class Saham {
    private String kode;
    private String namaPerusahaan;
    private double harga;

    public Saham(String kode, String namaPerusahaan, double harga) {
        this.kode = kode;
        this.namaPerusahaan = namaPerusahaan;
        this.harga = harga;
    }

    public String getKode() {
        return kode;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return kode + " - " + namaPerusahaan + " - " + String.format("Rp %, .2f", harga);

    }
}
