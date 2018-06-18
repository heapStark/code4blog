package heap.stark.designPattern.observer;

import java.util.Observable;
import java.util.Observer;

public class Teacher implements Observer{
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("teacher"+arg);
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        Student student = new Student(teacher);
        //student.addObserver(new Teacher());
        student.lateForSchoolWithOut();
        //输出1行
        student.lateForSchool();
        student.lateForSchoolWithOut();
    }
}
