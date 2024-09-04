package com.amazon.UI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearhProductsUI {

    public static final Target INPUT_SEARCH = Target
            .the("Select the search bar").located(By.xpath("//android.widget.TextView[@text=\"Search Amazon\"]"));

    public static final Target SEARCH_PRODUCTS = Target
            .the("Enter name products").located(By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text"));

    public static final Target SELECT_PRODUCT = Target
            .the("Select Product").located(By.xpath("//android.view.View[@resource-id=\"attach-to-me\"]/android.view.View[5]"));

    public static final Target ADD_TO_CART = Target
            .the("Add to cart").located(By.xpath("(//android.widget.Button[@text=\"Add to cart\"])[1]"));

    public static final Target SELECT_INPUT_SEARCH = Target
            .the("Select input search ").located(By.xpath("//android.widget.TextView[@resource-id=\"com.amazon.mShop.android.shopping:id/chrome_search_hint_view\"]"));

    public static final Target CLEAR_INPUT_SEARCH = Target
            .the("Clear field content").located(By.xpath("//android.widget.EditText[@resource-id=\"com.amazon.mShop.android.shopping:id/rs_search_src_text\"]"));

    public static final Target CART_BUTTON = Target
            .the("Select option Add to cart").located(By.id("com.amazon.mShop.android.shopping:id/cart_count"));

}
