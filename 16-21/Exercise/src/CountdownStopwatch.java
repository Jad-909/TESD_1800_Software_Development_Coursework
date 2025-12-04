import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class CountdownStopwatch extends Application {

    private int remainingSeconds;
    private Timeline animation;
    private MediaPlayer mediaPlayer;

    @Override
    public void start(Stage primaryStage) {
        TextField textField = new TextField();
        textField.setStyle("-fx-font-size: 40px; -fx-alignment: center;");
        
        StackPane pane = new StackPane(textField);

        textField.setOnAction(e -> {
            try {
                remainingSeconds = Integer.parseInt(textField.getText());

                if (animation != null) animation.stop();

                animation = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
                    remainingSeconds--;
                    textField.setText(remainingSeconds + "");

                    if (remainingSeconds <= 0) {
                        animation.stop();
                        playMusic();
                    }
                }));

                animation.setCycleCount(remainingSeconds);
                animation.play();
            }
            catch (NumberFormatException ex) {
                textField.setText("Enter number");
            }
        });

        Scene scene = new Scene(pane, 250, 120);
        primaryStage.setTitle("Exercise16_21");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void playMusic() {
        try {
            String url = "https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3";
            Media media = new Media(url);
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
        } catch (Exception ex) {
            System.out.println("Error playing media: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
