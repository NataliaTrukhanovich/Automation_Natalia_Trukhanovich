package Lecture12;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.DropdownPage;
import pageObjects.herokuapp.NavigationItems;
import pageObjects.herokuapp.NavigationPage;
import pageObjects.herokuapp.SortableDataTablesPage;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lecture12StreamSortTest extends BaseTest {

    @BeforeMethod
    public void preconditions() {
        get(NavigationPage.class).open();
    }

    @Test(priority = 1)
    public void DropdownTest(){
        get(NavigationPage.class).navigateTo(NavigationItems.DROPDOWN);
        get(DropdownPage.class)
                .verifyPageTitle("Dropdown List")
                .select(2)
                .verifySelectedValue("Option 2");
    }

    @Test(priority = 2)
    public void sortCurrencyTest() {
        get(NavigationPage.class).navigateTo(NavigationItems.SORTABLE_DATA_TABLES);
        Map<String, List<String>> mapTableData = get(SortableDataTablesPage.class)
                .clickTableColumn("Due").getMapTableData();
        List<Double> currencyData = mapTableData.get("Due").stream()
                .map(currency -> Double.parseDouble(currency.replace("$", "")))
                .collect(Collectors.toList());
        System.out.println(currencyData);
        List<Double> sortData = currencyData;
        Collections.sort(sortData);
        System.out.println(currencyData);
        Assert.assertEquals(currencyData, sortData);
    }


}
