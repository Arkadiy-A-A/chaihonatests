package ru.appline.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.appline.framework.pages.CartPage;
import ru.appline.framework.pages.CatalogPage;
import ru.appline.framework.pages.MenuPage;

/**
 * Created by Maria on 26.10.2017.
 */
public class ShopTest extends BaseTest {

	@Test
	public void testChaihona(){
		MenuPage menuPage = new MenuPage();
		CatalogPage catalogPage = new CatalogPage();
		CartPage cartPage = new CartPage();

		menuPage.selectMainMenuItem("Меню доставки");
		menuPage.selectSubMenuItem("Выпечка");
		catalogPage.addProduct("Пичча нон с сыром");

		menuPage.selectMainMenuItem("Меню доставки");
		menuPage.selectSubMenuItem("Бургеры и Шаурма");
		catalogPage.addProduct("С курицей");

		menuPage.selectMainMenuItem("Меню доставки");
		menuPage.selectSubMenuItem("Плов");
		catalogPage.addProduct("Плов Чайханский");

		menuPage.goToCart();

		Assert.assertTrue(String.format("товар %s не найден в корзине", "Пичча нон с сыром"),
				cartPage.productExist("Пичча нон с сыром"));
		Assert.assertTrue(String.format("товар %s не найден в корзине", "Шаурма с курицей"),
				cartPage.productExist("Пичча нон с сыром"));
		Assert.assertTrue(String.format("товар %s не найден в корзине", "Плов Чайханский"),
				cartPage.productExist("Пичча нон с сыром"));

	}


}
