public class Insertion {
    public static int[] array = {8, 5, 6, 2, 4};

    public static void main(String[] args){
        for(int i = 1; i < array.length; i++){
            for(int j = i; j > 0; j--){
                if(array[j] < array[j - 1]){
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                } else {
                    break;
                }
            }
        }
        for(int value : array){
            System.out.print(value + " ");
        }
    }
}
