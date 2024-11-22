package com.xiaoyongcai.io.designmode.Service.ObserverPattern;

public interface StoreStatusSubject {
    void addObserver(StoreStatusObserver observer);
    void removeObserver(StoreStatusObserver observer);
    void notifyObservers();
    void setStoreStatus(String storeStatus);
}
