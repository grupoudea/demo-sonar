package com.example.demosonar.models;

import lombok.Data;
import lombok.Getter;

public class Discount {
    // Getter for upperBound
    @Getter
    private Integer upperBound;
    @Getter
    private Integer lowerBound;
    @Getter
    private Integer maxArticles;
    @Getter
    private int minArticles;
    @Getter
    private int discount;

    // Constructor
    public Discount(Integer upperBound, Integer lowerBound, Integer maxArticles, int minArticles, int discount) {
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        this.maxArticles = maxArticles;
        this.minArticles = minArticles;
        this.discount = discount;
    }

    // Setter for upperBound
    public void setUpperBound(Integer upperBound) {
        this.upperBound = upperBound;
    }



    // Setter for lowerBound
    public void setLowerBound(Integer lowerBound) {
        this.lowerBound = lowerBound;
    }

    // Setter for maxArticles
    public void setMaxArticles(int maxArticles) {
        this.maxArticles = maxArticles;
    }



    // Setter for minArticles
    public void setMinArticles(int minArticles) {
        this.minArticles = minArticles;
    }


    // Setter for discount
    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
