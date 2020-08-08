/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import lombok.Data;

/**
 *
 * @author RSUI HA
 */
public class Toko {

    public static String namars;
    public static String alamatrs;
    public static String kabupatenrs;
    public static String propinsirs;
    public static String kontakrs;
    public static String emailrs;
    public static String nip;

    public static void setNamars(String namars) {
        Toko.namars = namars;
    }

    public static void setAlamatrs(String alamatrs) {
        Toko.alamatrs = alamatrs;
    }

    public static void setKabupatenrs(String kabupatenrs) {
        Toko.kabupatenrs = kabupatenrs;
    }

    public static void setPropinsirs(String propinsirs) {
        Toko.propinsirs = propinsirs;
    }

    public static void setKontakrs(String kontakrs) {
        Toko.kontakrs = kontakrs;
    }

    public static void setEmailrs(String emailrs) {
        Toko.emailrs = emailrs;
    }

    public static void setNip(String nip) {
        Toko.nip = nip;
    }

    public static String getNamars() {
        return namars;
    }

    public static String getAlamatrs() {
        return alamatrs;
    }

    public static String getKabupatenrs() {
        return kabupatenrs;
    }

    public static String getPropinsirs() {
        return propinsirs;
    }

    public static String getKontakrs() {
        return kontakrs;
    }

    public static String getEmailrs() {
        return emailrs;
    }

    public static String getNip() {
        return nip;
    }

}
