package presentation.states;

import presentation.Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuState extends JLayeredPane {
	private Dimension dimension;
	private int tileSize;
	private final String backgroundImage  = "res/presentation/menuState/Background.png";
	private final String playButtonImage  = "res/presentation/menuState/PlayButton.png";
	private final String scoreButtonImage = "res/presentation/menuState/ScoreButton.png";
	private final String helpButtonImage  = "res/presentation/menuState/HelpButton.png";
	private JPanel menu = new Panel(backgroundImage);
	private JButton playButton, scoreButton, helpButton;
	private GameState gameState;
	private HelpState helpState;
	private ScoreState scoreState;
	private boolean helpStateVisible = false;
	private boolean isTheHelpState = false;

	public MenuState(Dimension dimension, int tileSize) {

		this.dimension = dimension;
		this.tileSize = tileSize;

		setPreferredSize(dimension);
		setInitialValues();
		initializeStates();

		addButtons();
		configureButton(playButton, gameState);
		configureButton(scoreButton, scoreState);
		configureButton(helpButton, helpState);

		add(menu, JLayeredPane.PALETTE_LAYER);
		setVisible(true);

	}

	private void setInitialValues(){

		// botones
		menu.setLayout(new GridLayout(3, 1));
		menu.setOpaque(false);
		//Centrarle
		menu.setBounds(tileSize * 7 + 9, tileSize * 12 - 7, tileSize * 16, tileSize * 5);

	}

	private void initializeStates(){
		gameState = new GameState(dimension, tileSize);
		helpState = new HelpState(dimension, tileSize, this);
		scoreState = new ScoreState(dimension, tileSize);
	}
	private void addButtons(){

		playButton  = createButton(playButtonImage);
		scoreButton = createButton(scoreButtonImage);
		helpButton  = createButton(helpButtonImage);

		menu.add(playButton);
		menu.add(scoreButton);
		menu.add(helpButton);

	}
	private void setHelpStateVisible(boolean visible){
		this.helpStateVisible = visible;
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

			private boolean helpStateVisible = false;
			@Override
			public void actionPerformed(ActionEvent e) {
				if (state instanceof HelpState && helpStateVisible) {
					return; // No hacer nada si HelpState ya está visible
				}

				state.setLayout(new BorderLayout());
				state.setBounds(192, 6, 32*18, 32*18);

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

	public void switchToHelpState(){
		isTheHelpState = true;
	}
	public void hideButtons() {
		//menu.setVisible(false);
		if (!isTheHelpState) {
			menu.setVisible(false); // Ocultar los botones del menú
		}
	}
	public void showButtons() {
		menu.setVisible(true); // Mostrar los botones del menú principal
	}


}