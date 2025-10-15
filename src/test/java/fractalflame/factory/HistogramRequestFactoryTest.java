package fractalflame.factory;

import fractalflame.dto.AffineFunctionDto;
import fractalflame.dto.ConfigDto;
import fractalflame.dto.FractalImageRequest;
import fractalflame.dto.VariationDto;
import fractalflame.exception.IllegalTransformationException;
import fractalflame.factory.HistogramRequestFactory;
import fractalflame.model.Variation;
import fractalflame.transformation.impl.AffineTransform;
import fractalflame.transformation.impl.Heart;
import java.awt.Color;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HistogramRequestFactoryTest {
    @Test
    void createFromConfig_validConfig_returnsFractalImageRequest() {
        // Arrange
        ConfigDto config = new ConfigDto(4, 800, 600, 1000, 2,
            List.of(new VariationDto("Heart", 1.0, "#FFFFFF")),
            List.of(new AffineFunctionDto(0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 2, "#FFFFFF")),
            "png");

        FractalImageRequest expectedRequest = new FractalImageRequest(800, 600, 1000, 2,
            List.of(new Variation(new Heart(), 1.0, Color.decode("#FFFFFF")),
                new Variation(new AffineTransform(0.1, 0.2, 0.3, 0.4, 0.5, 0.6), 2, Color.decode("#FFFFFF")))
        );
        // Act
        FractalImageRequest actualRequest = HistogramRequestFactory.createFromConfig(config);

        // Assert
        assertEquals(expectedRequest, actualRequest);
    }

    @Test
    void createFromConfig_invalidTransformation_throwsIllegalTransformationException() {
        // Arrange
        ConfigDto config = new ConfigDto(4, 800, 600, 1000, 2,
            List.of(new VariationDto("invalid", 1.0, "#FFFFFF")),
            List.of(),
            "png");

        // Act & Assert
        assertThrows(IllegalTransformationException.class, () -> HistogramRequestFactory.createFromConfig(config));
    }
}
