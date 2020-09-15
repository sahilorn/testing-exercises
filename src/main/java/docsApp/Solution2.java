package docsApp;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

class Point {

    private double x;
    private double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static double distance(Point p1, Point p2) {

        return Math.sqrt(
                Math.pow(p2.getY() - p1.getY(), 2) +
                        Math.pow(p2.getX() - p1.getX(), 2)
        );
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}

class Line {

    private Point start = new Point(0, 0);
    private Point end = new Point(0, 0);

    Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public double getLineLength() {
        return Point.distance(start, end);
    }

    public String toString() {
        return "Start: " + this.start + " End: " + this.end;
    }
}

interface ListOfLines {

    Vector<Line> getLinesFromStartingPoint(Point p);

    Line getLineWithMaxLength();

    Vector<Line> list_of_lines = null;
}

class LineList implements ListOfLines {

    private Vector<Line> lines;

    public LineList(Vector<Line> lines) {
        this.lines = lines;
    }

    @Override
    public Vector<Line> getLinesFromStartingPoint(Point p) {
        Vector<Line> lines2 = new Vector<Line>();
        for(Line line:lines){
            if(line.getStart().getX() == p.getX() && line.getStart().getY() == p.getY()){
                lines2.add(line);
            }
        }
        return  lines2;
    }

    @Override
    public Line getLineWithMaxLength() {
        double maxLength = 0;
        Line maxLine = null;
        for (Line line : lines) {
            double length = Math.sqrt(Math.pow((line.getStart().getX() - line.getEnd().getX()), 2) + Math
                    .pow((line.getStart().getY() - line.getEnd().getY()), 2));
            if(length > maxLength){
                maxLength = length;
                maxLine = line;
            }
        }
        return maxLine;
    }
}

public class Solution2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        String[] input;
        Scanner sc = new Scanner(System.in);
        String sub = sc.nextLine();
        int nLines = Integer.parseInt(sub);
        Vector<Line> lines = new Vector<Line>();
        for (int i = 0; i < nLines; i++) {
            input = sc.nextLine().split(" ");
            /* x1 y1 x2 y2 */
            double x1 = Double.parseDouble(input[0]);
            double y1 = Double.parseDouble(input[1]);
            double x2 = Double.parseDouble(input[2]);
            double y2 = Double.parseDouble(input[3]);

            Point p1 = new Point(x1, y1);
            Point p2 = new Point(x2, y2);
            Line line = new Line(p1, p2);
            lines.add(line);
        }

        /* Input to find all the line starting from point p1 */
        input = sc.nextLine().split(" ");
        double point_x1 = Double.parseDouble(input[0]);
        double point_y1 = Double.parseDouble(input[1]);
        Point startingPoint = new Point(point_x1, point_y1);

        /* Finding Longest Line*/
        LineList myList = new LineList(lines);
        Line maxLine = myList.getLineWithMaxLength();
        System.out.println("Longest Line --> " + maxLine);
        double length = maxLine.getLineLength();
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("Length: " + (String) df.format(length));

        /* Finding all the lines starting from point startingPoint */
        Vector<Line> starting_lines = myList.getLinesFromStartingPoint(startingPoint);
        System.out.println("All the Lines starting from point: " + startingPoint);
        for (Line starting_line : starting_lines) {
            System.out.println(starting_line);
        }
    }
}
