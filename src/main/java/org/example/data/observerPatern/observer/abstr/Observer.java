package org.example.data.observerPatern.observer.abstr;

public interface Observer {
    void update(float temperature, float humidity, float pressure);
}
