package com.crud.springboot.Security;
import io.jsonwebtoken.Jwts;
import javax.crypto.SecretKey;

public class TokenJwtConfig {

    public static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_STRING = "Authorization";
    public static final String COTENT_TYPE = "application/json";

}
