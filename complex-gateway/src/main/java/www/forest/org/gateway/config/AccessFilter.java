package www.forest.org.gateway.config;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import io.jsonwebtoken.ExpiredJwtException;
import www.forest.org.common.client.TokenAuthenticationService;
import www.forest.org.common.util.JsonUtil;
import www.forest.org.common.util.ResultMessage;
import www.forest.org.common.util.StringUtil;
@Component
public class AccessFilter extends  ZuulFilter {

	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        if (request.getMethod().equals("OPTIONS")) {
            return false;
        }
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
        String token = request.getHeader("token");
        String pathName = request.getServletPath();
        if(!StringUtils.isBlank(pathName)&&!pathName.contains("login")){
        	if(StringUtil.isBlank(token)) {
        		ctx.getResponse().setContentType("text/html;charset=UTF-8");
        		ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(Integer.parseInt(ResultMessage.SUCCESS_CODE));
                ctx.setResponseBody(JsonUtil.toJson(ResultMessage.result(ResultMessage.TOKEN_NO, ResultMessage.ERROR_CODE_503)));
        	}else {
        		try{
           		 boolean authentication = TokenAuthenticationService.getAuthentication(request);
            	 if(authentication) {
            		return null;
            	 }
           	 }catch (Exception e) {
           		 if(e instanceof ExpiredJwtException) {
           			    ctx.setSendZuulResponse(false);
           			    ctx.getResponse().setContentType("text/html;charset=UTF-8");
                        ctx.setResponseStatusCode(Integer.parseInt(ResultMessage.SUCCESS_CODE));
                        ctx.setResponseBody(JsonUtil.toJson(ResultMessage.result(ResultMessage.TOKEN_EXPIRED, ResultMessage.ERROR_CODE_503)));
           		 }else {
           			    ctx.setSendZuulResponse(false);
           			    ctx.getResponse().setContentType("text/html;charset=UTF-8");
                        ctx.setResponseStatusCode(Integer.parseInt(ResultMessage.SUCCESS_CODE));
                        ctx.setResponseBody(JsonUtil.toJson(ResultMessage.result(ResultMessage.TOKEN_FAIL, ResultMessage.ERROR_CODE_503)));
           		 }
				}
        	}
        }
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
