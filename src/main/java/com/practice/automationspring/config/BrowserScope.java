package com.practice.automationspring.config;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

import java.util.Map;
import java.util.Objects;

public class BrowserScope extends SimpleThreadScope {


    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
            Object object = super.get(name, objectFactory);
        SessionId sessionId=((RemoteWebDriver) object).getSessionId();
        if(Objects.isNull(sessionId)){
            super.remove(name);
            object= super.get(name,objectFactory);
        }
        return  null;
    }

    public void registerDestructionCallback(String name, Runnable callback) {

    }
}
