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
package org.eclipse.kapua.processor.datastore.hono.settings;

import org.eclipse.kapua.commons.setting.SettingKey;

/**
 * HonoDatastoreSettingsKey keys.
 * 
 * @since 1.0
 */
public enum HonoDatastoreSettingsKey implements SettingKey {

    /**
     * Hono connection configuration - username
     */
    HONO_USERNAME("datastore.hono.connection.username"),
    /**
     * Hono connection configuration - password
     */
    HONO_PASSWORD("datastore.hono.connection.password"),
    /**
     * Hono connection configuration - truststore file
     */
    HONO_TRUSTSTORE_FILE("datastore.hono.connection.truststore_file"),
    /**
     * Hono connection configuration - tenant id (comma separated tenant id list)
     */
    HONO_TENANT_ID("datastore.hono.connection.tenant_id"),
    /**
     * Hono connection configuration - client id
     */
    HONO_CLIENT_ID("datastore.hono.connection.client_id"),
    /**
     * Hono connection configuration - host
     */
    HONO_HOST("datastore.hono.connection.host"),
    /**
     * Hono connection configuration - port
     */
    HONO_PORT("datastore.hono.connection.port"),
    /**
     * Subscription message type
     */
    HONO_MESSAGE_TYPE("datastore.hono.message_type"),
    /**
     * Maximum reconnection attempts (-1 means no limit)
     */
    HONO_PROTON_MAX_RECONNECT_ATTEMPTS("datastore.hono.connection.proton.max_reconnect_attempts"),
    /**
     * Wait between reconnection attempts
     */
    HONO_PROTON_WAIT_BETWEEN_RECONNECT("datastore.hono.connection.proton.wait_between_reconnection"),
    /**
     * Connection timeout (in seconds)
     */
    HONO_PROTON_CONNECT_TIMEOUT("datastore.hono.connection.proton.connect_timeout"),
    /**
     * idle timeout (in milliseconds)
     */
    HONO_PROTON_IDLE_TIMEOUT("datastore.hono.connection.proton.idle_timeout"),
    /**
     * Exiting code when maximum reconnection attempt is reached
     */
    HONO_EXIT_CODE("datastore.hono.connection.exit_code");

    private String key;

    private HonoDatastoreSettingsKey(String key) {
        this.key = key;
    }

    @Override
    public String key() {
        return key;
    }
}
