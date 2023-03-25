import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final int kittensCount;
    private final Boolean expected;
    private final String animalKind;
    private final List<String> foods;
    private Lion lion;
    private Feline feline;

    public LionTest(Boolean expected, String sex, int kittensCount, String animalKind, List<String> foods) {
        this.expected = expected;
        this.sex = sex;
        this.kittensCount = kittensCount;
        this.animalKind = animalKind;
        this.foods = foods;
    }

    @Before
    public void init() throws Exception {
        feline = spy(Feline.class);
        lion = new Lion(sex, feline);
    }

    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][]{
                {true, "Самец", 1, "Хищник", List.of("Животные", "Птицы", "Рыба")},
                {false, "Самка", 1, "Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void getKittens() {
        int kittens = lion.getKittens();
        assertEquals(kittensCount, kittens);
        verify(feline).getKittens();
        verify(feline).getKittens(1);
    }

    @Test
    public void doesHaveMane() {
        boolean haveMane = lion.doesHaveMane();
        assertEquals(expected, haveMane);
    }

    @Test
    public void doesHaveManeException() {
        try {
            new Lion("Тест", feline);
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самей или самка", e.getMessage());
        }
    }

    @Test
    public void getFood() throws Exception {
        List<String> food = lion.getFood();
        assertEquals(foods, food);
        verify(feline).getFood(animalKind);
    }
}
