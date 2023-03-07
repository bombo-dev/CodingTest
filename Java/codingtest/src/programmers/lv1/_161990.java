package programmers.lv1;

public class _161990 {
    public int[] solution(String[] wallpaper) {

        int[] answer = new int[4];

        int minRow = wallpaper.length;
        int maxRow = 0;
        int minCol = wallpaper[0].length();
        int maxCol = 0;

        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    minRow = Math.min(i, minRow);
                    maxRow = Math.max(maxRow, i + 1);
                    minCol = Math.min(j, minCol);
                    maxCol = Math.max(maxCol, j + 1);
                }
            }
        }
        answer[0] = minRow;
        answer[1] = minCol;
        answer[2] = maxRow;
        answer[3] = maxCol;

        return answer;
    }
}
