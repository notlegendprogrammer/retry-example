# Retry Example

This repository demonstrates how to implement retry logic in a Spring Boot application using the **Spring Retry** library. Additionally, examples of retry mechanisms using pure Java (manual retry logic) are included for comparison.

## Features

- **Retry Mechanism**: Automatically retries failed operations.
- **Customizable Backoff Policy**: Supports fixed delay, random jitter, and exponential backoff.
- **Retry Listener**: Tracks retry attempts and logs delay information (**to be enhanced** in future updates).
- **Recover Mechanism**: Defines fallback behavior when retries are exhausted.
- **Simulation of Failures**: Customizable success/failure probabilities for testing.
- **Retry with Pure Java**:
  - Retry logic without jitter (fixed delay).
  - Retry logic with jitter (randomized delay).

## Prerequisites

- Java 17 or higher (Tested with Java 23)
- Apache Maven 3.6+
- Spring Boot 3.4.0

## How It Works

### 1. Retry Logic with `@Retryable`
- Retries methods that throw specific exceptions.
- Configurable maximum attempts and backoff delay.

### 2. Custom Retry Listener (to be enhanced)
- Logs retry attempts and delay times.
- Planned improvements include:
  - More detailed retry context logging (e.g., exception stack trace).
  - Custom actions upon retry success or failure.

### 3. Retry with Pure Java
- **Without Jitter**: Fixed delay between retries.
- **With Jitter**: Adds random variation to delay times between retries.

### 4. Manual Retry Using `RetryTemplate`
- Offers more granular control over retry logic.

### 5. Failure Simulation
- Uses random values to simulate success or failure.
- Probabilities are adjustable for testing different scenarios.

## Getting Started

### Clone the repository
```bash
git clone https://github.com/your-username/retry-example.git
cd retry-example
