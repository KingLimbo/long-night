package com.limbo.practice.sys.service.impl;

import com.limbo.practice.core.base.PageTableBean;
import com.limbo.practice.sys.dao.Sys0101Dao;
import com.limbo.practice.sys.domain.Sys0101VO;
import com.limbo.practice.sys.service.Sys0101Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户一览Service 实现类
 *
 * @author limbo
 * @date 2019/4/25
 */
@Service
public class Sys0101ServiceImpl implements Sys0101Service<Sys0101VO> {

    @Autowired
    private Sys0101Dao sys0101Dao;


    /**
     * 页面初始化
     *
     * @param vo 页面参数
     * @return
     */
    @Override
    public ModelAndView init(Sys0101VO vo) {
        return null;
    }

    /**
     * 页面初始查询
     *
     * @param vo 页面参数
     * @return
     */
    @Override
    public PageTableBean queryList(Sys0101VO vo) {
        return null;
    }

    /**
     * 删除
     *
     * @param vo 页面参数
     * @return
     */
    @Override
    public PageTableBean delete(Sys0101VO vo) {
        return null;
    }
}
