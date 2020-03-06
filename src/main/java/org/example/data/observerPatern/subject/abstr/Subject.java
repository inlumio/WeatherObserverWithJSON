package org.example.data.observerPatern.subject.abstr;

import org.example.data.observerPatern.observer.abstr.Observer;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}
