package com.ticket.system.ticketsystembackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tickets")
public class Ticket {

    @Id
    @GeneratedValue
    private int ticketId;
    private int vendorId;
    private int ticketsPerRelease;
    private String eventName;
    private String venue;
    private String date;
    private String time;
    private double price;

    public Ticket(int vendorId, int ticketsPerRelease,String eventName, String venue, String date, String time, double price) {
        this.vendorId = vendorId;
        this.eventName = eventName;
        this.venue = venue;
        this.date = date;
        this.time = time;
        this.price = price;
        this.ticketsPerRelease = ticketsPerRelease;
    }

    public Ticket() {

    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVendorId() {
        return vendorId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getTicketsPerRelease() {
        return ticketsPerRelease;
    }

    public void setTicketsPerRelease(int ticketsPerRelease) {
        this.ticketsPerRelease = ticketsPerRelease;
    }
}