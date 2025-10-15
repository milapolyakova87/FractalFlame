package fractalflame.validator;

import fractalflame.dto.AffineFunctionDto;
import fractalflame.dto.ConfigDto;
import fractalflame.dto.VariationDto;
import fractalflame.exception.EmptyFormatFieldException;
import fractalflame.exception.EmptyVariationListException;
import fractalflame.exception.IllegalIterationsException;
import fractalflame.exception.IllegalNumThreadsException;
import fractalflame.exception.IllegalSizeException;
import fractalflame.exception.IllegalSymmetryException;
import java.util.List;

import fractalflame.validator.ConfigValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConfigValidatorTest {

    @Test
    void validate_validConfig_doesNotThrowException() {
        // Arrange
        ConfigDto configDto = new ConfigDto(4, 800, 600, 1000, 2,
            List.of(new VariationDto("Heart", 2, "#FFFFFF")),
            List.of(new AffineFunctionDto(0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 2, "#FFFFFF")),
            "png");

        // Act & Assert
        assertDoesNotThrow(() -> ConfigValidator.validate(configDto));
    }

    @Test
    void validate_threadsLessThanOne_throwsIllegalNumThreadsException() {
        // Arrange
        ConfigDto configDto = new ConfigDto(0, 800, 600, 1000, 2,
            List.of(new VariationDto("Heart", 2, "#FFFFFF")),
            List.of(new AffineFunctionDto(0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 2, "#FFFFFF")),
            "png");

        // Act & Assert
        assertThrows(IllegalNumThreadsException.class, () -> ConfigValidator.validate(configDto));
    }

    @Test
    void validate_nonPositiveHeight_throwsIllegalSizeException() {
        // Arrange
        ConfigDto configDto = new ConfigDto(4, 0, 600, 1000, 2,
            List.of(new VariationDto("Heart", 2, "#FFFFFF")),
            List.of(new AffineFunctionDto(0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 2, "#FFFFFF")),
            "png");

        // Act & Assert
        assertThrows(IllegalSizeException.class, () -> ConfigValidator.validate(configDto));
    }

    @Test
    void validate_nonPositiveWidth_throwsIllegalSizeException() {
        // Arrange
        ConfigDto configDto = new ConfigDto(4, 800, 0, 1000, 2,
            List.of(new VariationDto("Heart", 2, "#FFFFFF")),
            List.of(new AffineFunctionDto(0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 2, "#FFFFFF")),
            "png");

        // Act & Assert
        assertThrows(IllegalSizeException.class, () -> ConfigValidator.validate(configDto));
    }

    @Test
    void validate_iterationsLessThanWarmup_throwsIllegalIterationsException() {
        // Arrange
        ConfigDto configDto = new ConfigDto(4, 800, 600, 10, 2,
            List.of(new VariationDto("Heart", 2, "#FFFFFF")),
            List.of(new AffineFunctionDto(0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 2, "#FFFFFF")),
            "png");

        // Act & Assert
        assertThrows(IllegalIterationsException.class, () -> ConfigValidator.validate(configDto));
    }

    @Test
    void validate_nonPositiveSymmetry_throwsIllegalSymmetryException() {
        // Arrange
        ConfigDto configDto = new ConfigDto(4, 800, 600, 1000, 0,
            List.of(new VariationDto("Heart", 2, "#FFFFFF")),
            List.of(new AffineFunctionDto(0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 2, "#FFFFFF")),
            "png");

        // Act & Assert
        assertThrows(IllegalSymmetryException.class, () -> ConfigValidator.validate(configDto));
    }

    @Test
    void validate_nullVariationList_throwsEmptyVariationListException() {
        // Arrange
        ConfigDto configDto = new ConfigDto(4, 800, 600, 1000, 2,
            null,
            List.of(new AffineFunctionDto(0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 2, "#FFFFFF")),
            "png");

        // Act & Assert
        assertThrows(EmptyVariationListException.class, () -> ConfigValidator.validate(configDto));
    }

    @Test
    void validate_emptyVariationList_throwsEmptyVariationListException() {
        // Arrange
        ConfigDto configDto = new ConfigDto(4, 800, 600, 1000, 2,
            List.of(),
            List.of(new AffineFunctionDto(0.1, 0.2, 0.3, 0.4, 0.5, 0.6,2, "#FFFFFF")),
            "png");

        // Act & Assert
        assertThrows(EmptyVariationListException.class, () -> ConfigValidator.validate(configDto));
    }

    @Test
    void validate_nullFormat_throwsEmptyFormatFieldException() {
        // Arrange
        ConfigDto configDto = new ConfigDto(4, 800, 600, 1000, 2,
            List.of(new VariationDto("Heart", 2, "#FFFFFF")),
            List.of(new AffineFunctionDto(0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 2, "#FFFFFF")),
            null);

        // Act & Assert
        assertThrows(EmptyFormatFieldException.class, () -> ConfigValidator.validate(configDto));
    }

    @Test
    void validate_blankFormat_throwsEmptyFormatFieldException() {
        // Arrange
        ConfigDto configDto = new ConfigDto(4, 800, 600, 1000, 2,
            List.of(new VariationDto("Heart", 2, "#FFFFFF")),
            List.of(new AffineFunctionDto(0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 2, "#FFFFFF")),
            " ");

        // Act & Assert
        assertThrows(EmptyFormatFieldException.class, () -> ConfigValidator.validate(configDto));
    }
}
