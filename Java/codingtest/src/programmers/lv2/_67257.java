package programmers.lv2;
import java.util.*;
public class _67257 {
    String[] priority = {"*+-", "*-+", "+*-", "+-*", "-+*", "-*+"};
    long max = 0;
    List<Long> numberList = new ArrayList<>();
    List<Character> operList = new ArrayList<>();
    List<Long> tempList;
    List<Character> tempOpList;

    public long solution(String expression) {
        listInit(expression);
        solve();
        return max;
    }

    public void listInit(String exp) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < exp.length(); i++) {
            if(exp.charAt(i) != '*' && exp.charAt(i) != '+' && exp.charAt(i) != '-')
                sb.append(exp.charAt(i));
            else {
                numberList.add(Long.parseLong(sb.toString()));
                operList.add(exp.charAt(i));
                sb = new StringBuilder();
            }
        }
        numberList.add(Long.parseLong(sb.toString()));
    }

    void solve() {
        for(int i = 0; i < 6; i++) {
            initTempList();
            calc(priority[i]);
        }
    }

    void initTempList() {
        tempList = new ArrayList<>(numberList);
        tempOpList = new ArrayList<>(operList);
    }

    void calc(String p) {
        for(char op : p.toCharArray()) {
            for(int i = 0; i < tempOpList.size();) {
                if(op == tempOpList.get(i)) {
                    calculation(i, op);
                } else {
                    i++;
                }
            }
        }
        max = Math.max(max, Math.abs(tempList.get(0)));
    }
    void calculation(int i, char op) {
        if(op == '*') {
            tempList.set(i, tempList.get(i) * tempList.get(i + 1));
        } else if (op == '+') {
            tempList.set(i, tempList.get(i) + tempList.get(i + 1));
        } else {
            tempList.set(i, tempList.get(i) - tempList.get(i + 1));
        }

        tempList.remove(i + 1);
        tempOpList.remove(i);
    }

}
