package edu.ma.westfield.skillguildtracker;

import java.util.List;

/**
 * Represents a guild that contains a collection of adventurers.
 * Guilds can be compared alphabetically by name.
 */
public class Guild implements Comparable<Guild> {
    private String name;
    private List<Adventurer> adventurers;

    /**
     * Creates a new guild with a name and a list of adventurers.
     *
     * @param name         the guild's name
     * @param adventurers  the members of the guild
     */
    public Guild(String name, List<Adventurer> adventurers) {
        this.name = name;
        this.adventurers = adventurers;
    }

    /**
     * @return the guild's name
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the guild’s name if the value is not empty.
     *
     * @param name the new name
     */
    public void setName(String name) {
        if (!name.isEmpty())
            this.name = name;
    }

    /**
     * @return the list of adventurers in the guild
     */
    public List<Adventurer> getAdventurers() {
        return adventurers;
    }

    /**
     * Sets the guild’s list of adventurers.
     *
     * @param adventurers the new list of adventurers
     */
    public void setAdventurers(List<Adventurer> adventurers) {
        this.adventurers = adventurers;
    }

    /**
     * Returns a string containing the guild's name and its adventurers.
     *
     * @return a formatted string representation of the guild
     */
    @Override
    public String toString() {
        return "Guild{" +
                "name='" + name + '\'' +
                ", adventurers=" + adventurers +
                '}';
    }

    /**
     * Compares guilds alphabetically by name.
     *
     * @param guild the other guild to compare with
     * @return comparison result based on name
     */
    @Override
    public int compareTo(Guild guild) {
        return this.name.compareTo(guild.name);
    }
}
