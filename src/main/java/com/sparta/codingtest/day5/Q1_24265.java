package com.sparta.codingtest.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1_24265 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // n 값을 입력받고 long 타입으로 변환
            long n = Long.parseLong(br.readLine().trim());

            // 수행 횟수 계산 -> 이중 루프의 수행 횟수를 수학적으로 계산한 것
            long code1Count = n * (n - 1) / 2;

            // 수행 횟수 출력
            System.out.println(code1Count);

            // 알고리즘의 시간 복잡도 차수를 2로 출력
            System.out.println(2);
        } catch (IOException e) {
            System.err.println("입력 오류가 발생했습니다: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("잘못된 숫자 형식입니다: " + e.getMessage());
        }
        }
    }

/**
 * 14212 KB / 128 ms
 */

    /*
    조합 공식 사용.
    C(n, 2) = n! / (2! * (n - 2)!) -> C(n, 2) = n(n - 1) / 2
    중복된 쌍을 제거하기 위해 2로 나눔
    위 공식은 알고리즘의 수행 횟수

    예로 5개의 숫자가 있는 배열이 있다고 생각할 때
    배열의 숫자는 [A1, A2, A3, A4, A5] 라고 가정. 여기서 가능한 모든 숫자의 쌍의 곱을 구하는 것
    1. A1의 쌍 : 4
    2. A2의 쌍 : 3
    3. A3의 쌍 : 2
    4. A4의 쌍 : 1
      합하면 10 개의 쌍.
      위 공식을 적용해보면 n(n - 1) / 2
      즉,  5 * 4 / 2 = 10
     */

