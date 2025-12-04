import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

class BallPane extends Pane {
    private double radius = 20;
    private Circle ball = new Circle(radius, Color.RED);

    public BallPane() {
        // Initial position
        ball.setCenterX(100);
        ball.setCenterY(100);
        getChildren().add(ball);
    }

    public void moveLeft() {
        if (ball.getCenterX() - radius > 0) { // boundary check
            ball.setCenterX(ball.getCenterX() - 10);
        }
    }

    public void moveRight() {
        if (ball.getCenterX() + radius < getWidth()) {
            ball.setCenterX(ball.getCenterX() + 10);
        }
    }

    public void moveUp() {
        if (ball.getCenterY() - radius > 0) {
            ball.setCenterY(ball.getCenterY() - 10);
        }
    }

    public void moveDown() {
        if (ball.getCenterY() + radius < getHeight()) {
            ball.setCenterY(ball.getCenterY() + 10);
        }
    }
}