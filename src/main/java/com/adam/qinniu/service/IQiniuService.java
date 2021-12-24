package com.adam.qinniu.service;

import com.qiniu.common.QiniuException;

import java.io.File;
import java.io.InputStream;

public interface IQiniuService {
    String uploadFile(File file, String fileName) throws QiniuException;

    String uploadFile(InputStream inputStream, String fileName) throws QiniuException;

    String delete(String key) throws QiniuException;
}
