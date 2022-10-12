package Lecture12;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HwStream extends BaseTest {
    @Test
    public void dataSortTest() {
        List<Integer> data = Arrays.asList(-79, 99, -83, -75, -78, -22, -57, 84, 11, 15);
        List<Integer> dataSort1 = data.stream().map(element -> {
            if (element < 0) element *= -1;
            return element;
        }).collect(Collectors.toList());
        System.out.println("Массив положительных чисел \n" + dataSort1);
        List<Integer> dataSort2 = dataSort1.stream().sorted().collect(Collectors.toList());
        System.out.println("Отсортированная коллекция, способ с stream().sorted() \n" + dataSort2);
        Collections.sort(dataSort1);
        System.out.println("Отсортированная коллекция, способ с Collections().sort() \n" + dataSort1);
    }

}
