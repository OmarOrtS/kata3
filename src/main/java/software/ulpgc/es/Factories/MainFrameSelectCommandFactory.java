package software.ulpgc.es.Factories;

import software.ulpgc.es.Builder.SelectCommandBuilder;
import software.ulpgc.es.control.Command;
import software.ulpgc.es.view.BarchartDisplay;

import java.util.Map;

public class MainFrameSelectCommandFactory implements Factory{
    private final Map<String, Command> commands;
    private final String selectedGenre;
    private final Integer count;
    private final BarchartDisplay barchartDisplay;

    public MainFrameSelectCommandFactory(Map<String, Command> commands, String selectedGenre, Integer count, BarchartDisplay barchartDisplay) {
        this.commands = commands;
        this.selectedGenre = selectedGenre;
        this.count = count;
        this.barchartDisplay = barchartDisplay;
    }


    @Override
    public void addCommand() {commands.put("select "+selectedGenre, new SelectCommandBuilder(barchartDisplay,selectedGenre,count).build());}
}
