/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class EventBean implements Serializable {
    private int eventID;
    private String eventName;
    private String eventDate;
    private String venue;
    private int ticketPrice;
    private int seatsAvailable;

    public EventBean() {
    }

    public int getEventID() {
        return eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getVenue() {
        return venue;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }
    
    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setEventID (int eventID) {
        this.eventID = eventID;
    }

    public void setEventName (String eventName) {
        this.eventName = eventName;
    }

    public void setEventDate (String eventDate) {
        this.eventDate = eventDate;
    }

    public void setVenue (String venue) {
        this.venue = venue;
    }

    public void setTicketPrice (int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    
    public void setSeatsAvailable (int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }
    
}
