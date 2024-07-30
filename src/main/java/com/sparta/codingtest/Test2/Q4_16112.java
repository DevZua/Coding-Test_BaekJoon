package com.sparta.codingtest.Test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q4_16112 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N은 퀘스트의 수, K는 동시에 활성화 할 수 있는 최대 아케인스톤 수
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

       // 두 번째 줄에서 퀘스트의 경ㅎ머치 값을 읽어 배열에 저장
        int[] list = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        // 경험치 값 배열을 오름차순으로 정렬
        Arrays.sort(list);

        // 최대 경험치의 합을 계산하기 위한 dp 배열을 초기화
        // dp 배열은 필요 없음.
        // 최대 경험치의 합을 저장하기 위한 변수 answer 를 사용
        long answer = 0;

        // 배열을 순회하면서 최대 경험치의 합을 계산
        for (int i = 1; i < N; i++) {
            // 현재 인덱스 i에서 활성화된 아케인스톤의 수를 계산
            // i - K 는 현재 인덱스 i에서 활성화된 아케인스톤의 범위 시작 인덱스를 나타냄
            // 이 범위는 현재 인덱스 i에서 K개의 아케인스톤까지
            // (i - K) < 0 일 경우, 유효 범위 시작 인덱스는 0으로 설정
            int validRange = i - (i - K < 0 ? 0 : (i - K));

            // 현재 경험치(list[i])값이 validRange 개수의 아케인스톤의 추가됨
            // 총 경험치 합에 validRange * list[i]를 더함
            answer += validRange * (long) list[i];
        }
        System.out.println(answer);
    }
}
/*
54820 KB / 756 ms
 */