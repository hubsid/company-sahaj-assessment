package com.sidh.model;

public class StockResult extends Stock {
    private int finalQuantity;
    private Status status;

    public StockResult(Stock stock, int finalQuantity, Status status) {
        super(stock.getStockId(),
                stock.getSide(),
                stock.getCompany(),
                stock.getQuantity());
        this.finalQuantity= finalQuantity;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public int getFinalQuantity() {
        return finalQuantity;
    }

    @Override
    public String toString() {
        String superString = super.toString();
        return superString.substring(0, superString.length()-2)
                + ", finalQuantity=" + finalQuantity + ", status=" + status + "}";
    }
}
