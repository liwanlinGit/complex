package www.forest.org.common.client;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {
	static final long EXPIRATIONTIME = 600000;     // 5天
    static final String SECRET = "P@ssw02d";            // JWT密码
    static final String TOKEN_PREFIX = "Bearer";        // Token前缀
    static final String HEADER_STRING = "token";// 存放Token的Header Key
    
 // JWT生成方法
    public static String addAuthentication(String username) throws JSONException {
    // 生成JWT
        String jwt = Jwts.builder()
                // 保存权限（角色）
                .claim("authorities", "ROLE_ADMIN,AUTH_WRITE")
                // 用户名写入标题
                .setSubject(username)
                // 有效期设置
                        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                // 签名设置
                        .signWith(SignatureAlgorithm.HS512, SECRET)
                        .compact();
       return jwt;
       
    }
 
  // JWT验证方法
    public static boolean getAuthentication(HttpServletRequest request) {
        // 从Header中拿到token
        String token = request.getHeader(HEADER_STRING);
 
        if (token != null) {
        	Claims claims=claims= Jwts.parser()
                        // 验签
                        .setSigningKey(SECRET)
                        // 去掉 Bearer
                        .parseClaimsJws(token)
                        .getBody();
            // 拿用户名
            String user = claims.getSubject();
            if(user!=null) {
            	return true;
            }else {
            	 return false;
            }
        }
        return false;
    }
    
    public static String getAuthenticationUser(HttpServletRequest request) {
        // 从Header中拿到token
        String token = request.getHeader(HEADER_STRING);
 
        if (token != null) {
        	Claims claims=claims= Jwts.parser()
                        // 验签
                        .setSigningKey(SECRET)
                        // 去掉 Bearer
                        .parseClaimsJws(token)
                        .getBody();
            // 拿用户名
            String user = claims.getSubject();
            return user;
        }
        return null;
    }
}
