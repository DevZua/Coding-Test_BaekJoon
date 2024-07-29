package com.sparta.codingtest.week1.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1_1330 {
  public static void main(String[] args) throws IOException {
      // 입력을 받기 위해 BufferedReader를 생성
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      // 입력받은 한 줄을 공백으로 분리하여 배열에 저장
      String[] input = br.readLine().split(" ");

      // 배열의 첫 번째 요소를 정수로 변환하여 변수 A에 저장
      int A = Integer.parseInt(input[0]);
      // 배열의 두 번째 요소를 정수로 변환하여 변수 B에 저장
      int B = Integer.parseInt(input[1]);

      // A와 B를 비교하여 결과를 출력
      if (A > B) {
          System.out.println(">");
      } else if (A < B) {
          System.out.println("<");
      } else {
          System.out.println("==");
      }
  }

}
/*
14204 KB / 124 ms
 */

