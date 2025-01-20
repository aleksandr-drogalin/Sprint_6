import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private static String SEX = "Самец";
    private static String SEX_TROW = "Лев";

    //Проверяем, что метод getKittens() класса Lion вызывает метод getKittens() класса Feline, используем мок
    @Test
    public void lionGetKittensCallInFeline() {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = null;
        try {
            lion = new Lion(SEX, feline);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    //Проверяем, что метод getKittens() класса Lion возвращает значение количества котят, используем стаб
    @Test
    public void lionGetKittensCount() {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = null;
        try {
            lion = new Lion(SEX, feline);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int expectedCount = 1;
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualCount = lion.getKittens();
        Assert.assertEquals(expectedCount, actualCount);
    }

    //Проверяем, что метод getFood() класса Lion вызывает метод getFood() класса Feline
    //с аргументом "Хищник" (метод унаследован от класса Animal), используем мок
    @Test
    public void lionGetFoodCallInFeline() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = null;
        try {
            lion = new Lion(SEX, feline);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    //Проверяем, что метод getFood() класса Lion возвращает возвращает список еды хищников, которая перечислена в классе Animal, используем стаб
    @Test
    public void lionGetFoodList() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = null;
        try {
            lion = new Lion(SEX, feline);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual =  lion.getFood();
        Assert.assertEquals(expected, actual);
    }

    //Проверяем исключение при создании объекта класса Lion
    @Test
    public void lionTestTrow() {
        Feline feline = Mockito.mock(Feline.class);
        Exception exception = null;
        try {
            Lion lion = new Lion(SEX_TROW, feline);
        } catch (Exception e) {
            exception = e;
        }
        String expectedResult = "Используйте допустимые значения пола животного - самец или самка";
        String actualResult = exception != null ? exception.getMessage() : null;
        Assert.assertEquals(expectedResult, actualResult);
    }
}
