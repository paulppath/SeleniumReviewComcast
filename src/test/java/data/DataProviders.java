package data;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

public class DataProviders
{
    @DataProvider(name="email")
    public Object[] data01()
    {
        Faker facker = new Faker();
        Object[] data = new Object[1];
        data[0] = facker.internet().emailAddress();

        return data;
    }

}
