package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortableDataTablesPage extends BasePage {

    private By table = By.id("table");
    private By headers = By.xpath("//table[@id='table1']//th");
    private By getTableRow(String index) {
        return By.xpath("//table[@id='table1']//tbody//tr[" + index + "]");
    }

    public SortableDataTablesPage clickTableColumn(String columnName) {
        driver.findElement(headers).findElement(By.xpath(".//span[text()='" + columnName + "']")).click();
        return this;
    }

    public List<List<String>> getTableRowsData() {
        List<List<String>> data = new ArrayList<>();                        //объявили лист-таблицу и определили кол-во строк в таблице
        int rowsCount = driver.findElements(getTableRow("..")).size();

        for (int row = 0; row < rowsCount; row++) {                         //объявили лист-строку для строки и посчитали кол-во столбцов (эл-тов в строке)
            int columnsCount = driver.findElement(getTableRow(Integer.toString(row + 1)))
                    .findElements(By.xpath(".//td")).size();
            List<String> columnsData = new ArrayList<>();
            for (int column = 0; column < columnsCount; column++) {         //положили все эл-ты строки в лист-строку
                columnsData.add(driver.findElement(getTableRow(Integer.toString(row + 1)))
                        .findElement(By.xpath(".//td[" + (column + 1) + "]")).getText());
            }
            data.add(columnsData);                                          //положили лист-строку в лист-таблицу
        }
        return data;                                                        //вернули собранную с сайта таблицу в виде листа листов
    }

    public Map<String, List<String>> getTableData() {
        //объявляем мапу, в которой ключом будет заголовок столбца таблицы (эл-т типа String)
        //а значением - лист (колонка таблицы List<String>)
        Map<String, List<String>> mapData = new HashMap<>();
        //определяем кол-во значений в элементе header (в заголовке таблице). Это кол-во = 6, т.е. 6 столбцов в таблице
        int headersCount = driver.findElements(headers).size();
        //получаем таблицу в виде листа листов (по строкам) с помощью предыдущего метода getTableRowsData
        List<List<String>> tableData = getTableRowsData();

        for (int header = 0; header < headersCount; header++) {
            //в tableData в качестве эл-тов лежат строки в виде листов (List<String>)
            //берём один такой лист-строку и у него берём эл-т под индексом header и кладём его в новый лист, который
            //будет заполнен элементами таблицы ПО СТОЛБЦАМ. Т.е. получим листы-столбцы
            List<String> columnData = new ArrayList<>();
            for (List<String> data : tableData) {       //data - это лист-строка всего листа-таблицы tableData
                columnData.add(data.get(header));
            }
            //кладём получившийся лист-столбец в мапу
            //первый эл-т - это заголовок столбца под индексом header, второй - лист-столбец
            mapData.put(driver.findElements(headers).get(header).getText(), columnData);
        }
        return mapData;
    }

    //Метод для примера со скриншотом для Аллюра
    public SortableDataTablesPage checkTableIsDisplayed() {
        Assert.assertTrue(driver.findElement(table).isDisplayed());
        return this;
    }
}
