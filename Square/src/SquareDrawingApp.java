import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SquareDrawingApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Square Drawing Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(900, 600);
            SquarePanel squarePanel = new SquarePanel();
            frame.add(squarePanel);
            frame.setVisible(true);

            // Create a Timer to animate the square
            Timer timer = new Timer(10, new ActionListener() {
                int x = 0; // Initial x position

                @Override
                public void actionPerformed(ActionEvent e) {
                    x += 2; // Adjust the movement speed as needed
                    squarePanel.setSquareX(x); // Update the x coordinate of the square
                    squarePanel.repaint(); // Repaint the panel to show the updated square position

                    if (x >= frame.getWidth()) {
                        // If the square reaches the right end, reset it to the left
                        x = -squarePanel.getSquareSize();
                    }
                }
            });

            timer.start(); // Start the animation timer
        });
    }
}

class SquarePanel extends JPanel {
    private int squareX = 0; // Initial x coordinate of the square
    private int squareSize = 60; // Adjust the size of the square as needed

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawSquare(g);
    }

    private void drawSquare(Graphics g) {
        int y = (getHeight() - squareSize) / 2; // Center the square vertically

        g.setColor(Color.BLACK); // Set the square's color to black
        g.fillRect(squareX, y, squareSize, squareSize); // Draw the filled square
    }

    public void setSquareX(int x) {
        this.squareX = x;
    }

    public int getSquareSize() {
        return squareSize;
    }
}
