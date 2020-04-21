package com.xzsd.pc.goods成功.controller;



import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.goods成功.entity.GoodsData;
import com.xzsd.pc.goods成功.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
//@Controller的注解包括：@Target({ElementType.TYPE})、@Retention(RetentionPolicy.RUNTIME)、@Documented、  -@Component
//加了@Component注解，表明这是一个逻辑组件，告知Spring要为它创建bean。相当于xml配置文件中的 <bean id="" class=""/>的作用。

//@RestController的注解包括：@Target(ElementType.TYPE)、@Retention(RetentionPolicy.RUNTIME)、@Documented、  -@Controller、@ResponseBody
//@ResponseBody注解，就不得不提一个名词：表述性状态转移（Representational State Transfer，REST）。
//@ResponseBody注解告知Spring，要将返回的对象作为资源发送给客户端。使用Spring自带的各种Http消息转换器将控制器产生的数据转换为客户端需要的表述形式
@RestController
//@RequestMapping是一个用来处理请求地址映射的注解，可用于类或者方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径。
@RequestMapping("/goods")





public class GoodsController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Resource
    private GoodsService goodsService;

/**
 * goods 新增商品
 *
 * @param goodsData
 * @return AppResponse
 * @author xumintao
 * @Date 2020-03-21
 */
   @PostMapping("/goodsAdd")
   public AppResponse goodsAdd(GoodsData goodsData)
   {
       try
       {

           String userId = AuthUtils.getCurrentUserId();  //----
           goodsData.setCreateBy(userId);   //---
           AppResponse appResponse = goodsService.goodsAdd(goodsData);  //对应dao的方法
           return appResponse;
       }catch (Exception e)
       {
           logger.error("商品新增失败", e);
           System.out.println(e.toString());
           throw e;
       }
   }
    /**
     * 商品列表
     * @param goodsData
     * @return
     */
      @RequestMapping(value = "goodsListCheck")
      public AppResponse goodsListCheck(GoodsData goodsData) {
          try {
              return goodsService.goodsListCheck(goodsData);
          } catch (Exception e) {
              logger.error("查询用户列表异常", e);
              System.out.println(e.toString());
              throw e;
          }
      }

    /**
     * 商品删除
     * @param goodsId
     * @return
     */
      @PostMapping("goodsDelete")
      public AppResponse goodsDelete(String goodsId) {
          try {
              //获取用户id
              String goodsCode = AuthUtils.getCurrentUserId();
              return goodsService.goodsDelete(goodsId,goodsCode);
          } catch (Exception e) {
              logger.error("用户删除错误", e);
              System.out.println(e.toString());
              throw e;
          }
      }

    /**
     * 修改商品列表
     * @param goodsData
     * @return
     */
    @PostMapping("goodsUpdate")
    public AppResponse goodsUpdate(GoodsData goodsData) {
        try {
            //获取用户id
            String goodsId = AuthUtils.getCurrentUserId();
            goodsData.setCreateBy(goodsId);
            goodsData.setCreateBy(goodsId);
            return goodsService.goodsUpdate(goodsData);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * goods 商品详情查询
     *
     * @param goodsId             //paramtric参数
     * @return AppResponse         //@requestmapping地址映射
     * @author xumintao
     * @Date 2020-03-21
     */
    @RequestMapping(value = "getGoodsByGoodsId")
    public AppResponse getGoodsByGoodsId(String goodsId) {
        try {
            return goodsService.getGoodsByGoodsId(goodsId);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改商品状态
     * @param goodsInfo
     * @return
     * @author
     * @Date 2020-03-28
     */
    @PostMapping("updateGoodsStatus")
    public AppResponse updateGoodsStatus(GoodsData goodsInfo){
        try {
            //获取用户角色
            String userId = SecurityUtils.getCurrentUserId();
            goodsInfo.setUpdateBy(userId);
            return goodsService.updateGoodsStatus(goodsInfo);
        }catch (Exception e){
            logger.error("修改商品状态失败");
            System.out.println(e.toString());
            throw e;
        }
    }
/**
 * 商品图片上传
 */
@PostMapping("goodsUpLoadPicture")
    public void goodsUpLoadPicture()
{
   goodsService.goodsUpLoadPicture();
}

}

