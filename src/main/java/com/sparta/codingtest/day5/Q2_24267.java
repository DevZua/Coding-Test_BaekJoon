package com.sparta.codingtest.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2_24267 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 사용자로부터 입력을 받아 정수 n으로 변환
            int n = Integer.parseInt(br.readLine().trim());

            // 코드1의 수행 횟수 계산
            // 삼중 루프를 통해 가능한 모든 세 원소의 조합의 수는
            // (n * ( n - 1) * ( n - 2 )) / 6 으로 계산된다.
            // (long)을 사용해서 정수 오버플로우 방지
            long code1Count = (long) n * (n - 1) * (n - 2) / 6;

            // 계산된 수행 횟수를 출력
            System.out.println(code1Count);

            // 알고리즘 시간 복잡도 차수를 출력.
            // 삼중 루프이므로 차수는 3
            System.out.println(3);
        } catch (IOException e) {
            // 입력을 받는 도중에 발생할 수 있는 예외 처리
            System.err.println("입력 오류가 발생했습니다: " + e.getMessage());
        } catch (NumberFormatException e) {
            // 입력받은 값을 정수로 변환하는 도중에 발생할 수 있는 형식 오류를 처리
            System.err.println("잘못된 숫자 형식입니다: " + e.getMessage());
        }
    }
}

/*
14352 KB / 120 ms
 */

