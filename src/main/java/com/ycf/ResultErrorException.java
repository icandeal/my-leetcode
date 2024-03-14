package com.ycf;

/**
 * @author yuchunfan
 * @since 2024/3/14
 */

public class ResultErrorException extends RuntimeException {

  public ResultErrorException(String message) {
    super(message);
  }
}
