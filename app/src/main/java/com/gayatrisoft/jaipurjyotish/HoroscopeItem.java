package com.gayatrisoft.jaipurjyotish;

public class HoroscopeItem {

 String  tvHoroscope;
 int   ivHoroscope;
 String content;

    public HoroscopeItem(String tvHoroscope, int ivHoroscope,String content) {
        this.tvHoroscope = tvHoroscope;
        this.ivHoroscope = ivHoroscope;
        this.content=content;

    }

    public String getContent( ) {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTvHoroscope( ) {
        return tvHoroscope;
    }

    public void setTvHoroscope(String tvHoroscope) {
        this.tvHoroscope = tvHoroscope;
    }

    public int getIvHoroscope( ) {
        return ivHoroscope;
    }

    public void setIvHoroscope(int ivHoroscope) {
        this.ivHoroscope = ivHoroscope;
    }
}
