package com.amazon.tasks;

import com.amazon.utils.DataProducts;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.ArrayList;
import java.util.Map;

import static com.amazon.UI.SearhProductsUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchProductsTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        ArrayList<Map<String, String>> products = DataProducts.extractTo();

        for (int i = 0; i < products.size(); i++) {
            String productName = products.get(i).get("ProductList");

            if (SELECT_INPUT_SEARCH.resolveFor(actor).isVisible()) {
                actor.attemptsTo(
                        Click.on(SELECT_INPUT_SEARCH)
                );
            } else if (INPUT_SEARCH.resolveFor(actor).isVisible()) {
                actor.attemptsTo(
                        Click.on(INPUT_SEARCH)
                );
            }

            actor.attemptsTo(
                    Enter.theValue(productName).into(SEARCH_PRODUCTS),
                    Click.on(SEARCH_PRODUCTS)
            );

            actor.attemptsTo(
                    Click.on(SELECT_PRODUCT),
                    WaitUntil.the(ADD_TO_CART, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(ADD_TO_CART)
            );

            if (i < products.size() - 1) {
                actor.attemptsTo(
                        Click.on(SELECT_INPUT_SEARCH),
                        Clear.field(CLEAR_INPUT_SEARCH)
                );
            }
        }

        actor.attemptsTo(
                Click.on(CART_BUTTON)
        );
    }

    public static SearchProductsTask search() {
        return instrumented(SearchProductsTask.class);
    }
}




