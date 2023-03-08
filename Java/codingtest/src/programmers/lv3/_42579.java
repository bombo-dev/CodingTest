package programmers.lv3;

import java.util.*;

class Music implements Comparable<Music> {

    int index;
    int play;

    public Music(int index, int play){
        this.index = index;
        this.play = play;
    }

    @Override
    public int compareTo(Music m){
        if(this.play == m.play)
            return this.index - m.index;
        return m.play - this.play;
    }

}

class Genres implements Comparable<Genres> {
    String genre;
    int totalPlay;

    public Genres(String genre, int totalPlay){
        this.genre = genre;
        this.totalPlay = totalPlay;
    }

    @Override
    public int compareTo(Genres g){
        return g.totalPlay - this.totalPlay;
    }
}

public class _42579 {
    public int[] solution(String[] genres, int[] plays) {

        ArrayList<Integer> result = new ArrayList<>();

        HashMap<String, ArrayList<Music>> genresMap = new HashMap<>();
        HashMap<String, Integer> totalPlayMap = new HashMap<>();

        for(int i = 0; i < genres.length; i++){
            if(genresMap.containsKey(genres[i]))
                genresMap.get(genres[i]).add(new Music(i, plays[i]));
            else {
                genresMap.put(genres[i], new ArrayList<>());
                genresMap.get(genres[i]).add(new Music(i, plays[i]));
            }

            totalPlayMap.put(genres[i], totalPlayMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<Genres> genresList = new ArrayList<>();

        for(String key : totalPlayMap.keySet()){
            genresList.add(new Genres(key, totalPlayMap.get(key)));
        }

        Collections.sort(genresList);
        for(Genres genre : genresList){
            ArrayList<Music> list = genresMap.get(genre.genre);
            Collections.sort(list);

            int index = 0;
            while(index < 2 && index < list.size()) {
                result.add(list.get(index).index);
                index++;
            }
        }

        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = result.get(i);
        }

        return answer;
    }
}
