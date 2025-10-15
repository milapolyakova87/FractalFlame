package fractalflame.validator;

import fractalflame.validator.VariationValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import fractalflame.exception.InvalidColorValueException;

class VariationValidatorTest {

    @Test
    void isValidHexColor_validHexColor_true() {
        assertTrue(VariationValidator.isValidHexColor("#FFFFFF"));
    }

    @Test
    void isValidHexColor_validShortHexColor_true() {
        assertTrue(VariationValidator.isValidHexColor("#FFF"));
    }

    @Test
    void isValidHexColor_nullHexColor_false() {
        assertFalse(VariationValidator.isValidHexColor(null));
    }

    @Test
    void isValidHexColor_emptyString_false() {
        assertFalse(VariationValidator.isValidHexColor(""));
    }

    @Test
    void isValidHexColor_invalidHexColor_false() {
        assertFalse(VariationValidator.isValidHexColor("#ZZZZZZ"));
    }

    @Test
    void validateColor_validHexColor_NotThrowException() {
        assertDoesNotThrow(() -> VariationValidator.validateColor("#FFFFFF"));
    }

    @Test
    void validateColor_invalidHexColor_throwsInvalidColorValueException() {
        assertThrows(InvalidColorValueException.class, () -> VariationValidator.validateColor("#ZZZZZZ"));
    }
}
