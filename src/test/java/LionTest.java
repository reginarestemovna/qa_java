import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private static final String EXPECTED_ERROR = "Используйте допустимые значения пола животного - самей или самка";

    @Mock
    private Feline feline;

    @Test
    public void doesHaveManeException() {
        try {
            new Lion("Тест", feline);
        } catch (Exception e) {
            assertEquals(EXPECTED_ERROR, e.getMessage());
        }
    }
}
