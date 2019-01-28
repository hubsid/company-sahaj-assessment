package com.sidh.util;

import com.sidh.config.Config;
import com.sidh.model.Stock;

public class StockUtils {
    public static Stock stockFromString(String inputString) throws Exception {
        System.out.println("inputstring:" + inputString);
        String[] data = inputString.split(Config.CSV_SEPARATOR);
        for(int i = 0; i < data.length; i++)
            System.out.println("--" + data[i] + "--");
        if (data == null || data.length != 4)
            throw new Exception("mismatch in number of columns, expected:4, actual:" + data.toString());
        for(int i = 0; i < 4; i++) {
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
        if(! (stockId > 0 && quantity > 0))
            throw new Exception("stockId and quantity should be positive");

        return new Stock(stockId, side, company, quantity);
    }
}
