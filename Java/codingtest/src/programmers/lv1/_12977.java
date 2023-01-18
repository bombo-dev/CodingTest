package programmers.lv1;

public class _12977 {

    static int result = 0;
    static boolean[] notPrime;

    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 7, 6, 4};

        solution(nums2);
    }

    public static int solution(int[] nums) {
        int answer = -1;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        notPrime = new boolean[sum + 1];
        for(int i = 2; i <= (int)Math.sqrt(sum); i++){
            if(notPrime[i])
                continue;

            for(int j = i * 2; j <= sum; j += i){
                notPrime[j] = true;
            }
        }

        int max = 0;
        for(int value : nums){
            max = Math.max(max, value);
        }

        int[] arr = new int[3];
        boolean[] visited = new boolean[max + 1];


        comb(nums, 3, 0,  visited);

        System.out.print(result);

        return answer;
    }

    public static void comb(int[] n, int r, int start, boolean[] visited){
        if(r == 0){
            int total = 0;

            for(int i = 0; i < visited.length; i++){
                if(visited[i])
                    total += i;
            }
            System.out.println("total : " + total);



            if(!notPrime[total])
                result++;

            return;
        }

        for(int i = start; i < n.length; i++){
            visited[n[i]] = true;
            comb(n, r - 1, i + 1, visited);
            visited[n[i]] = false;
        }


    }
}
