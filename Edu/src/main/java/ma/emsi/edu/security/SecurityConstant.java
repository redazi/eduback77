package ma.emsi.edu.security;

public class SecurityConstant {
	public static final long EXPIRATION_TIME= 432_000_000 ;
    public static final String  TOKEN_PREFIX = "Bearer"  ;
    public static final String JWT_TOKEN_HEADER =  "jwt-token";
    public static final String 	TOKEN_CANNOT_BE_VERIFIED = "token cannot be verified" ;
    public static final String GET_ARRAYS_LLC = "get arrays , LLC " ;
    public static final String  GET_ARRAYS_ADMINISTRATION=  "user management portal";
    public static final String AUTHORITIES = "authorities" ;
    public static final String FORBIDEN_MESSAGE = "you need to log in to acces this page"  ;
    public static final String ACCES_DENIED_MESSAGE  = " you do not have permission to acces this page"  ;
    public static final String OPTIONS_HTTP_METHOD = "OPTIONS" ;
    public static final String[] PUBLIC_URLS = {"/","login"} ;



}
