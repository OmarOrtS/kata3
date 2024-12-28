package software.ulpgc.es.control;

import software.ulpgc.es.model.Barchart;
import software.ulpgc.es.view.BarchartDisplay;

public class SelectCommand implements Command {
    private final BarchartDisplay barchartDisplay;
    private final String selectedGenre;
    private final Integer count;

    public SelectCommand(BarchartDisplay barchartDisplay, String selectedGenre, Integer count) {
        this.barchartDisplay = barchartDisplay;
        this.selectedGenre = selectedGenre;
        this.count = count;
    }

    @Override
    public void execute() {
        Barchart barchart = generateBarchart(selectedGenre,count);
        barchartDisplay.display(barchart, selectedGenre);
    }

    private Barchart generateBarchart(String selectedGenre, Integer count) {
        Barchart barchart = new Barchart("Number of " + selectedGenre + " movies");
        barchart.add(selectedGenre, count);
        return barchart;
    }
}
