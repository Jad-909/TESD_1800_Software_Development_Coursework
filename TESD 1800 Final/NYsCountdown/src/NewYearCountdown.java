import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class NewYearCountdown extends Application {

    @Override
    public void start(Stage primaryStage) {

        // --- Root container ---
        BorderPane root = new BorderPane();

        // --- Background Image (Liang textbook style) ---
        Image background = new Image("file:nyball.jpg");

        BackgroundImage bgImage = new BackgroundImage(
                background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(
                        BackgroundSize.AUTO, BackgroundSize.AUTO,
                        false, false, true, true
                )
        );

        root.setBackground(new Background(bgImage));

        // --- Bottom semi-transparent bar ---
        StackPane bottomBar = new StackPane();
        bottomBar.setPrefHeight(90);
        bottomBar.setStyle("-fx-background-color: rgba(0, 0, 0, 0.55);");

        // --- Countdown text ---
        Text countdownText = new Text();
        countdownText.setFill(Color.WHITE);
        countdownText.setFont(Font.font("Arial", 34));
        countdownText.setTranslateY(-4); // Slight upward shift

        bottomBar.getChildren().add(countdownText);
        StackPane.setAlignment(countdownText, Pos.CENTER);

        root.setBottom(bottomBar);

        // --- Live countdown timeline ---
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                    countdownText.setText(getCountdownString());
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // Initial text set
        countdownText.setText(getCountdownString());

        // --- Scene setup ---
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("New Year Countdown");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // --- Time calculation ---
    private String getCountdownString() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextNY = LocalDateTime.of(now.getYear() + 1, 1, 1, 0, 0, 0);

        long totalSeconds = ChronoUnit.SECONDS.between(now, nextNY);
        long days = totalSeconds / (24 * 3600);
        long hours = (totalSeconds % (24 * 3600)) / 3600;
        long minutes = (totalSeconds % 3600) / 60;
        long seconds = totalSeconds % 60;

        return String.format(
                "Happy New Year in: %d days %02d:%02d:%02d",
                days, hours, minutes, seconds
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}
