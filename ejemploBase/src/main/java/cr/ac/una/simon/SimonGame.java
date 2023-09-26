
package cr.ac.una.simon;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimonGame {
    private List<Integer> sequence;
    private int currentIndex;
    private boolean isUserTurn;
    private boolean isGameOver;

    public SimonGame() {
        sequence = new ArrayList<>();
        currentIndex = 0;
        isUserTurn = false;
        isGameOver = false;
    }

    public void startGame() {
        sequence.clear();
        currentIndex = 0;
        isUserTurn = false;
        isGameOver = false;
        addRandomColor(); // Agregar el primer color aleatorio
    }

    public void addRandomColor() {
        Random random = new Random();
        int color = random.nextInt(4); // 0: Rojo, 1: Verde, 2: Amarillo, 3: Azul
        sequence.add(color);
    }

    public boolean isUserTurn() {
        return isUserTurn;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void playerClicked(int color) {
        if (isUserTurn) {
            int expectedColor = sequence.get(currentIndex);
            if (color == expectedColor) {
                currentIndex++;
                if (currentIndex == sequence.size()) {
                    // El jugador ha repetido correctamente la secuencia
                    currentIndex = 0;
                    isUserTurn = false;
                    addRandomColor(); // Agregar el siguiente color aleatorio
                }
            } else {
                // El jugador cometió un error
                isGameOver = true;
            }
        }
    }
}
