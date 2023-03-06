package programmers.lv3;

import java.util.*;
public class _42628 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        Set<Integer> remove = new HashSet<>();

        PriorityQueue<Integer> pqASC = new PriorityQueue<>();
        PriorityQueue<Integer> pqDESC = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < operations.length; i++){
            StringTokenizer st = new StringTokenizer(operations[i], " ");
            char command = st.nextToken().charAt(0);
            int value = Integer.parseInt(st.nextToken());

            switch(command){
                case 'I':
                    pqASC.offer(value);
                    pqDESC.offer(value);
                    break;
                case 'D':
                    if(value == 1 && !pqDESC.isEmpty()){
                        while(!pqDESC.isEmpty()){
                            if(!remove.contains(pqDESC.peek())){
                                remove.add(pqDESC.poll());
                                break;
                            }
                            pqDESC.poll();
                        }
                    }
                    else if(value == -1 && !pqASC.isEmpty()){
                        while(!pqASC.isEmpty()){
                            if(!remove.contains(pqASC.peek())){
                                remove.add(pqASC.poll());
                                break;
                            }
                            pqASC.poll();
                        }
                    }
                    break;
            }
        }
        while(!pqASC.isEmpty()){
            int min = pqASC.poll();
            if(!remove.contains(min)){
                answer[1] = min;
                break;
            }
        }

        while(!pqDESC.isEmpty()){
            int max = pqDESC.poll();
            if(!remove.contains(max)){
                answer[0] = max;
                break;
            }
        }

        return answer;
    }
}
