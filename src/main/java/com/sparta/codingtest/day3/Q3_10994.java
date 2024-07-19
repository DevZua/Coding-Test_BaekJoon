package com.sparta.codingtest.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3_10994 {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위해 BufferedReader를 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        // N이 1일 때는 별 하나를 출력하고 프로그램을 종료
        if (N == 1) {
            System.out.println("*");
            return;
        }

        // N이 2 이상일 때 별을 출력하는 로직
        int size = 4 * N - 3; // NxNx5 형태의 별을 출력
        char[][] stars = new char[size][size];

        // 배열을 공백 문자로 초기화합니다.
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                stars[i][j] = ' ';
            }
        }

        // 별을 그리는 재귀 함수
        drawStars(stars, N, 0, 0, size);

        // 배열에 저장된 별을 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(stars[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    // 재귀적으로 별을 그리는 함수
    public static void drawStars(char[][] stars, int N, int x, int y, int size) {
        if (N == 0) {
            return;
        }

        // 외곽 별을 그림
        for (int i = 0; i < size; i++) {
            stars[x][y + i] = '*'; // 상단
            stars[x + size - 1][y + i] = '*'; // 하단
            stars[x + i][y] = '*'; // 좌측
            stars[x + i][y + size - 1] = '*'; // 우측
        }

        // 내부의 별을 그리기 위해 재귀 호출함
        drawStars(stars, N - 1, x + 2, y + 2, size - 4);
    }
}
