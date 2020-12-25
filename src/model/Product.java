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
    @SerializedName("productset_group_name")
    private String productset_group_name;
    @SerializedName("discount_rate")
    private int discount_rate;

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    @SerializedName("current_seller")
    private Seller seller;

    public QuantityProduct getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(QuantityProduct quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    @SerializedName("stock_item")
    private QuantityProduct quantityProduct;

    public int getDiscount_rate() {
        return discount_rate;
    }

    public void setDiscount_rate(int discount_rate) {
        this.discount_rate = discount_rate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @SerializedName("categories")
    private Category category;

    public String getProductset_group_name() {
        return productset_group_name;
    }

    public void setProductset_group_name(String productset_group_name) {
        this.productset_group_name = productset_group_name;
    }

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
