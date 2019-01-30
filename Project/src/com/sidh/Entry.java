package com.sidh;

import com.sidh.io.InputManager;
import com.sidh.io.OutputManager;
import com.sidh.model.Stock;
import com.sidh.model.StockResult;
import com.sidh.process.StockProcessor;

import java.io.IOException;
import java.util.List;

public class Entry {
    public static void main(String[] args) throws IOException {
        List<Stock> stocks = InputManager.getStocks();

        StockProcessor stockProcessor = new StockProcessor(stocks);
        List<StockResult> stockResults = stockProcessor.process();

        OutputManager.putStocks(stockResults);
    }

    public static void terminate(String s) {
        System.err.println(s);
        System.exit(1);
    }
}
