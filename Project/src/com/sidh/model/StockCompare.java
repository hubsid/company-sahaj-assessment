package com.sidh.model;

public interface StockCompare {
    static int byQuantity(Stock stock1, Stock stock2) {
        return stock1.getQuantity() - stock2.getQuantity();
    }
    static int byFinalQuantity(StockResult stock1, StockResult stock2) {
        return stock1.getFinalQuantity() - stock2.getFinalQuantity();
    }

}
