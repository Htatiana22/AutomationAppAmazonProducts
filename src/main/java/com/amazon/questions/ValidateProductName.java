package com.amazon.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.amazon.UI.ProductNameUI.TXT_PRODUCT_NAME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidateProductName implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {

        WaitUntil.the(TXT_PRODUCT_NAME, isVisible()).forNoMoreThan(15).seconds();
        return TXT_PRODUCT_NAME.resolveFor(actor).isDisplayed();
    }

    public static ValidateProductName productName(){
        return new ValidateProductName();
    }
}
