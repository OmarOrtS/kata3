import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Barchart {
    private final String title;
    private final Map<String, Integer> counts;

    public Barchart(String title) {
        this.title = title;
        this.counts = new HashMap<>();
    }

    public String getTitle() { return title; }

    public Integer add(String key, Integer value) { return counts.put(key, value); }

    public Set<Map.Entry<String, Integer>> numberOfMoviesPerGenre() { return counts.entrySet(); }
}
