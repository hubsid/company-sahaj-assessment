package com.sidh.process;

import com.sidh.model.Stock;
import com.sidh.model.StockResult;

import java.util.*;

public class StockProcessor {
    private List<Stock> inputStocks;
    private List<StockResult> outputStocks = new ArrayList<>();
    private Map<String, List<StockResult>> splitStocks = new HashMap<>();

    public StockProcessor(List<Stock> stocks) {
        inputStocks = stocks;
    }

    public void process() {
        if(inputStocks.isEmpty()) return;

        makeOutputStocks();
        splitByCompany();
    }

    private void splitByCompany() {
        for(StockResult stockResult: outputStocks) {
            String company = stockResult.getCompany();
           if(splitStocks.containsKey(company)) {
                splitStocks.get(company).add(stockResult);
            }
           else {
               List<StockResult> stockResults = new ArrayList<>();
               stockResults.add(stockResult);
               splitStocks.put(company, stockResults);
           }
        }
    }

    private void makeOutputStocks() {
        for(Stock stock:inputStocks)
            outputStocks.add(new StockResult(stock, stock.getQuantity(), Stock.Status.OPEN));
    }
}
