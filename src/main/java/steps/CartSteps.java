package steps;

import ru.yandex.qatools.allure.annotations.Step;
import org.junit.Assert;
import pages.CartPage;

/**
 * Created by Maria on 26.10.2017.
 */
public class CartSteps {

			CartPage cartPage = new CartPage();

			@Step("товар {0} присутствует в корзине")
			public void stepCheckProduct(String productName){
						Assert.assertTrue(String.format("товар %s не найден в корзине", productName),
								cartPage.productExist(productName));
			}

			@Step("итоговая сумма равна - {0}")
			public void stepCheckTotalAmount(String expectedAmount){
				Assert.assertEquals(String.format("Итоговая сумма не равна значению %s. Получено значение %s", expectedAmount, cartPage.getTotalAmount()),
						expectedAmount, cartPage.getTotalAmount());
			}
}
