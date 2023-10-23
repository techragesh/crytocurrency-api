package com.techragesh.cryptoapi.model;

/**
 * Create a class CryptoCurrency with the following attributes:
 * symbol:string
 * available_exchanges:List of String
 * currency_base:string
 * currency_quote:string
 * Use lombok to generate getter and setter methods and constructor with all arguments.
 */
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CryptoCurrency {

    private String symbol;
    private String currency_base;
    private String currency_quote;
    private List<String> available_exchanges;
}
