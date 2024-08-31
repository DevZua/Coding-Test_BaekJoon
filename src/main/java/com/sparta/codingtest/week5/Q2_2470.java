package com.sparta.codingtest.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2_2470 {
    // 투 포인터
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 전체 용액의 수 N을 읽어들임
        int N = Integer.parseInt(br.readLine());

        // 두 번째 줄에서 용액의 특성값들을 읽어 배열에 저장
        int[] solutions = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        // 배열을 오름차순으로 정렬
        Arrays.sort(solutions);

        // 두 포인터를 사용하기 위해 초기화
        int left = 0, right = N - 1;
        // 최종적으로 0에 가장 가까운 합을 만드는 두 용액의 인덱스를 저장할 변수
        int answerLeft = 0, answerRight = 0;
        // 현재까지의 가장 가까운 합을 저장할 변수
        int closestSum = Integer.MAX_VALUE;

        // 두 포인터가 서로 교차하기 전까지 반복
        while (left < right) {
            // 두 포인터가 가리키는 용액의 특성값 합 계산
            int sum = solutions[left] + solutions[right];

            // 계산된 합이 현재까지 찾은 가장 가까운 합보다 0에 더 가깝다면 갱신
            if (Math.abs(sum) < Math.abs(closestSum)) {
                closestSum = sum;
                answerLeft = solutions[left];
                answerRight = solutions[right];
            }

            // 합이 0보다 작으면 왼쪽 포인터를 오른쪽으로 이동
            if (sum < 0) {
                left++;
            }
            // 합이 0보다 크면 오른쪽 포인터를 왼쪽으로 이동
            else if (sum > 0) {
                right--;
            }
            // 합이 정확히 0이면 더 이상 탐색이 필요 없으므로 종료
            else {
                break;
            }
        }

        // 찾은 두 용액의 특성값을 출력 (오름차순으로 이미 정렬된 상태)
        System.out.println(answerLeft + " " + answerRight);
    }

}
/*
28396 KB / 340 ms
 */