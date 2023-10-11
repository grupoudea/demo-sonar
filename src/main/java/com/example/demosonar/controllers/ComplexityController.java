package com.example.demosonar.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

public class ComplexityController {
    @GetMapping("/complexity/{number}")
    public List<Integer> calculateComplexity(@PathVariable int number) {
        List<Integer> result = new ArrayList<>();

        // Complexity due to loop
        for (int i = 1; i <= number; i++) {
            result.add(i);
        }

        // Complexity due to conditions
        if (number > 10) {
            result.add(100);
        } else {
            result.add(200);
        }

        // Complexity due to nested conditions
        if (number < 5) {
            if (number % 2 == 0) {
                result.add(500);
            } else {
                result.add(700);
            }
        } else {
            result.add(1000);
        }

        // Complexity due to method calls
        int sum = calculateSum(result);
        result.add(sum);

        return result;
    }

    private int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
