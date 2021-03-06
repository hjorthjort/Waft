package com.alive_n_clickin.waft.infrastructure.api;

import com.alive_n_clickin.waft.infrastructure.api.response.JsonFlag;

import java.util.Date;
import java.util.List;

/**
 * An interface for Waft's API.
 *
 * @since 1.0
 */
public interface IWaftApi {
    /**
     * Returns a list of all flags for a specific journey.
     *
     * @param journeyId the journey to get flags for.
     * @return a list of all flags for a specific journey. If there are no flags for the journey,
     * an empty list is returned.
     * @throws ConnectionException if anything goes wrong when fetching the response, or if the
     * server takes more than 5 seconds to respond.
     */
    List<JsonFlag> getFlagsForJourney(String journeyId) throws ConnectionException;

    /**
     * Adds a flag to the Waft database with the specified info.
     *
     * @param dgw the DGW for the bus to flag.
     * @param journeyId the journey id the bus is on currently.
     * @param flagTypeId the id of the flag type.
     * @param comment a comment for the flag.
     * @param createdTime the time the flag was created.
     * @return true if the bus was successfully flagged, otherwise false.
     * @throws ConnectionException if anything goes wrong when fetching the response, or if the
     * server takes more than 5 seconds to respond.
     */
    boolean addFlag(String dgw, String journeyId, int flagTypeId, String comment, Date createdTime)
            throws ConnectionException;
    /**
     * Removes a flag from the Waft database.
     *
     * @param id the id of the flag to remove.
     * @return true if the removal was successful, otherwise false.
     * @throws ConnectionException if anything goes wrong when fetching the response, or if the
     * server takes more than 5 seconds to respond.
     */
    boolean deleteFlag(String id) throws ConnectionException;
}
