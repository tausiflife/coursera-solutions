package com.general.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenericAutowire {

    @Autowired
    private Store<String> stringStore;

    @Autowired
    private Store<Integer> integerStore;

    public void testStores() {
        stringStore.whoAmI();
        integerStore.whoAmI();
    }
}
