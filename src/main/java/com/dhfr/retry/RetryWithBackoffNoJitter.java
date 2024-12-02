/*
 * 
 * This class implements retry logic with exponential backoff strategy.
 * It handles errors by retrying the operation up to a maximum number of attempts.
 * After each failure, the delay between retries increases exponentially.
 * If the maximum number of retries is reached, an error is logged, and no further attempts are made.
 * 
 * Logging is done using Log4j2 to record detailed information about each attempt, including timestamps,
 * the status of each operation, and backoff delays.
 * Logs are saved both to the console and to a file (logs/retry.log).
 * 
 * Dependencies:
 * - Log4j2 library for logging (log4j-core and log4j-api).
 * 
 * Author: Kang Legend
 * Date: 30 Novemner 2024
 */
package com.dhfr.retry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.TimeUnit;

public class RetryWithBackoffNoJitter {

    private static final Logger logger = LogManager.getLogger(RetryWithBackoffNoJitter.class);

    public static void main(String[] args) {
        int maxRetries = 5; // Batas percobaan ulang
        int baseDelay = 100; // Waktu jeda awal dalam milidetik

        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                logger.info("Attempt {}: Trying operation...", attempt);
                performOperation(); // Panggil metode yang bisa gagal
                logger.info("Operation succeeded!");

                break; // Keluar dari loop jika berhasil
            } catch (Exception e) {
                logger.error("Operation failed on attempt {}: {}", attempt, e.getMessage());
                if (attempt == maxRetries) {
                    logger.error("Max retries reached. Operation permanently failed.");
                    break;
                }

                // Hitung waktu tunggu dengan exponential backoff
                long backoffDelay = (long) (baseDelay * Math.pow(2, attempt - 1));
                logger.info("Waiting for {} ms before retrying...", backoffDelay);
                sleep(backoffDelay);
            }
        }
    }

    // Metode untuk simulasi operasi
    private static void performOperation() throws Exception {
        if (Math.random() < 1) { // Simulasikan kegagalan 70% peluang
            logger.info("Do some thing");
            throw new Exception("Simulated failure");
        }
    }

    // Metode sleep untuk jeda
    private static void sleep(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
