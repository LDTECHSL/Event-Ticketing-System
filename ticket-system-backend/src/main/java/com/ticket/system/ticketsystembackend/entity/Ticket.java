package com.ticket.system.ticketsystembackend.entity;


class Ticket {
    private int vendorId;
    private int ticketsPerRelease;

    public Ticket(int vendorId, int ticketsPerRelease) {
        this.vendorId = vendorId;
        this.ticketsPerRelease = ticketsPerRelease;
    }

    public int getVendorId() {
        return vendorId;
    }

    public int getTicketsPerRelease() {
        return ticketsPerRelease;
    }

    public void setTicketsPerRelease(int ticketsPerRelease) {
        this.ticketsPerRelease = ticketsPerRelease;
    }
}