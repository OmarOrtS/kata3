import java.util.Map;

public class ToggleCommand implements Command {
    private final BarchartDisplay barchartDisplay;

    public ToggleCommand(BarchartDisplay barchartDisplay) {
        this.barchartDisplay = barchartDisplay;
    }

    @Override
    public void execute(String selectedGenre, Integer count) {}

    @Override
    public void execute(Map<String, Integer> counts) {
        Barchart barchart = generateBarchart(counts);
        barchartDisplay.display(barchart, "All");
    }

    private Barchart generateBarchart(Map<String, Integer> counts) {
        Barchart barchart = new Barchart("Number of movies per genre");
        counts.forEach(barchart::add);
        return barchart;
    }
}
