package presentation;

import business.Level;
import business.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameState extends JPanel implements Runnable {

	private Player player;
	private Level[] levels;

	private boolean running;

	public GameState(){

		player = new Player();
		levels = new Level[5];

	}

	public void start(){
		run();
	}

	@Override
	public void run() {
		/*
		while (running){



		}
		 */

	}



}