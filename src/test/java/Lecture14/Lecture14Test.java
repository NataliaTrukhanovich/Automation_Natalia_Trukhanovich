package Lecture14;

import Lecture14.entity.Car;
import Lecture14.entity.Home;
import Lecture14.entity.Person;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;

@Log4j
public class Lecture14Test extends BaseTest {
    @Test
    public void personTest() {
        Person person = new Person() {{
            setAddress("Vitebsk");
            setFirstName("Vitali");
            setLastName("Shadrin");
        }};
        Person person1 = new Person("Vitali", "Shadrin", "Vitebsk", 31, "m", "12345");
        log.debug(person);
        log.debug(person1+"\n");
    }

    @Test(enabled = false)
    public void carTest() {
        Car car = new Car() {
            {
                setModel("Tesla");
                setType("Electro");
                setColor("Black");
            }
        };
        log.debug(car);
        log.debug(car.getModel());
    }

    @Test(enabled = false)
    public void homeTest(){
        Home home = new Home.HomeBuilder().withAddress("Vitebsk").withWinCount(10).create();
        log.debug(home);
    }
}
