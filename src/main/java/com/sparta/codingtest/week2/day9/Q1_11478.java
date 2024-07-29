package com.sparta.codingtest.week2.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Q1_11478 {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위해 BufferedReader를 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열 S를 입력받음
        String str = br.readLine();
        // UniqueSubstringCounter 객체를 생성하여 서로 다른 부분 문자열의 개수를 계산
        UniqueSubstringCounter counter = new UniqueSubstringCounter();
        // 결과를 출력
        System.out.println(counter.countUniqueSubstrings(str));
    }
}

class UniqueSubstringCounter {
    // 주어진 문자열에서 서로 다른 부분 문자열의 개수를 계산하는 메서드
    public int countUniqueSubstrings(String str) {
        Set<String> uniqueSubstrings = new HashSet<>(); // 중복을 피하기 위해 HashSet 을 사용
        int n = str.length(); // 문자열의 길이를 구함

        // 부분 문자열을 생성하여 HashSet에 추가
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                uniqueSubstrings.add(str.substring(i, j)); // HashSet 에 부분 문자열을 추가
            }
        }

        return uniqueSubstrings.size();
    }
}
/*
227012 KB / 728 ms
 */
