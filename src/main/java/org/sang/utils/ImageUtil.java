package org.sang.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class ImageUtil {


    /**
     * 保存图片
     * @param multipartFile
     * @param path
     * @param userId
     * @param imgPakage
     * @param imgType
     * @param imgurl
     * @return
     * @throws IOException
     */
    public static String saveImg(MultipartFile multipartFile, String path,String userId ,String imgPakage,String imgType,String imgurl) throws IOException {
        // 路径 基本路径+用户ID+图片类型
        path = path+imgPakage+"/"+userId+"/";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        Date date = new Date();
         // 文件的命名 随机数+时间戳
        Random random = new Random();
        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数
        String fileName = rannum+"_"+date.getTime()+imgType;
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + File.separator + fileName));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        String url = "";
        // 图片的绝对路径
        String newPath = imgPakage +"/"+userId+"/";
        url = imgurl+newPath + fileName;
        return url;
    }



    /**
     * 保存图片
     * @param multipartFile
     * @param path
     * @param userId
     * @param imgPakage
     * @param imgType
     * @param imgurl
     * @return
     * @throws IOException
     */
    public static String saveImg2(MultipartFile multipartFile, String path,String userId ,String imgPakage,String imgType,String imgurl) throws IOException {
        // 路径 基本路径+用户ID+图片类型
        path = path+imgPakage+"/"+userId+"/";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        Date date = new Date();
        // 文件的命名 随机数+时间戳
        Random random = new Random();
        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数
        String fileName = rannum+"_"+date.getTime()+imgType;
        String path1 = path + fileName;
        File saveFile = new File(path1);
        System.out.print(path1);
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
        out.write(multipartFile.getBytes());
        out.flush();
        out.close();
        String url = "";
        // 图片的绝对路径
        String newPath = imgPakage +"/"+userId+"/";
        url = imgurl+newPath + fileName;
        return url;
    }

    /**
     * 删除图片
     * @param imgurl
     * @param url
     * @return
     */
    public static Boolean delImage(String imgurl,String url,String location){
        Boolean flag = false;
        try {

            String strs = url.substring(imgurl.length(),url.length());
            String allURL = location + strs;
            File imageFile = new File(allURL);
            if(imageFile.exists() && imageFile.isFile()) {
              if(imageFile.delete()) {
                  flag  = true;
              }
            }
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
            return  flag;
        }
    }
}
