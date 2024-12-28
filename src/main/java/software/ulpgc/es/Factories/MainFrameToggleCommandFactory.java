package software.ulpgc.es.Factories;

import software.ulpgc.es.Builder.ToggleCommandBuilder;
import software.ulpgc.es.control.Command;
import software.ulpgc.es.view.BarchartDisplay;

import java.util.Map;

public class MainFrameToggleCommandFactory implements Factory{
    private final Map<String, Command> commands;
    private final  Map<String, Integer> counts;
    private final BarchartDisplay barchartDisplay;

    public MainFrameToggleCommandFactory(Map<String, Command> commands, Map<String, Integer> counts, BarchartDisplay barchartDisplay) {
        this.commands = commands;
        this.counts = counts;
        this.barchartDisplay = barchartDisplay;
    }

    @Override
    public void addCommand() {
        commands.put("toggle", new ToggleCommandBuilder(counts, barchartDisplay).build());
    }
}
