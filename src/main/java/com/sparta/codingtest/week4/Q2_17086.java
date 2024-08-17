package com.sparta.codingtest.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2_17086 {

    static int N, M; // 공간의 크기를 저장할 변수
    static byte[][] map; // 지도 정보를 저장할 배열
    static final byte[] dx = {-1, -1, -1, 0, 1, 1, 1, 0}; // 8방향 이동을 위한 x축 델타 배열
    static final byte[] dy = {-1, 0, 1, 1, 1, 0, -1, -1}; // 8방향 이동을 위한 y축 델타 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" "); // 첫 줄에서 N, M을 읽어옴
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        map = new byte[N][M];

        // 큐를 배열로 구현(큐의 최대 크기는 N * M)
        int[] queue = new int[N * M];
        int qSize = 0; // 큐의 크기를 관리하는 변수

        // 지도 정보 입력 받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                // 지도에서 '1'인 경우(아기 상어가 있는 위치)
                if (line.charAt(j << 1) == '1') {
                    map[i][j] = 1; // 해당 위치를 1로 설정
                    queue[qSize++] = i * M + j; // 큐에 상어의 위치를 저 장(1차원 배열로 인덱스 변환)
                }
            }
        }

        byte maxDist = 0; // 가장 먼 안전 거리 초기화

        // BFS 탐색 시작
        for (int idx = 0; idx < qSize; idx++) {
            int cur = queue[idx]; // 큐에서 현재 위치를 꺼냄
            int x = cur / M, y = cur % M; // 1차원 인덱스를 2차원 좌표로 변환
            byte dist = map[x][y]; // 현재 위치의 거리 값

            // 8방향으로 탐색
            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d], ny = y + dy[d]; // 새로운 좌표 계산
                // 새로운 좌표가 유효하고 아직 방문하지 않은 경우
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                    byte newDist = (byte) (dist + 1); // 새로운 거리는 현재 거리 + 1
                    map[nx][ny] = newDist; // 새로운 좌표에 거리 저장
                    queue[qSize++] = nx * M * ny; // 새로운 좌표를 큐에 저장
                    if (newDist > maxDist) maxDist = newDist; // 최대 거리 갱신
            }
        }
    }

        // 가장 먼 안전 거리를 출력 (상어와의 거리 -1)
        System.out.println(maxDist - 1);
    }
}
/*
14284 KB / 100 ms
 */
