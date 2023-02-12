package codeTree;

public class BubbleSort_A {
    public int bubbleSort(){
        int[] arr = {12, 4, 5, 2, 1, 3, 6, 9, 8, 11};

        int[] sortedArr = arr.clone();
        boolean sorted = true;
        int count = 0;

        do {
            sorted = true;
            count++;
            for(int i = 0; i < sortedArr.length - 1; i++){
                if(sortedArr[i] > sortedArr[i + 1]) {
                    int temp = sortedArr[i];
                    sortedArr[i] = sortedArr[i + 1];
                    sortedArr[i + 1] = temp;
                    sorted = false;
                }
            }
        }while(!sorted);

        return count;
    }
}
