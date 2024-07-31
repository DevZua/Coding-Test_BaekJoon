package com.sparta.codingtest.week3.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 : 배열의 크기 n을 읽어옴
        int n = Integer.parseInt(br.readLine());

        // 두 번째 줄 : 배열 a의 원소들을 읽어옴
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        // 세 번째 줄 : 배열 b의 원소들을 읽어옴
        int[] b = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 a를 오름차순으로 정렬
        Arrays.sort(a);

        // 최솟값 s를 저장할 변수 초기화
        int s = 0;

        // 배열 b에서 최대값을 추적하기 위해 사용된 여부를 저장하는 배열
        boolean[] bUsed = new boolean[n];

        // 배열 b의 각 원소와 배열 b의 최대값을 곱하여 S에 더함
        for (int i = 0; i < n; i++) {
            int maxIndex = -1; // 최댓값의 인덱스를 저장할 변수
            int maxValue = Integer.MIN_VALUE; // 최댓값을 저장할 변수

            // 배열 b에서 아직 사용되지 않은 최대값 찾기
            for (int j = 0; j < n; j++) {
                if (!bUsed[j] && b[j] > maxValue) {
                    maxValue = b[j];
                    maxIndex = j;
                }
            }

            // 찾은 최댓값을 사용한 것으로 표시
            bUsed[maxIndex] = true;

            // 배열 a의 현재 값과 배열 b의 최대값을 곱하여 s에 더함
            s += a[i] * maxValue;
        }

        System.out.println(s);
    }
}
/*
14256 KB / 128 ms
 */