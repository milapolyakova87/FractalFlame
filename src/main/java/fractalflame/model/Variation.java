package fractalflame.model;

import fractalflame.transformation.Transformation;
import java.awt.Color;
import java.util.Objects;

public record Variation(
    Transformation transformation,
    double weight,
    Color color
) {

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Variation variation = (Variation) o;

        if (Double.compare(weight, variation.weight) != 0) {
            return false;
        }
        if (!transformation.getClass().equals(variation.transformation.getClass())) {
            return false;
        }
        return Objects.equals(color, variation.color);
    }

    @Override
    public int hashCode() {
        int result;
        result = transformation.hashCode();
        result = 31 * result + Double.hashCode(weight);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
