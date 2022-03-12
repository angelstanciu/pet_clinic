package utils;

import models.Consult;
import models.Pet;
import models.Veterinarian;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class SessionManager extends AbstractSessionManager {
    private static final SessionManager INSTANCE = new SessionManager();
    public SessionManager() {}
    public static SessionFactory getSessionFactory() {
        return INSTANCE.getSessionFactory("pet_clinic");
    }
    public static void shutdown() {
        INSTANCE.shutdownSessionManager();
    }
    @Override
    protected void setAnnotatedClasses(Configuration configuration) {
        configuration.addAnnotatedClass(Consult.class);
        configuration.addAnnotatedClass(Veterinarian.class);
        configuration.addAnnotatedClass(Pet.class);
    }
}