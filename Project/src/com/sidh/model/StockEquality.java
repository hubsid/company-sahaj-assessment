package com.sidh.model;

public interface StockEquality {
    static boolean bySide(StockResult stock1, StockResult stock2) {
        return stock1.getSide() == stock2.getSide();
    }
    static boolean byStatus(StockResult stock1, StockResult stock2) {
        return stock1.getStatus() == stock2.getStatus();
    }
}
