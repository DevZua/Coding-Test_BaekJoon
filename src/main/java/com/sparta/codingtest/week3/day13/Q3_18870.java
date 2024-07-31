package com.sparta.codingtest.week3.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q3_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫 번째 줄에서 N을 읽음
        int N = Integer.parseInt(br.readLine().trim());
        // 두 번째 줄에서 좌표 리스트를 읽음
        st = new StringTokenizer(br.readLine().trim());
        int[] X = new int[N];

        // 입력된 좌표를 배열 X에 저장
        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
        }

        // 좌표 압축을 위해 X 배열을 복제하여 정렬
        int[] sortedX = X.clone();
        Arrays.sort(sortedX);

        // 좌표 압축을 위한 HashMap 을 초기화
        int[] compressed = new int[N];
        Map<Integer, Integer> dic = new HashMap<>();
        int index = 0;

        // 정렬된 배열을 순회하며 좌표 압축을 위한 인덱스를 생성
        for (int x : sortedX) {
            // 중복된 값은 무시하고 새로운 값에 대해 인덱스를 부여
            if (!dic.containsKey(x)) {
                dic.put(x, index++);
            }
        }

        StringBuilder sb = new StringBuilder();
        // 원본 배열 X를 순회하며 압축된 인덱스를 결과에 추가
        for (int x : X) {
            sb.append(dic.get(x)).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
/*
276752 KB / 1856 ms
 */