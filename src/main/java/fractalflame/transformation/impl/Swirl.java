package fractalflame.transformation.impl;

import fractalflame.model.Point;
import fractalflame.transformation.Transformation;

public class Swirl implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = point.distance();
        double r2 = r * r;
        return new Point(
            point.x() * Math.sin(r2) - point.y() * Math.cos(r2),
            point.x() * Math.cos(r2) + point.y() * Math.sin(r2)
        );
    }
}
