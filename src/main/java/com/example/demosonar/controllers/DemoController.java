package com.example.demosonar.controllers;

import com.example.demosonar.dtos.DemoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController()
@RequestMapping("/demo")

public class DemoController {

    private final Logger log = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/get-demo")
    public ResponseEntity<DemoDto> getDemo(){
        var demo = new DemoDto();
        demo.age = 1;
        demo.setName("DemoName");

        System.out.println("Demo: "+ demo);

        return ResponseEntity.ok(demo);

    }

    @GetMapping("/list-numbers-until/{maxNumber}")
    public ResponseEntity<List<String>> getListNumber(@PathVariable Integer maxNumber) {

        log.info("Starting...");
        long startTime = System.currentTimeMillis();
        if (maxNumber <= 0) {
            return ResponseEntity.badRequest().body(null);
        }

        List<String> numberList = new ArrayList<>();

        for (int i = 1; i <= maxNumber; i++) {
            numberList.add(String.valueOf(i));
        }
        long endTime = System.currentTimeMillis();
        long overalTime = endTime - startTime;
        log.info("Basic algorithm (for)");
        log.info("Execution time: " + overalTime + " ms");

        return ResponseEntity.ok(numberList);

    }

    @GetMapping("/stream/list-numbers-until/{maxNumber}")
    public ResponseEntity<List<String>> getListNumberWithStream(@PathVariable Integer maxNumber) {

        log.info("Starting...");
        long startTime = System.currentTimeMillis();
        if (maxNumber <= 0) {
            return ResponseEntity.badRequest().body(null);
        }

        List<String> numberList = IntStream
                .rangeClosed(1, maxNumber)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());

        long endTime = System.currentTimeMillis();
        long overalTime = endTime - startTime;
        log.info("Stream API algorithm (stream)");
        log.info("Execution time: " + overalTime + " ms");

        return ResponseEntity.ok(numberList);

    }

    @GetMapping("/concurent/list-numbers-until/{maxNumber}")
    public ResponseEntity<List<String>> getListNumberWithConcurrency(@PathVariable Integer maxNumber) {
        log.info("Starting...");

        long startTime = System.currentTimeMillis();

        if (maxNumber <= 0) {
            return ResponseEntity.badRequest().body(null);
        }

        int threads = 1;

        if (maxNumber % 2 == 0) {
            int ten = 1;
            if (maxNumber > 10) {
                ten = 5;
            }
            threads = 2*ten;
        } else if (maxNumber % 3 == 0) {
            threads = 3;
        } else if (maxNumber % 5 == 0) {
            threads = 5;
        }

        ExecutorService executor = Executors.newFixedThreadPool(threads);

        List<Future<List<String>>> futures = new ArrayList<>();
        int batchSize = maxNumber / threads;
        int start = 1;
        int end = batchSize;

        for (int i = 0; i < threads; i++) {
            final int from = start;
            final int to = i == threads - 1 ? maxNumber : end;

            Future<List<String>> future = executor.submit(() -> generateNumberList(from, to));
            futures.add(future);

            start = end + 1;
            end += batchSize;
        }

        List<String> numberList = new ArrayList<>();

        for (Future<List<String>> future : futures) {
            try {
                numberList.addAll(future.get());
            } catch (Exception e) {
                log.error("Error al obtener resultados de un hilo: " + e.getMessage());
            }
        }

        executor.shutdown();
        long endTime = System.currentTimeMillis();
        long overalTime = endTime - startTime;
        log.info("Concurrent algorithm (for)");
        log.info("Execution time: " + overalTime + " ms");
        return ResponseEntity.ok(numberList);
    }

    private List<String> generateNumberList(int from, int to) {

        var result =  IntStream.rangeClosed(from, to)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());

        return result;
    }



}
