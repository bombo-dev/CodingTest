package baekjoon;

import java.io.*;
import java.util.*;

class Message {
    int order;
    int count;

    Message(int order, int count) {
        this.order = order;
        this.count = count;
    }
}
public class _2910 {
    static int N;
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int order = 0;
        Map<String, Message> message = new HashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            String value = st.nextToken();
            if(!message.containsKey(value)) {
                message.put(value, new Message(order++, 1));
            } else {
                Message preMessage = message.get(value);
                preMessage.count++;
                message.put(value, preMessage);
            }
        }

        List<Map.Entry<String, Message>> entryList = new ArrayList<>(message.entrySet());

        Collections.sort(entryList, new Comparator<Map.Entry<String, Message>>() {
            @Override
            public int compare(Map.Entry<String, Message> o1, Map.Entry<String, Message> o2) {
                if(o1.getValue().count == o2.getValue().count){
                    return o1.getValue().order - o2.getValue().order;
                }
                return o2.getValue().count - o1.getValue().count;
            }
        });

        for(Map.Entry<String, Message> val : entryList){
            int count = val.getValue().count;
            for(int i = 0; i < count; i++) {
                System.out.print(val.getKey() + " ");
            }
        }
    }
}
