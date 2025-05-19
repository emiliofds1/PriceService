package com.emiliofds.prices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the Prices service Spring Boot application.
 *
 * <p>Bootstraps the application context and starts the embedded server.
 */
@SpringBootApplication
public class PricesServiceApplication {

  /**
   * Application entry point.
   *
   * <p>Bootstraps and launches the Spring Boot application context.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    SpringApplication.run(PricesServiceApplication.class, args);
  }
}
