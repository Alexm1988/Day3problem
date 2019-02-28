package Day3;

public class Point {
    int fieldx;
    int fieldy;

    public Point() {
        System.out.println("Constructor with no arguments called");
    }

    public Point(int fieldx, int fieldy) {
        this.fieldx = fieldx;
        this.fieldy = fieldy;
        System.out.println("field value x = " + fieldx + "and value y =" + fieldy);
    }

    public void printX() {
        System.out.println ("field value x = " + this.fieldx);
    }
    public void printY (String textToPrint) {
        System.out.println (textToPrint + this.fieldy);
    }
}
