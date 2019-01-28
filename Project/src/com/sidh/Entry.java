package com.sidh;

import com.sidh.io.InputManager;
import com.sidh.io.StockInput;
import com.sidh.model.Stock;
import com.sidh.model.StockCompare;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Entry {
    public static void main(String[] args) throws IOException {
//        List<Stock> stocks = InputManager.getStocks(StockInput.getInstance());

//        System.out.println("operation over:stocks are:");
//        System.out.println(stocks);

        List<Stock> stocks = new ArrayList<>();
        stocks.addAll(Arrays.asList(
                new Stock(1, Stock.Side.BUY, "mother", 56),
                new Stock(2, Stock.Side.BUY, "sister", 23),
                new Stock(3, Stock.Side.SELL, "", 42)
        ));
    }

    public static void terminate(String s) {
        System.err.println(s);
        System.exit(1);
    }
}
