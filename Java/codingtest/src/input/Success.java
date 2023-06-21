package input;

public class Success {
    public static int dedication = 0;
    public static int persistence = 0;
    public static boolean passion = false;
    public static int magic = 0;

    public int success(){
        dedication += 1; // dedicate yourself
        persistence += 1; // be persistent
        passion = true; // have passion

        if(passion == true){
            magic = dedication + persistence;
            return magic;
        } else {
            magic = 0;
            return magic;
        }
    }
    // love your dream. make mistakes. learn. keep grinding
}
