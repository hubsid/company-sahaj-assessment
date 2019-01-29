package com.sidh;

import com.sidh.io.InputManager;
import com.sidh.io.OutputManager;
import com.sidh.io.StockInput;
import com.sidh.model.Stock;
import com.sidh.model.StockCompare;
import com.sidh.model.StockResult;
import com.sidh.process.StockProcessor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
