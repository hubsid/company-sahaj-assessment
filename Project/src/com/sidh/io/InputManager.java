package com.sidh.io;

import com.sidh.model.Stock;

import java.util.ArrayList;
import java.util.List;

public class InputManager {
    public static List<Stock> getStocks(StockInput input) {
        List<Stock> stocks = new ArrayList<>();
        while (input.hasNext())
            stocks.add(input.getNext());

        return stocks;
    }
}
