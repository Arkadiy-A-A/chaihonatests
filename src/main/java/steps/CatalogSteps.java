package steps;

import ru.yandex.qatools.allure.annotations.Step;
import pages.CatalogPage;

/**
 * Created by Maria on 26.10.2017.
 */
public class CatalogSteps {

	CatalogPage catalogPage = new CatalogPage();


	@Step("в корзину добавлен - {0}")
	public void stepAddProduct(String productName){
		catalogPage.addProduct(productName);
	}


}
