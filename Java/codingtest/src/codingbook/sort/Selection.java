package codingbook.sort;

public class Selection {
    public static int[] array = {9, 6, 7, 3, 5};

    public static void main(String[] args){
        for(int i = 0; i < array.length; i++){
            int minIndex = i;
            for(int j = i; j < array.length; j++){
                if(array[minIndex] > array[j]){
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        for(int value: array){
            System.out.print(value + " ");
        }
    }
}
