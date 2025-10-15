package fractalflame.transformation.impl;

import fractalflame.model.Point;
import fractalflame.transformation.Transformation;

public class Bent implements Transformation {
    @Override
    public Point apply(Point point) {
        double newX = point.x() >= 0 ? point.x() : 2 * point.x();
        double newY = point.y() >= 0 ? point.y() : point.y() / 2;
        return new Point(newX, newY);
    }
}
