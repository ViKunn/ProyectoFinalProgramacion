package presentation.states;

import presentation.Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuState extends JLayeredPane {

	private final Dimension dimension;
	private final int tileSize;

	private static final String backgroundImage  = "res/presentation/menuState/Background.png";

	private static final String playButtonImage  = "res/presentation/menuState/PlayButton.png";
	private static final String scoreButtonImage = "res/presentation/menuState/ScoreButton.png";
	private static final String helpButtonImage  = "res/presentation/menuState/HelpButton.png";


	private final JPanel menu = new Panel(backgroundImage);
	private JButton playButton, scoreButton, helpButton;

	private GameState gameState;


	public MenuState(Dimension dimension, int tileSize) {

		this.dimension = dimension;
		this.tileSize = tileSize;

		setPreferredSize(dimension);
		setInitialValues();
		initializeStates();

		addButtons();
		configureButton(playButton, gameState);
		// configureButton(button2, scoreState);
		// configureButton(button3, helpState);

		add(menu, JLayeredPane.PALETTE_LAYER);
		setVisible(true);

	}

	private void setInitialValues(){

		menu.setLayout(new GridLayout(3, 1));
		menu.setOpaque(false);
		menu.setBounds(tileSize * 7 + 9, tileSize * 12 - 7, tileSize * 16, tileSize * 5);

	}
	private void initializeStates(){
		gameState = new GameState(dimension, tileSize);
	}

	private void addButtons(){

		playButton  = createButton(playButtonImage);
		scoreButton = createButton(scoreButtonImage);
		helpButton  = createButton(helpButtonImage);

		menu.add(playButton);
		menu.add(scoreButton);
		menu.add(helpButton);

	}
	private JButton createButton(String iconPath){

		JButton button = new JButton(new ImageIcon(iconPath));

		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);

		return button;
	}


	private void configureButton(JButton button, State state) {

		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				state.setLayout(new BorderLayout());
				state.setBounds(192, 10, 32*18, 32*18);

				state.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						e.consume();
					}
				});

				add(state, JLayeredPane.POPUP_LAYER);
				revalidate();
				repaint();

				state.start();

			}

		};

		button.addActionListener(actionListener);
	}

}