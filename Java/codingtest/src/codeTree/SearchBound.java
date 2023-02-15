package codeTree;

public class SearchBound {
    public static void main(String[] args){
        int [] arr = {1, 3, 5, 7, 9, 11, 12, 13, 13, 14, 15, 15, 17, 19};
        new CustomBound().customBound(arr, 15);
        new LowerBound().lowerBound(arr, 15);
        new UpperBound().upperBound(arr, 15);
    }
}
