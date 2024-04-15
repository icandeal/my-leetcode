package com.ycf.q289;

/**
 * @author yuchunfan
 * @since 2024/3/21
 */

public class Solution {
  public static void main(String[] args) {
  }

  public void gameOfLife(int[][] board) {
    int iLen = board.length;
    int jLen = board[0].length;
    int[][] result = new int[iLen][jLen];
    for (int i = 0; i < iLen; i++) {
      for (int j = 0; j < jLen; j++) {
        int sum = 0;
        sum += getValue(board, i , j + 1);
        sum += getValue(board, i , j - 1);
        sum += getValue(board, i + 1, j);
        sum += getValue(board, i - 1, j);
        sum += getValue(board, i + 1, j + 1);
        sum += getValue(board, i - 1, j - 1);
        sum += getValue(board, i - 1, j + 1);
        sum += getValue(board, i + 1, j - 1);
        if (sum < 2) {
          result[i][j] = 0;
        } else if (sum == 2) {
          result[i][j] = board[i][j];
        } else if ((sum == 3)) {
          result[i][j] = 1;
        } else {
          result[i][j] = 0;
        }
      }
    }

    for (int i = 0; i < iLen; i++) {
      for (int j = 0; j < jLen; j++) {
        board[i][j] = result[i][j];
      }
    }
  }

  public int getValue(int[][] broad, int i, int j) {
    if (i >= broad.length || i < 0) {
      return 0;
    }
    if (j >= broad[0].length || j < 0) {
      return 0;
    }
    return broad[i][j];
  }
}
