package com.sidh.io;

import com.sidh.config.Config;
import com.sidh.model.Stock;

import java.io.IOException;

public interface StockInput {
    static StockInput getInstance() throws IOException {
        switch (Config.INPUT_SOURCE) {
            case FROM_CMD: return new StockInputFromCmd();
            case FROM_NETWORK_REQUEST: return new StockInputFromNetwork();
            case FROM_FILE: return new StockInputFromFile();
            default: return null;
        }
    }

    boolean hasNext();

    Stock getNext();
}
