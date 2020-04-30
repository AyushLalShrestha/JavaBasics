package com.als.reflections;

public class TaskWorker {
    public TaskWorker() {
    }
    public void doWork(){
        System.out.println("h3h3 hasl3y");
    }
    public void setTarget(Object obj){
        System.out.println(obj.getClass().getSimpleName());
    }
}
