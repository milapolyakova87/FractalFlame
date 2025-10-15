package fractalflame.transformation.impl;

import fractalflame.model.Point;
import fractalflame.transformation.Transformation;

public class Diamond implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = point.distance();
        double theta = point.theta();
        return new Point(Math.sin(theta) * Math.cos(r), Math.cos(theta) * Math.sin(r));
    }
}
