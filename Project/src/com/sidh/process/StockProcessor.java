package com.sidh.process;

import com.sidh.model.Stock;
import com.sidh.model.StockCompare;
import com.sidh.model.StockResult;
import com.sidh.util.StockUtils;

import java.util.*;
import java.util.stream.Collectors;

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
        processStocks();
    }

    private void processStocks() {
        for(String company:splitStocks.keySet()) {
            List<StockResult> companyStocks = splitStocks.get(company);

            List<StockResult> buyStocks = companyStocks.stream()
                    .filter(stock -> stock.getSide() == Stock.Side.BUY)
                    .sorted(StockCompare::byFinalQuantity)
                    .collect(Collectors.toList());

            List<StockResult> sellStocks = companyStocks.stream()
                    .sorted(StockCompare::byFinalQuantity)
                    .collect(Collectors.toList());


            int sumBuyStock = buyStocks.stream().mapToInt(StockResult::getFinalQuantity).sum();
            int sumSellStock = sellStocks.stream().mapToInt(StockResult::getFinalQuantity).sum();

            if(sumBuyStock > sumSellStock) {
                StockUtils.closeAll(sellStocks);
                subtract(buyStocks, sumSellStock);
            }
            else {
                StockUtils.closeAll(buyStocks);
                if(sumBuyStock == sumSellStock)
                    StockUtils.closeAll(sellStocks);
                subtract(sellStocks, sumBuyStock);
            }
        }
    }

    private void subtract(List<StockResult> stocks, int value) {
        do {

        } while (value > 0);
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
