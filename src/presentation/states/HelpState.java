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
    private final String nextHelpButton = "res/presentation/helpState/nextHelpButton.png";
    private final String prevHelpButton = "res/presentation/helpState/prevHelptButton.png";
    private JPanel help;
    private JButton backToMenu, nextHelp, prevHelp;
    private MenuState menuState;
    private String backgrounButtonPanel = "res/presentation/helpState/img.png";


    public boolean menuVisibleOnReturn = false;
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
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.setOpaque(false);
        //JButton backToMenu = new JButton(new ImageIcon(backToMenuButton));

        backToMenu  = createButton(backToMenuButton);
        nextHelp = createButton(nextHelpButton);
        prevHelp  = createButton(prevHelpButton);

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
    private JButton createButton(String iconPath){

        JButton button = new JButton(new ImageIcon(iconPath));

        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);

        return button;
    }
    public void switchToMenuState() {
        menuState.setVisible(true); // Mostrar el menú principal
        setVisible(false); // Ocultar el submenú de Help
        menuState.showButtons(); // Mostrar los botones del menú principal
    }
    private void updateImage(String helpImage) {
        help.removeAll();

        ImageIcon imageIcon = new ImageIcon(helpImage);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(help.getWidth(), help.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledImageIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        help.add(imageLabel, BorderLayout.CENTER);
        // Volver a validar el panel para que se muestre la nueva imagen
        help.revalidate();
        help.repaint();
    }
    @Override
    public void start() {
        help = new Panel(helpImages[currentImageIndex]);
        menuState.hideButtons();
        addButtons();

        if (help.getComponentCount() == 0) {
            addButtons(); // Agregar el panel de botones solo si no está presente
        }

        add(help, BorderLayout.CENTER);

        setVisible(true);
    }

}