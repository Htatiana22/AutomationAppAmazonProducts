package com.amazon.interfaces;

import net.serenitybdd.screenplay.Performable;

public interface IOnSearch {
    default <T>Performable onSearch(T arg){
        return null;
    }

}
