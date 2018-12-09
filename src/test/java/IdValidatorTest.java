import Validator.IdValidatorClass;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class IdValidatorTest {

    @Test
    @Parameters({"AB, false",
            "ABC123456, false",
            "AP22086771, false",
            "123456789, false",
            "1PM096771, false"})
    public void IncorrectIdValidatorTest(String id, boolean expectedValidation) {
        IdValidatorClass idValidator = new IdValidatorClass(id);
        assertEquals(expectedValidation, idValidator.validator());
    }

    @Test
    @Parameters({"APM086771, true",
            "TUU771990, true",
            "GAK154750, true",
            "DUZ357797, true",
            "GNW125221, true",
            "MFO561397, true"})
    public void CorrectIdValidatorTest(String id, boolean expectedValidation) {
        IdValidatorClass idValidator = new IdValidatorClass(id);
        assertEquals(expectedValidation, idValidator.validator());
    }
}
