package programmers.lv1;

import java.util.ArrayList;
import java.util.List;

// 신규 아이디 추천
public class _72410 {
    public static void main(String[] args){
        String s1 = "...!@BaT#*..y.abcdefghijklm";
        String s2 = "z-+.^.";
        String s3 = "=.=";
        String s4 = "123_.def";
        String s5 = "abcdefghijklmn.p";
        System.out.println(solution(s5));
    }

    public static String solution(String new_id){
        String answer = "";
        answer = firstStage(new_id);
        answer = secondStage(answer);
        answer = thirdStage(answer);
        answer = fourthStage(answer);
        answer = fifthStage(answer);
        answer = sixthStage(answer);
        answer = seventhStage(answer);
        return answer;
    }

    public static String firstStage(String new_id){
        String first_id = new_id.toLowerCase();
        return first_id;
    }

    public static String secondStage(String new_id){
        char[] idCharacter = new_id.toCharArray();
        List<Character> list = new ArrayList<>();
        for(char ch : idCharacter){
            list.add(ch);
        }
        for(int i = 0; i < list.size(); i++){
            if(checkSpecialSymbol(list.get(i))) {
                list.remove(i);
                i--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : list){
            sb.append(Character.toString(ch));
        }
        return sb.toString();
    }

    public static boolean checkSpecialSymbol(char ch){
        if(ch == '~' || ch == '!' || ch =='@' || ch == '#'
                || ch == '$' || ch == '%' || ch =='^' || ch == '&'
                || ch == '*' || ch == '(' || ch == ')' || ch == '='
                || ch == '+' || ch == '[' || ch == '{' || ch == ']'
                || ch == '}' || ch == ':' || ch == '?' || ch == ','
                || ch == '<' || ch == '>' || ch == '/')
            return true;
        else
            return false;
    }

    public static String thirdStage(String new_id){
        char[] ch = new_id.toCharArray();
        List<Character> list = new ArrayList<>();
        for(char c : ch){
            list.add(c);
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == '.'){
                while(i + 1 < list.size() && list.get(i + 1) == '.' ){
                    list.remove(i + 1);
                }
            }
            sb.append(list.get(i));
        }

        return sb.toString();
    }

    public static String fourthStage(String new_id){
        if(new_id.startsWith(".")){
            new_id = new_id.substring(1);
        }

        if(new_id.endsWith(".")){
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        return new_id;
    }

    public static String fifthStage(String new_id){
        if(new_id.length() == 0){
            new_id += "a";
        }
        return new_id;
    }

    public static String sixthStage(String new_id){
        if(new_id.length() >= 16){
            new_id = new_id.substring(0, 15);
            if(new_id.endsWith(".")){
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }
        return new_id;
    }

    public static String seventhStage(String new_id){
        if(new_id.length() <= 2){
            while(new_id.length() < 3){
                new_id += Character.toString(new_id.charAt(new_id.length() - 1));
            }
        }
        return new_id;
    }
}
