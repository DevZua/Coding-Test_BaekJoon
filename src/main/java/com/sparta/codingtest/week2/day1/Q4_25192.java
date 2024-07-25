package com.sparta.codingtest.week2.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Q4_25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 첫 번째 줄에서 N을 입력받기
        int count = 0; // 곰곰티콘이 사용된 횟수
        HashSet<String> set = new HashSet<>(); // 중복되지 않은 유저를 저장할 HashSet

        for (int i = 0; i < N; i++) {
            String name = br.readLine(); // 각 줄에서 입력을 받음

            if (name.equals("ENTER")) {
                set.clear(); // 새로운 입장이 발생했음을 표시하고 HashSet 을 초기화
            } else {
                if (!set.contains(name)) { // 유저가 처음 등장하는 경우
                    set.add(name); // HashSet에 유저를 추가
                    count++; // 곰곰티콘 사용 횟수를 증가시킴
                }
            }
        }

        System.out.println(count); // 곰곰티콘 사용 횟수를 출력
    }
}
/*
26536 KB / 276 ms
 */
