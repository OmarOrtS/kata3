package software.ulpgc.es.Builder;

import software.ulpgc.es.control.Command;
import software.ulpgc.es.control.ToggleCommand;
import software.ulpgc.es.view.BarchartDisplay;

import java.util.Map;

public class ToggleCommandBuilder implements Builder{
    private final Map<String, Integer> counts;
    private final BarchartDisplay barchartDisplay;

    public ToggleCommandBuilder(Map<String, Integer> counts, BarchartDisplay barchartDisplay) {
        this.counts = counts;
        this.barchartDisplay = barchartDisplay;
    }

    @Override
    public Command build() {
        return new ToggleCommand(barchartDisplay, counts);
    }
}
