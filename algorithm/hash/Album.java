package algorithm.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Album {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();
        HashMap<String, Integer> playSumMap = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            if (!genreMap.containsKey(genre)) {
                genreMap.put(genre, new ArrayList<>());
                playSumMap.put(genre, 0);
            }
            genreMap.get(genre).add(new int[]{i, play});
            playSumMap.put(genre, playSumMap.get(genre) + play);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        Stream<Map.Entry<String, Integer>> sortedGenre = playSumMap.entrySet().stream().sorted(((o1, o2) ->
                Integer.compare(o2.getValue(), o1.getValue())
        ));

        sortedGenre.forEach(entry -> {
            Stream<int[]> sortedSongs = genreMap.get(entry.getKey()).stream().sorted(((o1, o2) -> Integer.compare(o2[1], o1[1]))).limit(2);
            sortedSongs.forEach(song -> answer.add(song[0]));
        });

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
