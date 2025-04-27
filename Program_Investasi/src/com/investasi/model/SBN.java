package com.investasi.model;

public class SBN {
    private String nama;
    private double bunga;
    private int jangkaWaktu;
    private String tanggalJatuhTempo;
    private double kuotaNasional;

    public SBN(String nama, double bunga, int jangkaWaktu, String tanggalJatuhTempo, double kuotaNasional) {
        this.nama = nama;
        this.bunga = bunga;
        this.jangkaWaktu = jangkaWaktu;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        this.kuotaNasional = kuotaNasional;
    }

    public String getNama() {
        return nama;
    }

    public double getBunga() {
        return bunga;
    }

    public int getJangkaWaktu() {
        return jangkaWaktu;
    }

   public String getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }

    public double getKuotaNasional() {
        return kuotaNasional;
    }

    public void kurangiKuota(double jumlah) {
        this.kuotaNasional -= jumlah;
    }

    @Override
    public String toString() {
        return nama + " | Bunga: " + bunga + "% | Jangka: " + jangkaWaktu + " bulan | Jatuh Tempo: " + tanggalJatuhTempo;

    }
}
