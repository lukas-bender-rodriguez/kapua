/*******************************************************************************
 * Copyright (c) 2018 Eurotech and/or its affiliates and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.processor.datastore.hono;

import org.eclipse.kapua.broker.client.hono.ClientOptions;
import org.eclipse.kapua.broker.client.hono.ClientOptions.HonoClientOptions;
import org.eclipse.kapua.processor.datastore.hono.settings.HonoDatastoreSettings;
import org.eclipse.kapua.processor.datastore.hono.settings.HonoDatastoreSettingsKey;

public class SourceConfiguration {

    private String clientId;
    private String tenantId;
    private String truststoreFile;

    public SourceConfiguration() {
        clientId = HonoDatastoreSettings.getInstance().getString(HonoDatastoreSettingsKey.HONO_CLIENT_ID);
        tenantId = HonoDatastoreSettings.getInstance().getString(HonoDatastoreSettingsKey.HONO_TENANT_ID);
        truststoreFile = HonoDatastoreSettings.getInstance().getString(HonoDatastoreSettingsKey.HONO_TRUSTSTORE_FILE);
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTruststoreFile(String truststoreFile) {
        this.truststoreFile = truststoreFile;
    }

    public String getTruststoreFile() {
        return truststoreFile;
    }

    public ClientOptions createClientOptions(ConnectionConfiguration connectionOptions) {
        ClientOptions options = new ClientOptions(
                connectionOptions.getConnectionHost(),
                connectionOptions.getPort(),
                connectionOptions.getUsername(),
                connectionOptions.getPassword());
        options.put(HonoClientOptions.CLIENT_ID, getClientId());
        options.put(HonoClientOptions.TENANT_ID, getTenantId());
        options.put(HonoClientOptions.MESSAGE_TYPE, connectionOptions.getTransportMessageType());
        options.put(HonoClientOptions.TRUSTSTORE_FILE,getTruststoreFile());
        options.put(HonoClientOptions.CONNECT_TIMEOUT, connectionOptions.getConnectTimeout());
        options.put(HonoClientOptions.MAXIMUM_RECONNECTION_ATTEMPTS, connectionOptions.getMaxReconnectAttempts());
        options.put(HonoClientOptions.IDLE_TIMEOUT, connectionOptions.getIdelTimeout());
        return options;
    }

}
