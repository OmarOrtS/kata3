import software.ulpgc.es.model.FileTitleLoader;
import software.ulpgc.es.model.Title;
import software.ulpgc.es.model.TsvTitleDeserializer;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("E:/Is2/title.basics.tsv");
        List<Title> titles = new FileTitleLoader(file, new TsvTitleDeserializer()).load();
        Map<String, String> moviesGenres = new HashMap<>();
        titlesAndGenresList(titles, moviesGenres);
        List<String> genres = new ArrayList<>(Arrays.asList(
                "Action", "Music", "Documentary", "News",
                "Sport", "Animation", "Comedy",
                "Short", "Family", "Reality-TV",
                "History", "Adult", "Talk-Show",
                "Adventure", "Family", "Sci-Fi",
                "Drama", "Crime", "Short",
                "Mystery", "War", "Romance",
                "Biography", "Western", "Musical",
                "Game-Show", "Fantasy"
        ));

        MainFrame mainframe = new MainFrame(moviesGenres);
        mainframe.put("select", new SelectCommand(mainframe.getBarchartDisplay()));
        mainframe.put("toggle", new ToggleCommand(mainframe.getBarchartDisplay()));
        mainframe.addGenres(genres);
        mainframe.setVisible(true);

    }

    private static void titlesAndGenresList(List<Title> titles, Map<String, String> moviesGenres) {
        for (Title title : titles) {
            moviesGenres.put(title.getTitle(), title.getGenre());
        }
    }
}
