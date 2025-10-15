package fractalflame.loader;

import fractalflame.dto.ConfigDto;
import fractalflame.exception.JsonLoadException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Path;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JsonConfigLoader {
    private final ObjectMapper mapper;

    public ConfigDto loadConfig(Path path) {
        try {
            return mapper.readValue(path.toFile(), ConfigDto.class);
        } catch (IOException e) {
            throw new JsonLoadException(e.getMessage());
        }
    }
}
