package presentation.states;

import java.awt.*;
        import java.awt.event.*;

        import presentation.Panel;

        import javax.swing.*;

public class HelpState extends State{

    private Dimension dimensionHelp;
    private final int tileSize;
    private final String [] helpImages = {
            "res/presentation/helpState/help1.jpg",
            "res/presentation/helpState/help2.jpg",
            "res/presentation/helpState/help3.jpg",
            "res/presentation/helpState/help4.jpg",
    };
    private int currentImageIndex = 0;
    private final String backToMenuButton = "res/presentation/helpState/backToMenuBotton.png";
    private JPanel help;
    private JButton backToMenu, nextHelp, prevHelp;
    private MenuState menuState;
    private String backgrounButtonPanel = "res/presentation/helpState/img.png";

    public HelpState(Dimension dimensionHelp, int tileSize, MenuState menuState) {

        this.dimensionHelp = dimensionHelp;
        this.tileSize = tileSize;
        this.menuState = menuState;
        this.help =  new JPanel();

        setPreferredSize(dimensionHelp);
        setLayout(new BorderLayout());
        //addButtons();

    }

    private void addButtons(){
        // Panel para los botones
        JPanel buttonPanel = new Panel(backgrounButtonPanel);
        //buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.setOpaque(false);
        JButton backToMenu = new JButton(new ImageIcon(backToMenuButton));

        //backToMenu  = createButton("Back to Menu");
        nextHelp = createButton("Next");
        prevHelp  = createButton("Previous");

        backToMenu.setOpaque(false);
        backToMenu.setContentAreaFilled(false);
        backToMenu.setBorderPainted(false);
        backToMenu.setBounds(12, 13, 13, 13);

        buttonPanel.add(prevHelp);
        buttonPanel.add(backToMenu);
        buttonPanel.add(nextHelp);

        add(buttonPanel, BorderLayout.SOUTH);
        backToMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToMenuState();
            }
        });

        nextHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndex = (currentImageIndex + 1) % helpImages.length;
                updateImage(helpImages[currentImageIndex]);
            }
        });

        prevHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndex = (currentImageIndex - 1 + helpImages.length) % helpImages.length;
                updateImage(helpImages[currentImageIndex]);
            }
        });
    }

    private JButton createButton(String icon){

        JButton button = new JButton();

        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);

        return button;
    }

    public void switchToMenuState(){
        this.setVisible(false);
        menuState.setVisible(true);
    }
    private void updateImage(String helpImage) {
        help.removeAll();

        ImageIcon imageIcon = new ImageIcon(helpImage);
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        help.add(imageLabel, BorderLayout.CENTER);

        // Volver a validar el panel para que se muestre la nueva imagen
        help.revalidate();
        help.repaint();
    }
    @Override
    public void start() {
        help = new Panel(helpImages[currentImageIndex]);
        addButtons();

        add(help, BorderLayout.CENTER);

        setVisible(true);
    }
    //Si llega la última que regrese una por una reiterador
}