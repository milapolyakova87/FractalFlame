package fractalflame.dto;

import fractalflame.model.Variation;
import java.util.List;

public record FractalImageRequest(
    int height,
    int width,
    int iterations,
    int symmetry,
    List<Variation> variations
) {
}
