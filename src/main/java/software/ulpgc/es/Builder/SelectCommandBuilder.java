package software.ulpgc.es.Builder;

import software.ulpgc.es.control.Command;
import software.ulpgc.es.control.SelectCommand;
import software.ulpgc.es.view.BarchartDisplay;

public class SelectCommandBuilder implements Builder{

    private final BarchartDisplay barchartDisplay;
    private final String selectedGenre;
    private final Integer count;

    public SelectCommandBuilder(BarchartDisplay barchartDisplay, String selectedGenre, Integer count) {
        this.barchartDisplay = barchartDisplay;
        this.selectedGenre = selectedGenre;
        this.count = count;
    }

    @Override
    public Command build() {
        return new SelectCommand(barchartDisplay,selectedGenre,count);
    }
}
