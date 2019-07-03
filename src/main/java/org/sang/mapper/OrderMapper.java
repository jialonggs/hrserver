package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;
import org.sang.bean.Order;
import org.sang.bean.Project;
import org.sang.bean.requestEntity.AddFuKuanRequest;
import org.sang.bean.responseEntity.*;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Mapper
public interface OrderMapper {

    List<FaMoOrder> getNeedFaMo(@Param("addUserId") Integer addUserId, @Param("storageStatus") Integer storageStatus, @Param("faMoStatus") Integer faMoStatus);

    List<Order> getOrdersList(@Param("addUserId") Integer addUserId);

    List<FaMoOrder> getOrderAndProject(@Param("addUserId") Integer addUserId, @Param("isHavePower") Integer isHasPower);

    List<OrderAndProject> getPlantOrdersList(@Param("userId") Long userId, @Param("plantStatus") Integer plantStatus,
                                             @Param("orderName") String orderName, @Param("projectIds") List<Project>  projects);

    List<Order> getStroageOrdersList(@Param("liuChengStatus") Integer liuChengStatus, @Param("jingFengStatus") Integer jingFengStatus, @Param("storageStatus") Integer storageStatus);

    List<Order> getStroageOrdersList1(@Param("storageStatus") Integer storageStatus);

    Long addOrder(Order order);

    List<Order> getOrdersUnAddTech(@Param("techId") Boolean techId);

    List<TechOrder> getOrdersUnAddTech1();


    int updateOrderTech(@Param("id") Long orderId, @Param("workArea") Double workArea, @Param("techNum") Integer techNum);

    List<Order> getUnYaoJianList(@Param("yaoJian") Boolean yaoJian);

    int updateOrderYaoJian(@Param("id") Long orderId);

    List<Order> getOrdersByProjectId(@Param("projectId") Long projectId);

    OrderInfoResp getOrderInfoResp(@Param("orderId") Long orderId);

    Long getMaxOrderID();

    Order getOrderInfoById(@Param("orderId") Long orderId);

    int updateOrder(@Param("order") Order order);

    int updateOrderBaseInfo(@Param("order") Order order);

    int checkKuFang(@Param("kuFangRemark") String kuFangRemark, @Param("storageStatus") Integer storageStatus, @Param("orderId") Long orderId);

    int liuZhuan(@Param("id") Long id, @Param("liuZhuanStatus") Integer liuZhuanStatus, @Param("liuZhuanArea")  Double liuZhuanArea, @Param("liuZhuanBiLi") Double liuZhuanBiLi);

    int updateOrderNanDu(@Param("nanDuDengJi") String nanDuDengJi, @Param("id") Long id);

    int updateStorageStatus(@Param("storageStatus") Integer storageStatus, @Param("orderId") Long orderId);

    int addFuKuan(@Param("fuKuan")AddFuKuanRequest addFuKuanRequest);

    int updateFaMoStatus(@Param("faMoStatus") Integer faMoStatus, @Param("orderId") Long orderId);

    List<OverOrderResponse> getOverOrdersList(@Param("jingFengStatus") Integer jingFengStatus, @Param("liuChengStatus") Integer liuChengStatus,
                                              @Param("orderName") String orderName,@Param("projectIds") List<Project> projectList);

    List<Order> getCheckOrder(@Param("beginDate") String beginDate);

    List<FaMoOrder> getOrderByCondition(@Param("addUserId") Long addUserId, @Param("projectList") List<Project> projectList, @Param("orderName") String orderName);

    List<FaMoOrder> getOrdersByPId(@Param("addUserId") Long addUserId,@Param("projectId")Long projectId, @Param("orderName") String orderName);

    int updateUgency(@Param("urgency") Integer urgency ,@Param("orderId") Integer orderId);



    int updateAfterStatus(@Param("afterStatus") Integer afterStatus, @Param("orderId") Integer orderId);

    List<Order> getAfterOrderShouHou(@Param("userId") Integer userId, @Param("status") Integer status);

    List<OrderAffterOffice> getOrderAffterOffice(@Param("userId") Integer userId);

    int updateRealiyArea(@Param("realityArea") Double realityArea, @Param("orderId") Long orderId,
                         @Param("techNum") Integer techNum, @Param("workArea") Double workArea);

    int updateBackPlant(@Param("orderId") Long orderId);

    OrderAndProject getProjectAndOrder(@Param("orderId") Long orderId);

    int updateFaMoOverStatus( @Param("id") Long id,  @Param("faMoOverStatus") Integer faMoOverStatus);


}
