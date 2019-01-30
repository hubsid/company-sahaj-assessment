package com.sidh.io;

import com.sidh.model.Stock;

public interface StockInput {
    boolean hasNext();

    Stock getNext();
}
