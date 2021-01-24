package com.limbo.practice;

import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorProperties;

/**
 * long-night
 *
 * @author : limbo
 * @date : 2020/12/26
 */
public class MyGenerator {
    public static final String GENERATOR_TABLE_KEY = "generator.table";
    public static final String GENERATOR_ALL_KEY = "generator.all";
    public static final String BOOLEAN_TRUE = "true";
    public static void main(String[] args) throws Exception {
        GeneratorFacade g = new GeneratorFacade();
        String templatePath = ClassLoader.getSystemResource("template").getPath();
        g.getGenerator().addTemplateRootDir(templatePath);
        String all = GeneratorProperties.getProperty(GENERATOR_ALL_KEY);
        g.deleteOutRootDir();
        if (BOOLEAN_TRUE.equals(all)) {
            g.generateByAllTable();
        } else {
            String tables =  GeneratorProperties.getRequiredProperty(GENERATOR_TABLE_KEY);
            String[] tableArray = tables.split(",");
            g.generateByTable(tableArray);
        }

    }
}
