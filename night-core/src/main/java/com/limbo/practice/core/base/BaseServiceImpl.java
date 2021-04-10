package com.limbo.practice.core.base;

import com.limbo.practice.core.constant.CoreConsts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 基础service简单实现类
 *
 * @param <T> bean类型
 * @author : limbo
 * @date : 2019/11/16
 */
public class BaseServiceImpl<T extends BaseBO, D extends BaseDao<T>> implements BaseService<T, D> {

    @Autowired
    private D dao;

    /**
     * 页面初始化
     *
     * @param vo 页面参数
     * @return
     */
    @Override
    public ModelAndView init(T vo) {
        return new ModelAndView("/init");
    }

    /**
     * 页面数据保存
     *
     * @param vo 页面参数
     * @return
     */
    @Override
    public ResultBean save(T vo) {
        ResultBean resultBean = new ResultBean();
        int update = dao.update(vo);
        if (update == 1) {
            resultBean.setResultFlg(CoreConsts.SERVICE_SUCCESS);
        } else {
            resultBean.setResultFlg(CoreConsts.SERVICE_FAIL);
        }
        return resultBean;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public ResultBean delete(Long id){
        ResultBean resultBean = new ResultBean();
        int i = dao.delete(id);
        if (i == 1) {
            resultBean.setResultFlg(CoreConsts.SERVICE_SUCCESS);
        } else {
            resultBean.setResultFlg(CoreConsts.SERVICE_FAIL);
        }
        return resultBean;
    }

    /**
     * 页面初始查询
     *
     * @param vo 页面参数
     * @return
     */
    @Override
    public PageTableBean queryList(T vo){
        PageTableBean pageTableBean = new PageTableBean();
        List<T> list = dao.list(vo);
        pageTableBean.setData(list);
        pageTableBean.setCode(0);
        pageTableBean.setCount((long) list.size());
        return pageTableBean;
    }

    /**
     * 插入数据
     *
     * @param bean
     * @return
     */
    @Override
    public int insertDb(T bean) {
       return dao.insert(bean);
    }

    /**
     * 批量插入数据
     *
     * @param beanList
     * @return
     */
    @Override
    public int insertBatch(List<T> beanList) {
        return dao.insertBatch(beanList);
    }
}
