package com.limbo.practice.core.base;

import cn.hutool.core.util.ArrayUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.limbo.practice.core.constant.CoreConsts;
import com.limbo.practice.core.util.LoggerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
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
    protected D dao;

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
    @Transactional(rollbackFor = Exception.class, readOnly = false)
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
     * 页面数据保存,局部更新
     *
     * @param vo 页面参数
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = false)
    public ResultBean saveActive(T vo) {
        ResultBean resultBean = new ResultBean();
        int update = dao.updateActive(vo);
        if (update == 1) {
            resultBean.setResultFlg(CoreConsts.SERVICE_SUCCESS);
        } else {
            resultBean.setResultFlg(CoreConsts.SERVICE_FAIL);
        }
        return resultBean;
    }

    /**
     * 页面数据保存
     *
     * @param vo 页面参数
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = false)
    public int update(T vo) {
        return dao.update(vo);
    }

    /**
     * 页面数据保存,局部更新
     *
     * @param vo 页面参数
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = false)
    public int updateActive(T vo) {
        return dao.updateActive(vo);
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
        try {
            Page<T> page = null;
            if (vo.needPage()) {
                page = PageHelper.startPage(vo.getPage(), vo.getLimit(), true);
            }
            List<T> list = dao.list(vo);
            pageTableBean.setData(list);
            pageTableBean.setCode(CoreConsts.CODE_NORMAL);
            if (vo.needPage()) {
                pageTableBean.setCount(page.getTotal());
            }
        } catch (Exception e) {
            LoggerUtils.fmtError(BaseServiceImpl.class, e, "分页查询失败");
            pageTableBean.setCode(CoreConsts.CODE_ERROR);
            pageTableBean.setMsg(e.getMessage());
        }
        return pageTableBean;
    }

    /**
     * 获取数据
     *
     * @param vo 查询参数
     * @return
     */
    @Override
    public T get(T vo){
        T data = dao.get(vo);
        return data;
    }

    /**
     * 通过ID获取数据
     *
     * @param id id
     * @return
     */
    @Override
    public T getById(Long id){
        T data = dao.getById(id);
        return data;
    }

    /**
     * 插入数据
     *
     * @param bean
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = false)
    public Long insertDb(T bean) {
        bean.setGmtCreate(new Date());
       return dao.insert(bean) > 0 ? bean.getId() : null;
    }

    /**
     * 批量插入数据
     *
     * @param beanList
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = false)
    public int insertBatch(List<T> beanList) {
        Date gmtModified = new Date();
        beanList.stream().forEach(o -> {
            o.setGmtCreate(gmtModified);
        });
        return dao.insertBatch(beanList);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = false)
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
     * 批量删除
     *
     * @param ids
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = false)
    public ResultBean batchDelete(Long[] ids) {
        ResultBean resultBean = new ResultBean();
        if (ArrayUtil.isNotEmpty(ids)) {
            Arrays.stream(ids).forEach(o -> dao.delete(o));
            resultBean.setResultFlg(CoreConsts.SERVICE_SUCCESS);
        } else {
            resultBean.setResultFlg(CoreConsts.SERVICE_FAIL);
            resultBean.setMessage("删除id不能为空！");
        }
        return resultBean;
    }

//    protected PageTableBean queryPage(PageTableBean pageTableBean, T vo){
//        Page<T> page = null;
//        if (vo.needPage()) {
//            page = PageHelper.startPage(vo.getPage(), vo.getLimit(), true);
//        }
//        List<T> list = dao.list(vo);
//        pageTableBean.setData(list);
//        pageTableBean.setCode(CoreConsts.CODE_NORMAL);
//        if (vo.needPage()) {
//            pageTableBean.setCount(page.getTotal());
//        }
//        return pageTableBean;
//    }
}
