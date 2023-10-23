package com.techragesh.cryptoapi.controller;

import com.techragesh.cryptoapi.model.Currency;
import com.techragesh.cryptoapi.service.CurrencyService;
import java.math.BigInteger;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Create a class CurrencyController with the following methods:
 * Instantiation of CurrencyService class using Constructor based dependency injection.
 * getAllCurrencies():ResponseEntity<List<Currency>>
 * getCurrencyById(BigInteger id):ResponseEntity<Currency>
 * addCurrency(Currency currency):ResponseEntity<Currency>
 * updateCurrency(Currency currency):ResponseEntity<Currency>
 * deleteCurrency(BigInteger id):ResponseEntity<Void>
 *
 */

@RestController
@RequestMapping("/api/v1/currencies")
@Slf4j
public class CurrencyController {

  private final CurrencyService currencyService;

  public CurrencyController(CurrencyService currencyService) {
    this.currencyService = currencyService;
  }

  @GetMapping
  public ResponseEntity<List<Currency>> getAllCurrencies() {
    log.info("getAllCurrencies() called");
    return ResponseEntity.ok(currencyService.getAllCurrencies());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Currency> getCurrencyById(@PathVariable BigInteger id) {
    log.info("getCurrencyById() called with id: {}", id);
    return ResponseEntity.ok(currencyService.getCurrencyById(id));
  }

  @PostMapping
  public ResponseEntity<Currency> addCurrency(@RequestBody Currency currency) {
    log.info("addCurrency() called with currency: {}", currency);
    return ResponseEntity.ok(currencyService.addCurrency(currency));
  }

  @PutMapping
  public ResponseEntity<Currency> updateCurrency(@RequestBody Currency currency) {
    log.info("updateCurrency() called with currency: {}", currency);
    return ResponseEntity.ok(currencyService.updateCurrency(currency));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCurrency(@PathVariable BigInteger id) {
    log.info("deleteCurrency() called with id: {}", id);
    currencyService.deleteCurrency(id);
    return ResponseEntity.ok().build();
  }

}
