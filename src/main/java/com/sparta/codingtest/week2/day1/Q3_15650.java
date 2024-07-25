package com.sparta.codingtest.week2.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3_15650 {
    static int N, M;
    static int[] combination; // 선택한 숫자를 저장할 배열
    static StringBuilder sb = new StringBuilder(); // 결과 출력을 위한 StringBuilder

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 첫 번째 숫자 : N
        M = Integer.parseInt(st.nextToken()); // 두 번째 숫자 : M

        combination = new int[M]; // 선택된 숫자를 저장할 배열을 생성

        // 백트래킹을 이용하여 모든 조합을 찾는 재귀함수 호출
        findCombinations(1, 0);

        System.out.println(sb.toString());
    }

    /**
     * 모든 가능한 조합을 찾는 재귀 메서드
     * @param start : 선택 가능한 시작 숫자
     * @param depth : 현재 선택된 숫자의 개수
     */
    private static void findCombinations(int start, int depth) {
        if (depth == M) { // 현재 조합이 M개의 숫자를 모두 포함하면 출력함
            for (int i = 0; i < M; i++) {
                sb.append(combination[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        // start 부터 N 까지의 숫자를 순회하여 조합을 생성
        for (int i = start; i <= N; i++) {
            combination[depth] = i; // 현재 깊이 위치에 숫자를 저장
            findCombinations(i + 1, depth + 1); // 다음 깊이로 재귀 호출
        }
    }
}
/*
14164 kB / 132 ms
 */