import java.util.ArrayList;
import java.util.List;

// Subject
class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;
    private float humidity;

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyAllObservers();
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

// Observer
abstract class Observer {
    protected WeatherStation weatherStation;

    public abstract void update();
}

// Concrete Observers
class PhoneDisplay extends Observer {
    public PhoneDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        this.weatherStation.attach(this);
    }

    public void update() {
        System.out.println("Phone Display - Temperature: " + weatherStation.getTemperature() + ", Humidity: " + weatherStation.getHumidity());
    }
}