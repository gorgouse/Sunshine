package com.xzsd.pc.classify.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.classify.controller.ClassifyController;
import com.xzsd.pc.classify.dao.ClassifyDao;
import com.xzsd.pc.classify.entity.ClassifyData;
import com.xzsd.pc.classify.entity.ClassifyOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class ClassifyService {

    @Resource
    private ClassifyDao classifyDao;


    private static final Logger logger = LoggerFactory.getLogger(ClassifyController.class);

    /**
     * 分类新增
     * @param classifyData
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse classifyAdd(ClassifyData classifyData)     //橙色代表这个方法与与Mapper的xuml文件对应
    {
        //检验ID是否存在
        int countClassifyId = classifyDao.countClassifyId(classifyData);             //比较ID不同
        if (0 != countClassifyId)
        {
            return AppResponse.success("新增的商品已存在，请再次尝试");
        }

        classifyData.setClassifyId(StringUtil.getCommonCode(2));  //生成随机编码ID
        classifyData.setIsDelete(0);   //设置作废标记为0
        // 新增商品
        int count = classifyDao.classifyAdd(classifyData);        //紫色字代表数据库的方法ID
        if (0 == count) {
            return AppResponse.success("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 分类列表
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse classifyListCheck() {

        List<ClassifyOne> classifyOneList = classifyDao.classifyListCheck();
        return AppResponse.success("查询成功！",  classifyOneList);

    }

    /**
     * demo 删除
     *
     * @param classifyData
     * @return
     * @Author sumintao
     * @Date 2020-03-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse classifyDelete(ClassifyData classifyData) {
        int countSecondList = classifyDao.countTwoClassify(classifyData.getClassifyId());
        if(countSecondList != 0)
        {
            return AppResponse.bizError("无法删除，该目录下存在二级分类");
        }
        int count = classifyDao.classifyDelete(classifyData);
        if (0 == count) {
            return AppResponse.bizError("删除分类失败，请重试！");
        }
        return AppResponse.success("删除分类成功！");
    }
    /**
     * 修改分类
     * @param classifyData
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse classifyUpdate(ClassifyData classifyData) {
        int count =classifyDao.classifyUpdate(classifyData);
        if (0 == count) {
           return AppResponse.bizError("修改失败");

        }
        return AppResponse.success("修改成功");
    }
    /**
     * 分类信息详情
     * @param classifyId
     * @return
     */
    public AppResponse getClassifyByClassifyId(String classifyId)
    {

        ClassifyData classifyData =  classifyDao.getClassifyByClassifyId(classifyId);
        return AppResponse.success("分类查询成功！", classifyData);
    }

}
