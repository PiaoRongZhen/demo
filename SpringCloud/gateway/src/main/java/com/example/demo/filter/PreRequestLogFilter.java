package com.example.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

public class PreRequestLogFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(PreRequestLogFilter.class);

    // 返回过滤器的类型。有 pre、route、post、error 等几种取值。
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    // 返回一个 int 值来指定过滤器的执行顺序，不同的过滤器允许返回相同的数字。
    @Override
    public int filterOrder() {
        // 在 PRE_DECORATION_FILTER 之前执行
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    // 返回一个 boolean 值来判断该过滤器是否要执行，true 表示执行，false 表示不执行。
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // 过滤器的具体逻辑。
    @Override
    public Object run() {

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        PreRequestLogFilter.LOGGER.info("send " + request.getMethod() + " request to " + request.getRequestURL().toString());

        return null;
    }

}
