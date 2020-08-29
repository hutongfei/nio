package com.my;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.my.utils.HttpClientUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;


@SpringBootApplication
@RestController
public class NioApplication {

    public static void main(String[] args) {
        SpringApplication.run(NioApplication.class, args);
    }

    /**
     * JSONObject 使用
     * @return
     * @throws IOException
     */
    @RequestMapping("/t")
    public Object t2() throws IOException {
        String s = HttpClientUtil.get("http://localhost:9000/t");
        JSONObject parse = ((JSONObject) JSONObject.parse(s));
        Object name = parse.get("name");
        Object age = parse.get("age");
        Object sex = parse.get("sex");
        JSONArray list = ((JSONArray) parse.get("list"));
        Iterator<Object> iterator = list.iterator();

        while (iterator.hasNext()) {
            JSONObject next = ((JSONObject) iterator.next());
            Object no = next.get("no");
            Object name1 = next.get("name");
            System.out.println(no + "****" + name1);
        }
        System.out.println("********************************************");

        for (int i = 0; i < list.size(); i++) {
            JSONObject o = ((JSONObject) list.get(i));
            System.out.println(o.get("no") + "****" + o.get("name"));
        }
        return name + "     " + age + "     "+ sex + " "+list;
    }

    /**
     * IO 工具类
     */
    @RequestMapping("/tt")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception{
        String fileName = "F://"+System.currentTimeMillis() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        File file1 = new File(fileName);
        if (file1.exists()) {
            file1.delete();
        }
        file.transferTo(file1);
        return null;
    }



}
