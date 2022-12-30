package programmers.lv1;

public class _82612 {
    public static void main(String[] args){
        int price = 3;
        int money = 20;
        int count = 4;

        long total = recursion(0, price, count);
        if(money - total > 0){
            System.out.println(0);
        } else{
            System.out.println(total - money);
        }
        System.out.println(solution2(price, money, count));
    }

    public static long recursion(long total, int price, int count){
        if(count == 0){
            return total;
        }
        total += price * count;
        return recursion(total, price, count - 1);
    }

    public static long solution2(int price, int money, int count){

        long total = price * (count * (count + 1) / 2);
        // Math.max(total - money, 0);
        return money - total > 0 ? 0 : total - money;
    }
}
