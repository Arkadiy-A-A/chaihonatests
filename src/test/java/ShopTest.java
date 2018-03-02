
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.BaseSteps;
import steps.CartSteps;
import steps.CatalogSteps;
import steps.MenuSteps;

/**
 * Created by Maria on 26.10.2017.
 */
public class ShopTest extends BaseSteps {

	@Test
	@Title("Заказ в чайхоне")
	public void Test(){
		MenuSteps menuSteps = new MenuSteps();
		CatalogSteps catalogSteps = new CatalogSteps();
		CartSteps cartSteps = new CartSteps();

		menuSteps.stepSelectMenuItem("Меню доставки");
		menuSteps.stepSelectMenuCategory("Выпечка");
		catalogSteps.stepAddProduct("Пичча нон с сыром");

		menuSteps.stepSelectMenuItem("Меню доставки");
		menuSteps.stepSelectMenuCategory("Бургеры и Шаурма");
		catalogSteps.stepAddProduct("Шаурма из телятины");

		menuSteps.stepSelectMenuItem("Меню доставки");
		menuSteps.stepSelectMenuCategory("Плов");

		catalogSteps.stepAddProduct("Плов Чайханский");

		menuSteps.stepGoToCart();

		cartSteps.stepCheckProduct("Пичча нон с сыром");
		cartSteps.stepCheckProduct("Шаурма из телятины");
		cartSteps.stepCheckProduct("Плов Чайханский");

		Integer expectedAmount = Integer.parseInt(getVariable("Пичча нон с сыром")) + Integer.parseInt(getVariable("Шаурма из телятины")) +
				Integer.parseInt(getVariable("Плов Чайханский"));

		cartSteps.stepCheckTotalAmount(expectedAmount.toString());

	}



}
