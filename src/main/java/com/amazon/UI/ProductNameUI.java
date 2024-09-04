package com.amazon.UI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductNameUI {
    public static final Target TXT_PRODUCT_NAME = Target
            .the("ProductName").located(By.xpath("//android.webkit.WebView[@text=\"Amazon.com Shopping Cart\"]"));

}
