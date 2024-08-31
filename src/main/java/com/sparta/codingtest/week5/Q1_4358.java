package com.sparta.codingtest.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1_4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // HashMap을 사용하여 나무 이름(String)과 그 빈도수(Integer)를 저장
        Map<String, Integer> map = new HashMap<>();
        String s;
        int total = 0; // 입력된 나무의 총 개수를 세기 위한 변수

        // 입력된 각 줄을 읽어서 처리
        while ((s = br.readLine()) != null && !s.isEmpty()) {
            total++; // 입력된 줄(나무 이름)의 개수를 증가
            // 나무 이름이 이미 맵에 존재하면 값을 1 증가시키고, 그렇지 않으면 1로 초기화
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        // Map의 엔트리(키-값 쌍)를 리스트로 변환
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(map.entrySet());
        // 엔트리를 키(나무 이름)의 알파벳 순서로 정렬
        sortedEntries.sort(Map.Entry.comparingByKey());

        // 결과를 저장하기 위해 StringBuilder를 사용. 이를 통해 문자열 결합의 성능을 최적화
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            // 각 나무 이름과 해당 빈도를 백분율로 계산하여 포맷팅된 문자열로 추가
            sb.append(entry.getKey()) // 나무 이름 추가
                    .append(' ') // 공백 추가
                    .append(String.format("%.4f", entry.getValue() * 100.0 / total)) // 백분율 계산 후 소수점 4자리로 포맷팅
                    .append('\n'); // 줄 바꿈 추가
        }

        // StringBuilder에 담긴 최종 결과를 출력
        System.out.print(sb);
    }
}
/*
85220 KB / 548 ms
 */

