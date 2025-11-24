package edu.ma.westfield.skillguildtracker;

import java.util.List;

/**
 * Represents an adventurer with identifying information, a role, gold earned,
 * and a set of skills. Adventurers can be compared alphabetically by name.
 */
public class Adventurer implements Comparable<Adventurer> {
    private String name;
    private int age;
    private String role;
    private double goldEarned;
    private List<Skill> skills;

    /**
     * Creates a new adventurer with the given attributes.
     *
     * @param name       the adventurer's name
     * @param age        the adventurer's age
     * @param role       the adventurer's role or class
     * @param goldEarned the amount of gold the adventurer has earned
     * @param skills     the list of skills the adventurer possesses
     */
    public Adventurer(String name, int age, String role, double goldEarned, List<Skill> skills) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.goldEarned = goldEarned;
        this.skills = skills;
    }

    /**
     * @return the adventurer’s name
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the adventurer’s name if the value is not empty.
     *
     * @param name the new name
     */
    public void setName(String name) {
        if (!name.isEmpty())
            this.name = name;
    }

    /**
     * @return the adventurer’s age
     */
    public int getAge() {
        return age;
    }

    /**
     * Updates the adventurer's age if the value is positive.
     *
     * @param age the new age
     */
    public void setAge(int age) {
        if (age > 0)
            this.age = age;
    }

    /**
     * @return the adventurer’s role or class
     */
    public String getRole() {
        return role;
    }

    /**
     * Updates the adventurer's role if the value is not empty.
     *
     * @param role the new role
     */
    public void setRole(String role) {
        if (!role.isEmpty())
            this.role = role;
    }

    /**
     * @return the amount of gold the adventurer has earned
     */
    public double getGoldEarned() {
        return goldEarned;
    }

    /**
     * Sets the gold earned by the adventurer.
     *
     * @param goldEarned the new gold amount
     */
    public void setGoldEarned(double goldEarned) {
        this.goldEarned = goldEarned;
    }

    /**
     * @return a list of the adventurer’s skills
     */
    public List<Skill> getSkills() {
        return skills;
    }

    /**
     * Sets the list of skills for the adventurer.
     *
     * @param skills a new list of skills
     */
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    /**
     * Returns a string containing the adventurer’s name, role, age, gold earned,
     * and skills.
     *
     * @return a formatted string representation of the adventurer
     */
    @Override
    public String toString() {
        return name +
                " (Role: " + role +
                ", Age: " + age +
                ", Gold: " + goldEarned +
                ") Skills: " + skills;
    }

    /**
     * Compares adventurers alphabetically by name.
     *
     * @param adventurer the other adventurer to compare with
     * @return a negative, zero, or positive integer depending on name ordering
     */
    @Override
    public int compareTo(Adventurer adventurer) {
        return this.name.compareTo(adventurer.name);
    }
}