package com.limbo.practice.comm.service;

import java.util.List;

/**
 * 注解扫描
 *
 * @author limbo
 * @date 2021/7/23
 */
public interface AnnotationScanService {

    /**
     * 通过PublicUrl扫描url
     * @return
     */
    List<String> scanUrlByPublicUrl();

}
