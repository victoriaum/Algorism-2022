package programmers.commuLearing;

import java.util.*;

// Greedy
public class BaseStationInstallation {
    public static void main(String[] args){
        /*
            1번째 제출풀이(mySolution_1):
                정확성: 75.0/75.0
                효율성: 0.0/29.5
                중복 for문과 if문이 많아서 효율성이 좋지 않은 코드였다. 메모리초과 또는 시간초과가 발생했다. 주석다는 습관을 기를 것.

            정답풀이(teacherSolution_1):
                시간초과 발생.

            정답풀이(teacherSolution_2):
                object 타입보다 primitive 타입을 사용하는 것이 좋다.
                *** Loop 개선하고, 적절한 데이터 구조를 사용하기, 불필요한 object 제거
        */

        System.out.println( firstSolution(11, new int[]{4,11}, 1) );
        System.out.println( teacherSolution_1(11, new int[]{4,11}, 1) );
        System.out.println( teacherSolution_2(11, new int[]{4,11}, 1) );
    }

    private static int teacherSolution_2(int n, int[] stations, int w) {
        int answer = 0;
        int si = 0; // 인덱스 사용
        int position = 1;
        while(position <= n){
            if(si < stations.length && stations[si] - w <= position){   // 인덱스가 stations 수보다 작고, stations 인덱스 값에서 범위 w를 뺀 값이 현재 position 보다 작거나 같으면
                position = stations[si] + w + 1;
                si += 1;
            }else{
                answer += 1;
                position += w * 2 + 1;
            }
        }
        return answer;
    }

    private static int teacherSolution_1(int n, int[] stations, int w) {
        int answer = 0;

        Queue<Integer> sq = new LinkedList<>();
        for(int s : stations) sq.offer(s);

        int position = 1;
        while(position <= n){
            if(!sq.isEmpty() && sq.peek() - w <= position){
                position = sq.poll() + w + 1;
            }else{
                answer += 1;
                position += w * 2 + 1;
            }
        }

        return answer;
    }


    private static int firstSolution(int n, int[] stations, int w) {
        int answer = 0;

        List<Integer> list = new ArrayList(Arrays.asList(new int[0]));
        list.remove(0);
        for(int i=1; i<n+1; i++){
            list.add(i);
        }

        for(int i=0; i<stations.length; i++){
            for(int j=0; j<list.size(); j++){
                if(list.get(j)!=0 && j+1 > stations[i]-w-1 && j+1 < stations[i]+w+1){
                    list.set(j, 0);
                }
            }
        }

        list.add(0);

        int cnt = 0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i)!=0){
                cnt++;
            }else{
                if(cnt!=0){
                    if(cnt%(w*2+1)==0){
                        answer += cnt/(w*2+1);
                    }else{
                        answer += cnt/(w*2+1)+1;
                    }
                    cnt=0;
                }
            }
        }
        return answer;
    }
}
