package com.praxisgs.securesecrets.controllers;

import eventbus.AppNavigationEvents;
import eventbus.SecureSecretsEventBus;

/**
 * Created on 04/02/2016.
 */
public class AppNavigationController {

    private final String TAG = AppNavigationController.class.getName();
    private final AppNavigationControllerInterface implementer;

    public AppNavigationController(AppNavigationControllerInterface implementer) {
        this.implementer = implementer;
        SecureSecretsEventBus.register(this);
    }

    public void onEvent(AppNavigationEvents.EventShowCategoriesPage event) {
        implementer.showCategoriesPage();
    }

    public void onEvent(AppNavigationEvents.EventShowPassCodePage event) {
        implementer.showPassCodePage();
    }

    public void onEvent(AppNavigationEvents.EventShowRecordsForId event){
        implementer.showRecordsPage(event.getId());
    }

    public void onEvent(AppNavigationEvents.EventShowRecordDetails event){
        implementer.showRecordDetailsPage(event.getId());
    }

    public void onEvent(AppNavigationEvents.EventShowCreateRecord event){
        implementer.showCreateRecordPage();
    }

    public void onEvent(AppNavigationEvents.EventShowPreviousPage event){
        implementer.showPreviousPage();
    }

    public void onEvent(AppNavigationEvents.EventShowSettings event){
        implementer.showSettingsPage();
    }

    public void destroy() {
        SecureSecretsEventBus.unregister(this);
    }


}
