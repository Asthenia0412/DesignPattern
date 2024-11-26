package com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.ObserverPattern.SubjectImpl;

import com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.ObserverPattern.StoreStatusSubject;
import com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.ObserverPattern.StoreStatusObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreStatusSubjectImpl implements StoreStatusSubject
{
    @Autowired
    private List<StoreStatusObserver> observers = new ArrayList<StoreStatusObserver>();
    private String storeStatus;


    @Override
    public void addObserver(StoreStatusObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(StoreStatusObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(StoreStatusObserver observer : observers) {
            observer.update(storeStatus);
        }
    }
    @Override
    public void setStoreStatus(String storeStatus) {
        this.storeStatus = storeStatus;
        notifyObservers();
    }
}
