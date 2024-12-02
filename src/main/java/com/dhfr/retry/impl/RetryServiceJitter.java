/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dhfr.retry.impl;

import java.util.concurrent.ThreadLocalRandom;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 *
 * @author d.husnifahririzal
 */
@Service

public class RetryServiceJitter {

    private int attempt = 0;

    /**
     * Simulasi operasi dengan probabilitas kontrol.
     *
     * @param successProbability Probabilitas keberhasilan (0.0 - 1.0).
     * @throws java.lang.Exception
     */
    @Retryable(
            retryFor = {Exception.class},
            maxAttempts = 6,
            backoff = @Backoff(delay = 1000, random = true)
    )
    public void performOperation(double successProbability) throws Exception {
        attempt++;
        System.out.println("Attempt #" + attempt + ": Trying operation...");

        // Menghasilkan nilai acak dan membandingkannya dengan probabilitas keberhasilan
        double randomValue = ThreadLocalRandom.current().nextDouble();
        if (randomValue > successProbability) {
            throw new Exception("Simulated failure Jitter (Random value: " + randomValue + ")");
        }

        System.out.println("Operation succeeded! (Random value: " + randomValue + ")");
    }

    @Recover
    public void recover(Exception e) {
        System.out.println("Recovery after retry: " + e.getMessage());
    }
}
