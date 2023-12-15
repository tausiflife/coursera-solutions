package com.algo1.weeks;

public class Point implements Comparable<Point>{
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    private Point comparePoint;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static boolean isCCW(Point a, Point b, Point c) {
        double area2 = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        return area2 > 0;
    }

    public double getPolarAngle() {
        double arcTan = Math.atan2(y, x);
        return arcTan > 0 ? arcTan : (Math.PI * 2 - arcTan);
    }

    public double getPolarAngle(Point p) {
        double x1 = p.x - x;
        double y1 = p.y - y;
        return new Point(x1, y1).getPolarAngle();
    }

    public void setComparatorPoint(Point p) {
        this.comparePoint = p;
    }

    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point p = (Point) o;
            return p.x == x && p.y == y;
        }
        return false;
    }

    public int compareTo(Point point) {
        if (comparePoint == null)
            comparePoint = new Point(0, 0);
        Double a1 = comparePoint.getPolarAngle(this);
        Double a2 = comparePoint.getPolarAngle(point);
        return a1.compareTo(a2);
    }
}
