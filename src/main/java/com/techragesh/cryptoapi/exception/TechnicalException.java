package com.techragesh.cryptoapi.exception;

/**
 * Create a class DataNotFoundException extending RuntimeException
 * return a message when this exception is thrown.
 */
public class TechnicalException extends RuntimeException{

      public TechnicalException(String message) {
          super(message);
      }

}
