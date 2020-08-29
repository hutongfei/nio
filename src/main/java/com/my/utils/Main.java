package com.my.utils;

import com.alibaba.fastjson.JSONObject;
import org.openjdk.jol.info.ClassLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date getStopTime(Date t1,int t2) {
        Date date = new Date(t1.getTime() + t2 * 60 * 1000);
        return date;
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
    }
}
