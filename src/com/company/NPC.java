package com.company;

public class NPC extends Person{
    public NPC(String name) {
        setName(name);
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public enum Agency { Trainer, Vendor } private Agency agency;

}
