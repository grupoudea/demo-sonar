package com.example.demosonar.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
public class ComplexityController2 {
    @GetMapping("/complexity/{number}")
    public List<Integer> calculateComplexity(@PathVariable int number) {
        var result = processLoop(number);
        processConditions(result,number);
        processMethodCall(result);

        return result;
    }

    private List<Integer> processLoop(int number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            result.add(i);
        }
        return result;
    }

    private void processConditions(List<Integer> result, int number) {
        if (number > 10) {
            result.add(100);
        } else {
            result.add(200);
        }

        if (number < 5) {
            if (number % 2 == 0) {
                result.add(500);
            } else {
                result.add(700);
            }
        } else {
            result.add(1000);
        }
    }

    private void processMethodCall(List<Integer> result) {
        int sum = calculateSum(result);
        result.add(sum);
    }

    private int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
