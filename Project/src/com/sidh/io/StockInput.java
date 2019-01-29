package com.sidh.io;

import com.sidh.config.Config;
import com.sidh.model.Stock;

import java.io.IOException;

public interface StockInput {
    boolean hasNext();

    Stock getNext();
}
