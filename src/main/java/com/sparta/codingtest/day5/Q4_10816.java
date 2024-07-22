package com.sparta.codingtest.day5;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q4_10816 {
    public static void main(String[] args) throws IOException {
        // 큰 버퍼 크기 설정(16KB) -> 입출력 효율성 높임
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 16 * 1024);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out), 16 * 1024);

        // 첫 번째 줄 : 상근이가 가진 숫자 카드의 개수 N
        int n = Integer.parseInt(br.readLine().trim());

        // 두 번째 줄 : 상근이가 가진 숫자 카드들
        HashMap<Integer, Integer> cardMap = new HashMap<>(n);  // 초기 용량을 n으로 설정
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            cardMap.put(num, cardMap.getOrDefault(num, 0) + 1);
        }

        // 세 번째 줄 : 확인할 숫자의 개수 N
        int m = Integer.parseInt(br.readLine().trim());

        // 네 번째 줄 : 확인할 숫자들
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            bw.write(cardMap.getOrDefault(num, 0) + " ");
        }

        bw.flush();
    }

    /*
     173464 KB / 988 ms
     */
}
