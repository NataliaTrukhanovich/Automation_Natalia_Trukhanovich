package Lecture10;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.NavigationPage;
import pageObjects.herokuapp.SortableDataTablesPage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static pageObjects.herokuapp.NavigationItems.SORTABLE_DATA_TABLES;

public class SortableDataTablesTest extends BaseTest {
    @BeforeMethod
    public void precondition() {
        new NavigationPage()
                .open()
                .navigateTo(SORTABLE_DATA_TABLES);
    }

    @Test
    public void listDataTest() {
        List<List<String>> dataTable = new SortableDataTablesPage().getTableRowsData();
        dataTable.forEach(System.out::println);
        Assert.assertTrue(dataTable.get(2).contains("$100.00"));
    }

    @Test
    public void mapDataTest(){
        //объявляем мапу, кликаем на сайте по колонке "Last Name" и собираем в мапу сразу отсортированную таблицу
        Map<String, List<String>> mapTableData = new SortableDataTablesPage().checkTableIsDisplayed()
                .clickTableColumn("Last Name").getTableData();
        System.out.println(mapTableData);
        //кладём в lastNameData один столбец под именем Last Name
        List<String> lastNameData =  mapTableData.get("Last Name");
        //сравниваем наш отсортированный столбец с сортировкой java через stream().sorted().collect
        Assert.assertEquals(lastNameData, lastNameData.stream().sorted().collect(Collectors.toList()));
    }

}





