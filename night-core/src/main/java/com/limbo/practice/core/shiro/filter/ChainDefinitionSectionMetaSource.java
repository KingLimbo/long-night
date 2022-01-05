package com.limbo.practice.core.shiro.filter;

import com.limbo.practice.comm.service.AnnotationScanService;
import org.apache.shiro.config.Ini;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * 自定义的动态获取资源类
 *
 * @author limbo
 * @date 2021/7/30
 */
@Component
public class ChainDefinitionSectionMetaSource implements FactoryBean<Ini.Section> {

    @Autowired
    private AnnotationScanService annotationScanService;

    /**
     * 默认permission字符串
     */
    public static final String PERMISSION = "anon";
    public static final String LAST_FILTER_KEY = "/**";
    public static final String LAST_FILTER_VALUE = "authc";

    /**
     * 过滤规则
     */
    private String filterChainDefinitions;

    @Override
    public Ini.Section getObject() throws Exception {
        // 获取所有Public url
        List<String> list = annotationScanService.scanUrlByPublicUrl();

        Ini ini = new Ini();
        // 加载默认的url
        ini.load(filterChainDefinitions);
        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        if (Objects.isNull(section)) {
            section = ini.addSection(Ini.DEFAULT_SECTION_NAME);
        }
        // 循环Resource的url,逐个添加到section中。section就是filterChainDefinitionMap,
        // 里面的键就是链接URL,值就是存在什么条件才能访问该链接
        for (String url : list) {
            section.put(url, PERMISSION);
        }
        section.put(LAST_FILTER_KEY, LAST_FILTER_VALUE);
        return section;
    }

    /**
     * 通过filterChainDefinitions对默认的url过滤定义
     *
     * @param filterChainDefinitions 默认的url过滤定义
     */
    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }


    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
