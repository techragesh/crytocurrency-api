package com.techragesh.cryptoapi.controller;


import com.techragesh.cryptoapi.model.CryptoCurrencies;
import com.techragesh.cryptoapi.service.CryptoCurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create a class CryptoCurrenciesController with the following methods:
 * Instantiation of CryptoCurrencyService class
 * getAllCryptoCurrencies():ResponseEntity<CryptoCurrencies>
 * Implement getAllCryptoCurrencies() method to call the getAllCryptoCurrencies() method of CryptoCurrencyService class.
 * Return ResponseEntity<CryptoCurrencies> from getAllCryptoCurrencies() method.
 */

@RestController
@RequestMapping("/api/v1/cryptocurrencies")
@Slf4j
public class CryptoCurrenciesController {

  private final CryptoCurrencyService cryptoCurrencyService;

  public CryptoCurrenciesController(CryptoCurrencyService cryptoCurrencyService) {
    this.cryptoCurrencyService = cryptoCurrencyService;
  }

  @GetMapping
  public ResponseEntity<CryptoCurrencies> getAllCryptoCurrencies() {
    log.info("getAllCryptoCurrencies() called");
    return ResponseEntity.ok(cryptoCurrencyService.getAllCryptoCurrencies());
  }


}
