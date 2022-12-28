package programmers.kit.Greedy;

import java.util.*;

// 그리디 - 조이스틱
public class JoyStick {
    public static void main(String[] args) {
        // 조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
        // ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
        // 조이스틱은 아래 위로 움직일 수 있고 더 가까운 값을 선택해야 한다.
        // 만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.
        // 아스키코드표 65 ~ 90

        System.out.println(solution("JEROEN"));     // 56
        System.out.println(solution("JAN"));        // 23
    }

    private static int solution(String name) {
        int answer = 0;
        char[] array = name.toCharArray();

        for(char c : array){
            int value = (int)c-65;
            int value2 = 90-(int)c;
            if(value>value2) answer += value2+1;
            else answer += value+1;
        }

        return answer-1;
    }
}