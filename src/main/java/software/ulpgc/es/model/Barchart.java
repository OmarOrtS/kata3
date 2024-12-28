package software.ulpgc.es.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Barchart {
    private final String title;
    private final Map<String, Integer> count;

    public Barchart(String title) {
        this.title = title;
        this.count = new HashMap<>();
    }

    public String getTitle() { return title; }

    public void add(String key, Integer value) {count.put(key, value);}

    public Set<Map.Entry<String, Integer>> numberOfMoviesPerGenre() { return count.entrySet(); }
}
