package fractalflame;

import fractalflame.constant.Constants;
import fractalflame.core.FractalImageGenerator;
import fractalflame.core.MultiThreadingFractalImageGenerator;
import fractalflame.core.SingleThreadFractalImageGenerator;
import fractalflame.dto.ConfigDto;
import fractalflame.dto.FractalImageRequest;
import fractalflame.enums.ImageFormat;
import fractalflame.factory.HistogramRequestFactory;
import fractalflame.loader.JsonConfigLoader;
import fractalflame.model.FractalImage;
import fractalflame.postprocessing.impl.LogDensity;
import fractalflame.service.FractalFlameService;
import fractalflame.utils.FileNameGenerator;
import fractalflame.utils.ImageUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Path;

public class FractalFlameApi {
    private final JsonConfigLoader configLoader = new JsonConfigLoader(new ObjectMapper());

    public void start() {

        ConfigDto configDto = configLoader.loadConfig(Path.of(Constants.CONFIG_PATH));

        FractalImageRequest fractalImageRequest = HistogramRequestFactory.createFromConfig(configDto);
        ImageFormat format = ImageFormat.valueOfLabel(configDto.format());
        FractalFlameService service =
            new FractalFlameService(fractalGenerator(configDto.threads()), new LogDensity(Constants.GAMMA));

        FractalImage fractalImage = service.createFractalImage(fractalImageRequest);
        fractalImage = service.postProcessing(fractalImage);

        saveImage(fractalImage, Constants.OUTPUT_DIRECTORY, format);
    }

    private FractalImageGenerator fractalGenerator(int threads) {
        return threads == 1
            ? new SingleThreadFractalImageGenerator()
            : new MultiThreadingFractalImageGenerator(threads);
    }

    private void saveImage(FractalImage fractalImage, String outputDirectory, ImageFormat format) {
        ImageUtils.save(fractalImage, Path.of(outputDirectory, FileNameGenerator.dataTimeName()), format);
    }
}
