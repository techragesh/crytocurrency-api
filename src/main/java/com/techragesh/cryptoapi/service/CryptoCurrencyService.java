package com.techragesh.cryptoapi.service;

import com.techragesh.cryptoapi.model.CryptoCurrencies;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Create a class CryptoCurrencyService with the following methods:
 * getAllCryptoCurrencies():List of CryptoCurrency
 * Implement RestTemplate to call the API https://api.twelvedata.com/cryptocurrencies in getAllCryptoCurrencies() method.
 * Return CryptoCurrencies object from getAllCryptoCurrencies() method.
 */

@Service
@Slf4j
public class CryptoCurrencyService {

  private final RestTemplate restTemplate;

  public CryptoCurrencyService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public CryptoCurrencies getAllCryptoCurrencies() {
    log.info("getAllCryptoCurrencies() called");
    return restTemplate.getForObject("https://api.twelvedata.com/cryptocurrencies", CryptoCurrencies.class);
  }

}
