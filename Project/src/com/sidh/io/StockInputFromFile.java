package com.sidh.io;

import com.sidh.Entry;
import com.sidh.config.Config;
import com.sidh.model.Stock;
import com.sidh.util.StockUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StockInputFromFile implements StockInput {
    protected File file;
    protected BufferedReader reader;
    private int line = 0;
    private String nextLine;

    public StockInputFromFile() throws IOException {
        file = new File(Config.INPUT_FILE);
        reader = new BufferedReader(new FileReader(file));
        nextLine = reader.readLine();
    }

    @Override
    public boolean hasNext() {
        try {
            nextLine = reader.readLine();
            if(nextLine == null || nextLine.equals("")) {
                reader.close();
                return false;
            }
        } catch (IOException e) {
            Entry.terminate("some io exception:" + e.getMessage());
        }
        line++;
        return true;
    }

    @Override
    public Stock getNext() {
        try {
            return StockUtils.stockFromString(nextLine);
        } catch (Exception e) {
            Entry.terminate(e.getMessage() + ", at stock: " + line);
        }
        return null;
    }
}
