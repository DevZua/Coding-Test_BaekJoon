package com.sparta.codingtest.week2.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Q4_15829 {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위해 BufferedReader 를 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 해시 값을 저장할 Map 을 생성
        Map<Integer, BigInteger> map = new HashMap<>();
        // 문자열의 길이를 입력 받기
        int number = Integer.parseInt(br.readLine());
        // 모듈로 연산에 사용할 값을 설정
        int mod = 1_234_567_891;

        /*
         * 1. 50까지 연산을 수행해준다.
         * 2. 숫자가 크기 때문에 BigInteger 를 사용
         * 3. 큰 숫자일 경우 모듈로 연산을 수행한다.
         * 4. Map 에 값을 저장하여 재사용한다.
         */

        for (int i = 1; i < 50; i++) {
            BigInteger value = BigInteger.ONE;
            if (map.containsKey(i - 1)) {
                // 이전 값이 존재하면 31을 곱한 후 모듈로 연산을 수행
                value = map.get(i - 1).multiply(BigInteger.valueOf(31)).mod(BigInteger.valueOf(mod));
            } else {
                // 처음 계산할 때는 31의 거듭제곱 값을 계산
                for (int j = 0; j < i; j++) {
                    value = value.multiply(BigInteger.valueOf(31)).mod(BigInteger.valueOf(mod));
                }
            }
            // 계산된 값을 Map 에 저장
            map.put(i, value);
        }

        // 해시 값을 저장할 변수를 초기화
        BigInteger sum = BigInteger.ZERO;
        // 문자열을 입력받습니다.
        String str = br.readLine();

        // 문자열의 각 문자를 처리
        for (int i = 0; i < number; i++) {
            // 문자를 숫자로 변환 (a는 1, b는 2, ..., z는 26)
            int num = (int) str.charAt(i) - 96;
            if (i > 0) {
                // i가 0보다 크면 31의 i 제곱을 곱한 값을 더함
                sum = sum.add(BigInteger.valueOf(num).multiply(map.get(i))).mod(BigInteger.valueOf(mod));
            } else {
                // 첫 번째 문자는 그대로 더함
                sum = sum.add(BigInteger.valueOf(num));
            }
        }

        // 최종 해시 값을 출력
        System.out.println(sum);
    }
}
/*
 14532 KB / 132 ms
 */
