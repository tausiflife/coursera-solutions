import edu.princeton.cs.algs4.MergeX;

public class FastCollinearPoints {
    private int numberOfLineSegment = 0;
    private final LineSegment[] lineSegments;

    public FastCollinearPoints(Point[] points) {
        checkForNullPoints(points);
        Point[] p = new Point[points.length];
        System.arraycopy(points, 0, p, 0, points.length);
        MergeX.sort(p);
        checkForDuplicates(p);
        lineSegments = findCollinearPointsAndSetLineSegments(p);
    }

    private void checkForNullPoints(Point[] points) {
        if (points == null)
            throw new IllegalArgumentException("Argument is null");

        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException("Point is null");
            }
        }
    }

    private boolean checkForDuplicates(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) {
                throw new IllegalArgumentException("Duplicates");
            }
        }
        return false;
    }
    private LineSegment[] findCollinearPointsAndSetLineSegments(Point[] points) {
        LineSegment[] tmpSegments = new LineSegment[points.length * 4];
        for (int i = 0; i < points.length; i++) {
            Point p = points[i];
            MergeX.sort(points, p.slopeOrder());
            for (int first = 1, last = 2; last < points.length; last++) {
                while (last < points.length && Double.compare(p.slopeTo(points[first]), p.slopeTo(points[last])) == 0) {
                    last++;
                }
                if (last - first >= 3) {
                    tmpSegments[numberOfLineSegment++] = new LineSegment(p, points[last - 1]);
                }
                first = last;
            }
        }

        LineSegment[] realSegments = new LineSegment[numberOfLineSegment];
        for (int i = 0; i < numberOfLineSegment; i++) {
            realSegments[i] = tmpSegments[i];
        }
        return realSegments;
    }

    public int numberOfSegments() {
        return numberOfLineSegment;
    }

    public LineSegment[] segments() {
        LineSegment[] returnSegments = new LineSegment[lineSegments.length];
        System.arraycopy(lineSegments, 0, returnSegments, 0, lineSegments.length);
        return returnSegments;
    }
}
