package org.example.data.observerPatern.subject.abstr;

import org.example.data.observerPatern.observer.abstr.MyObserver;

public interface Subject {
    void registerObserver(MyObserver observer);
    void removeObserver(MyObserver observer);
    void notifyObserver();
}
