package fractalflame.transformation.impl;

import fractalflame.model.Point;
import fractalflame.transformation.Transformation;

public class Spherical implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = point.distance();
        double r2 = r * r;
        return new Point(point.x() / r2, point.y() / r2);
    }
}
