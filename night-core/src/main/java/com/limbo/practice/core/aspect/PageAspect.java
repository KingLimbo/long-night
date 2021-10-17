package com.limbo.practice.core.aspect;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.limbo.practice.core.base.PageRO;
import com.limbo.practice.core.base.PageTableBean;
import com.limbo.practice.core.constant.CoreConsts;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 分页Aspect
 *
 * @author limbo
 * @date 2021/8/25
 */
@Aspect
@Component
@Slf4j
public class PageAspect {

    @Around("execution(com.limbo.practice.core.base.PageTableBean com.limbo.practice..*.service.impl.*ServiceImpl.page*(..)) && args(com.limbo.practice.core.base.PageRO)")
    public PageTableBean setPageLimit(ProceedingJoinPoint pj) {
        PageTableBean pageTable = new PageTableBean();
        try {
            PageRO ro = null;
            Object[] args = pj.getArgs();
            for (Object arg : args) {
                if (arg instanceof PageRO) {
                    ro = (PageRO) arg;
                    break;
                }
            }
            Page<?> page;
            if (Objects.nonNull(ro) && ro.needPage()) {
                page = PageHelper.startPage(ro.getPage(), ro.getLimit(), true);
                Object proceed = pj.proceed();
                if (proceed instanceof PageTableBean) {
                    pageTable = (PageTableBean) proceed;
                    pageTable.setCount(page.getTotal());
                    return pageTable;
                }
            } else {
                pj.proceed();
            }
        } catch (Throwable throwable) {
            log.error("PageAspect setPageLimit error", throwable);
            throwable.printStackTrace();
            pageTable.setCode(CoreConsts.CODE_ERROR);
            pageTable.setMsg(throwable.getMessage());
        }
        return pageTable;
    }
}
