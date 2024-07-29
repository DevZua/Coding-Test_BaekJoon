package com.sparta.codingtest.week2.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1_15649 {
    // 전역 변수 선언
    static int N; // 선택 가능한 최대 숫자
    static int M; // 선텍할 숫자의 개수
    static int[] combination; // 현재까지 선택된 숫자를 저장하는 배열
    static boolean[] used; // 숫자 사용 여부를 추적하는 배열
    static StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder 객체

    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferReader 와 StringTokenizer 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N 과 M 초기화
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 배열 초기화
        combination = new int[M];
        used = new boolean[N + 1]; // 1부터 N 까지의 숫자를 사용하기 위해 크기를 N+1로 설정

        // 조합을 찾는 메서드 호출
        generateCombinations(0);

        // 결과 출력
        System.out.println(sb);
    }

    /*
    depth : 현재 선택된 숫자의 개수
     */
    private static void generateCombinations(int depth) {
        // 종료 조건 : depth 가 M에 도달하면 현재 조합을 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(combination[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i <= N; i++) {
            if (!used[i]) {  // 사용되지 않은 숫자를 조합에 추가
                used[i] = true; // 현재 숫자를 사용된 것으로 표시
                combination[depth] = i + 1; // 현재 깊이에 숫자 저장
                generateCombinations(depth + 1); // 다음 깊이로 재귀 호출
                used[i] = false; // 재귀 호출이 끝나면 숫자를 다시 사용가능하도록 설정
            }
        }
    }
}
/*
22040 KB / 256 ms
 */
