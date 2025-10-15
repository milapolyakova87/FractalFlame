package fractalflame.transformation.impl;

import fractalflame.model.Point;
import fractalflame.transformation.Transformation;

public class Fisheye implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = point.distance();
        return new Point(2 * point.y() / (r + 1), 2 * point.x() / (r + 1));
    }
}
