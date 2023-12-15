import edu.princeton.cs.algs4.MergeX;

public class BruteCollinearPoints {
    private int numberOfLineSegment = 0;
    private final LineSegment[] lineSegments;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        checkForNullPoints(points);
        Point[] p = new Point[points.length];
        System.arraycopy(points, 0, p, 0, points.length);
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

    private LineSegment[] findCollinearPointsAndSetLineSegments(Point[] points) {
        LineSegment[] tempSegments = new LineSegment[points.length * 4];
        MergeX.sort(points);
        for (int p = 0; p < points.length; p++) {
            Point pointP = points[p];
            for (int q = p + 1; q < points.length; q++) {
                Point pointQ = points[q];
                if (pointP.equals(pointQ)) {
                    throw new IllegalArgumentException("Repeated points.");
                }
                for (int r = q + 1; r < points.length; r++) {
                    Point pointR = points[r];
                    if (pointP.equals(pointQ) || pointP.equals(pointR) || pointQ.equals(pointR)) {
                        throw new IllegalArgumentException("Repeated points.");
                    }
                    for (int s = r + 1; s < points.length; s++) {
                        Point pointS = points[s];
                        if (isAnyPointRepeated(pointP, pointQ, pointR, pointS)) {
                            throw new IllegalArgumentException("Repeated points.");
                        }
                        if (areSlopesEqualBetweenFourPoints(pointP, pointQ, pointR, pointS)) {
                            tempSegments[numberOfLineSegment++] = new LineSegment(pointP, pointS);
                        }
                    }
                }
            }
        }
        LineSegment[] returnSegments = new LineSegment[numberOfLineSegment];
        for (int i = 0; i < numberOfLineSegment; i++) {
            returnSegments[i] = tempSegments[i];
        }
        return returnSegments;
    }

    private boolean isAnyPointRepeated(Point pointP, Point pointQ, Point pointR, Point pointS) {
        return pointP.equals(pointQ) || pointP.equals(pointR) || pointP.equals(pointS)
                || pointQ.equals(pointR) || pointQ.equals(pointS) || pointR.equals(pointS);
    }


    private boolean areSlopesEqualBetweenFourPoints(Point pointP, Point pointQ, Point pointR, Point pointS) {
        return Double.compare(pointP.slopeTo(pointQ), pointP.slopeTo(pointR)) == 0
                && Double.compare(pointP.slopeTo(pointQ), pointP.slopeTo(pointS)) == 0;
    }

    // the number of line segments
    public int numberOfSegments() {
        return numberOfLineSegment;
    }

    // the line segments
    public LineSegment[] segments() {
        LineSegment[] returnSegments = new LineSegment[lineSegments.length];
        for (int i = 0; i < lineSegments.length; i++) {
            returnSegments[i] = lineSegments[i];
        }
        return returnSegments;
    }
}
