package com.techragesh.cryptoapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create a class Currency with the following attributes:
 * id:BigInteger
 * symbol:string
 * base:string
 * quote:string
 * Use lombok to generate getter and setter methods and constructor with all arguments and no arguments.
 * Create Entity and Table annotation to map Currency class to currency table.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "currency")
public class Currency {

      @Id
      @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
      @Column(name = "id")
      private BigInteger id;
      @Column(name = "symbol")
      private String symbol;
      @Column(name = "base")
      private String base;
      @Column(name = "quote")
      private String quote;
}
