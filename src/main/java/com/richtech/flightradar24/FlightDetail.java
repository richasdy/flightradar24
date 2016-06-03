/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.richtech.flightradar24;

/**
 *
 * @author richasdy
 */
public class FlightDetail {
    private String kodepenerbangan;
    private double lintang;
    private double bujur;
    private int heading;
    private int ketinggian;
    private int kecepatan;
    private int squawk;
    private String radar;
    private String tipe;
    private String kodepesawat;
    private int timestamps;
    private String band_asal;
    private String band_tujuan;
    private String flightnumber;
    private int unknown1;
    private int vert_speed;
    private String callsign;
    private int unknown2;

    public String getKodepenerbangan() {
        return kodepenerbangan;
    }

    public void setKodepenerbangan(String kodepenerbangan) {
        this.kodepenerbangan = kodepenerbangan;
    }

    public double getLintang() {
        return lintang;
    }

    public void setLintang(double lintang) {
        this.lintang = lintang;
    }

    public double getBujur() {
        return bujur;
    }

    public void setBujur(double bujur) {
        this.bujur = bujur;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public int getKetinggian() {
        return ketinggian;
    }

    public void setKetinggian(int ketinggian) {
        this.ketinggian = ketinggian;
    }

    public int getKecepatan() {
        return kecepatan;
    }

    public void setKecepatan(int kecepatan) {
        this.kecepatan = kecepatan;
    }

    public int getSquawk() {
        return squawk;
    }

    public void setSquawk(int squawk) {
        this.squawk = squawk;
    }

    public String getRadar() {
        return radar;
    }

    public void setRadar(String radar) {
        this.radar = radar;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getKodepesawat() {
        return kodepesawat;
    }

    public void setKodepesawat(String kodepesawat) {
        this.kodepesawat = kodepesawat;
    }

    public int getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(int timestamps) {
        this.timestamps = timestamps;
    }

    public String getBand_asal() {
        return band_asal;
    }

    public void setBand_asal(String band_asal) {
        this.band_asal = band_asal;
    }

    public String getBand_tujuan() {
        return band_tujuan;
    }

    public void setBand_tujuan(String band_tujuan) {
        this.band_tujuan = band_tujuan;
    }

    public String getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(String flightnumber) {
        this.flightnumber = flightnumber;
    }

    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public int getUnknown1() {
        return unknown1;
    }

    public void setUnknown1(int unknown1) {
        this.unknown1 = unknown1;
    }

    public int getVert_speed() {
        return vert_speed;
    }

    public void setVert_speed(int vert_speed) {
        this.vert_speed = vert_speed;
    }

    public int getUnknown2() {
        return unknown2;
    }

    public void setUnknown2(int unknown2) {
        this.unknown2 = unknown2;
    }
    
    
    
}
