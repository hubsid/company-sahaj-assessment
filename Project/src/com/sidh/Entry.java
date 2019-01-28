package com.sidh;

import com.sidh.io.InputManager;
import com.sidh.io.StockInput;
import com.sidh.model.Stock;

import java.io.IOException;
import java.util.List;

public class Entry {
    public static void main(String[] args) throws IOException {
        List<Stock> stocks = InputManager.getStocks(StockInput.getInstance());

//        System.out.println("operation over:stocks are:");
//        System.out.println(stocks);


    }

    public static void terminate(String s) {
        System.err.println(s);
        System.exit(1);
    }
}
