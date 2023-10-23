package com.techragesh.cryptoapi.model;

/**
 * Create a class CryptoCurrencies with the following attributes:
 * data: List of CryptoCurrency
 * Use lombok to generate getter and setter methods and constructor with all arguments.
 */
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CryptoCurrencies {

  private List<CryptoCurrency> data;
}
