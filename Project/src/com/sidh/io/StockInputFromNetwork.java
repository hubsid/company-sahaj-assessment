package com.sidh.io;

import com.sidh.model.Stock;

public class StockInputFromNetwork implements StockInput {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Stock getNext() {
        return null;
    }
}
