package com.codecool.cai.queue;

import com.codecool.cai.Example;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample implements Example {
    @Override
    public void show() {
        Queue<String> students = new LinkedList<>();
        students.add("Julia");
        students.add("Imre");
        students.add("Jessica");
        System.out.println("students = " + students);
        // FIFO // First In First Out
        String nextStudent = students.peek();
        System.out.println("nextStudent = " + nextStudent);
        System.out.println("students = " + students);
        String nextConsultationSlot = students.poll();
        System.out.println("nextConsultationSlot = " + nextConsultationSlot);
        System.out.println("students = " + students);
         nextConsultationSlot = students.poll();
        System.out.println("nextConsultationSlot = " + nextConsultationSlot);
        System.out.println("students = " + students);
        nextConsultationSlot = students.poll();
        System.out.println("nextConsultationSlot = " + nextConsultationSlot);
        System.out.println("students = " + students);
        nextConsultationSlot = students.poll();
        System.out.println("nextConsultationSlot = " + nextConsultationSlot);
        System.out.println("students = " + students);
    }
}
