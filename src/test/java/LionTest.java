import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private static final String SEX = "Самец";
    private static final String SEX_THROW = "Лев";

    //Проверяем, что метод getKittens() класса Lion вызывает метод getKittens() класса Feline, используем мок
    @Test
    public void lionGetKittensCallInFeline() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(SEX, feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    //Проверяем, что метод getKittens() класса Lion возвращает значение количества котят, используем стаб
    @Test
    public void lionGetKittensCount() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(SEX, feline);
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
        Lion lion = new Lion(SEX, feline);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    //Проверяем, что метод getFood() класса Lion возвращает возвращает список еды хищников, которая перечислена в классе Animal, используем стаб
    @Test
    public void lionGetFoodList() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(SEX, feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual =  lion.getFood();
        Assert.assertEquals(expected, actual);
    }

    //Проверяем исключение при создании объекта класса Lion
    @Test
    public void lionTestThrow() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Exception exception = assertThrows(Exception.class, ()-> new Lion(SEX_THROW, feline));
        String expectedResult = "Используйте допустимые значения пола животного - самец или самка";
        Assert.assertEquals(expectedResult, exception.getMessage());
    }
}
