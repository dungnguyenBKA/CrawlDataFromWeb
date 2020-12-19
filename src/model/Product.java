package model;

import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("url_key")
    private String url_key;
    @SerializedName("url_path")
    private String url_path;
    @SerializedName("short_description")
    private String short_description;
    @SerializedName("price")
    private int price;
    @SerializedName("list_price")
    private int list_price;
    @SerializedName("price_usd")
    private float price_usd;
    @SerializedName("thumbnail_url")
    private String thumbnail_url;
    @SerializedName("description")
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl_key() {
        return url_key;
    }

    public void setUrl_key(String url_key) {
        this.url_key = url_key;
    }

    public String getUrl_path() {
        return url_path;
    }

    public void setUrl_path(String url_path) {
        this.url_path = url_path;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getList_price() {
        return list_price;
    }

    public void setList_price(int list_price) {
        this.list_price = list_price;
    }

    public float getPrice_usd() {
        return price_usd;
    }

    public void setPrice_usd(float price_usd) {
        this.price_usd = price_usd;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
