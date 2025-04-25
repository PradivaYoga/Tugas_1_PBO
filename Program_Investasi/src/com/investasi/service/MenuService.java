package com.investasi.service;

import com.investasi.app.Main;
import com.investasi.model.*;
import com.investasi.util.InputUtil;
import java.text.NumberFormat;
import java.util.*;

public class MenuService {
    private static final List<Saham> daftarSaham = new ArrayList<>();
    private static final List<SBN> daftarSBN = new ArrayList<>();
    private static final NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

    public void menuAdmin() {
        while (true) {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Saham");
            System.out.println("2. SBN");
            System.out.println("3. Logout");
            String pilihan = InputUtil.input("Pilih menu: ");

            switch (pilihan) {
                case "1":
                    menuSaham();
                    break;
                case "2":
                    menuSBN();
                    break;
                case "3":
                    System.out.println("Logout berhasil.\n");
                    Main.main(null);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.\n");
            }
        }
    }

    private void menuSaham() {
        while (true) {
            System.out.println("\n-- Menu Saham --");
            System.out.println("1. Tambah Saham");
            System.out.println("2. Ubah Harga Saham");
            System.out.println("3. Lihat Daftar Saham");
            System.out.println("4. Kembali");
            String pilihan = InputUtil.input("Pilih: ");

            switch (pilihan) {
                case "1":
                    String kode = InputUtil.input("Kode Saham: ");
                    String nama = InputUtil.input("Nama Perusahaan: ");
                    double harga = getPositiveDouble("Harga Saham: ");
                    daftarSaham.add(new Saham(kode, nama, harga));
                    System.out.println("Saham berhasil ditambahkan.");
                    break;
                case "2":
                    String cariKode = InputUtil.input("Masukkan kode saham: ");
                    Saham saham = findSahamByKode(cariKode);
                    if (saham != null) {
                        double hargaBaru = getPositiveDouble("Harga baru: ");
                        saham.setHarga(hargaBaru);
                        System.out.println("Harga saham diperbarui.");
                    } else {
                        System.out.println("Saham tidak ditemukan.");
                    }
                    break;
                case "3":
                    if (daftarSaham.isEmpty()) System.out.println("Belum ada saham terdaftar.");
                    else daftarSaham.forEach(s -> System.out.println(s + " | Harga: " + formatter.format(s.getHarga())));
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void menuSBN() {
        while (true) {
            System.out.println("\n-- Menu SBN --");
            System.out.println("1. Tambah SBN");
            System.out.println("2. Lihat Daftar SBN");
            System.out.println("3. Kembali");
            String pilihan = InputUtil.input("Pilih: ");

            switch (pilihan) {
                case "1":
                    String namaSBN = InputUtil.input("Nama SBN: ");
                    double bunga = getPositiveDouble("Bunga (%): ");
                    int jangka = getPositiveInt("Jangka Waktu (bulan): ");
                    String jatuhTempo = InputUtil.input("Tanggal Jatuh Tempo: ");
                    double kuota = getPositiveDouble("Kuota Nasional: ");
                    daftarSBN.add(new SBN(namaSBN, bunga, jangka, jatuhTempo, kuota));
                    System.out.println("SBN berhasil ditambahkan.");
                    break;
                case "2":
                    if (daftarSBN.isEmpty()) System.out.println("Belum ada SBN terdaftar.");
                    else daftarSBN.forEach(s -> System.out.println(s + " | Kuota: " + formatter.format(s.getKuotaNasional())));
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public void menuCustomer(Customer customer) {
        while (true) {
            System.out.println("\n=== Menu Customer ===");
            System.out.println("1. Beli Saham");
            System.out.println("2. Jual Saham");
            System.out.println("3. Beli SBN");
            System.out.println("4. Simulasi SBN");
            System.out.println("5. Portofolio");
            System.out.println("6. Logout");
            String pilihan = InputUtil.input("Pilih menu: ");

            switch (pilihan) {
                case "1":
                    if (daftarSaham.isEmpty()) {
                        System.out.println("Belum ada saham tersedia.");
                        break;
                    }
                    daftarSaham.forEach(s -> System.out.println(s + " | Harga: " + formatter.format(s.getHarga())));
                    String kode = InputUtil.input("Masukkan kode saham: ");
                    Saham saham = findSahamByKode(kode);
                    if (saham != null) {
                        int jumlah = getPositiveInt("Jumlah lembar: ");
                        customer.getPortofolio().beliSaham(kode, jumlah);
                        System.out.println("Pembelian berhasil!");
                    } else {
                        System.out.println("Saham tidak ditemukan.");
                    }
                    break;
                case "2":
                    Map<String, Integer> sahamMu = customer.getPortofolio().getSahamDimiliki();
                    if (sahamMu.isEmpty()) {
                        System.out.println("Tidak ada saham yang dimiliki.");
                        break;
                    }
                    sahamMu.forEach((k, v) -> System.out.println(k + " = " + v + " lembar"));
                    String jualKode = InputUtil.input("Kode saham yang ingin dijual: ");
                    if (!sahamMu.containsKey(jualKode)) {
                        System.out.println("Kamu tidak punya saham itu.");
                        break;
                    }
                    int lembar = getPositiveInt("Jumlah lembar yang ingin dijual: ");
                    if (lembar > sahamMu.get(jualKode)) {
                        System.out.println("Gagal: jumlah lembar melebihi kepemilikan.");
                    } else {
                        customer.getPortofolio().jualSaham(jualKode, lembar);
                        System.out.println("Saham berhasil dijual.");
                    }
                    break;
                case "3":
                    if (daftarSBN.isEmpty()) {
                        System.out.println("Belum ada SBN tersedia.");
                        break;
                    }
                    daftarSBN.forEach(s -> System.out.println(s + " | Kuota: " + formatter.format(s.getKuotaNasional())));
                    String namaSBN = InputUtil.input("Pilih nama SBN: ");
                    SBN sbn = daftarSBN.stream().filter(s -> s.getNama().equals(namaSBN)).findFirst().orElse(null);
                    if (sbn != null) {
                        double nominal = getPositiveDouble("Nominal pembelian: ");
                        if (sbn.getKuotaNasional() < nominal) {
                            System.out.println("Gagal: kuota tidak cukup.");
                        } else {
                            customer.getPortofolio().beliSBN(namaSBN, nominal);
                            sbn.kurangiKuota(nominal);
                            System.out.println("SBN berhasil dibeli!");
                        }
                    }
                    break;
                case "4":
                    customer.getPortofolio().getSbnDimiliki().forEach((nama, nominal) -> {
                        SBN data = daftarSBN.stream().filter(s -> s.getNama().equals(nama)).findFirst().orElse(null);
                        if (data != null) {
                            double bungaBulanan = (data.getBunga() / 12) * 0.9 * nominal;
                            System.out.println(nama + ": bunga per bulan = " + formatter.format(bungaBulanan));
                        }
                    });
                    break;
                case "5":
                    System.out.println("\n=== Portofolio Saham ===");
                    double totalSaham = 0;
                    for (Map.Entry<String, Integer> entry : customer.getPortofolio().getSahamDimiliki().entrySet()) {
                        Saham s = findSahamByKode(entry.getKey());
                        if (s != null) {
                            double nilai = s.getHarga() * entry.getValue();
                            System.out.println(entry.getKey() + ": " + entry.getValue() + " lembar | Nilai pasar: " + formatter.format(nilai));
                            totalSaham += nilai;
                        }
                    }
                    System.out.println("Total nilai pasar saham: " + formatter.format(totalSaham));

                    System.out.println("\n=== Portofolio SBN ===");
                    double totalBunga = 0;
                    for (Map.Entry<String, Double> entry : customer.getPortofolio().getSbnDimiliki().entrySet()) {
                        SBN s = daftarSBN.stream().filter(sb -> sb.getNama().equals(entry.getKey())).findFirst().orElse(null);
                        if (s != null) {
                            double bungaBulanan = (s.getBunga() / 12) * 0.9 * entry.getValue();
                            System.out.println(entry.getKey() + ": " + formatter.format(entry.getValue()) + " | bunga/bulan: " + formatter.format(bungaBulanan));
                            totalBunga += bungaBulanan;
                        }
                    }
                    System.out.println("Total bunga SBN/bulan: " + formatter.format(totalBunga));
                    break;
                case "6":
                    Main.main(null);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private double getPositiveDouble(String prompt) {
        double val;
        do {
            val = InputUtil.inputDouble(prompt);
            if (val <= 0) System.out.println("Harus lebih dari 0!");
        } while (val <= 0);
        return val;
    }

    private int getPositiveInt(String prompt) {
        int val;
        do {
            val = InputUtil.inputInt(prompt);
            if (val <= 0) System.out.println("Harus lebih dari 0!");
        } while (val <= 0);
        return val;
    }

    private Saham findSahamByKode(String kode) {
        return daftarSaham.stream().filter(s -> s.getKode().equals(kode)).findFirst().orElse(null);
    }
}
