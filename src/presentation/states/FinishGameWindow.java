package presentation.states;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinishGameWindow extends JFrame {

    private JButton returnToMenuButton;

    public FinishGameWindow() {
        setTitle("¡Felicidades!");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("¡Felicidades! Has completado todos los niveles.");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);

        returnToMenuButton = new JButton("END");
        returnToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana y volver al menú principal
                dispose();
                // Aquí puedes agregar código para regresar al menú principal
                // Por ejemplo:
                // MainMenu mainMenu = new MainMenu();
                // mainMenu.setVisible(true);
            }
        });
        panel.add(returnToMenuButton, BorderLayout.SOUTH);

        add(panel);
    }
}