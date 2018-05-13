package steps;


import pages.MenuPage;
import io.qameta.allure.Step;

/**
 * Created by Maria on 26.10.2017.
 */
public class MenuSteps {

		MenuPage menuPage = new MenuPage();

		@Step("выбран пункт главного меню - {0}")
		public void stepSelectMenuItem(String item){
			menuPage.selectMainMenuItem(item);
		}

		@Step("в Меню Доставки выбран пункт - {0}")
		public void stepSelectMenuCategory(String item){
			menuPage.selectSubMenuItem(item);
		}

		@Step("выполнен переход в корзину")
		public void stepGoToCart(){
				menuPage.goToCart.click();
		}

}
