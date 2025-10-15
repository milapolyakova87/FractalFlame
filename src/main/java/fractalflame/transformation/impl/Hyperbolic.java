package fractalflame.transformation.impl;

import fractalflame.model.Point;
import fractalflame.transformation.Transformation;

public class Hyperbolic implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = point.distance();
        double theta = point.theta();
        return new Point(Math.sin(theta) / r, r * Math.cos(theta));
    }
}
