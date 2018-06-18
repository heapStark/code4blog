package heap.stark.designPattern.observer;

import java.util.Observable;
import java.util.Observer;

public class Student extends Observable {
    public Student(Observer observer) {
        super();
        this.addObserver(observer);
    }

    public void lateForSchool() {
        //System.out.println("late");
        this.setChanged();
        notifyObservers("-----");
    }

    public void lateForSchoolWithOut() {
        //System.out.println("late");
        //this.setChanged();
        notifyObservers("-----");
    }
}
