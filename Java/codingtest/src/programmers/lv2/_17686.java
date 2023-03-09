package programmers.lv2;

import java.util.*;

class File implements Comparable<File> {
    String head;
    String number;
    String tail;

    public File(String head, String number, String tail){
        this.head = head;
        this.number = number;
        this.tail = tail;
    }

    @Override
    public int compareTo(File file){
        if(this.head.toLowerCase().equals(file.head.toLowerCase()))
            return Integer.parseInt(this.number) - Integer.parseInt(file.number);
        else
            return this.head.toLowerCase().compareTo(file.head.toLowerCase());
    }

    @Override
    public String toString(){
        return "head : [" + head + "], number : [" + number + "], tail : [" + tail + "]";
    }

    public String getFullName() {
        return head + number + tail;
    }
}
public class _17686 {
    public String[] solution(String[] files) {
        ArrayList<File> list = new ArrayList<>();
        for(int i = 0; i < files.length; i++){
            String file = files[i];
            boolean numberCheck = false;
            int startNumber = 0;
            int lastNumber = 0;
            for(int j = 0; j < file.length(); j++){
                if(Character.isDigit(file.charAt(j)) && !numberCheck){
                    numberCheck = true;
                    startNumber = j;
                } else if(!Character.isDigit(file.charAt(j)) && numberCheck){
                    lastNumber = j - 1;
                    break;
                }
            }

            if(lastNumber == 0){
                lastNumber = file.length() - 1;
            }

            list.add(convertFile(file, startNumber, lastNumber));
        }
        Collections.sort(list);

        String[] answer = new String[list.size()];

        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i).getFullName();
        }

        return answer;
    }

    public File convertFile(String file, int startNumber, int lastNumber){
        String head = file.substring(0, startNumber);
        String number = file.substring(startNumber, lastNumber + 1);
        String tail = "";
        if(lastNumber != file.length() - 1);
        tail = file.substring(lastNumber + 1, file.length());
        return new File(head, number, tail);
    }
}
