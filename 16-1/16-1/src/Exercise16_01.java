import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise16_01 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane centerPane = new Pane();
        centerPane.setStyle("-fx-background-color: white;");

        Text text = new Text("Programming is fun");
        text.setFont(Font.font(36));
        text.setFill(Color.ORANGE);

        text.setX(20);
        text.setY(60); 

        centerPane.getChildren().add(text);

        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbBlack = new RadioButton("Black");
        RadioButton rbOrange = new RadioButton("Orange");
        RadioButton rbGreen = new RadioButton("Green");

        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbYellow.setToggleGroup(group);
        rbBlack.setToggleGroup(group);
        rbOrange.setToggleGroup(group);
        rbGreen.setToggleGroup(group);

        rbOrange.setSelected(true);

        rbRed.setOnAction(e -> text.setFill(Color.RED));
        rbYellow.setOnAction(e -> text.setFill(Color.YELLOW));
        rbBlack.setOnAction(e -> text.setFill(Color.BLACK));
        rbOrange.setOnAction(e -> text.setFill(Color.ORANGE));
        rbGreen.setOnAction(e -> text.setFill(Color.GREEN));

        HBox top = new HBox(10, rbRed, rbYellow, rbBlack, rbOrange, rbGreen);
        top.setAlignment(Pos.CENTER);

        Button btLeft = new Button("<=");
        Button btRight = new Button("=>");

        HBox bottom = new HBox(10, btLeft, btRight);
        bottom.setAlignment(Pos.CENTER);

        BorderPane pane = new BorderPane();
        pane.setTop(top);
        pane.setBottom(bottom);
        pane.setCenter(centerPane);

        btLeft.setOnAction(e -> {
            double newX = text.getX() - 10;
            if (newX >= 0) {
                text.setX(newX);
            } else {
                text.setX(0);
            }
        });

        btRight.setOnAction(e -> {
            double rightEdge = text.getX() + text.getLayoutBounds().getWidth();
            double maxX = centerPane.getWidth();
            if (rightEdge + 10 <= maxX) {
                text.setX(text.getX() + 10);
            } else {
                text.setX(Math.max(0, maxX - text.getLayoutBounds().getWidth()));
            }
        });

        Scene scene = new Scene(pane, 800, 220);
        primaryStage.setTitle("Exercise16_01 - Fixed");
        primaryStage.setScene(scene);
        primaryStage.show();

        centerPane.widthProperty().addListener((obs, oldW, newW) -> {
            double rightEdge = text.getX() + text.getLayoutBounds().getWidth();
            if (rightEdge > newW.doubleValue()) {
                text.setX(Math.max(0, newW.doubleValue() - text.getLayoutBounds().getWidth()));
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
