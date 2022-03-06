package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class SessionManager extends AbstractSessionManager {
    private static final SessionManager INSTANCE = new SessionManager();
    public SessionManager() {}
    public static SessionFactory getSessionFactory() {
        return INSTANCE.getSessionFactory("test_hibernate");
    }
    public static void shutdown() {
        INSTANCE.shutdownSessionManager();
    }
    @Override
    protected void setAnnotatedClasses(Configuration configuration) {

    }
}