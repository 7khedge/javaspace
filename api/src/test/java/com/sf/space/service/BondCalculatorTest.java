package com.sf.space.service;


import com.sf.space.domain.Bond;
import com.sf.space.domain.Entity;
import com.sf.space.domain.EntityType;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by adityasofat on 08/04/2017.
 */
public class BondCalculatorTest {


    @Test
    public void shouldCalculatePrice() throws Exception {
        //Given
        Entity entity = new Entity(EntityType.Bond);
        entity.addEntityItem(Bond.ParValue,1000.0)
        .addEntityItem(Bond.Tenor,10)
        .addEntityItem(Bond.CouponRate,0.1)
        .addEntityItem(Bond.Yield,0.12)
        .addEntityItem(Bond.Payments,2);
        BondCalculator bondCalculator = new BondCalculator();
        ///When
        BigDecimal bondPrice = bondCalculator.calculate(entity);

        //Then
        MatcherAssert.assertThat(bondPrice, CoreMatchers.equalTo(new BigDecimal(885.32).setScale(2,BigDecimal.ROUND_HALF_UP)));
    }
}