import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EncodeConsonantsTests {
    @Test
    public void testEncodeConsonants() {
        EncodeConsonants encodeConsonants = new EncodeConsonants();
        String encoded = encodeConsonants.encode("hello world");
        assertEquals("jemmo xosmf", encoded);
    }

    @Test
    public void testSUbStr() {
        EncodeConsonants encodeConsonants = new EncodeConsonants();

        String subSrt = encodeConsonants.findSubstr("abababababab");
        assertEquals("ababab", subSrt);
    }
}
