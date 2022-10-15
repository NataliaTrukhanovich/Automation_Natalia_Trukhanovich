package Lecture12;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.NavigationItems;
import pageObjects.herokuapp.NavigationPage;
import pageObjects.herokuapp.SortableDataTablesPage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HwEmailChange extends BaseTest {
    @BeforeMethod
    public void preconditions() {
        get(NavigationPage.class)
                .open()
                .navigateTo(NavigationItems.SORTABLE_DATA_TABLES);
    }

    @Test
    public void emailChangeTest() {
        Map<String, List<String>> mapTableData = get(SortableDataTablesPage.class).getMapTableData();
        List<String> emailData = mapTableData.get("Email");

        List<String> newData = emailData.stream()
                .map(email -> email.replaceAll("@.*", "@gmail.com"))
                .collect(Collectors.toList());
        newData.forEach(System.out::println);
    }

}
