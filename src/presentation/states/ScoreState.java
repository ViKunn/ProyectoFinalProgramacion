package presentation.states;

import business.GameLogic;

import java.awt.*;
import javax.swing.*;

public class ScoreState extends State {
    private final Dimension dimension;
    private final int tileSize;
    public ScoreState(Dimension dimension, int tileSize) {
        this.dimension = dimension;
        this.tileSize = tileSize;

        setInitialValues();

    }

    private void setInitialValues(){
        //para centrar todo, el panel

        setPreferredSize(dimension);
        setBounds(tileSize * 5, 7, tileSize * 18, tileSize * 18);

    }
    @Override
    public void start() {

    }
}