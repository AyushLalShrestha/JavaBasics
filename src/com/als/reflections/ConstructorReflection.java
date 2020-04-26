package com.als.reflections;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ConstructorReflection {
    public static void run(String[] args){
        // Instantiate a new Object of some class
    }
    void startWork(String workerTypeName, Object workerTarget) {
        /*
        workerTypeName is the Fully Qualified class name which has 2
         constructors accepting different type of Objects defined as workerTarget
         */
        Class<?> workerType = Class.forName(workerTypeName);
        Class<?> targetType = workerTarget.getClass();

        Constructor c = workerType.getConstructor(targetType);
        Object worker = c.newInstance(workerTarget);
        Method doWork = workerType.getMethod("doWork");
        doWork.invoke(worker);
    }

    void startWorkSimpler(String workerTypeName, Object workerTarget) {
        /*
        workerTypeName is the Fully Qualified class name which has 3
         constructors accepting different type of Objects defined as workerTarget
         */
        Class<?> workerType = Class.forName(workerTypeName);
        TaskWorker worker = (TaskWorker) workerType.newInstance();
        worker.setTarget(workerTarget);
        worker.doWork();
    }

}
