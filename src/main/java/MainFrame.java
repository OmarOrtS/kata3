import software.ulpgc.es.Factories.MainFrameSelectCommandFactory;
import software.ulpgc.es.Factories.MainFrameToggleCommandFactory;
import software.ulpgc.es.control.Command;
import software.ulpgc.es.view.BarchartDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands = new HashMap<>();
    private final Map<String, Integer> counts;
    private BarchartDisplay barchartDisplay;
    private final List<String> genres;
    private JComboBox<String> comboBox;
    private final Map<String, String> moviesGenres;

    public MainFrame(Map<String, String> moviesGenres) {
        this.setTitle("Statistics");
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.moviesGenres = moviesGenres;
        this.add(barchartDisplay());
        this.genres = new ArrayList<>();
        this.add(menu(), BorderLayout.NORTH);
        this.counts = new HashMap<>();
        genreCount();
        new MainFrameToggleCommandFactory(commands, counts, barchartDisplay).addCommand();
    }

    private void genreCount() {
        for (String genres : moviesGenres.values()) {
            String[] genreList = genres.split(",");
            for (String genre : genreList) counts.put(genre.trim(), counts.getOrDefault(genre.trim(), 0) + 1);
        }
    }

    public void addGenres(List<String> genres){
        this.genres.addAll(genres);
        updateComboBox();
    }

    private void updateComboBox() {
        comboBox.removeAllItems();
        for (String genre : genres) comboBox.addItem(genre);
    }

    private JPanel menu() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(comboBox());
        panel.add(toggle());
        return panel;
    }

    private JButton toggle() {
        JButton toggle = new JButton("toggle");
        toggle.addActionListener(e -> commands.get("toggle").execute());
        return toggle;
    }

    private JComboBox<String> comboBox() {
        comboBox = new JComboBox<>();

        for (String genre : genres) comboBox.addItem(genre);
        comboBox.addActionListener(e -> {
            String selectedGenre = (String) comboBox.getSelectedItem();
            new MainFrameSelectCommandFactory(commands,selectedGenre,counts.get(selectedGenre),barchartDisplay).addCommand();
            commands.get("select "+selectedGenre).execute();
        });

        return comboBox;
    }

    private JPanel barchartDisplay() {
        JFreeBarchartDisplay display = new JFreeBarchartDisplay();
        barchartDisplay = display;
        return display;
    }

}
