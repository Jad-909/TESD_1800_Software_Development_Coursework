/*
 * Author : Jared Dan
 * Date: 10/14/2025
 * This program is to create a rectagnle
 */
    public class rectangle {
         double width = 1;
        double height = 1;

    rectangle() {
    }

     rectangle(double newWidth, double newHeight) {
        width = newWidth;
        height = newHeight;
    }

    double getArea() {
        return width * height;
    }

    double getPerimeter() {
        return 2 * (width + height);
    }

}