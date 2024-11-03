import java.util.Map;

public class SelectCommand implements Command {
    private final BarchartDisplay barchartDisplay;

    public SelectCommand(BarchartDisplay barchartDisplay) {
        this.barchartDisplay = barchartDisplay;
    }

    @Override
    public void execute(String selectedGenre, Integer count) {
        Barchart barchart = generateBarchart(selectedGenre, count);
        barchartDisplay.display(barchart, selectedGenre);
    }

    private Barchart generateBarchart(String selectedGenre, Integer count) {
        Barchart barchart = new Barchart("Number of " + selectedGenre + " movies");
        barchart.add(selectedGenre, count);
        return barchart;
    }

    @Override
    public void execute(Map<String, Integer> counts) {}
}
