import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    //Проверяем, что метод getSound() класса Cat возвращает "Мяу", используем Мок
    @Test
    public void catGetSound() {
        Feline feline = Mockito.mock(Feline.class);
        Cat cat = new Cat(feline);
        Assert.assertEquals("Кот должен говорить Мяу", "Мяу", cat.getSound());
    }

    //Проверяем, что метод getFood() класса Cat вызывает метод eatMeat() класса Feline, используем Мок
    @Test
    public void catGetFoodInFeline() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }

    //Проверяем, что метод getFood() класса Cat возвращает список еды хищников, которая перечислена в классе Animal используем стаб
    @Test
    public void catGetFoodList() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Cat cat = new Cat(feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expected);
        List<String> actual =  cat.getFood();
        Assert.assertEquals("Списки не совпадают",expected, actual);
    }
}