package www.forest.org.common.util;

import java.util.HashMap;
import java.util.Map;

public class ResultMessage {

	public final static String STATUSCODE="statusCode";
	
	public final static String DATA="data";
	
	public final static String SUCCESS_CODE="200"; //成功状态码
	
	public final static String SUCCESS_CODE_204="204";//成功但是没返回数据
	
	public final static String ERROR_CODE="500";//服务器错误
	
	public final static String ERROR_CODE_503="503";//token 校验
	
	
	public final static String RESULT_NO="未查找到信息";
	
	public final static String RESULT_500="服务器错误";
	
	public final static String TOKEN_NO="token不能为空";
	
	public final static String TOKEN_EXPIRED="token已过期";
	
	public final static String TOKEN_FAIL="token校验失败";
	
	public final static String USERNAME_NULL="没有该用户";
	
	
	public static Map<String, Object> result(String message,String statusCode) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put(STATUSCODE, statusCode);
		map.put(DATA, message);
		return map;
	}
	
	public static Map<String, Object> result(String result){
		if(!StringUtil.isBlank(result)) {
			if(ResultMessage.ERROR_CODE.equals(result)) {
				return result(ResultMessage.RESULT_500, ResultMessage.ERROR_CODE);
			}else {
				return result(result, ResultMessage.SUCCESS_CODE);
			}
		}else {
			return result(ResultMessage.RESULT_NO, ResultMessage.SUCCESS_CODE_204);
		}
	}
	
}
