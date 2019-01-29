package com.sidh.io;

import com.sidh.model.StockResult;

import java.io.IOException;
import java.util.List;

public interface StockOutput {
    public void output(List<StockResult> stocks) throws IOException;
}
