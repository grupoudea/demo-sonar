package com.example.demosonar.business;

public class DiscountComplexBL {
    public float CalculateDiscount(float saleValue , int numberArticles){
        if(saleValue<=0){
            return saleValue;
        }

        if(saleValue > 100 && saleValue<200 ){
            if(numberArticles<5){
                return ApplyDiscount(saleValue,20);
            }else if(numberArticles>5 && numberArticles<10){
                return  ApplyDiscount(saleValue,30);
            }else {
                return  ApplyDiscount(saleValue,35);
            }
        }else if(saleValue < 100 ){
            if(numberArticles<3){
                return ApplyDiscount(saleValue,5);
            }else if(numberArticles>=4 && numberArticles<=10) {
                return ApplyDiscount(saleValue,8);
            }
            else {
                return ApplyDiscount(saleValue,10);
            }
        }else if(saleValue>200){
            if(numberArticles<3){
                return ApplyDiscount(saleValue,10);
            }else if(numberArticles>3 && saleValue>300){
                return ApplyDiscount(saleValue,30);
            }else{
                return ApplyDiscount(saleValue,25);
            }
        }

        return saleValue;
    }

    public float ApplyDiscount(float saleValue, int discount) {
        return  saleValue - (saleValue*discount/100);
    }
}
