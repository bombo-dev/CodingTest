import java.util.*;

class Solution {
    
    public int[][] turn_clock_key(int[][] key){
        
        int[][] turn_key = new int[key.length][key.length];
        for(int i = 0; i < turn_key.length; i++){
            System.arraycopy(key[i], 0, turn_key[i], 0, key.length);
        }
        
        for(int i = 0; i < turn_key.length; i++){
            for(int j = 0; j < turn_key.length; j++){
                turn_key[i][j] = key[turn_key.length - 1 - j][i];
            }
        }
        return turn_key;
    }
    
    public int[][] new_lock(int[][] lock){
        int[][] new_lock = new int[lock.length * 3][lock.length * 3];

        for(int i = 0; i < lock.length; i++){
            for(int j = 0; j < lock.length; j++){
                new_lock[lock.length + i][lock.length + j] = lock[i][j];
            }
        }
        return new_lock;
    }
    
    public boolean check(int[][] new_lock){
        int lockLength = new_lock.length / 3;
        for(int i = lockLength; i < lockLength * 2; i++){
            for(int j = lockLength; j < lockLength * 2; j++){
                if(new_lock[i][j] != 1){
                    return false;
                }
            }
        }
        return true;
    }
    
    
    public boolean solution(int[][] key, int[][] lock) {
        int[][] extendLock = new_lock(lock);
        
        if(check(extendLock) == true){
            return true;
        }
        
        int[][] turnedKey = new int[key.length][key.length];
        for(int i = 0; i < turnedKey.length; i++){
            System.arraycopy(key[i], 0, turnedKey[i], 0, key.length);
        }
        
        boolean answer = false;
        
        for(int i = 0; i < 4; i++){
            turnedKey = turn_clock_key(turnedKey);
            
            for(int j = 0 ; j < (lock.length * 2); j++){
                for(int k = 0; k < (lock.length * 2) ; k++){
                    for(int l = 0; l < key.length; l++){
                        for(int m = 0; m < key.length; m++){
                            extendLock[j + l][k + m] += turnedKey[l][m];
                        }
                    }
                    
                    if(check(extendLock) == true){
                        return true;
                    }
                    extendLock = new_lock(lock);
                }
            }
        }
        return answer;
    }
}
