/*************************************************************************
 *                                                                       *
 *  EJBCA: The OpenSource Certificate Authority                          *
 *                                                                       *
 *  This software is free software; you can redistribute it and/or       *
 *  modify it under the terms of the GNU Lesser General Public           *
 *  License as published by the Free Software Foundation; either         *
 *  version 2.1 of the License, or any later version.                    *
 *                                                                       *
 *  See terms of license at gnu.org.                                     *
 *                                                                       *
 *************************************************************************/
package org.cesecore.certificates.ocsp;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.cesecore.authorization.AuthorizationDeniedException;
import org.cesecore.certificates.ocsp.integrated.IntegratedOcspResponseGeneratorSessionLocal;
import org.cesecore.jndi.JndiConstants;

/**
 * @version $Id$
 *
 */
@Stateless(mappedName = JndiConstants.APP_JNDI_PREFIX + "IntegratedOcspResponseGeneratorProxySessionRemote")
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class IntegratedOcspResponseGeneratorProxySessionBean implements IntegratedOcspResponseGeneratorProxySessionRemote {

    @EJB
    private IntegratedOcspResponseGeneratorSessionLocal integratedOcspResponseGeneratorSession;
    
    @Override
    public void reloadTokenAndChainCache() throws AuthorizationDeniedException {
        integratedOcspResponseGeneratorSession.reloadTokenAndChainCache();
    }

}