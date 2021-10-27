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

package com.flipkart.flux.dao.iface;

import com.flipkart.flux.api.EventData;
import com.flipkart.flux.domain.Event;

import java.util.List;
import java.util.Map;

/**
 * <code>EventsDAO</code> interface provides methods to perform CR operations on {@link Event}
 * @author shyam.akirala
 */
public interface EventsDAO {

    /** Creates Event in the db, and returns the saved object*/
    Event create(String stateMachineInstanceId, Event event);

    /** Updates the event */
    void updateEvent(String stateMachineInstanceId, Event event);

    /** Retrieves all the events which belongs to a particular state machine instance*/
    List<Event> findBySMInstanceId(String stateMachineInstanceId);


    /** Retrieves Event by state machine instance id and event name */
    Event findBySMIdAndName(String stateMachineInstanceId, String eventName);

    /** Retrieves list of events which are in triggered/cancelled state and belongs to provided state machine */
    List<String> findTriggeredOrCancelledEventsNamesBySMId(String stateMachineInstanceId);

    /** Retrieves list of events which are in triggered state and belongs to provided state machine */
    List<Event> findTriggeredEventsBySMId(String stateMachineInstanceId);

    /** Retrieves list of events by their names and state machine id */
    List<EventData> findByEventNamesAndSMId(String stateMachineInstanceId, List<String> eventNames );

    /** Retrieves list of versioned events by their names and state machine id */
    List<EventData> findByVersionedEventNamesAndSMId(String stateMachineInstanceId, List<String> eventNames );

    /** Retrieves all the events names and statuses. Selects for update if forUpdate is true */
    Map<String, Event.EventStatus> getAllEventsNameAndStatus(String stateMachineInstanceId, boolean forUpdate);

    /** Marks an event as cancelled */
    void markEventAsCancelled(String stateMachineInstanceId, String eventName);
}