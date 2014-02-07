package guice.multi.jpa.module;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class DAO2
{

    @Inject
    public DAO2()
    {
    }

    @Inject
    @Named("REACT_DB_TST")
    EntityManager entityManager;

    public void testMe()
    {
        try
        {
            entityManager.getTransaction().begin();
            entityManager.createNativeQuery("CREATE TABLE T1 (ID INT NOT NULL)").executeUpdate();
            entityManager.getTransaction().commit();
        }
        catch (PersistenceException pe)
        {
            if (!Utils.getErrorMessage(pe).contains("already exists in Schema"))
                pe.printStackTrace();
        }
        System.out.println(entityManager.createNativeQuery("SELECT t.tablename FROM sys.systables t where t.tablename='T2'").getSingleResult());

    }

}
