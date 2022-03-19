package utilstest;

import models.Consult;
import models.Pet;
import models.Veterinarian;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManagerTest extends AbstractSessionManagerTest {
    private static final SessionManagerTest INSTANCE = new SessionManagerTest();
    public SessionManagerTest() {}
    public static SessionFactory getSessionFactory() {
        return INSTANCE.getSessionFactory("pet_clinic_test");
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