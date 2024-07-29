package com.sparta.codingtest.week2.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 9명의 난쟁이 키를 저장할 배열 선언
        int[] heights = new int[9];
        // 총 난쟁이이 키의 합계를 저장할 변수
        int totalHeight = 0;

        // 아홉 난쟁이의 키를 입력받아 배열에 저장하고, 총합을 계산
        for (int i = 0; i < heights.length; i++) {
            // 한 줄씩 입력받아 난쟁이의 키를 정수로 변환하여 배열에 저장
            heights[i] = Integer.parseInt(br.readLine());
            // 난쟁이의 키를 총합에 더함
            totalHeight += heights[i];
        }

            // 난쟁이의 키를 오름차순으로 정렬
            Arrays.sort(heights);

            // 전체 난쟁이 키의 합에서 100을 빼서 제외해야 할 두 난쟁이의 키의 합을 계산
            int targetSum = totalHeight - 100;

            // 제외할 두 난쟁이의 키를 저장할 변수와 찾았는지 여부를 나타내는 플래그를 선언
            int firstExcluded = -1;
            int secondExcluded = -1;
            boolean found = false; // 난쟁이를 찾았는지 여부를 나타내는 플래그

        // 두 난쟁이를 찾기 위한 이중 반복문
        for (int i = 0; i < heights.length - 1 && !found; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                // 두 난쟁이의 키의 합이 targetSum 과 같으면 해당 난쟁이들을 제외할 대상으로 설정
                if (heights[i] + heights[j] == targetSum) {
                    // 제외할 난쟁이의 키를 변수에 저장
                    firstExcluded = heights[i];
                    secondExcluded = heights[j];
                    // 난쟁이를 찾았으므로 플래그를 true 로 설정
                    found = true;
                    // 조건을 만족하는 난쟁이들을 찾았으므로 내부 루프를 종료
                    break;
                }
            }
        }

        // 일곱 난쟁이의 키를 출력하기 위한 StringBuilder 를 생성
        StringBuilder sb = new StringBuilder();
        // 배열을 순회하며 제외할 난쟁이의 키를 제 외한 나머지 난쟁이의 키를 추가
        for (int height : heights) {
            // 현재 난쟁이의 키가 제외할 난쟁이의 키와 같지 않은 경우에만 추가
            if (height != firstExcluded && height != secondExcluded) {
                // 제외할 난쟁이의 키가 아닌 경우 StringBuilder 에 추가
                sb.append(height).append('\n');
            }
        }

        // StringBuilder 에 저장된 결과를 출력
        System.out.println(sb);
    }
}
/*
14176 KB / 120 ms
 */
