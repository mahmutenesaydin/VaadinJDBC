package com.uniyaz.domain;

public class Icerik
{
    private int id;
    private String baslik;
    private String detay;
    private int categoryID;

    public Icerik(int id, String baslik, String detay, int categoryID) {
        this.id = id;
        this.baslik = baslik;
        this.detay = detay;
        this.categoryID = categoryID;
    }

    public Icerik(String baslik)
    {

    }

    public Icerik()
    {

    }

    public Icerik(String value, String value1, Object value2) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getDetay() {
        return detay;
    }

    public void setDetay(String detay) {
        this.detay = detay;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}
