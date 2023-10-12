package com.example.demosonar.business;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

public class ComplexityExampleBL {
    public List<Integer> calculateComplexity(@PathVariable int number) {
        List<Integer> result = new ArrayList<>();

        // Complexity due to loop
        for (int i = 1; i <= number; i++) {//+1
            result.add(i);
        }

        // Complexity due to conditions
        if (number > 10) {//+1
            result.add(100);
        } else {
            result.add(200);
        }

        // Complexity due to nested conditions //+1
        if (number < 5) {
            if (number % 2 == 0) {//+1
                result.add(500);
            } else {
                result.add(700);
            }
        } else {
            result.add(1000);
        }

        // Complexity due to method calls +2
        int sum = calculateSum(result);
        result.add(sum);

        return result;//+1
    }

    private int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) { //+1
            sum += num;
        }
        return sum;//+1
    }
}
