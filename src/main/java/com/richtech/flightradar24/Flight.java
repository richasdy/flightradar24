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
public class Flight {
    private int hex;
    private String registration;
    private String callsign;
    private String flight;
    private String snapshot_id;
    private String aircraft;
    private String sideview;
    private String image;
    private String imagelink;
    private String copyright;
    private int q;
    private int status;
    private int dep_schd;
    private int arr_schd;
    private int departure;
    private int arrival;
    private int eta;
    private String from_iata;
    private String from_city;
    int[] from_pos = new int[2];
    private String from_tz_code;
    private String from_tz_offset;
    private String from_tz_name;
    private String to_iata;
    private String to_city;
    int[] to_pos = new int[2];
    private String to_tz_code;
    private String to_tz_offset;
    private String to_tz_name;
    private String airline;
    private String airline_url;
    private String imagesource;
    private String image_large;
    private String imagelink_large;
    private String copyright_large;

    public int getHex() {
        return hex;
    }

    public void setHex(int hex) {
        this.hex = hex;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getSnapshot_id() {
        return snapshot_id;
    }

    public void setSnapshot_id(String snapshot_id) {
        this.snapshot_id = snapshot_id;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public String getSideview() {
        return sideview;
    }

    public void setSideview(String sideview) {
        this.sideview = sideview;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImagelink() {
        return imagelink;
    }

    public void setImagelink(String imagelink) {
        this.imagelink = imagelink;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDep_schd() {
        return dep_schd;
    }

    public void setDep_schd(int dep_schd) {
        this.dep_schd = dep_schd;
    }

    public int getArr_schd() {
        return arr_schd;
    }

    public void setArr_schd(int arr_schd) {
        this.arr_schd = arr_schd;
    }

    public int getDeparture() {
        return departure;
    }

    public void setDeparture(int departure) {
        this.departure = departure;
    }

    public int getArrival() {
        return arrival;
    }

    public void setArrival(int arrival) {
        this.arrival = arrival;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getFrom_iata() {
        return from_iata;
    }

    public void setFrom_iata(String from_iata) {
        this.from_iata = from_iata;
    }

    public String getFrom_city() {
        return from_city;
    }

    public void setFrom_city(String from_city) {
        this.from_city = from_city;
    }

    public int[] getFrom_pos() {
        return from_pos;
    }

    public void setFrom_pos(int[] from_pos) {
        this.from_pos = from_pos;
    }

    public String getFrom_tz_code() {
        return from_tz_code;
    }

    public void setFrom_tz_code(String from_tz_code) {
        this.from_tz_code = from_tz_code;
    }

    public String getFrom_tz_offset() {
        return from_tz_offset;
    }

    public void setFrom_tz_offset(String from_tz_offset) {
        this.from_tz_offset = from_tz_offset;
    }

    public String getFrom_tz_name() {
        return from_tz_name;
    }

    public void setFrom_tz_name(String from_tz_name) {
        this.from_tz_name = from_tz_name;
    }

    public String getTo_iata() {
        return to_iata;
    }

    public void setTo_iata(String to_iata) {
        this.to_iata = to_iata;
    }

    public String getTo_city() {
        return to_city;
    }

    public void setTo_city(String to_city) {
        this.to_city = to_city;
    }

    public int[] getTo_pos() {
        return to_pos;
    }

    public void setTo_pos(int[] to_pos) {
        this.to_pos = to_pos;
    }

    public String getTo_tz_code() {
        return to_tz_code;
    }

    public void setTo_tz_code(String to_tz_code) {
        this.to_tz_code = to_tz_code;
    }

    public String getTo_tz_offset() {
        return to_tz_offset;
    }

    public void setTo_tz_offset(String to_tz_offset) {
        this.to_tz_offset = to_tz_offset;
    }

    public String getTo_tz_name() {
        return to_tz_name;
    }

    public void setTo_tz_name(String to_tz_name) {
        this.to_tz_name = to_tz_name;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getAirline_url() {
        return airline_url;
    }

    public void setAirline_url(String airline_url) {
        this.airline_url = airline_url;
    }

    public String getImagesource() {
        return imagesource;
    }

    public void setImagesource(String imagesource) {
        this.imagesource = imagesource;
    }

    public String getImage_large() {
        return image_large;
    }

    public void setImage_large(String image_large) {
        this.image_large = image_large;
    }

    public String getImagelink_large() {
        return imagelink_large;
    }

    public void setImagelink_large(String imagelink_large) {
        this.imagelink_large = imagelink_large;
    }

    public String getCopyright_large() {
        return copyright_large;
    }

    public void setCopyright_large(String copyright_large) {
        this.copyright_large = copyright_large;
    }
    
    
}
