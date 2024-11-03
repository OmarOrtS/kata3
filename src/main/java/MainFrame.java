import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFrame extends JFrame{
    private final Map<String, String> moviesGenres;
    private final Map<String, Command> commands;
    private BarchartDisplay barchartDisplay;
    private final List<String> genres;
    private JComboBox<String> comboBox;
    private Map<String, Integer> counts;

    public MainFrame(Map<String, String> moviesGenres) {
        this.setTitle("Statistics");
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.moviesGenres = moviesGenres;
        this.genres = new ArrayList<>();
        this.commands = new HashMap<>();
        this.add(barchartDisplay());
        this.add(menu(), BorderLayout.NORTH);
        this.counts = new HashMap<>();
        genreCount();

    }

    public void addGenres(List<String> genres){
        this.genres.addAll(genres);
        updateComboBox();
    }

    private void updateComboBox() {
        comboBox.removeAllItems();
        genres.forEach(genre -> comboBox.addItem(genre));
    }

    private void genreCount() {
        for (String genres : moviesGenres.values()) {
            String[] genreList = genres.split(",");
            for (String genre : genreList) counts.put(genre.trim(), counts.getOrDefault(genre.trim(), 0) + 1);
        }
    }

    private JPanel menu() {
         JPanel panel = new JPanel(new FlowLayout());
         panel.add(comboBox());
         panel.add(toggle());
         return panel;
    }

    private JButton toggle() {
        JButton toggle = new JButton("toggle");
        toggle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("toggle").execute(counts);
            }
        });
        return toggle;
    }

    private JComboBox<String> comboBox() {
        JComboBox<String> combobox = new JComboBox<>();
        for (String genre : genres) combobox.addItem(genre);
        combobox.addActionListener(e -> {
            String selectedGenre = (String) combobox.getSelectedItem();
            commands.get("select").execute(selectedGenre, counts.get(selectedGenre));
        });

        return combobox;
    }

    private JPanel barchartDisplay() {
        JFreeBarchartDisplay display = new JFreeBarchartDisplay();
        barchartDisplay = display;
        return display;
    }

    public BarchartDisplay getBarchartDisplay() { return barchartDisplay; }

    public Command put(String key, Command value) { return commands.put(key, value); }
}
