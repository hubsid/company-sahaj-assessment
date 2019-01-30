package com.sidh.io;

import com.sidh.config.Config;
import com.sidh.model.StockResult;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class StockOutputToFile implements StockOutput {
    public static final String QUOTE = "\"";
    public static final String NEWLINE = "\n";
    Path filePath;
    BufferedWriter writer;

    public StockOutputToFile() throws IOException {
        filePath = Paths.get(Config.OUTPUT_FILE);
        writer = new BufferedWriter(new FileWriter(filePath.toFile()));
    }

    @Override
    public void output(List<StockResult> stocks) throws IOException {
        StringBuilder outString = new StringBuilder();
        outString.append("StockId,Side,Company,Quantity,Status\n");
        try {
            for (StockResult stock : stocks) {
                outString.append(stock.getStockId() + Config.CSV_SEPARATOR +
                        stock.getSide() + Config.CSV_SEPARATOR +
                        stock.getCompany() + Config.CSV_SEPARATOR +
                        QUOTE +
                        stock.getQuantity() + Config.CSV_SEPARATOR +
                        stock.getFinalQuantity() +
                        QUOTE + Config.CSV_SEPARATOR +
                        stock.getStatus() +
                        NEWLINE);
            }
            writer.write(outString.toString());
            writer.flush();
        } finally {
            writer.close();
        }
    }
}
