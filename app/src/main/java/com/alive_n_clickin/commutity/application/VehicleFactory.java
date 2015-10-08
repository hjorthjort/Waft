package com.alive_n_clickin.commutity.application;

import com.alive_n_clickin.commutity.domain.ArrivingVehicle;
import com.alive_n_clickin.commutity.domain.Bus;
import com.alive_n_clickin.commutity.domain.Flag;
import com.alive_n_clickin.commutity.domain.IArrivingVehicle;
import com.alive_n_clickin.commutity.domain.IBus;
import com.alive_n_clickin.commutity.domain.IFlag;
import com.alive_n_clickin.commutity.infrastructure.api.response.Arrival;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.NonNull;

/**
 * This is a factory for creating ready-to-use vehicles. The idea is that you ask this factory
 * to build a vehicle from existing data (for example an ID or a response object received from
 * an external API), and that the factory simply responds with a bus object. The factory
 * is responsible for fetching all the data required for that bus from whatever sources it needs.
 */
public class VehicleFactory {

    /**
     * Takes a DGW and returns a new bus object with all the data for the bus with that DGW.
     *
     * @param DGW the DGW id for the bus you want to have.
     * @return a new bus object.
     */
    public static IBus getBus(String DGW) {
        // TODO: Build bus from real data
        // 1. get information from ElectriCity's API and our backend
        // 2. create and return bus object with retreived data

        return new Bus(DGW, "destination", "journeyName", "routeNumber", new ArrayList<IFlag>());
    }

    /**
     * Creates a new arriving vehicle object based on an API response.
     *
     * @param arrival The API response
     * @return  A new arriving vehicle based on the response
     * @throws NullPointerException if the parameter is null
     */
    public static IArrivingVehicle getArrivingVehicle(@NonNull Arrival arrival) {
        // TODO: Fetch flags from our backend

        List<IFlag> flags = new ArrayList<>();
        flags.add(new Flag(Flag.Type.NO_PRAMS, "", new Date()));
        flags.add(new Flag(Flag.Type.MESSY, "", new Date()));
        flags.add(new Flag(Flag.Type.MESSY, "", new Date()));
        flags.add(new Flag(Flag.Type.MESSY, "", new Date()));
        flags.add(new Flag(Flag.Type.MESSY, "", new Date()));
        flags.add(new Flag(Flag.Type.OVERCROWDED, "", new Date()));
        flags.add(new Flag(Flag.Type.NO_PRAMS, "", new Date()));
        flags.add(new Flag(Flag.Type.MESSY, "", new Date()));
        flags.add(new Flag(Flag.Type.MESSY, "", new Date()));
        flags.add(new Flag(Flag.Type.MESSY, "", new Date()));

        return new ArrivingVehicle(arrival.getDirection(), arrival.getSname(),
                arrival.getJourneyid(), arrival.getRealArrival(), flags);
    }
}
