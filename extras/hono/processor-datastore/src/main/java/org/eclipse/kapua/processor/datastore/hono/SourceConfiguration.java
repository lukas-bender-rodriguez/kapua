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

import io.vertx.proton.ProtonQoS;

public class SourceConfiguration {

    private boolean autoAccept;

    private String qos;
    private String clientId;
    private String destination;
    private int prefetchMessages;
    private String tenantId;
    private String truststoreFile;

    public SourceConfiguration() {
        clientId = HonoDatastoreSettings.getInstance().getString(HonoDatastoreSettingsKey.TELEMETRY_CLIENT_ID);
        destination = HonoDatastoreSettings.getInstance().getString(HonoDatastoreSettingsKey.TELEMETRY_DESTINATION);
        prefetchMessages = HonoDatastoreSettings.getInstance().getInt(HonoDatastoreSettingsKey.TELEMETRY_PREFETCH_MESSAGES);
        autoAccept = false;
        qos = ProtonQoS.AT_LEAST_ONCE.name();
    }

    public boolean isAutoAccept() {
        return autoAccept;
    }

    public void setAutoAccept(boolean autoAccept) {
        this.autoAccept = autoAccept;
    }

    public String getQos() {
        return qos;
    }

    public void setQos(String qos) {
        this.qos = qos;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getPrefetchMessages() {
        return prefetchMessages;
    }

    public void setPrefetchMessages(int prefetchMessages) {
        this.prefetchMessages = prefetchMessages;
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
        options.put(HonoClientOptions.TENANT_ID, getTenantId());
        options.put(HonoClientOptions.TRUSTSTORE_FILE,getTruststoreFile());
        options.put(HonoClientOptions.DESTINATION, getDestination());
        options.put(HonoClientOptions.CONNECT_TIMEOUT, connectionOptions.getConnectTimeout());
        options.put(HonoClientOptions.MAXIMUM_RECONNECTION_ATTEMPTS, connectionOptions.getMaxReconnectAttempts());
        options.put(HonoClientOptions.IDLE_TIMEOUT, connectionOptions.getIdelTimeout());
        return options;
    }

}
