package com.limbo.practice.core.freemarker.extend;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.limbo.practice.core.utils.CoreConstans;
import com.limbo.practice.core.utils.LoggerUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

/**
 * FreeMarker视图扩赞类
 *
 * @author lf
 * @version 1.0, 2019年6月11日 <br/>
 */
public class FreeMarkerViewExtend extends FreeMarkerView {

    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) {

        try {
            super.exposeHelpers(model, request);
        } catch (Exception e) {
            LoggerUtils.fmtError(FreeMarkerViewExtend.class, e, "FreeMarkerViewExtend 加载父类出现异常。请检查。");
        }
        model.put(CoreConstans.CONTEXT_PATH, request.getContextPath());
//        model.putAll(Ferrmarker.initMap);
//        User token = TokenManager.getToken();
//        //String ip = IPUtils.getIP(request);
//        if(TokenManager.isLogin()){
//            model.put("token", token);//登录的token
//        }
        // 系统时间
        model.put("_time", new Date().getTime());
        // 今年
        model.put("NOW_YEAY", CoreConstans.NOW_YEAY);

        // 版本号，重启的时间
        model.put("_v", CoreConstans.VERSION);
//        model.put("cdn", CoreConstans.DOMAIN_CDN);//CDN域名
        // base目录。
        model.put("basePath", request.getContextPath());

    }
}