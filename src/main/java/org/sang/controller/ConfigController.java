package org.sang.controller;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.Hr;
import org.sang.bean.Menu;
import org.sang.bean.RespBean;
import org.sang.bean.ResponseDataEntity;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.bean.responseEntity.OrderInfoResp;
import org.sang.common.HrUtils;
import org.sang.config.ErrCodeMsg;
import org.sang.service.HrService;
import org.sang.service.MenuService;
import org.sang.service.OrderService;
import org.sang.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 这是一个只要登录就能访问的Controller
 * 主要用来获取一些配置信息
 */
@RestController
@RequestMapping("/config")
public class ConfigController extends BaseController{
    @Value("${img.location}")
    private String location;

    @Value("${imgurl.url}")
    public  String imgurl;

    @Autowired
    OrderService orderService;

    @Autowired
    HrService hrService;

    @Autowired
    MenuService menuService;
    @RequestMapping("/sysmenu")
    public List<Menu> sysmenu() {
        return menuService.getMenusByHrId();
    }

    @RequestMapping("/hr")
    public Hr currentUser() {
        return HrUtils.getCurrentHr();
    }


    /**
     *
     * @param multipartFiles | 文件
     * @param userId |用户id
     * @param imgPakage | 存放文件夹
     * @return
     */
    @RequestMapping(value = "/upload/image", method = RequestMethod.POST)
    public Map<String,Object> toAddImageFile(@RequestParam("imageFile[]")  MultipartFile[] multipartFiles, String userId, String imgPakage) {
        Map<String, Object> map = new HashMap<>();
        List<String> fileUrls = new ArrayList<>();
        for (MultipartFile file : multipartFiles){
            // 获取文件类型
            String fileTyle= file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String fileUrl = ""; //文件的绝对路径
            // 存储文件
//          String path = "src/main/resources/static/img/";
            try {
                fileUrl = ImageUtil.saveImg2(file,location,userId,imgPakage,fileTyle,imgurl);
                fileUrls.add(fileUrl);
            }catch (Exception e){
                e.printStackTrace();
                map.put("url",fileUrls);
                return  map;
            }
        }
        map.put("url",fileUrls);
        return  map;

    }

    /**
     * 删除上传图片
     * @param url
     * @return
     */
    @RequestMapping(value = "/delfile/delImage", method = RequestMethod.GET)
    public BaseResponseEntity delImage(@RequestParam("url") String url) {
        if(null == url || url == "") {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Boolean delFlag = ImageUtil.delImage(imgurl,url,location);
        if(delFlag){
            return succResult();
        }else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

    /**
     * 查看订单详情
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public BaseResponseEntity getOrderInfo(@Param("orderId") Long orderId){
        if(null == orderId ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        OrderInfoResp orderInfoResp = orderService.getOrderInfoResp(orderId);
        map.put("orderinfo", orderInfoResp);
        return succResult(map);
    }

    /**
     * 获取角色为车间主管的用户
     * @return
     */
    @RequestMapping(value = "/mangers", method = RequestMethod.GET)
    public BaseResponseEntity getHrRoleOfManger(@RequestParam(value = "role") String role) {
        List<Hr> list = hrService.getByRole(role);
        if(null == list || list.size() == 0){
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
        return succResult(list);
    }

}
