package com.techragesh.cryptoapi.repository;

import com.techragesh.cryptoapi.model.Currency;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Create a interface CurrencyRepository extending JpaRepository<Currency, Long>
 *
 */

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, BigInteger> {

  Currency findBySymbol(String symbol);
}
