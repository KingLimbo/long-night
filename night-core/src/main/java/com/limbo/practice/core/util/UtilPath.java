package com.limbo.practice.core.util;

import cn.hutool.core.util.StrUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 静态化路径工具类
 *
 * @author limbo
 * @version 0.0.1v
 */
public class UtilPath {

    /**
     * 获取到classes目录
     *
     * @return path
     */
    public static String getClassPath() {
        String systemName = System.getProperty("os.name");

        //判断当前环境，如果是Windows 要截取路径的第一个 '/'
        if (!StringUtils.isBlank(systemName) && systemName.indexOf("Windows") != -1) {
            return UtilPath.class.getResource("/").getFile().toString().substring(1);
        } else {
            return UtilPath.class.getResource("/").getFile().toString();
        }
    }

    /**
     * 获取当前对象的路径
     *
     * @param object
     * @return path
     */
    public static String getObjectPath(Object object) {
        return object.getClass().getResource(".").getFile().toString();
    }

    /**
     * 获取到项目的路径
     *
     * @return path
     */
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    /**
     * 获取 root目录
     *
     * @return path
     */
    public static String getRootPath() {
        return getWEB_INF().replace("WEB-INF/", "");
    }

    /**
     * 获取输出HTML目录
     *
     * @return
     */
    public static String getHTMLPath() {
        return getFreePath() + "html/html/";
    }

    /**
     * 获取输出FTL目录
     *
     * @return
     */
    public static String getFTLPath() {
        return getFreePath() + "html/ftl/";
    }

    /**
     * 获取 web-inf目录
     *
     * @return path
     */
    public static String getWEB_INF() {
        return getClassPath().replace("classes/", "");
    }

    /**
     * 获取模版文件夹路径
     *
     * @return path
     */
    public static String getFreePath() {
        return getWEB_INF() + "ftl/";
    }

    /**
     * 获取一个目录下所有的文件
     *
     * @param path
     * @return
     */
    public static File[] getFiles(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        return files;
    }

    /**
     * 获取当前时间 + 中国时区
     *
     * @return
     */
    public static String getDate() {
        SimpleDateFormat sformart = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String result = sformart.format(new Date());
        result = result.replace("_", "T");
        result += "+08:00";
        return result;
    }

    /**
     * 不带结尾的XmlSitemap头部
     *
     * @return
     */
    public static String getXmlSitemap() {
        StringBuffer sb = new StringBuffer()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + nextLine())
                .append("<?xml-stylesheet type=\"text/xsl\" href=\"sitemap.xsl\"?>" + nextLine())
                .append("<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">" + nextLine());
        return sb.toString();
    }

    /**
     * 文本换行
     *
     * @return
     */
    public static String nextLine() {
        String nextLine = System.getProperty("line.separator");
        return nextLine;
    }

    /**
     * 获取domain
     *
     * @param request
     * @return
     */
    public static String getDomain(HttpServletRequest request) {
        return ((String) request.getSession().getAttribute("nowPath")).replaceAll("(www.)|(.com)|(.net)|(http://)", "").trim();
    }

    /**
     * 获取images 路径
     *
     * @return
     */
    public static String getImages() {
        return getRootPath() + "images/";
    }

    /**
     * 替换url参数
     *
     * @param url
     * @return
     */
    public static String replaceAllUrlParams(String url) {
        String str = "";
        if (StrUtil.isNotBlank(url)) {
            String patternDoubleSlash = "\\//";
            Pattern rDoubleSlash = Pattern.compile(patternDoubleSlash);
            Matcher mDoubleSlash = rDoubleSlash.matcher(url);
            url = mDoubleSlash.replaceAll("/");
            String pattern = "\\{[a-zA-Z0-9-]*}";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(url);
            str = m.replaceAll(".*");
        }
        return str;
    }

    /**
     * 替换url,shiro[none]验证规则
     *
     * @param url
     * @return
     */
    public static String replaceAllUrlShiroNone(String url) {
        String str = replaceAllUrlParams(url);
        if (StrUtil.isNotBlank(str)) {
            if (StrUtil.endWith(str, "*")) {
                str += "*";
            }
        }
        return str;
    }
}