package com.sparta.codingtest.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3_27160 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 과일 배열과 개수 배열 생성
        String[] fruits = {"STRAWBERRY", "BANANA", "LIME", "PLUM"}; // 과일 종류 저장
        int[] count = {0, 0, 0, 0}; // 각 과일의 개수를 저장하는 배열

        // 첫 번째 줄에서 카드의 개수 N을 입력받고 정수로 변환
        int N = Integer.parseInt(br.readLine());

        // N개의 줄에 걸쳐 각 카드의 정보를 입력받기 위한 반복문
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            // 과일 종류와 개수를 각각 변수에 저장하는 로직
            // 첫 번째 토큰을 과일 종류로 저장
            String fruit = st.nextToken();
            // 두 번째 토큰을 정수로 변환하여 과일의 개수로 저장
            int amount = Integer.parseInt(st.nextToken());

            // 입력받은 과일 종류에 해당되는 인덱스를 찾아 개수를 더해줌
            for (int j = 0; j < fruits.length; j++) {
                if (fruits[j].equals(fruit)) {
                    count[j] += amount;
                }
            }
        }

        // 과일 개수가 정확히 5개인 경우가 있는지 확인
        String answer = "NO";
        // 과일 개수 배열을 순회하는 반복문
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 5) {
                answer = "YES";
                break; // 5개인 과일이 있으면 더 이상 확인하지 않고 종료
            }
        }

        // 최종 결과를 출력
        System.out.println(answer);
    }
}
