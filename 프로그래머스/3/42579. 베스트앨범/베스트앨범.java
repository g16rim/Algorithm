import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, List<int[]>> genreSongs = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];
            
            genreTotal.put(g, genreTotal.getOrDefault(g, 0) + p);
            
            List<int[]> list = genreSongs.get(g);
            if (list == null) {
                list = new ArrayList<int[]>();
                genreSongs.put(g, list);
            }
            list.add(new int[] {i, p});
        }
        
        List<String> sortedGenres = new ArrayList<String>(genreTotal.keySet());
        Collections.sort(sortedGenres, new Comparator<String>() {
            public int compare(String a, String b) {
                return genreTotal.get(b) - genreTotal.get(a);
            }
        });
        
        List<Integer> resultList = new ArrayList<Integer>();
        
        for (String g : sortedGenres) {
            List<int[]> songs = genreSongs.get(g);
            
            Collections.sort(songs, new Comparator<int[]>() {
                public int compare(int[] x, int[] y) {
                    if (x[1] != y[1]) {
                        return y[1] - x[1];
                    } else {
                        return x[0] - y[0];
                    }
                }
            });
            
            resultList.add(songs.get(0)[0]);
            if (songs.size() > 1) {
                resultList.add(songs.get(1)[0]);
            }
        } 
        
        int[] answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        return answer;
    }
}