public class TestColorable {
    public static void main(String[] args) {
        GeometricObject[] objects = new GeometricObject[5];

        objects[0] = new Triangle(3, 4, 5);
        objects[1] = new Triangle(6, 6, 6);
        objects[2] = new Triangle(2, 2, 3);
        objects[3] = new Triangle(4, 4, 5);
        objects[4] = new Triangle(5, 5, 8);

        for (int i = 0; i < objects.length; i++) {
            System.out.println("Object " + (i + 1) + ": " + objects[i].toString());
            System.out.printf("Area: %.2f%n", objects[i].getArea());

            if (objects[i] instanceof Colorable) {
                ((Colorable) objects[i]).howToColor();
            }

            System.out.println();
        }
    }
}
