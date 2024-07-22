package com.sparta.codingtest.day5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


// 숫자 카드 저장을 위한 인터페이스 정의
interface CardStorage {
    void add(int number); // 숫자를 추가하는 메소드

    boolean contains(int number); // 숫자가 존재하는지 확인하는 메소드
}

// HashSet 을 사용하는 구현 클래스
class HashSetCardStorage implements CardStorage {
    private Set<Integer> cardSet = new HashSet<>(); // 숫자 카드를 저장하기 위한 HashSet

    @Override
    public void add(int number) {
        cardSet.add(number); // HasSet 에 숫자를 추가
    }

    @Override
    public boolean contains(int number) {
        return cardSet.contains(number); // HasSet 에 숫자가 존재하는지 확인
    }
}

public class Q3_10815 {
    private CardStorage cardStorage;

    public Q3_10815(CardStorage cardStorage) {
        this.cardStorage = cardStorage;
    }

    // 입력을 처리하고 결과를 출력하는 메소드
    public void processInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 상근이가 가진 숫자 카드의 개수 N 입력 받기
        int n = Integer.parseInt(br.readLine().trim());
        // 두 번째 줄에서 숫자 카드를 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            cardStorage.add(Integer.parseInt(st.nextToken())); // 각 숫자를 HashSet 에 추가
        }

        // 세 번째 줄에서 확인할 숫자의 개수 M 입력 받기
        int m = Integer.parseInt(br.readLine().trim());
        StringBuilder result = new StringBuilder();
        // 네 번째 줄에서 확인할 숫자들 입력 받기
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
             result.append(cardStorage.contains(num) ? "1 " : "0")
        }

        System.out.println(result.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        Q3_10815 q3_10815 = new Q3_10815(new HashSetCardStorage());
        q3_10815.processInput(); // 입력을 처리하고 결과를 출력
    }
    /*
    136132 KB / 940 ms
     */
}

