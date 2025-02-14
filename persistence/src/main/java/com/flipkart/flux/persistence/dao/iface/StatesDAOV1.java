/*
 * Copyright 2012-2016, the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.flipkart.flux.persistence.dao.iface;

import com.flipkart.flux.domain.State;
import com.flipkart.flux.persistence.dto.StateUpdate;
import com.flipkart.flux.persistence.key.FSMIdEntityId;

/**
 * The @DAO interface for @State entity
 * @author regu.b
 *
 */public interface StatesDAOV1 extends DAO <State> {

	/**
	 * Updates the @State entity's underlying data store for the specified field/attribute with the specified data updates 
	 * @param field the entity field/attribute identifier @see @StateUpdate.Field
	 * @param updates the data containing updates
	 */
	public void updateState(StateUpdate.Field field, Object updates);
	
	/**
	 * Gets the replayable retries of the @State identified by the specified @FSMIdEntityId identifier while locking it for subsequent update
	 * @param fsmIdEntityId the FSMIdEntityId identifier
	 * @return the replayable retries
	 */
	public short getReplayableRetriesForUpdate(FSMIdEntityId fsmIdEntityId);
	
}
