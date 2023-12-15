package com.algo1.weeks;

import java.util.Arrays;

public class ConvexHull {

    public Stack<Point> getConvexHull(Point[] points) {
        Stack<Point> hull = new Stack<Point>();
        Point lowest_y = points[0];
        for (int i = 1; i < points.length; i++) {
            if ((points[i].getY() < lowest_y.getY())
                    || (points[i].getY() == lowest_y.getY() && points[i].getX() < lowest_y.getX()) )
                lowest_y = points[i];
        }
        for (int i = 0; i < points.length; i++)
            points[i].setComparatorPoint(lowest_y);
        Arrays.sort(points);
        hull.push(points[0]);
        hull.push(points[1]);
        for (int i = 2;  i < points.length; i++) {
            Point top = hull.pop();
            while (!Point.isCCW(hull.peek(), top, points[i]))
                top = hull.pop();
            hull.push(top);
            hull.push(points[i]);
        }
        return hull;
    }
}
