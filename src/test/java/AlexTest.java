import com.example.Alex;
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.util.HashSet;
import java.util.List;

public class AlexTest {

    @Mock
    Feline feline;

    //Проверяем метод getFriends() который должен вернуть список друзей Алекса
    @Test
    public void alexGetFriends() throws Exception {
        Alex alex = new Alex(feline);
        List<String> expectedResult = List.of("Марти","Глория","Мелман");
        Assert.assertEquals("Имена друзей Алекса разнятся, проверьте количество, порядок и правильность написания имён",
                expectedResult, alex.getFriends());
    }

    //Проверяем метод getPlaceOfLiving() который должен вернуть место где живет Алекс
    @Test
    public  void alexGetPlaceOfLiving() throws Exception {
        Alex alex = new Alex(feline);
        String expectedResult = "Нью-Йоркский зоопарк";
        Assert.assertEquals("Место жительства Алекса не соответствует действительному", expectedResult, alex.getPlaceOfLiving());
    }

    //Проверяем, что Алекс бездетный
    @Test
    public void alexGetKittens() throws Exception {
        Alex alex = new Alex(feline);
        Assert.assertEquals("У Алекса не должно быть детей",0, alex.getKittens());
    }
}
