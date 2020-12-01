package com.design.behavior.observer.design;

import com.design.behavior.observer.design.event.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangyuj
 * @date 2020/12/1
 **/
public class EventManager {
    private Map<EventType, List<EventListener>> eventTypeMap = new HashMap<>();

    public EventManager(EventType... eventTypes) {
        for (EventType eventType : eventTypes) {
            eventTypeMap.put(eventType, new ArrayList<>());
        }
    }

    public void subscribe(EventType eventType, EventListener eventListener) {
        List<EventListener> eventListeners = eventTypeMap.getOrDefault(eventType, new ArrayList<>());
        eventListeners.add(eventListener);
        eventTypeMap.put(eventType, eventListeners);
    }

    public void unsubscribe(EventType eventType, EventListener eventListener) {
        List<EventListener> eventListeners = eventTypeMap.get(eventType);
        eventListeners.remove(eventListener);
    }

    public void notice(EventType eventType) {
        List<EventListener> eventList = eventTypeMap.get(eventType);
        if (eventList != null && eventList.size() > 0) {
            eventList.forEach(EventListener::doEvent);
        }
    }

    public enum EventType {
        MQ, MSG;
    }
}
