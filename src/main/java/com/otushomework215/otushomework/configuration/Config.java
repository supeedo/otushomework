package com.otushomework215.otushomework.configuration;


@org.aeonbits.owner.Config.Sources("classpath:config.properties")
public interface Config extends org.aeonbits.owner.Config {

    @Key("url")
    String URL();

    @Key("login")
    String LOGIN();

    @Key("password")
    String PASSWORD();
}