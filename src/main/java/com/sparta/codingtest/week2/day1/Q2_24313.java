package com.sparta.codingtest.week2.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2_24313 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 a1과 a0을 입력받음
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());

        // 두 번째 줄에서 c를 입력받음
        int c = Integer.parseInt(br.readLine().trim());

        // 세 번째 줄에서 n0을 입력받음
        int n0 = Integer.parseInt(br.readLine().trim());

        // 주어진 n0에서의 f(n0) 값을 계산
        int fn = a1 * n0 * a0;

        // 조건을 확인하여 결과를 출력
        if (fn <= c * n0 && c >= a1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

}

/*
[문제 이해하기]
1. 함수 f(n) = a1 * n + a0 이 있고, 이 함수가 O(n)의 정의를 만족하는지 확인
2. O(n)란? 함수가 n에 비례해서 커지는지 확인

[주어진 조건]
1. f(n) = a1 x n + a0 함수가 있을 때 a1과 a0는 주어진 숫자
2. c와 n0이라는 숫자가 주어짐.
3. n이 n0보다 크거나 같을 때, 아래 조건이 항상 성립하는지 확인해야 함
   a1 * n + a0 <= c * n
   따라서 n은 n0보다 크거나 같아야 함.

[접근 방법]
1. f(n0) 값을 계산. f(n0) = a1 * n0 * a0
2. c * n0 값 계산
3. f(n0) <= c * n0 인지 확인
4. c >= a1 인지 확인
5. 두 조건을 모두 만족하면 1, 아니면 0 출력
 */

/*
14244 KB / 128 ms
 */