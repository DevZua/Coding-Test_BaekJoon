package com.sparta.codingtest.week2.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3_1769 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine(); // 입력된 숫자 문자열

        int count = reduceToSingleDigit(X);
    }

    // 숫자를 한 자리로 줄이고 변환 횟수를 반환하는 메서드
    private static int reduceToSingleDigit(String number) {
        int count = 0; // 변환 횟수를 추적
        while (number.length() > 1) {
            int sum = 0;
            for (char digit : number.toCharArray()) {
                sum += digit - '0'; // 아스키코드를 사용하여 문자에서 숫자를 구함
            }
            number = String.valueOf(sum);
            count++;
        }
        int result = Integer.parseInt(number); // 최종 한 자리 숫자를 구함

        System.out.println(count); // 변환 횟수 출력
        if (isMultipleOfThree(result)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        return count;
    }

    // 숫자가 3의 배수인지 확인하는 메서드
    private static boolean isMultipleOfThree(int number) {
        return number % 3 == 0;
    }
}
/*
  21960 KB / 260 ms
 */