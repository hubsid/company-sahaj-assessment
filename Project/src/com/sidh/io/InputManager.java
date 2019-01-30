package com.sidh.io;

import com.sidh.config.Config;
import com.sidh.model.Stock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputManager {


    public static List<Stock> getStocks() throws IOException {
        StockInput input = getInput();
        List<Stock> stocks = new ArrayList<>();
        while (input.hasNext())
            stocks.add(input.getNext());

        return stocks;
    }

    public static StockInput getInput() throws IOException {
        switch (Config.INPUT_SOURCE) {
            case FROM_CMD:
                return new StockInputFromCmd();
            case FROM_NETWORK_REQUEST:
                return new StockInputFromNetwork();
            case FROM_FILE:
                return new StockInputFromFile();
            default:
                return null;
        }
    }
}
