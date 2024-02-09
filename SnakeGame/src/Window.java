import javax.swing.*;

public class Window extends JFrame {

	Window(){

		this.add(new GamePanel());
		windowConfiguration();
	}

	private void windowConfiguration(){
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}