package fractalflame.utils;

import fractalflame.transformation.Transformation;
import fractalflame.transformation.impl.Bent;
import fractalflame.transformation.impl.Diamond;
import fractalflame.transformation.impl.Disc;
import fractalflame.transformation.impl.Ex;
import fractalflame.transformation.impl.Fisheye;
import fractalflame.transformation.impl.Heart;
import fractalflame.transformation.impl.Hyperbolic;
import fractalflame.transformation.impl.Noise;
import fractalflame.transformation.impl.Sinusoidal;
import fractalflame.transformation.impl.Spherical;
import fractalflame.transformation.impl.Spiral;
import fractalflame.transformation.impl.Swirl;
import java.util.Map;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MapTransformation {
    private static final Map<String, Transformation> TRANSFORMATION_MAP = Map.ofEntries(
        Map.entry("Bent", new Bent()),
        Map.entry("Diamond", new Diamond()),
        Map.entry("Disc", new Disc()),
        Map.entry("Ex", new Ex()),
        Map.entry("Fisheye", new Fisheye()),
        Map.entry("Heart", new Heart()),
        Map.entry("Hyperbolic", new Hyperbolic()),
        Map.entry("Sinusoidal", new Sinusoidal()),
        Map.entry("Spherical", new Spherical()),
        Map.entry("Spiral", new Spiral()),
        Map.entry("Swirl", new Swirl()),
        Map.entry("Noise", new Noise())
    );

    public static Transformation get(String title) {
        return TRANSFORMATION_MAP.get(title);
    }
}
