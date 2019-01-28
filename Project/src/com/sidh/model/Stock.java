package com.sidh.model;

public class Stock {
    public enum Side {BUY, SELL}
    public enum Status {CLOSED, OPEN}

    private int stockId;
    private Side side;
    private String company;
    private int quantity;

    public Stock(int stockId, Side side, String company, int quantity) {
        this.stockId = stockId;
        this.side = side;
        this.company = company;
        this.quantity = quantity;
    }

    public int getStockId() {
        return stockId;
    }

    public Side getSide() {
        return side;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCompany() {
        return company;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "{stockId=" + stockId + ", side=" + side + ", company=" + company + ", quantity=" + quantity + "}";
    }
}
