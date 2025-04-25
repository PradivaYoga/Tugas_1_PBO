package com.investasi.model;

import java.util.HashMap;
import java.util.Map;

public class Portofolio {
    private Map<String, Integer> sahamDimiliki;
    private Map<String, Double> sbnDimiliki;

    public Portofolio() {
        sahamDimiliki = new HashMap<>();
        sbnDimiliki = new HashMap<>();
    }

    public Map<String, Integer> getSahamDimiliki() {
        return sahamDimiliki;
    }

    public Map<String, Double> getSbnDimiliki() {
        return sbnDimiliki;
    }

    public void beliSaham(String kode, int jumlah) {
        sahamDimiliki.put(kode, sahamDimiliki.getOrDefault(kode, 0) + jumlah);
    }

    public void jualSaham(String kode, int jumlah) {
        if (sahamDimiliki.containsKey(kode)) {
            int sisa = sahamDimiliki.get(kode) - jumlah;
            if (sisa <= 0) sahamDimiliki.remove(kode);
            else sahamDimiliki.put(kode, sisa);
        }
    }

    public void beliSBN(String nama, double nominal) {
        sbnDimiliki.put(nama, sbnDimiliki.getOrDefault(nama, 0.0) + nominal);
    }
}
