package com.sparta.codingtest.week2.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q3_31562 {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위해 BufferedReader를 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 결과를 저장할 StringBuilder를 생성
        StringBuilder sb = new StringBuilder();

        // 첫 번째 줄을 읽어 공백으로 구분하여 배열에 저장
        String[] arr = br.readLine().split(" ");
        // 정환이 아는 노래의 개수
        int record = Integer.parseInt(arr[0]);
        // 정환이 맞히기를 시도할 노래의 개수
        int count = Integer.parseInt(arr[1]);

        // 노래 정보를 저장할 HashMap을 생성
        Map<String, String> map = new HashMap<>();

        // 정환이 아는 노래의 개수만큼 반복
        for (int i = 0; i < record; i++) {
            // 노래 제목과 음정을 공백으로 구분하여 배열에 저장
            String[] target = br.readLine().split(" ");
            // 첫 세 음정을 키로 설정합니다.
            String key = target[2] + " " + target[3] + " " + target[4];

            // 첫 세 음정을 키로 하고, 노래 제목을 값으로 저장
            // 만약 동일한 키가 이미 존재하면 값을 "?"로 설정
            map.compute(key, (k, value) -> {
                if (value != null) {
                    return "?";
                } else {
                    return target[1];
                }
            });
        }

        // 정환이 맞히기를 시도할 노래의 개수만큼 반복
        for (int i = 0; i < count; i++) {
            // 음정을 읽어 문자열로 저장합니다.
            String target = br.readLine();

            // 음정을 키로 하여 노래 제목을 찾음
            // 찾지 못하면 "!"를 반환
            sb.append(map.getOrDefault(target, "!")).append('\n');
        }

        // 결과를 출력
        System.out.print(sb);
    }
}
/*
 17668 KB / 216 ms
 */