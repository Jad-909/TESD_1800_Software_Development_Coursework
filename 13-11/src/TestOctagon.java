public class TestOctagon {
    public static void main(String[] args) {
        Octagon octagon1 = new Octagon(5);
        System.out.println("Octagon 1: " + octagon1);

        Octagon octagon2 = (Octagon) octagon1.clone();
        System.out.println("Octagon 2 (clone): " + octagon2);

        int result = octagon1.compareTo(octagon2);

        if (result == 0)
            System.out.println("The two octagons are equal in area.");
        else if (result > 0)
            System.out.println("Octagon 1 is larger than Octagon 2.");
        else
            System.out.println("Octagon 1 is smaller than Octagon 2.");
    }
}
