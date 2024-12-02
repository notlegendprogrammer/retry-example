/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dhfr.retry.impl;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 *
 * @author d.husnifahririzal
 */
@Service
public class RetryService {

    private int attempt = 0;

    @Retryable(retryFor = {RuntimeException.class}, maxAttempts = 6, backoff = @Backoff(delay = 1000))
    public void performOperation() {
        attempt++;
        System.out.println("Attempt #" + attempt + ": Trying operation...");
        if (attempt < 6) {
            throw new RuntimeException("Simulated failure");
        }
        System.out.println("Operation succeeded!");
    }

    @Recover
    public void recover(RuntimeException e) {
        System.out.println("Recovery after retry: " + e.getMessage());
    }
}
