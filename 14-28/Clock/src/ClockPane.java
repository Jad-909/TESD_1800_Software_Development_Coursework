import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.shape.Circle;

public class ClockPane extends Pane {
    private int hour;
    private int minute;
    private int second;

    private boolean hourHandVisible = true;
    private boolean minuteHandVisible = true;
    private boolean secondHandVisible = true;

    public ClockPane() {
        setCurrentTime();
    }

    public ClockPane(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        paintClock();
    }

    public void setCurrentTime() {
        Calendar calendar = new GregorianCalendar();
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
        paintClock();
    }

    public int getHour() { return hour; }
    public int getMinute() { return minute; }
    public int getSecond() { return second; }

    public void setHourHandVisible(boolean v) {
        hourHandVisible = v;
        paintClock();
    }

    public void setMinuteHandVisible(boolean v) {
        minuteHandVisible = v;
        paintClock();
    }

    public void setSecondHandVisible(boolean v) {
        secondHandVisible = v;
        paintClock();
    }

    public boolean isHourHandVisible() { return hourHandVisible; }
    public boolean isMinuteHandVisible() { return minuteHandVisible; }
    public boolean isSecondHandVisible() { return secondHandVisible; }

    private void paintClock() {
        double clockRadius = Math.min(getWidth(), getHeight()) * 0.4;
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;

        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        Text t12 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
        Text t3 = new Text(centerX + clockRadius - 10, centerY + 5, "3");
        Text t6 = new Text(centerX - 3, centerY + clockRadius - 3, "6");
        Text t9 = new Text(centerX - clockRadius + 3, centerY + 5, "9");

        // SECOND HAND
        Line sLine = null;
        if (secondHandVisible) {
            double sLength = clockRadius * 0.8;
            double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
            double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
            sLine = new Line(centerX, centerY, secondX, secondY);
            sLine.setStroke(Color.RED);
        }

        // MINUTE HAND
        Line mLine = null;
        if (minuteHandVisible) {
            double mLength = clockRadius * 0.65;
            double minuteX = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
            double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
            mLine = new Line(centerX, centerY, minuteX, minuteY);
            mLine.setStroke(Color.BLUE);
        }

        // HOUR HAND
        Line hLine = null;
        if (hourHandVisible) {
            double hLength = clockRadius * 0.5;
            double hourAngle = (hour % 12 + minute / 60.0) * (2 * Math.PI / 12);
            double hourX = centerX + hLength * Math.sin(hourAngle);
            double hourY = centerY - hLength * Math.cos(hourAngle);
            hLine = new Line(centerX, centerY, hourX, hourY);
            hLine.setStroke(Color.GREEN);
        }

        getChildren().clear();
        getChildren().add(circle);
        getChildren().addAll(t12, t3, t6, t9);
        if (hLine != null) getChildren().add(hLine);
        if (mLine != null) getChildren().add(mLine);
        if (sLine != null) getChildren().add(sLine);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paintClock();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paintClock();
    }
}
