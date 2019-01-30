package com.sidh.model;

public class StockResult extends Stock {
    private int finalQuantity;
    private Status status;

    public StockResult(Stock stock, int finalQuantity, Status status) {
        super(stock.getStockId(),
                stock.getSide(),
                stock.getCompany(),
                stock.getQuantity());
        this.finalQuantity = finalQuantity;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getFinalQuantity() {
        return finalQuantity;
    }

    public void setFinalQuantity(int finalQuantity) {
        this.finalQuantity = finalQuantity;
    }

    @Override
    public String toString() {
        String superString = super.toString();
        return superString.substring(0, superString.length() - 1)
                + ", finalQuantity=" + finalQuantity + ", status=" + status + "}\n";
    }
}
