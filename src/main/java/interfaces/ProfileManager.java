package interfaces;

import javax.servlet.http.Cookie;

public interface ProfileManager {
    boolean checkPrincipal(Cookie[] cookies,String key);
}
