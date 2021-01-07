package com.storageApi.modelo;

public class Item {

    private int id;
    private String title;
    private int category_id;
    private double price;
    private String symbol;
    private String currency;
    private int currency_id;
    private String country;
    private int country_id;
    private String create_at;
    private String modified_at;

    public Item() {
    }

    public Item(int id, String title, int category_id, double price, String symbol, int currency_id, int country_id, String create_at, String modified_at) {
        this.id = id;
        this.title = title;
        this.category_id = category_id;
        this.price = price;
        this.symbol = symbol;
        this.currency_id = currency_id;
        this.country_id = country_id;
        this.create_at = create_at;
        this.modified_at = modified_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(int currency_id) {
        this.currency_id = currency_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getModified_at() {
        return modified_at;
    }

    public void setModified_at(String modified_at) {
        this.modified_at = modified_at;
    }

    
    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", title=" + title + ", category_id=" + category_id + ", price=" + price + ", symbol=" + symbol + ", currency_id=" + currency_id + ", country_id=" + country_id + ", create_at=" + create_at + ", modified_at=" + modified_at + '}';
    }

    
  

  

  
    

   
    
}
