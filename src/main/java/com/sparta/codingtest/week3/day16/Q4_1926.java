package com.sparta.codingtest.week3.day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * DFS 사용
 * 연결된 모든 노드(색칠된 칸)를 효율적으로 방문할 수 있기 때문에 하나의 그림에 대한 넓이를 계산하기에 적합.
 */
public class Q4_1926 {
    // n, m: 그림의 세로와 가로 크기
    static int n, m;
    // canvas: 그림의 데이터를 저장하는 2차원배열
    // 0: 방문 했거나 색칠되지 않은 칸, 1: 색칠된 칸
    static int[][] canvas;
    // 이동 방향을 나타내는 배열.
    // 순서대로 상, 하, 좌, 우
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
         n = Integer.parseInt(st.nextToken()); // 세로 크기 입력
         m = Integer.parseInt(st.nextToken()); // 가로 크기 입력

        // canvas 초기화
        canvas = new int[n][m];

        //  그림 정보 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < m; j++) {
                canvas[i][j] = Integer.parseInt(st.nextToken()); // 각 칸의 색칠 정보 입력
            }
        }

        int numberOfPictures = 0; // 그림의 개수
        int maxArea = 0; // 가장 큰 그림의 넓이

        // 모든 칸을 순회하면서 그림의 넓이 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (canvas[i][j] == 1) { // 색칠된 칸을 발견한 경우
                    int area = dfs(i, j); // DFS 를 시작하여 그림의 넓이 계산
                    numberOfPictures++; // 그림의 개수 증가
                    maxArea = Math.max(maxArea, area); // 최대 그림의 넓이 갱신
                }
            }
        }
        System.out.println(numberOfPictures + "\n" + maxArea);
    }

    // DFS 를 사용하여 그림의 넓이를 계산하는 함수
    static int dfs(int x, int y) {
        canvas[x][y] = 0; // 현재 칸을 방문 처리
        int area = 1; // 현재 칸을 포함하여 넓이를 1로 시작

        // 네 방향에 대해 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i]; // 새로운 x 위치
            int ny = y + dy[i]; // 새로운 y 위치

             // 유효한 위치이며 색칠된 칸이 방문되지 않았다면
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && canvas[nx][ny] == 1) {
                area += dfs(nx, ny); // 재귀적으로 DFS 를 수행하며 넓이 계산
            }
        }
        return area; // 계산된 넓이 반환
    }
}
/*
53460 KB / 344 ms
 */