
package cr.ac.una.simon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class SimonGameUI extends JFrame {

    private SimonGame simonGame;
    private JButton redButton;
    private JButton greenButton;
    private JButton yellowButton;
    private JButton blueButton;

    public SimonGameUI(SimonGame simonGame) {
        this.simonGame = simonGame;

        setTitle("Simon Dice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        redButton = createColorButton(Color.RED);
        greenButton = createColorButton(Color.GREEN);
        yellowButton = createColorButton(Color.YELLOW);
        blueButton = createColorButton(Color.BLUE);

        panel.add(redButton);
        panel.add(greenButton);
        panel.add(yellowButton);
        panel.add(blueButton);

        add(panel, BorderLayout.CENTER);

        ActionListener buttonClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (simonGame.isUserTurn()) {
                    JButton clickedButton = (JButton) e.getSource();
                    int color = getColorForButton(clickedButton);
                    simonGame.playerClicked(color);
                    updateUI();
                }
            }
        };

        redButton.addActionListener(buttonClickListener);
        greenButton.addActionListener(buttonClickListener);
        yellowButton.addActionListener(buttonClickListener);
        blueButton.addActionListener(buttonClickListener);
    }

    private JButton createColorButton(Color color) {
        JButton button = new JButton();
        button.setBackground(color);
        button.setOpaque(true);
        button.setBorderPainted(false);
        return button;
    }

    private int getColorForButton(JButton button) {
    if (button == redButton) {
        return Color.RED.getRGB();
    } else if (button == greenButton) {
        return Color.GREEN.getRGB();
    } else if (button == yellowButton) {
        return Color.YELLOW.getRGB();
    } else if (button == blueButton) {
        return Color.BLUE.getRGB();
    }
    return -1; // Valor predeterminado si no coincide con ningún botón
    }
    public void startGame() {
        simonGame.startGame();
        updateUI();
    }

    public void updateUI() {
        if (simonGame.isGameOver()) {
            // Mostrar mensaje de "Game Over" o realizar acciones relacionadas con el fin del juego
            JOptionPane.showMessageDialog(this, "Game Over!");
            startGame(); // Reiniciar el juego
        } else {
            // Realizar actualizaciones de la interfaz según el estado del juego
            // Puedes resaltar la secuencia actual o mostrar otros indicadores
        }
    }
}
