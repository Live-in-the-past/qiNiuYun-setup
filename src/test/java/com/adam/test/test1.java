package com.adam.test;

import com.adam.qinniu.qinniuCloudApplication;
import com.adam.qinniu.service.IQiniuService;
import com.qiniu.common.QiniuException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = qinniuCloudApplication.class)
public class test1 {
    @Autowired
    private IQiniuService service;

    @Test
    public void testUpload() throws QiniuException {
        String result = service.uploadFile(new File("/home/adam/Downloads/1.txt"),"test");
        System.out.println("address: " + result);
    }

    public void testDelete() throws QiniuException {
        String res = service.delete("test");
        System.out.println(res);
    }
}
