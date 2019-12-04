package com.iversonx.strategy;

import com.iversonx.strategy.quote.LargeCustomerQuote;
import com.iversonx.strategy.quote.NormalCustomerQuote;
import com.iversonx.strategy.quote.OldCustomerQuote;
import com.iversonx.strategy.quote.Quote;

import java.util.HashMap;
import java.util.Map;

public class PriceContext {
    private static PriceContext CONTEXT = new PriceContext();
    private PriceContext() {
    }

    public static PriceContext getInstance() {
        return CONTEXT;
    }

    private static Map<String, Quote> quoteMap = new HashMap<>();
    static {
        quoteMap.put("large", new LargeCustomerQuote());
        quoteMap.put("old", new OldCustomerQuote());
        quoteMap.put("normal", new NormalCustomerQuote());
    }

    public double quotePrice(String customerType, double goodsPrice) {
        Quote quote = quoteMap.get(customerType);
        return quote.quotePrice(goodsPrice);
    }
}
