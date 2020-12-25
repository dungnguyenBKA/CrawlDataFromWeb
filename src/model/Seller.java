package model;

import com.google.gson.annotations.SerializedName;

public class Seller {
    @SerializedName("store_id")
    private String store_id;
    @SerializedName("name")
    private String name;
    @SerializedName("logo")
    private String logo;

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
