package interfaces;

import models.User;

public interface AuthManager {
    boolean checkAuthorization(User user);
}
