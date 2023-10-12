package com.example.demosonar.business;

import com.example.demosonar.models.Discount;

import java.util.Arrays;
import java.util.Optional;

public class DiscountBL {

    //total complexity 10
    public float CalculateDiscount(float saleValue , int numberArticles){
        Discount[] discounts =  {
                new Discount(100,0,3,0,5),
                new Discount(100,0,null,4,10),
                new Discount(200,100,5,0,20),
                new Discount(200,100,10,6,30),
                new Discount(200,100,null,11,35),
                new Discount(null,200,10,6,30),
                new Discount(100,0,10,4,8),
        };//+1

        Optional<Discount> finalDiscount = Arrays.stream(discounts).filter(item -> (item.getUpperBound() != null  && saleValue<=item.getUpperBound())
                && (item.getLowerBound() != null && saleValue>= item.getLowerBound())
                && (item.getMaxArticles() != null && item.getMaxArticles() >= numberArticles)
                && (item.getMinArticles() <= numberArticles)).findFirst();//+7

        if(finalDiscount.isPresent()){//+1
            return ApplyDiscount(saleValue,finalDiscount.get().getDiscount());
        }

        return saleValue;//+1
    }

    public float ApplyDiscount(float saleValue, int discount) {
        return  saleValue - (saleValue*discount/100);
    }
}
