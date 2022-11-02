package pageObjects.rw;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Selenide.$$;

@Log4j
public class SearchResultPage {
    private final ElementsCollection searchResults = $$("[class=sch-table__body-wrap] [class=sch-table__row]");

    public SearchResultPage checkResultCount(Integer size) {
        log.debug("Expected amount of trains " + size + "\nActual amount of trains " + searchResults.size());
        searchResults.should(CollectionCondition.size(size));
        return this;
    }
}
