import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String testName;
    private final String sex;
    private final Boolean expectedResult;

    //Объявляем конструктор класса
    public LionParameterizedTest(String testName, String sex, Boolean expectedResult) {
        this.testName = testName;
        this.sex = sex;
        this.expectedResult = expectedResult;
    }

    //Получаем тестовые значения
    @Parameterized.Parameters (name = "{0}")
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Значение переменной наличия гривы истинно","Самец", true},
                {"Значение переменной наличия гривы ложно","Самка", false},
        };
    }

    //Тестовый метод
    @Test
        public void testDoesHaveMane() throws Exception{
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, feline);
        Boolean actualResult = lion.doesHaveMane();
        Assert.assertEquals("Логические выражения не равны", expectedResult, actualResult);
    }
}