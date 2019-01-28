package com.sidh.io;

import com.sidh.config.Config;
import com.sidh.model.Stock;
import com.sidh.model.StockResult;

import java.io.IOException;
import java.util.List;

public class OutputManager {
    public static void putStocks(List<StockResult> stocks) throws IOException {
        switch (Config.OUTPUT_DESTINATION) {
            case TO_FILE: new StockOutputToFile().output(stocks);
            break;
            case TO_CMD: new StockOutputToCmd().output(stocks);
            break;
            case TO_NETWORK_RESPONSE: new StockOutputToResp().output(stocks);
        }
    }
}
