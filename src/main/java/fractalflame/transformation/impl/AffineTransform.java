package fractalflame.transformation.impl;

import fractalflame.model.Point;
import fractalflame.transformation.Transformation;

public record AffineTransform(double a, double b, double c, double d, double e, double f) implements Transformation {
    @Override
    public Point apply(Point p) {
        double x = a * p.x() + b * p.y() + e;
        double y = c * p.x() + d * p.y() + f;
        return new Point(x, y);
    }
}
