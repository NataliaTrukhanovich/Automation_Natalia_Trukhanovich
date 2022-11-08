package Lecture10;

import lombok.extern.log4j.Log4j;
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
@Log4j
public class Lecture10SortableDataTablesTest extends BaseTest {
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
        Map<String, List<String>> mapTableData = new SortableDataTablesPage().checkTableIsDisplayed()
                .clickTableColumn("Last Name").getMapTableData();
        log.debug(mapTableData);
        List<String> lastNameData =  mapTableData.get("Last Name");
        Assert.assertEquals(lastNameData, lastNameData.stream().sorted().collect(Collectors.toList()));
    }

}





