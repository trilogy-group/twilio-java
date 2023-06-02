/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.kandy.twiml.video;

import com.kandy.twiml.TwiML;

/**
 * TwiML wrapper for {@code <Room>}
 */
public class Room extends TwiML {
    private final String name;

    /**
     * For XML Serialization/Deserialization
     */
    private Room() {
        this(new Builder((String) null));
    }

    /**
     * Create a new {@code <Room>} element
     */
    private Room(Builder b) {
        super("Room", b);
        this.name = b.name;
    }

    /**
     * The body of the TwiML element
     * 
     * @return Element body as a string if present else null
     */
    protected String getElementBody() {
        return this.getName() == null ? null : this.getName();
    }

    /**
     * Room name
     * 
     * @return Room name
     */
    public String getName() {
        return name;
    }

    /**
     * Create a new {@code <Room>} element
     */
    public static class Builder extends TwiML.Builder<Builder> {
        private String name;

        /**
         * Create a {@code <Room>} with name
         */
        public Builder(String name) {
            this.name = name;
        }

        /**
         * Create and return resulting {@code <Room>} element
         */
        public Room build() {
            return new Room(this);
        }
    }
}
