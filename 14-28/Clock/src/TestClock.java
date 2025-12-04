import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestClock extends Application {

    @Override
    public void start(Stage stage) {
        int hour = (int)(Math.random() * 12);
        int minute = Math.random() < 0.5 ? 0 : 30;

        ClockPane clock = new ClockPane(hour, minute, 0);

        clock.setSecondHandVisible(false);  // Hide seconds
        clock.setHourHandVisible(true);
        clock.setMinuteHandVisible(true);

        Scene scene = new Scene(clock, 300, 300);
        stage.setScene(scene);
        stage.setTitle("Random Clock — Only Hour & Minute Hands Visible");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}