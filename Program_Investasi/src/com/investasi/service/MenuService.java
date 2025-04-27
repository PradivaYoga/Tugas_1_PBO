package com.investasi.service;

import com.investasi.app.Main;
import com.investasi.model.*;
import com.investasi.util.InputUtil;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class MenuService {
    private static final List<Saham> daftarSaham = new ArrayList<>();
    private static final List<SBN> daftarSBN = new ArrayList<>();
    private static final NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

    public void menuAdmin() {
        while (true) {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("| 1. Saham       |");
            System.out.println("| 2. SBN         |");
            System.out.println("| 3. Logout      |");
            System.out.println("==================");

            String pilihan = InputUtil.input("Pilih menu: ");

            switch (pilihan) {
                case "1":
                    InputUtil.clearScreen();
                    tampilkanMenuSaham();
                    break;
                case "2":
                    InputUtil.clearScreen();
                    tampilkanMenuSBN();
                    break;
                case "3":
                    logout();
                    return;
                default:
                    System.out.println("!! Pilihan tidak valid. !!");
                    InputUtil.pause();
                    InputUtil.clearScreen();
            }
        }
    }

    private void tampilkanMenuSaham() {
        while (true) {
            System.out.println("\n__________________________");
            System.out.println("|  --- Kelola Saham ---  |");
            System.out.println("| 1. Tambah Saham        |");
            System.out.println("| 2. Ubah Harga Saham    |");
            System.out.println("| 3. Lihat Daftar Saham  |");
            System.out.println("| 4. Hapus Saham         |");
            System.out.println("| 5. Kembali             |");
            System.out.println("==========================");

            String pilihan = InputUtil.input("Pilih menu: ");

            switch (pilihan) {
                case "1":
                    tambahSaham();
                    break;
                case "2":
                    ubahHargaSaham();
                    break;
                case "3":
                    lihatDaftarSaham();
                    break;
                case "4":
                    hapusSaham();
                    break;
                case "5":
                    InputUtil.clearScreen();
                    return;
                default:
                    System.out.println("!! Pilihan tidak valid. !!");
                    InputUtil.pause();
                    InputUtil.clearScreen();
            }
        }
    }

    private void tampilkanMenuSBN() {
        while (true) {
            System.out.println("\n________________________");
            System.out.println("|  --- Kelola SBN ---  |");
            System.out.println("| 1. Tambah SBN        |");
            System.out.println("| 2. Lihat Daftar SBN  |");
            System.out.println("| 3. Hapus SBN         |");
            System.out.println("| 4. Kembali           |");
            System.out.println("========================");

            String pilihan = InputUtil.input("Pilih menu: ");

            switch (pilihan) {
                case "1":
                    tambahSBN();
                    break;
                case "2":
                    lihatDaftarSBN();
                    break;
                case "3":
                    hapusSBN();
                    break;
                case "4":
                    InputUtil.clearScreen();
                    return;
                default:
                    System.out.println("!! Pilihan tidak valid. !!");
                    InputUtil.pause();
                    InputUtil.clearScreen();
            }
        }
    }

    public void menuCustomer(Customer customer) {
        while (true) {
            System.out.println("\n[]===== Menu Customer =====[]");
            System.out.println("| 1. Beli Saham             |");
            System.out.println("| 2. Jual Saham             |");
            System.out.println("| 3. Beli SBN               |");
            System.out.println("| 4. Simulasi Bunga SBN     |");
            System.out.println("| 5. Lihat Portofolio       |");
            System.out.println("| 6. Logout                 |");
            System.out.println("[]=========================[]");

            String pilihan = InputUtil.input("Pilih menu: ");

            switch (pilihan) {
                case "1":
                    beliSaham(customer);
                    break;
                case "2":
                    jualSaham(customer);
                    break;
                case "3":
                    beliSBN(customer);
                    break;
                case "4":
                    simulasiBungaSBN(customer);
                    break;
                case "5":
                    tampilkanPortofolio(customer);
                    break;
                case "6":
                    logout();
                    return;
                default:
                    System.out.println("!! Pilihan tidak valid. !!");
                    InputUtil.pause();
                    InputUtil.clearScreen();
            }
        }
    }

    // Fitur Saham
    private void tambahSaham() {
        InputUtil.pause();
        InputUtil.clearScreen();
        String kode = InputUtil.input("Masukkan Kode Saham: ");
        while (isKodeSahamExist(kode)){
            System.out.println("Kode saham ini sudah ada. Silahkan masukkan kode lain!");
            kode = InputUtil.input("Masukkan Kode Saham: ");
        }
        String nama = InputUtil.input("Masukkan Nama Perusahaan: ");
        double harga = inputPositiveDouble("Masukkan Harga Saham: ");
        daftarSaham.add(new Saham(kode, nama, harga));
        System.out.println("Saham berhasil ditambahkan.");
        InputUtil.pause();
        InputUtil.clearScreen();
    }

    private void ubahHargaSaham() {
        if (daftarSaham.isEmpty()) {
            System.out.println("Belum ada saham yang tersedia.");
        } else {
            lihatDaftarSaham();
            String kode = InputUtil.input("Masukkan Kode Saham yang ingin diubah: ");
            Saham saham = cariSahamByKode(kode);
            if (saham != null) {
                double hargaBaru = inputPositiveDouble("Masukkan Harga Baru: ");
                saham.setHarga(hargaBaru);
                System.out.println("Harga saham berhasil diperbarui.");
            } else {
                System.out.println("Saham tidak ditemukan.");
            }
        }
        InputUtil.pause();
        InputUtil.clearScreen();
    }

    private void lihatDaftarSaham() {
        if (daftarSaham.isEmpty()) {
            InputUtil.pause();
            InputUtil.clearScreen();
            System.out.println("Belum ada saham terdaftar.");
        } else {
            InputUtil.pause();
            InputUtil.clearScreen();
            System.out.println("\n[]==============[]");
            System.out.println("|| DAFTAR SAHAM ||");
            System.out.println("[]==============[]");
            System.out.println("|");
            daftarSaham.forEach(s -> System.out.println("| " + s + " | Harga: " + formatter.format(s.getHarga())));
        }
        InputUtil.pause();
        InputUtil.clearScreen();
    }

    private void hapusSaham() {
        if (daftarSaham.isEmpty()) {
        InputUtil.pause();
        InputUtil.clearScreen();
            System.out.println("Belum ada saham yang tersedia.");
        } else {
            lihatDaftarSaham();
            String kode = InputUtil.input("Masukkan Kode Saham yang ingin dihapus: ");
            Saham saham = cariSahamByKode(kode);
            if (saham != null) {
                daftarSaham.remove(saham);
                System.out.println("Saham berhasil dihapus.");
            } else {
                System.out.println("Saham tidak ditemukan.");
            }
        }
        InputUtil.pause();
        InputUtil.clearScreen();
    }

    public static boolean isKodeSahamExist(String kode) {
        for (Saham saham : daftarSaham) {
            if (saham.getKode().equalsIgnoreCase(kode)) {
                return true;
            }
        }
        return false;
    } 

    // Fitur SBN
    private void tambahSBN() {
        InputUtil.pause();
        InputUtil.clearScreen();
        String nama = InputUtil.input("Masukkan Nama SBN: ");
        while (isNamaSBNExist(nama)) {
            System.out.println("Nama ini sudah ada. Silahkan masukkan nama lain!");
            nama = InputUtil.input("Masukkan Nama SBN: ");
        }
        double bunga = inputPositiveDouble("Masukkan Bunga (%): ");
        int jangkaWaktu = inputPositiveInt("Masukkan Jangka Waktu (bulan): ");
        String jatuhTempo = InputUtil.input("Masukkan Tanggal Jatuh Tempo (dd/MM/yyyy): ");
        while (!isValidDate(jatuhTempo)) {
            System.out.println("Format tanggal salah. Masukkan lagi (dd/MM/yyyy)!");
            jatuhTempo = InputUtil.input("Masukkan Tanggal Jatuh Tempo (dd/MM/yyyy): ");
        }
        double kuotaNasional = inputPositiveDouble("Masukkan Kuota Nasional: ");
        daftarSBN.add(new SBN(nama, bunga, jangkaWaktu, jatuhTempo, kuotaNasional));
        System.out.println("SBN berhasil ditambahkan.");
        InputUtil.pause();
        InputUtil.clearScreen();
    }

    private void lihatDaftarSBN() {
        if (daftarSBN.isEmpty()) {
            InputUtil.pause();
            InputUtil.clearScreen();
            System.out.println("Belum ada SBN terdaftar.");
        } else {
            InputUtil.pause();
            InputUtil.clearScreen();
            System.out.println("\n[]==============[]");
            System.out.println("||  DAFTAR SBN  ||");
            System.out.println("[]==============[]");
            System.out.println("|");
            daftarSBN.forEach(s -> System.out.println("| " + s + " | Kuota: " + formatter.format(s.getKuotaNasional())));
        }
        InputUtil.pause();
        InputUtil.clearScreen();
    }

    private void hapusSBN() {
        if (daftarSBN.isEmpty()) {
            System.out.println("Belum ada SBN yang tersedia.");
        } else {
            lihatDaftarSBN();
            String nama = InputUtil.input("Masukkan Nama SBN yang ingin dihapus: ");
            SBN sbn = cariSBNByNama(nama);
            if (sbn != null) {
                daftarSBN.remove(sbn);
                System.out.println("SBN berhasil dihapus.");
            } else {
                System.out.println("SBN tidak ditemukan.");
            }
        }
        InputUtil.pause();
        InputUtil.clearScreen();
    }

    public static boolean isNamaSBNExist(String nama) {
        for (SBN sbn : daftarSBN) {
            if (sbn.getNama().equalsIgnoreCase(nama)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidDate(String tanggal) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate.parse(tanggal, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }


    // Fitur Customer
    private void beliSaham(Customer customer) {
        if (daftarSaham.isEmpty()) {
            System.out.println("Belum ada saham yang tersedia.");
            InputUtil.pause();
            InputUtil.clearScreen();
            return;
        }
        lihatDaftarSaham();
        String kode = InputUtil.input("Masukkan Kode Saham: ");
        Saham saham = cariSahamByKode(kode);
        if (saham != null) {
            int jumlah = inputPositiveInt("Masukkan Jumlah Lembar: ");
            customer.getPortofolio().beliSaham(kode, jumlah);
            System.out.println("Pembelian saham berhasil!");
        } else {
            System.out.println("Saham tidak ditemukan.");
        }
        InputUtil.pause();
        InputUtil.clearScreen();
    }

    private void jualSaham(Customer customer) {
        Map<String, Integer> sahamDimiliki = customer.getPortofolio().getSahamDimiliki();
        if (sahamDimiliki.isEmpty()) {
            System.out.println("Kamu belum memiliki saham.");
            InputUtil.pause();
            InputUtil.clearScreen();
            return;
        }
        sahamDimiliki.forEach((kode, jumlah) -> System.out.println(kode + " = " + jumlah + " lembar"));
        String kode = InputUtil.input("Masukkan Kode Saham yang ingin dijual: ");
        if (!sahamDimiliki.containsKey(kode)) {
            System.out.println("Kamu tidak memiliki saham ini.");
        } else {
            int jumlah = inputPositiveInt("Masukkan Jumlah Lembar yang ingin dijual: ");
            if (jumlah > sahamDimiliki.get(kode)) {
                System.out.println("Jumlah lembar melebihi kepemilikan.");
            } else {
                customer.getPortofolio().jualSaham(kode, jumlah);
                System.out.println("Penjualan saham berhasil.");
            }
        }
        InputUtil.pause();
        InputUtil.clearScreen();
    }

    private void beliSBN(Customer customer) {
        if (daftarSBN.isEmpty()) {
            System.out.println("Belum ada SBN yang tersedia.");
            InputUtil.pause();
            InputUtil.clearScreen();
            return;
        }
        lihatDaftarSBN();
        String nama = InputUtil.input("Masukkan Nama SBN: ");
        SBN sbn = cariSBNByNama(nama);
        if (sbn != null) {
            double nominal = inputPositiveDouble("Masukkan Nominal Pembelian: ");
            if (nominal > sbn.getKuotaNasional()) {
                System.out.println("Kuota tidak mencukupi.");
            } else {
                customer.getPortofolio().beliSBN(nama, nominal);
                sbn.kurangiKuota(nominal);
                System.out.println("Pembelian SBN berhasil!");
            }
        } else {
            System.out.println("SBN tidak ditemukan.");
        }
        InputUtil.pause();
        InputUtil.clearScreen();
    }

    private void simulasiBungaSBN(Customer customer) {
        Map<String, Double> sbnDimiliki = customer.getPortofolio().getSbnDimiliki();
        if (sbnDimiliki.isEmpty()) {
            System.out.println("Kamu belum memiliki SBN.");
        } else {
            sbnDimiliki.forEach((nama, nominal) -> {
                SBN sbn = cariSBNByNama(nama);
                if (sbn != null) {
                    double bungaBulanan = (sbn.getBunga() / 12) * 0.9 * nominal;
                    System.out.println(nama + " | Perkiraan bunga per bulan: " + formatter.format(bungaBulanan));
                }
            });
        }
        InputUtil.pause();
        InputUtil.clearScreen();
    }

    private void tampilkanPortofolio(Customer customer) {
        System.out.println("\n--- Portofolio Saham ---");
        double totalNilaiSaham = 0;
        for (Map.Entry<String, Integer> entry : customer.getPortofolio().getSahamDimiliki().entrySet()) {
            Saham saham = cariSahamByKode(entry.getKey());
            if (saham != null) {
                double nilai = saham.getHarga() * entry.getValue();
                System.out.println(entry.getKey() + ": " + entry.getValue() + " lembar | Nilai: " + formatter.format(nilai));
                totalNilaiSaham += nilai;
            }
        }
        System.out.println("Total nilai saham: " + formatter.format(totalNilaiSaham));

        System.out.println("\n--- Portofolio SBN ---");
        double totalBungaSBN = 0;
        for (Map.Entry<String, Double> entry : customer.getPortofolio().getSbnDimiliki().entrySet()) {
            SBN sbn = cariSBNByNama(entry.getKey());
            if (sbn != null) {
                double bungaBulanan = (sbn.getBunga() / 12) * 0.9 * entry.getValue();
                System.out.println(entry.getKey() + ": " + formatter.format(entry.getValue()) + " | Bunga/Bulan: " + formatter.format(bungaBulanan));
                totalBungaSBN += bungaBulanan;
            }
        }
        System.out.println("Total bunga SBN per bulan: " + formatter.format(totalBungaSBN));

        InputUtil.pause();
        InputUtil.clearScreen();
    }

    // Tambahan
    private double inputPositiveDouble(String prompt) {
        double value;
        do {
            value = InputUtil.inputDouble(prompt);
            if (value <= 0) System.out.println("!! Nilai harus lebih dari 0 !!");
        } while (value <= 0);
        return value;
    }

    private int inputPositiveInt(String prompt) {
        int value;
        do {
            value = InputUtil.inputInt(prompt);
            if (value <= 0) System.out.println("!! Nilai harus lebih dari 0 !!");
        } while (value <= 0);
        return value;
    }

    private Saham cariSahamByKode(String kode) {
        return daftarSaham.stream().filter(s -> s.getKode().equals(kode)).findFirst().orElse(null);
    }

    private SBN cariSBNByNama(String nama) {
        return daftarSBN.stream().filter(s -> s.getNama().equals(nama)).findFirst().orElse(null);
    }

    private void logout() {
        System.out.println(" ");
        System.out.println(" ");
        InputUtil.pause();
        InputUtil.clearScreen();
        System.out.println("Logout berhasil.\n");
        System.out.println("()~~~~~~~~~~~~~~~~~~~~~~~~~~~()");
        System.out.println("[] Ingin Mengulangi Program? []");
        System.out.println("[] 1. Ya                     []");
        System.out.println("[] 2. Tidak                  []");
        System.out.println("()~~~~~~~~~~~~~~~~~~~~~~~~~~~()");
        int logout = InputUtil.inputInt("Tolong masukkan angka: ");
        if (logout == 1 || logout == 2) {
            if (logout == 1) {
                InputUtil.pause();
                InputUtil.clearScreen();
                Main.main(null);
            } else if (logout == 2) {
                InputUtil.pause();
                InputUtil.clearScreen();
                System.out.println("Terima kasih telah menggunakan program ini!\n");
            }
        } else {
            System.out.println("!! Masukkan Pilihan yang sesuai (1) atau (2) !!");
            InputUtil.pause();
            InputUtil.clearScreen();
            logout();
        }
    }
}
