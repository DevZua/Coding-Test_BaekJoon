package com.sparta.codingtest.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1_20057 {
    // 격자의 크기, 현자 좌표 (curX, curY),
    // 현재 방향 (curDir), 격자 밖으로 나간 모래의 양(answer)
    static int N, curX, curY, curDir = 0, answer = 0;
    static int[][] map;

    // 방향 좌, 하, 우, 상(서, 남, 동, 북) 순서
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    // 모래 퍼짐 비율과 위치 설정 (서, 남, 동, 북 순서)
    // dsx 와 dsy 는 각 방향에서 모래가 퍼지는 좌표를 나타냄
    static int[][][] dsx = {
        {{-1, 1, -2, -1, 1, 2, -1, 1, 0}},  // 서쪽
        {{-1, -1, 0, 0, 0, 0, 1, 1, 2}},    // 남쪽
        {{1, -1, 2, 1, -1, -2, 1, -1, 0}},  // 동쪽
        {{1, 1, 0, 0, 0, 0, -1, -1, -2}}    // 북쪽
    };
    static int[][][] dsy = {
        {{1, 1, 0, 0, 0, 0, -1, -1, -2}},    // 서쪽
        {{-1, 1, -2, -1, 1, 2, -1, 1, 0}},   // 남쪽
        {{-1, -1, 0, 0, 0, 0, 1, 1, 2}},     // 동쪽
        {{1, -1, 2, 1, -1, -2, 1, -1, 0}}    // 북쪽
    };

    static int[] sandRatio = {1, 1, 2, 7, 7, 2, 10, 10, 5}; // 각 위치에서 퍼지는 모래 비율(퍼센트)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 격자의 크기 N
        map = new int[N][N]; // N*N 크기의 격자 크기 초기화

        // 격자 정보 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작 좌표는 격자의 중앙
        curX = N / 2;
        curY = N / 2;

        // 나선형으로 토네이도가 이동하며 모래를 퍼트리는 과정
        for (int i = 0; i < N; i++) {
            // 길이 i 만큼 두 번씩 반복 (한 번은 서 -> 남, 그 다음은 동 -> 북)
            for (int j = 0; j < 2; j++) {
                spread(curDir, i); // 현재 방향으로 i만큼 이동하여 모래 퍼트리기
                curDir = (curDir + 1) % 4; // 방향 전환 (서 -> 남 -> 동 -> 북)
            }
        }

        // 마지막으로 좌 방향(서쪽)으로 N-1 만큼 이동
        spread(0, N - 1);

        // 격자 밖으로 나간 모래의 양
        System.out.println(answer);
    }

    // 같은 방향으로 이동(방향, 길이)
    public static void move(int dir, int length) {
        for (int i = 0; i < length; i++) {
            // 다음 좌표로 이동
            curX += dx[dir];
            curY += dy[dir];

            int total = map[curX][curY]; // 현재 위치의 모래 양
            if (total > 0) { // 현재 좌표에 모래가 있다면 모래를 퍼트림
                spread(total, dir);
            }
            map[curX][curY] = 0; // 모래를 모두 흩뿌린 후, 현재 위치의 모래는 0
        }
    }



    // 모래 흩뿌리기(모래양, 현재 방향)
    private static void spread(int total, int dir) {
        int alpha = total; // 알파 영역에 남을 모래 양
        for (int d = 0; d < 9; d++) {
            int nx = curX + dsx[dir][0][d]; // 퍼지는 모래의 x 좌표
            int ny = curY + dsy[dir][0][d]; // 퍼지는 모래의 y 좌표
            int spreadAmount = (total * sandRatio[d]) / 100; // 퍼질 모래의 양(비율에 따른 계산)
            alpha -= spreadAmount; // 퍼진 모래를 뺀 나머지 모래의 양 계산

            if (isOutOfBounds(nx, ny)) { // 격자 밖으로 나가는 경우
                answer += spreadAmount; // 격자 밖으로 나간 모래의 양 추가
            } else {
                map[nx][ny] += spreadAmount; // 격자 안에 퍼진 모래 추가
            }
        }

        // 알파 영역 모래 처리 (나머지 모래가 퍼질 위치)
        int alphaX = curX + dx[dir];
        int alphaY = curY + dy[dir];
        if (isOutOfBounds(alphaX, alphaY)) {
            answer += alpha; // 격자 밖으로 나가면 모래 양 추가
        } else {
            map[alphaX][alphaY] += alpha; // 격자 안에 퍼진 경우 추가
        }
    }

    // 격자 밖으로 나가는지 체크하는 함수
    private static boolean isOutOfBounds(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }
}
/*
34520 KB / 424 ms
 */