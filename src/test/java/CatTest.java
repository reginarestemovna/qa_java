import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private static final List<String> EXPECTED_FOOD = List.of("Животные", "Птицы", "Рыба");

    private Cat cat;
    @Mock
    private Feline feline;

    @Before
    public void init() throws Exception {
        cat = new Cat(feline);
        when(feline.eatMeat()).thenReturn(EXPECTED_FOOD);
    }

    @Test
    public void getSound() {
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }

    @Test
    public void getFood() throws Exception {
        List<String> food = cat.getFood();
        assertEquals(EXPECTED_FOOD, food);
        verify(feline).eatMeat();
    }
}
