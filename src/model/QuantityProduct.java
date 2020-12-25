package model;

import com.google.gson.annotations.SerializedName;

public class QuantityProduct {
    @SerializedName("qty")
    private int qty;

    @SerializedName("min_sale_qty")
    private int min_sale_qty;

    @SerializedName("max_sale_qty")
    private int max_sale_qty;

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getMin_sale_qty() {
        return min_sale_qty;
    }

    public void setMin_sale_qty(int min_sale_qty) {
        this.min_sale_qty = min_sale_qty;
    }

    public int getMax_sale_qty() {
        return max_sale_qty;
    }

    public void setMax_sale_qty(int max_sale_qty) {
        this.max_sale_qty = max_sale_qty;
    }
}
