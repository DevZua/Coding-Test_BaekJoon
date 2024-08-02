package com.sparta.codingtest.week3.dayx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q2_9934 {

    // 노드 번호를 저장하는 배열
    static int[] input;
    // 각 레벨의 노드를 저장하는 리스트 배열
    static List<Integer>[] arr;

    // 중위 순회 방식으로 트리를 구성하는 재귀 함수
    static void insertTree(int depth, int start, int end) {
        // 현재 범위의 시작과 끝이 같거나 시작이 끝을 넘으면 종료
        if (start >= end) {
            return;
        }

        // 현재 범위의 중간 인덱스를 계산
        int mid = (start + end) / 2;

        // 현재 깊이의 리스트에 중간 값을 추가
        arr[depth].add(input[mid]);

        // 왼쪽 자식 노드와 오른쪽 자식 노드를 재귀적으로 처리
        insertTree(depth + 1, start, mid);
        insertTree(depth + 1, mid + 1, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력을 공백으로 구분하기 위한 StringTokenizer
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 트리의 깊이 K를 읽어오기
        int k = Integer.parseInt(st.nextToken());

        // 완전 이진 트리의 노드 수는 (2^k - 1)개
        input = new int[(1 << k) - 1];
        // 각 레벨에 대한 노드를 저장할 리스트 배열 초기화
        arr = new ArrayList[k];
        for (int i = 0; i < k; i++) {
            arr[i] = new ArrayList<>();
        }

        // 노드 번호를 읽어서 input 배열에 저장
        st = new StringTokenizer(br.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            input[idx++] = Integer.parseInt(st.nextToken());
        }

        // 트리를 구성하기 위해 insertTree 함수 호출
        insertTree(0, 0, idx);

        // 각 레벨별로 노드 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            // 현재 레벨의 모든 노드를 출력
            for (int num : arr[i]) {
                sb.append(num).append(' ');
            }
            // 각 레벨의 노드 출력 후 줄바꿈
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
/*
14320 KB / 140 ms
 */