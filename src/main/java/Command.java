import java.util.Map;

public interface Command {
    void execute(String selectedGenre, Integer count);
    void execute(Map<String, Integer> counts);
}
