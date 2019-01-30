package com.sidh.util;

import com.sidh.config.Config;
import com.sidh.model.Stock;
import com.sidh.model.StockResult;

import java.util.List;

public class StockUtils {
    public static Stock stockFromString(String inputString) throws Exception {
        System.out.println("inputstring:" + inputString);
        String[] data = inputString.split(Config.CSV_SEPARATOR);
        for (int i = 0; i < data.length; i++)
            System.out.println("--" + data[i] + "--");
        if (data == null || data.length != 4)
            throw new Exception("mismatch in number of columns, expected:4, actual:" + data.toString());
        for (int i = 0; i < 4; i++) {
            if (data[i].equals(""))
                throw new Exception("data should not be empty");
            data[i] = data[i].trim();
        }
        Stock.Side side;
        if (data[1].equalsIgnoreCase("buy"))
            side = Stock.Side.BUY;
        else if (data[1].equalsIgnoreCase("sell"))
            side = Stock.Side.SELL;
        else
            throw new Exception("side should be either buy or sell");
        String company = data[2];
        int stockId;
        int quantity;
        try {
            stockId = Integer.parseInt(data[0]);
            quantity = Integer.parseInt(data[3]);
        } catch (NumberFormatException e) {
            throw new Exception("stockId and quantity should be integers");
        }
        if (!(stockId > 0 && quantity > 0))
            throw new Exception("stockId and quantity should be positive");

        return new Stock(stockId, side, company, quantity);
    }

    public static boolean areOpposites(Stock stock1, Stock stock2) {
        return stock1.getSide() != stock2.getSide();
    }

    public static void performOrder(StockResult stock1, StockResult stock2) {
        StockResult temp1, temp2;

        if (stock1.getFinalQuantity() > stock2.getFinalQuantity()) {
            temp1 = stock1;
            temp2 = stock2;
        } else {
            temp1 = stock2;
            temp2 = stock1;
        }
        temp1.setFinalQuantity(temp1.getFinalQuantity() - temp2.getFinalQuantity());

        if (temp1.getFinalQuantity() == 0)
            temp1.setStatus(Stock.Status.CLOSED);
        temp2.setStatus(Stock.Status.CLOSED);
    }

    public static void closeAll(List<StockResult> stocks) {
        stocks.stream().forEach(stock -> {
            stock.setFinalQuantity(0);
            stock.setStatus(Stock.Status.CLOSED);
        });
    }

    public static void close(List<StockResult> stocks) {
        stocks.stream().filter(stock -> stock.getFinalQuantity() == 0).forEach(stock -> {
            stock.setStatus(Stock.Status.CLOSED);
        });
    }
}
