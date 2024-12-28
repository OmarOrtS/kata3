package software.ulpgc.es.control;

import software.ulpgc.es.model.Barchart;
import software.ulpgc.es.view.BarchartDisplay;

import java.util.Map;

public class ToggleCommand implements Command {
    private final BarchartDisplay barchartDisplay;
    private final Map<String, Integer> counts;

    public ToggleCommand(BarchartDisplay barchartDisplay, Map<String, Integer> counts) {
        this.barchartDisplay = barchartDisplay;
        this.counts = counts;
    }

    @Override
    public void execute() {
        Barchart barchart = generateBarchart(counts);
        barchartDisplay.display(barchart, "All");
    }

    private Barchart generateBarchart(Map<String, Integer> counts) {
        Barchart barchart = new Barchart("Number of movies per genre");
        for (Map.Entry<String, Integer> entry : counts.entrySet()) barchart.add(entry.getKey(), entry.getValue());
        return barchart;
    }
}
