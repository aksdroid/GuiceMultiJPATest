/** Copyright (c) 2013, TCL, All rights
 * reserved worldwide. This program or documentation is supplied
 * pursuant to and its use is governed by a license agreement
 * from TCL and contains confidential information
 * of TCL Disclosure and copying are subject to
 * restrictions contained in such agreement and any subsidiary
 * agreement.
 * author: pcaetano
 */
package guice.multi.jpa.module;

import javax.persistence.EntityManager;

import com.google.inject.PrivateModule;
import com.google.inject.name.Names;
import com.google.inject.persist.jpa.JpaPersistModule;

/**
 * Module for persistence
 * 
 * @author pcaetano
 * 
 */
public class PersistenceModule2 extends PrivateModule
{

    @Override
    protected void configure()
    {
        install(new JpaPersistModule("REACT_DB_TST"));
        bind(PersistenceInitializer.class).asEagerSingleton();
        bind(EntityManager.class).annotatedWith(Names.named("REACT_DB_TST")).to(EntityManager.class);
        expose(EntityManager.class).annotatedWith(Names.named("REACT_DB_TST"));

    }

}
