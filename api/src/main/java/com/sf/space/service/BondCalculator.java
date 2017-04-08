package com.sf.space.service;

import com.sf.space.domain.Bond;
import com.sf.space.domain.Entity;

import java.math.BigDecimal;

/**
 * Created by adityasofat on 08/04/2017.
 */
public class BondCalculator {


    public BigDecimal calculate(Entity entity) {
        BigDecimal payments = new BigDecimal( entity.getEntityItem(Bond.Payments,Integer.class));
        BigDecimal rate = entity.getEntityItemBigDecimal(Bond.CouponRate);
        BigDecimal parValue = entity.getEntityItemBigDecimal(Bond.ParValue);
        BigDecimal numberOfCoupons = payments.multiply(new BigDecimal(entity.getEntityItem(Bond.Tenor,Integer.class)));
        BigDecimal couponRate  = rate.divide(payments);
        BigDecimal couponPayment  = parValue.multiply(couponRate).setScale(2,BigDecimal.ROUND_HALF_UP);
        BigDecimal requiredYield = entity.getEntityItemBigDecimal(Bond.Yield).divide(payments);
        BigDecimal numerator = BigDecimal.ONE.add(requiredYield).pow(numberOfCoupons.intValue()).setScale(3,BigDecimal.ROUND_HALF_UP);
        BigDecimal invertedNumerator = BigDecimal.ONE.divide(numerator,4,BigDecimal.ROUND_HALF_UP);
        BigDecimal middle  =  BigDecimal.ONE.subtract(invertedNumerator).divide(requiredYield,2,BigDecimal.ROUND_HALF_UP);
        BigDecimal right = parValue.divide(numerator,2,BigDecimal.ROUND_HALF_UP);
        return couponPayment.multiply(middle).add(right).setScale(2,BigDecimal.ROUND_HALF_UP);
    }
}
