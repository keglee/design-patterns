package com.iversonx.strategy;

public class Application {
    public static void main(String[] args){
        PriceContext context = PriceContext.getInstance();
        context.quotePrice("large", 100.0);
        context.quotePrice("old", 100.0);
        context.quotePrice("normal", 100.0);
    }
}
