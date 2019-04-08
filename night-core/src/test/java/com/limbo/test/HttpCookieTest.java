package com.limbo.test;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpCookieTest {

    private final static String LOGIN_URL = "http://sfgj.yibin.gov.cn/tt/business/buildingRooms_view.asp?ip=&webName=tt&buildid=53911&systemMode=gs";

    private final static String GET_XML_URL = "http://sfgj.yibin.gov.cn/tt/business/buildingRooms_xml.asp?functiontype=6&sid=0.514099159786785&client_showMode=&client_stanID=1610&client_realtypeID=-1&client_mainTable=unrelatedresource&client_mainno=0&client_buildID=53911&floorStart=-100&floorEnd=-100&roomNoStart=-100&roomNoEnd=-100&cancelBldroomShow=4&client_showiscansale=0&client_showRoomCond=&pmBldRoomID=undefined";

    public static void main(String[] args) {
//        // 登陆 Url
//        String loginUrl = "http://passport.mop.com/?targetUrl=http://hi.mop.com/?&g=1447141423230&loginCheck=UNLOGINED";
//        // 需登陆后访问的 Url
//        String dataUrl = "http://hi.mop.com/?";
        HttpClient httpClient = new HttpClient();

        // 模拟登陆，按实际服务器端要求选用 Post 或 Get 请求方式
        PostMethod postMethod = new PostMethod(LOGIN_URL);
        try {
            // 设置 HttpClient 接收 Cookie,用与浏览器一样的策略
            httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
            int statusCode=httpClient.executeMethod(postMethod);

            // 获得登陆后的 Cookie
            Cookie[] cookies = httpClient.getState().getCookies();
            StringBuffer tmpcookies = new StringBuffer();
            for (Cookie c : cookies) {
                tmpcookies.append(c.toString() + ";");
                System.out.println("cookies = "+c.toString());
            }
            if(statusCode==302){//重定向到新的URL
                System.out.println("模拟登录成功");
                // 进行登陆后的操作
                GetMethod getMethod = new GetMethod(GET_XML_URL);
                // 每次访问需授权的网址时需带上前面的 cookie 作为通行证
                getMethod.setRequestHeader("cookie", tmpcookies.toString());
                // 你还可以通过 PostMethod/GetMethod 设置更多的请求后数据
                // 例如，referer 从哪里来的，UA 像搜索引擎都会表名自己是谁，无良搜索引擎除外
                postMethod.setRequestHeader("Referer", "http://passport.mop.com/");
                postMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");
                httpClient.executeMethod(getMethod);
                // 打印出返回数据，检验一下是否成功
                String text = getMethod.getResponseBodyAsString();
                System.out.println(text);
            }
            else {
                System.out.println("登录失败");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

//    /**
//     * 将请求的头信息获取到session中
//     * @param connection
//     */
//    private static String getCookie(URLConnection connection) {
//
//        Map<String, List<String>> map = connection.getHeaderFields();
//        for (String key : map.keySet()) {
//            System.out.println(key + "--->" + map.get(key));
//        }
//
//        List<String> cookie=map.get("Set-Cookie");
//        String cookieStr = cookie.toString().split("\\;")[0];
//        return cookieStr;
//    }
//    private static String loginAndGetSetSession(){
//        //当传入的url返回不为空的时候，读取数据
//        InputStream  input=null;
//        byte[] data = null;//提高字符数据的生成
//        String cookieStr="";
//        if(StringUtils.isEmpty(LOGIN_URL)){
//            try{
//                //设置请求的头信息
//                URL urlInfo = new URL(LOGIN_URL);
//                URLConnection connection = urlInfo.openConnection();
//                connection.addRequestProperty("Host", urlInfo.getHost());//设置头信息
//                connection.addRequestProperty("Connection", "keep-alive");
//                connection.addRequestProperty("Accept", "*/*");
//                connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64)");
//                connection.connect();
//                // 获取所有响应头字段
//                cookieStr = getCookie(connection);
//                //获取请求回来的信息
//                input = connection.getInputStream();//定义返回数据的格式
//                data =  new byte[input.available()];
//                input.read(data);
//
//            }catch(Exception e){
//                System.out.println("读取Url数据失败："+ LOGIN_URL);
//            }finally {
//                try{
//                    input.close();
//                }catch(Exception e){}
//            }
//        }
//        return cookieStr;
//    }
}
