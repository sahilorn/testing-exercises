package designPatterns;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;

public class FlyweighDesignPattern {

    public interface Shape {

        public void draw(Graphics g, int x, int y, int width, int height,
                Color color);
    }


    public static class Line implements Shape {

        public Line() {
            System.out.println("Creating Line object");
            //adding time delay
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void draw(Graphics line, int x1, int y1, int x2, int y2,
                Color color) {
            line.setColor(color);
            line.drawLine(x1, y1, x2, y2);
        }

    }

    public static class Oval implements Shape {

        //intrinsic property
        private boolean fill;

        public Oval(boolean f) {
            this.fill = f;
            System.out.println("Creating Oval object with fill=" + f);
            //adding time delay
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void draw(Graphics circle, int x, int y, int width, int height,
                Color color) {
            circle.setColor(color);
            circle.drawOval(x, y, width, height);
            if (fill) {
                circle.fillOval(x, y, width, height);
            }
        }

    }


    public static class ShapeFactory {

        private static final HashMap<ShapeType, Shape> shapes = new HashMap<ShapeType, Shape>();

        public static Shape getShape(ShapeType type) {
            Shape shapeImpl = shapes.get(type);

            if (shapeImpl == null) {
                if (type.equals(ShapeType.OVAL_FILL)) {
                    shapeImpl = new Oval(true);
                } else if (type.equals(ShapeType.OVAL_NOFILL)) {
                    shapeImpl = new Oval(false);
                } else if (type.equals(ShapeType.LINE)) {
                    shapeImpl = new Line();
                }
                shapes.put(type, shapeImpl);
            }
            return shapeImpl;
        }

        public enum ShapeType {
            OVAL_FILL, OVAL_NOFILL, LINE;
        }
    }
}
