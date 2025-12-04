import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PentagonAnimation extends Application {

    @Override
    public void start(Stage primaryStage) {
        AnimationPane pane = new AnimationPane();

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Rectangle on a Pentagon Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class AnimationPane extends Pane {

    private Polygon pentagon = new Polygon();
    private Rectangle rect = new Rectangle(30, 20, Color.BLUE);

    private Timeline animation;

    private int index = 0;
    private double opacity = 1;
    private boolean fadeOut = true;

    public AnimationPane() {

        
        drawPentagon();

        
        rect.setX( pentagon.getPoints().get(0) - rect.getWidth() / 2 );
        rect.setY( pentagon.getPoints().get(1) - rect.getHeight() / 2 );

        getChildren().addAll(pentagon, rect);
       
        animation = new Timeline(new KeyFrame(Duration.millis(20), e -> moveRect()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY)
                animation.play();
            else if (e.getButton() == MouseButton.SECONDARY)
                animation.pause();
        });
    }

    private void drawPentagon() {
        double centerX = 250;
        double centerY = 250;
        double radius = 150;

        ObservableList<Double> list = pentagon.getPoints();

        for (int i = 0; i < 5; i++) {
            list.add(centerX + radius * Math.cos(2 * Math.PI * i / 5 - Math.PI / 2));
            list.add(centerY + radius * Math.sin(2 * Math.PI * i / 5 - Math.PI / 2));
        }

        pentagon.setFill(Color.TRANSPARENT);
        pentagon.setStroke(Color.BLACK);
    }

    private void moveRect() {
        ObservableList<Double> pts = pentagon.getPoints();

        double x1 = pts.get(index * 2);
        double y1 = pts.get(index * 2 + 1);

        int nextIndex = (index + 1) % 5;
        double x2 = pts.get(nextIndex * 2);
        double y2 = pts.get(nextIndex * 2 + 1);

        double dx = (x2 - x1) / 60;
        double dy = (y2 - y1) / 60;

        rect.setX(rect.getX() + dx);
        rect.setY(rect.getY() + dy);

        if (fadeOut) {
            opacity -= 0.01;
            if (opacity <= 0.3) fadeOut = false;
        } else {
            opacity += 0.01;
            if (opacity >= 1.0) fadeOut = true;
        }
        rect.setOpacity(opacity);

        if (Math.hypot(rect.getX() + rect.getWidth() / 2 - x2,
                       rect.getY() + rect.getHeight() / 2 - y2) < 3) {
            index = nextIndex;
        }
    }
}
