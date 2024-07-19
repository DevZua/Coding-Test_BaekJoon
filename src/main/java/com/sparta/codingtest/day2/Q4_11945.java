package com.sparta.codingtest.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4_11945 {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄에서 N과 M을 읽음
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        // 입력받은 N개의 줄을 저장할 2차원 배열
        String[] inputLines = new String[N];

        // 입력받은 각 줄을 배열에 저장
        for (int i = 0; i < N; i++) {
            inputLines[i] = br.readLine();
        }

        // 결과를 저장할 StringBuilder
        StringBuilder sb = new StringBuilder();

        // 각 줄을 역순으로 뒤집어서 결과에 추가
        for (int i = 0; i < N; i++) {
            for (int j = M - 1; j >= 0; j--) {
                sb.append(inputLines[i].charAt(j));
            }
            sb.append('\n');
        }

        // 결과 출력
        System.out.print(sb.toString());
    }
}
