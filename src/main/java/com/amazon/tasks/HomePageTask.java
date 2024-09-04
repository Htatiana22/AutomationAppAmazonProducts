package com.amazon.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.amazon.UI.HomePageUI.BTN_SKIP_SIGN_IN;
import static com.amazon.UI.SearhProductsUI.INPUT_SEARCH;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class HomePageTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        if (BTN_SKIP_SIGN_IN.resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    Click.on(BTN_SKIP_SIGN_IN)
            );
        } else {
            actor.attemptsTo(
                    Click.on(INPUT_SEARCH)
            );
        }
    }

    public static HomePageTask open(){
        return instrumented(HomePageTask.class);
    }
}
