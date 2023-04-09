import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private static final List<String> EXPECTED_FOOD = List.of("Животные", "Птицы", "Рыба");

    private final String sex;
    private final int kittensCount;
    private final String animalKind;
    private final List<String> foods;
    private final Boolean expectedIsHaveMane;
    private Lion lion;
    private Feline feline;

    public LionParameterizedTest(Boolean expectedIsHaveMane, String sex, int kittensCount, String animalKind, List<String> foods) {
        this.expectedIsHaveMane = expectedIsHaveMane;
        this.sex = sex;
        this.kittensCount = kittensCount;
        this.animalKind = animalKind;
        this.foods = foods;
    }

    @Before
    public void init() throws Exception {
        feline = mock(Feline.class);
        lion = new Lion(sex, feline);
        when(feline.getKittens()).thenReturn(1);
        when(feline.getFood("Хищник")).thenReturn(EXPECTED_FOOD);
    }

    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][]{
                {true, "Самец", 1, "Хищник", EXPECTED_FOOD},
                {false, "Самка", 1, "Хищник", EXPECTED_FOOD},
        };
    }

    @Test
    public void getKittens() {
        int kittens = lion.getKittens();
        assertEquals(kittensCount, kittens);
        verify(feline).getKittens();
    }

    @Test
    public void doesHaveMane() {
        boolean haveMane = lion.doesHaveMane();
        assertEquals(expectedIsHaveMane, haveMane);
    }

    @Test
    public void getFood() throws Exception {
        List<String> food = lion.getFood();
        assertEquals(foods, food);
        verify(feline).getFood(animalKind);
    }
}
