package guice.multi.jpa.module;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class Main
{

    public static Injector injector = com.google.inject.Guice.createInjector(new PersistenceModule1(), new PersistenceModule2());

    @Inject
    DAO1 dBService1;

    @Inject
    DAO2 dBService2;

    @Inject
    public Main()
    {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args)
    {
        injector.getInstance(Main.class).testThis();
    }

    public void testThis()
    {
        dBService1.testMe();
        dBService2.testMe();
    }

}
