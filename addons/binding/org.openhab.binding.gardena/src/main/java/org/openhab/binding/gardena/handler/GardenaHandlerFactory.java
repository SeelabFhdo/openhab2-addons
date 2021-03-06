/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.gardena.handler;

import static org.openhab.binding.gardena.GardenaBindingConstants.*;

import org.eclipse.smarthome.core.thing.Bridge;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;

/**
 * The {@link GardenaHandlerFactory} is responsible for creating Gardena things and thing handlers.
 *
 * @author Gerhard Riegler - Initial contribution
 */
public class GardenaHandlerFactory extends BaseThingHandlerFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        return BINDING_ID.equals(thingTypeUID.getBindingId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ThingHandler createHandler(Thing thing) {
        if (THING_TYPE_ACCOUNT.equals(thing.getThingTypeUID())) {
            return new GardenaAccountHandler((Bridge) thing);
        } else {
            return new GardenaThingHandler(thing);
        }
    }
}
