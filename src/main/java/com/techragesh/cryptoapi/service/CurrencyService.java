package com.techragesh.cryptoapi.service;

import com.techragesh.cryptoapi.exception.TechnicalException;
import com.techragesh.cryptoapi.model.Currency;
import java.math.BigInteger;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.techragesh.cryptoapi.repository.CurrencyRepository;

/**
 * Create a class CurrencyService with the following methods:
 * Instantiation of CurrencyRepository class using Constructor based dependency injection.
 * getAllCurrencies():List<Currency>
 * getCurrencyById(BigInteger id):Currency
 * addCurrency(Currency currency):Currency
 * updateCurrency(Currency currency):Currency
 * deleteCurrency(BigInteger id):void
 *
 */

@Service
@Slf4j
public class CurrencyService {

  private final CurrencyRepository currencyRepository;

  public CurrencyService(CurrencyRepository currencyRepository) {
    this.currencyRepository = currencyRepository;
  }

  public List<Currency> getAllCurrencies() {
    log.info("getAllCurrencies() called");
    return currencyRepository.findAll();
  }

  public Currency getCurrencyById(BigInteger id) {
    log.info("getCurrencyById() called with id: {}", id);
    return currencyRepository.findById(id).orElseThrow(() -> new RuntimeException("Currency not found"));
  }

  public Currency addCurrency(Currency currency) {
    log.info("addCurrency() called with currency: {}", currency);

    //Check if currency already exists in the database
    Currency existingCurrency = currencyRepository.findBySymbol(currency.getSymbol());
    if (existingCurrency != null) {
      throw new TechnicalException("Currency already exists");
    }
    return currencyRepository.save(currency);
  }

  public Currency updateCurrency(Currency currency) {
    log.info("updateCurrency() called with currency: {}", currency);
    return currencyRepository.save(currency);
  }

  public void deleteCurrency(BigInteger id) {
    log.info("deleteCurrency() called with id: {}", id);
    currencyRepository.deleteById(id);
  }

}
