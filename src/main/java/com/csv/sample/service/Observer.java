package com.csv.sample.service;

public interface Observer {

    void onEvent(String string);

    void onError(Throwable e);

    void onComplete();

}
