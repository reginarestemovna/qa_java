import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private Cat cat;
    @Mock
    private Feline feline;

    @Before
    public void init() {
        cat = new Cat(feline);
    }

    @Test
    public void getSound() {
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }

    @Test
    public void getFood() throws Exception {
        cat.getFood();
        verify(feline).eatMeat();
    }
}
