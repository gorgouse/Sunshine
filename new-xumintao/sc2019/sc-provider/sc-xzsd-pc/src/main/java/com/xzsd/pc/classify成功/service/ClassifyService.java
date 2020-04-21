package com.xzsd.pc.classify成功.service;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.classify成功.controller.ClassifyController;
import com.xzsd.pc.classify成功.dao.ClassifyDao;
import com.xzsd.pc.classify成功.entity.ClassifyData;

import com.xzsd.pc.classify成功.entity.ClassifyList;
import com.xzsd.pc.classify成功.entity.ClassifyOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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

        ClassifyList classifyList = new ClassifyList();
        classifyList.setOneClassifyList(classifyOneList);

        return AppResponse.success("查询成功！",classifyOneList);
    }

    /**
     *  删除分类
     *
     * @param classifyData
     * @return
     * @Author xumintao
     * @Date 2020-03-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse classifyDelete(ClassifyData classifyData) {

        //是否存在二级分类
        int isExistTwoClassify = classifyDao.countParentId(classifyData.getClassifyId());
        if(isExistTwoClassify != 0)
        {
            return AppResponse.versionError("改一级分类下存在二级分类,删除失败");
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
