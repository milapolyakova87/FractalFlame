package fractalflame.validator;

import fractalflame.constant.Constants;
import fractalflame.dto.ConfigDto;
import fractalflame.dto.VariationDto;
import fractalflame.exception.EmptyFormatFieldException;
import fractalflame.exception.EmptyVariationListException;
import fractalflame.exception.IllegalIterationsException;
import fractalflame.exception.IllegalNumThreadsException;
import fractalflame.exception.IllegalSizeException;
import fractalflame.exception.IllegalSymmetryException;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ConfigValidator {
    public static void validate(ConfigDto configDto) {
        valildateThreads(configDto.threads());
        validateSize(configDto.height(), configDto.width());
        validateIterations(configDto.iterations());
        validateSymmetry(configDto.symmetry());
        validateVariations(configDto.variations());
        validateFormat(configDto.format());
    }

    private static void valildateThreads(int threads) {
        if (threads < 1) {
            throw new IllegalNumThreadsException(threads);
        }
    }

    private static void validateSize(int height, int width) {
        if (height <= 0 || width <= 0) {
            throw new IllegalSizeException(height, width);
        }
    }

    private static void validateIterations(int iterations) {
        if (iterations <= Constants.WARMUP_ITERATIONS) {
            throw new IllegalIterationsException(iterations);
        }
    }

    private static void validateSymmetry(int symmetry) {
        if (symmetry <= 0) {
            throw new IllegalSymmetryException(symmetry);
        }
    }

    private static void validateVariations(List<VariationDto> variationDtos) {
        if (variationDtos == null || variationDtos.isEmpty()) {
            throw new EmptyVariationListException();
        }
    }

    private static void validateFormat(String name) {
        if (name == null || name.isBlank()) {
            throw new EmptyFormatFieldException();
        }
    }
}
