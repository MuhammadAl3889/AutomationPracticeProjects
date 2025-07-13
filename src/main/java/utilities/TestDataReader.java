package utilities;

import com.github.javafaker.Faker;

public class TestDataReader {
    static Faker faker = new Faker();

    public static String getFakeName() {
        return faker.name().firstName();
    }

    public static String getFakeEmail() {
        return faker.internet().emailAddress();
    }

    public static String getFakePassword() {
        return faker.internet().password();
    }
}
