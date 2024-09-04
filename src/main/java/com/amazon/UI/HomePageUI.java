package com.amazon.UI;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePageUI {

    public static final Target BTN_SKIP_SIGN_IN = Target
            .the("Select the search field").located(By.id("com.amazon.mShop.android.shopping:id/skip_sign_in_button"));

}
