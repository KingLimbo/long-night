package com.limbo.practice.comm.service.impl;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ClassUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.limbo.practice.comm.service.AnnotationScanService;
import com.limbo.practice.core.annotation.PublicUrl;
import com.limbo.practice.core.constant.CoreConsts;
import com.limbo.practice.core.util.UtilPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * 注解扫描实现类
 *
 * @author limbo
 * @date 2021/7/23
 */
@Service
@Slf4j
public class AnnotationScanServiceImpl implements AnnotationScanService {

    public static void main(String[] args) {
        AnnotationScanServiceImpl annotationScanService = new AnnotationScanServiceImpl();
        List<String> strings = annotationScanService.scanUrlByPublicUrl();
        System.out.println(JSON.toJSONString(strings));
    }

    @Override
    public List<String> scanUrlByPublicUrl() {
        ArrayList<String> urlList = Lists.newArrayList();
        Set<Class<?>> classSet = ClassUtil.scanPackageByAnnotation(CoreConsts.CORE_PACKAGE, RequestMapping.class);
        if (CollectionUtil.isNotEmpty(classSet)) {
            classSet.forEach(aClass -> {
                urlList.addAll(scanController(aClass));
            });
        }
        return urlList;
    }

    public List<String> scanController(Class c) {
        ArrayList<String> urlList = Lists.newArrayList();
        RequestMapping requestMapping = (RequestMapping) c.getAnnotation(RequestMapping.class);
        if (Objects.nonNull(requestMapping)) {
            String cUrl = requestMapping.value()[0];
            boolean hasPublicUrl = AnnotationUtil.hasAnnotation(c, PublicUrl.class);
            Method[] methods = c.getMethods();
            if (ArrayUtil.isNotEmpty(methods)) {
                for (Method method : methods) {
                    boolean methodHasPublicUrl = AnnotationUtil.hasAnnotation(method, PublicUrl.class);
                    if (hasPublicUrl || methodHasPublicUrl) {
                        String mUrl = "";
                        GetMapping get = method.getAnnotation(GetMapping.class);
                        if (Objects.nonNull(get)) {
                            mUrl = get.value()[0] + "*";
                        }
                        PostMapping post = method.getAnnotation(PostMapping.class);
                        if (Objects.nonNull(post)) {
                            mUrl = post.value()[0];
                        }
                        PutMapping put = method.getAnnotation(PutMapping.class);
                        if (Objects.nonNull(put)) {
                            mUrl = put.value()[0];
                        }
                        PatchMapping patch = method.getAnnotation(PatchMapping.class);
                        if (Objects.nonNull(patch)) {
                            mUrl = patch.value()[0];
                        }
                        DeleteMapping delete = method.getAnnotation(DeleteMapping.class);
                        if (Objects.nonNull(delete)) {
                            mUrl = delete.value()[0];
                        }
                        mUrl = cUrl + mUrl;
                        String urlString = UtilPath.replaceAllUrlShiroNone(mUrl);
                        urlList.add(urlString);
                    }
                }
            }
        }
        return urlList;
    }
}
