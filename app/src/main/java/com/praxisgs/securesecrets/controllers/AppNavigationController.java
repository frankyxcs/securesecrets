package com.praxisgs.securesecrets.controllers;

import eventbus.AppNavigationEvents;
import eventbus.SecureSecretsEventBus;

/**
 * Created on 04/02/2016.
 */
public class AppNavigationController {

    private final String TAG = AppNavigationController.class.getName();
    private static AppNavigationController instance;
    private final AppNavigationControllerInterface implementer;

    private AppNavigationController(AppNavigationControllerInterface implementer) {
        this.implementer = implementer;
        SecureSecretsEventBus.register(this);
    }

    public static void initialise(AppNavigationControllerInterface implementer) {
        if (instance == null)
            instance = new AppNavigationController(implementer);
    }

    public void onEvent(AppNavigationEvents.EventShowCategoriesPage event) {
        implementer.showCategoriesPage();
    }

    public void onEvent(AppNavigationEvents.EventShowPassCodePage event) {
        implementer.showPassCodePage();
    }

}
