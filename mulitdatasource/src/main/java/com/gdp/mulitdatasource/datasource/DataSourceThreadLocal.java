package com.gdp.mulitdatasource.datasource;

public class DataSourceThreadLocal {
    private static final ThreadLocal<String> threadlocal = new ThreadLocal();

    public static void clean(){
        threadlocal.remove();
    }

    public static void set(String name){
        threadlocal.set(name);
    }

    public static String get(){
        return threadlocal.get();
    }
}

