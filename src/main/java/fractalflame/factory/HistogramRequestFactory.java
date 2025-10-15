package fractalflame.factory;

import fractalflame.dto.AffineFunctionDto;
import fractalflame.dto.ConfigDto;
import fractalflame.dto.FractalImageRequest;
import fractalflame.dto.VariationDto;
import fractalflame.exception.IllegalTransformationException;
import fractalflame.model.Variation;
import fractalflame.transformation.Transformation;
import fractalflame.transformation.impl.AffineTransform;
import fractalflame.utils.MapTransformation;
import fractalflame.validator.ConfigValidator;
import fractalflame.validator.VariationValidator;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class HistogramRequestFactory {
    public static FractalImageRequest createFromConfig(ConfigDto config) {
        ConfigValidator.validate(config);

        List<Variation> variations = mapVariations(config.variations(), config.affineFunctions());

        return new FractalImageRequest(config.height(), config.width(), config.iterations(), config.symmetry(),
            variations);
    }

    private static List<Variation> mapVariations(
        List<VariationDto> variationDtos,
        List<AffineFunctionDto> affineFunctionDtos
    ) {
        List<Variation> variations = new ArrayList<>();
        for (var varDto : variationDtos) {
            VariationValidator.validateColor(varDto.color());
            Transformation transformation = getTransformation(varDto.name());
            variations.add(new Variation(
                transformation,
                varDto.weight(),
                Color.decode(varDto.color()))
            );
        }

        for (var funcDto : affineFunctionDtos) {
            VariationValidator.validateColor(funcDto.color());
            variations.add(new Variation(
                new AffineTransform(funcDto.a(), funcDto.b(), funcDto.c(), funcDto.d(), funcDto.e(), funcDto.f()),
                funcDto.weight(),
                Color.decode(funcDto.color())
            ));
        }
        return variations;
    }

    private static Transformation getTransformation(String title) {
        Transformation transformation = MapTransformation.get(title);
        if (transformation == null) {
            throw new IllegalTransformationException(title);
        }
        return transformation;
    }
}
