import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    //Проверяем, что метод getFamily() класса Feline возвращает "Кошачьи"
    @Test
    public void felineGetFamily() {
        Feline feline = new Feline();
        Assert.assertEquals("Строки не совпадают", "Кошачьи", feline.getFamily());
    }

    //Для следующих тестов потребуется Spy
    @Spy
    private Feline feline;

    //Проверяем, что метод getKittens() класса Feline возвращает заданное значение
    @Test
    public void felineGetKittenQuantity() {
        int countKittens = 3;
        Assert.assertEquals("Метод не вернул значение, которое заданно в качестве аргумента", countKittens, feline.getKittens(countKittens));
    }

    //Проверяем, что метод getKittens() класса Feline возвращает дефолтное значение, используем Spy
    @Test
    public void felineGetKittensDefaultQuantity() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    //Проверяем, что унаследованный метод getFood() класса Feline возвращает список еды хищников
    @Test
    public void felineGetFoodList() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Списки не совпадают", expected, feline.getFood("Хищник"));
    }

    //Проверяем, что метод eatMeat() класса Feline вызывает метод getFood() с аргументом "Хищник", используем Spy
    @Test
    public void felineEatMeatCallGetFood() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

}
