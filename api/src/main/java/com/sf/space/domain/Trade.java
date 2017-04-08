package com.sf.space.domain;

/**
 * Created by adityasofat on 07/04/2017.
 */
public class Trade {
    private final TradeEvent tradeEvent;

    public Trade(TradeEvent tradeEvent) {
        this.tradeEvent = tradeEvent;
    }

    public TradeEvent getTradeEvent() {
        return tradeEvent;
    }

}
