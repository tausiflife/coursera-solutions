package com.algo1.weeks;

public class Point2D implements Comparable<Point2D> {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Point2D) {
            Point2D p = (Point2D) o;
            return this.x == p.x && this.y == p.y;
        }
        return false;
    }

    @Override
    public int compareTo(Point2D b) {
        int xResult = ((Double) this.x).compareTo((Double) b.x);
        return xResult != 0 ? xResult : ((Double) this.y).compareTo((Double) b.y);
    }
}
