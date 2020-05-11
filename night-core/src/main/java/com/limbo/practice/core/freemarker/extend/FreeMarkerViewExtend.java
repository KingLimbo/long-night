package com.limbo.practice.core.freemarker.extend;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.limbo.practice.core.constant.CoreConsts;
import com.limbo.practice.core.util.LoggerUtils;
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

        // 系统时间
        model.put("_time", new Date().getTime());
        // 今年
        model.put("NOW_YEAY", CoreConsts.NOW_YEAY);

        // 版本号，重启的时间
        model.put("_v", CoreConsts.VERSION);

        // base目录。
        model.put(CoreConsts.CONTEXT_PATH, request.getContextPath());

    }
}