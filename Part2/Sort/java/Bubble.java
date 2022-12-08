public class Bubble {
    public static int[] array = {7, 4, 5, 1, 3};

    public static void main(String[] args){

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - 1; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for(int value : array){
            System.out.print(value +  " ");
        }
    }
}
