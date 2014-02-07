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

import javax.inject.Inject;

import com.google.inject.persist.PersistService;

/**
 * initialize the persistence server here
 * 
 * @author pcaetano
 * 
 */
public class PersistenceInitializer
{
    @Inject
    public PersistenceInitializer(PersistService service)
    {
        // the persist service must be initialized once
        service.start();
    }
}
