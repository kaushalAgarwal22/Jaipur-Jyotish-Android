package com.gayatrisoft.jaipurjyotish;

public class JyotishItem {

    String tvHoroscope,tvRead;
    int ivHoroscope;

    public JyotishItem(String tvHoroscope, String tvRead, int ivHoroscope) {
        this.tvHoroscope = tvHoroscope;
        this.tvRead = tvRead;
        this.ivHoroscope = ivHoroscope;
    }

    public String getTvHoroscope( ) {
        return tvHoroscope;
    }

    public void setTvHoroscope(String tvHoroscope) {
        this.tvHoroscope = tvHoroscope;
    }

    public String getTvRead( ) {
        return tvRead;
    }

    public void setTvRead(String tvRead) {
        this.tvRead = tvRead;
    }

    public int getIvHoroscope( ) {
        return ivHoroscope;
    }

    public void setIvHoroscope(int ivHoroscope) {
        this.ivHoroscope = ivHoroscope;
    }
}
