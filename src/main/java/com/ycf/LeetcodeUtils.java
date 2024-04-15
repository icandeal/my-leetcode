package com.ycf;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuchunfan
 * @since 2024/3/14
 */

public class LeetcodeUtils {
  public static final ObjectMapper objectMapper = new ObjectMapper();


  public static int[] parseIntArray(String arrayStr) {
    JsonNode jsonNode;
    try {
      jsonNode = objectMapper.readTree(arrayStr);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("数组解析失败");
    }
    int size = jsonNode.size();
    int[] result = new int[size];
    int i = 0;
    Iterator<JsonNode> iterator = jsonNode.elements();
    while (iterator.hasNext()) {
      result[i++] = iterator.next().asInt();
    }
    return result;
  }

  public static String[] parseStringArray(String arrayStr) {
    JsonNode jsonNode;
    try {
      jsonNode = objectMapper.readTree(arrayStr);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("数组解析失败");
    }
    int size = jsonNode.size();
    String[] result = new String[size];
    int i = 0;
    Iterator<JsonNode> iterator = jsonNode.elements();
    while (iterator.hasNext()) {
      result[i++] = iterator.next().asText();
    }
    return result;
  }

  public static int[][] castIntArrayArray(String arrayStr) {
    JsonNode jsonNode;
    try {
      jsonNode = objectMapper.readTree(arrayStr);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("数组解析失败");
    }
    int size = jsonNode.size();
    int[][] result = new int[size][];
    int i = 0;
    Iterator<JsonNode> iterator = jsonNode.elements();
    while (iterator.hasNext()) {
      JsonNode next = iterator.next();
      result[i] = new int[next.size()];
      Iterator<JsonNode> elements = next.elements();
      int j = 0;
      while (elements.hasNext()) {
        result[i][j ++] = elements.next().asInt();
      }
      i ++;
    }
    return result;
  }

  public static String arrayToString(int[] array) {
    return Arrays.stream(array)
        .mapToObj(Integer::toString)
        .collect(Collectors.joining(",", "[", "]"));
  }

  public static void testArray(String arrayStr, int[] result) {
    String string = arrayToString(result);
    testEqual(arrayStr, string);
  }

  public static void testEqual(Object obj, Object result) {
    if (!obj.equals(result)) {
      throw new ResultErrorException("######Failed! answer: " + obj + " >>> result: " + result);
    }
    System.out.println("Success! answer: " + obj + " >>> result: " + result);
  }
}
