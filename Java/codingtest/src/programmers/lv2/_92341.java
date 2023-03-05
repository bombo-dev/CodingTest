package programmers.lv2;

import java.util.*;

class Parking implements Comparable<Parking> {
    String carNum;
    int price;

    public Parking(String carNum, int price){
        this.carNum = carNum;
        this.price = price;
    }

    @Override
    public int compareTo(Parking p){
        return this.carNum.compareTo(p.carNum);
    }

}
public class _92341 {
    public int[] solution(int[] fees, String[] records) {
        PriorityQueue<Parking> pq = new PriorityQueue<>();
        // 차량번호, 입차 시간
        HashMap<String, Integer> inOutTime = new HashMap<>();
        // 차량번호, 가격
        HashMap<String, Integer> price = new HashMap<>();
        Set<String> isOut = new HashSet<>();

        for(String record : records){
            StringTokenizer st = new StringTokenizer(record, " ");
            String[] time = st.nextToken().split(":");
            String number = st.nextToken();
            String command = st.nextToken();
            int hour = Integer.parseInt(time[0]) * 60;
            int minute = Integer.parseInt(time[1]);
            int total = hour + minute;
            if(command.equals("IN")){
                inOutTime.put(number, total);
                isOut.add(number);
            } else {
                int calcTime = total - inOutTime.get(number);

                price.put(number, price.getOrDefault(number, 0) + calcTime);
                isOut.remove(number);
            }
        }

        Iterator<String> iter = isOut.iterator();
        while(iter.hasNext()){
            String carNumber = iter.next();
            int lastTime = 23 * 60 + 59;
            int calcTime = lastTime - inOutTime.get(carNumber);
            price.put(carNumber, price.getOrDefault(carNumber, 0) + calcTime);
        }

        for(String carNumber : price.keySet()){
            pq.offer(new Parking(carNumber, calcPrice(price.get(carNumber), fees)));
        }

        int[] answer = new int[pq.size()];

        int index = 0;
        while(!pq.isEmpty()){
            answer[index++] = pq.poll().price;
        }



        return answer;
    }

    public int calcPrice(int calcTime, int[] fees){
        int basicTime = fees[0];
        int basicPrice = fees[1];
        int unitTime = fees[2];
        int unitPrice = fees[3];

        calcTime -= basicTime;

        if(calcTime <= 0){
            return basicPrice;
        } else {
            int remain = (calcTime - 1) / unitTime + 1;
            return basicPrice + unitPrice * remain;
        }
    }
}
