package edu.ma.westfield.skillguildtracker;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessingApp {
    public static List<Adventurer> filterAdventurers(List<Guild> guilds, Predicate<Adventurer> condition) {
        return guilds.stream()
                .flatMap(g -> (g.getAdventurers().stream()))
                .filter(condition) // Test adventurers for a condition
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        List<Guild> guilds = new ArrayList<>();


            // Adventurers for Guild 1
            Adventurer a1 = new Adventurer("Elen", 25, "Wizard", 800,
                    Arrays.asList(Skill.HEALING, Skill.NECROMANCY, Skill.RUNECRAFTING));
            Adventurer a2 = new Adventurer("Barin", 30, "Warrior", 1500,
                    Arrays.asList(Skill.SWORDSMANSHIP, Skill.HORSEMANSHIP, Skill.BLACKSMITHING));
            Adventurer a3 = new Adventurer("Lysa", 22, "Rogue", 400,
                    Arrays.asList(Skill.THIEVERY, Skill.STEALTH, Skill.MEMECRAFTING));

            Guild g1 = new Guild("Dragon Slayers", Arrays.asList(a1, a2, a3));

            // Adventurers for Guild 2
            Adventurer a4 = new Adventurer("Kael", 35, "Wizard", 1200,
                    Arrays.asList(Skill.NECROMANCY, Skill.RUNECRAFTING));
            Adventurer a5 = new Adventurer("Rina", 28, "Rogue", 950,
                    Arrays.asList(Skill.THIEVERY, Skill.STEALTH));
            Adventurer a6 = new Adventurer("Toran", 40, "Warrior", 2000,
                    Arrays.asList(Skill.SWORDSMANSHIP, Skill.HORSEMANSHIP));

            Guild g2 = new Guild("Shadow Hunters", Arrays.asList(a4, a5, a6));

            // Adventurers for Guild 3
            Adventurer a7 = new Adventurer("Mira", 20, "Wizard", 300,
                    Arrays.asList(Skill.HEALING, Skill.MEMECRAFTING));
            Adventurer a8 = new Adventurer("Finn", 32, "Warrior", 1800,
                    Arrays.asList(Skill.SWORDSMANSHIP, Skill.BLACKSMITHING));
            Adventurer a9 = new Adventurer("Loki", 26, "Rogue", 600,
                    Arrays.asList(Skill.THIEVERY, Skill.STEALTH, Skill.MEMECRAFTING));

            Guild g3 = new Guild("Mystic Blades", Arrays.asList(a7, a8, a9));

            guilds.add(g1);
            guilds.add(g2);
            guilds.add(g3);

        while (choice != 7) {
            System.out.println("Please select an option from 1-7:\n" +
                    "1. Search across guilds for adventurers with a skill\n" +
                    "2. Search across guilds for adventurers of a certain role\n" +
                    "3. Search for the adventurer with the most skills\n" +
                    "4. Rank guilds by their average adventurer age\n" +
                    "5. Create a skill-wise adventurer count map\n" +
                    "6. Grant bonus gold to adventurers with less than 1000 gold\n" +
                    "7. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: // Adventurers across guilds with Skill
                    System.out.println("Please enter the name of the skill to search for: ");
                    String skillInput = scanner.nextLine().toUpperCase(); // Makes it uppercase
                    try {
                        Skill requiredSkill = Skill.valueOf(skillInput); // Turns input to skill
                        filterAdventurers(guilds, adventurer -> adventurer.getSkills().contains(requiredSkill)) // Retruns adventurers with the skill
                                .forEach(System.out::println);
                    }
                    catch (Exception e) {
                        System.out.println("Please enter a valid skill: SWORDSMANSHIP, ARCHERY, THIEVERY, HORSEMANSHIP, STEALTH, HEALING, NECROMANCY, BLACKSMITHING, RUNECRAFTING, or MEMECRAFTING");
                    }
                    break;
                case 2: // Adventurers across guilds by role
                    System.out.println("Please enter the desired role to search for:");
                    String role = scanner.nextLine();
                    filterAdventurers(guilds, adventurer -> adventurer.getRole().equalsIgnoreCase(role)) // Returns adventurers with the role
                            .forEach(System.out::println);
                    break;
                case 3: // Adventurers with most skills
                    guilds.stream()
                            .flatMap(g -> (g.getAdventurers().stream()))
                                .max(Comparator.comparingInt((a -> a.getSkills().size())))
                                .ifPresent(System.out::println); // Prints adventurer with biggest Skills list
                    break;
                case 4: // Guilds by Adventurer age
                    guilds.stream() // Sorts by average adventurer age
                            .sorted(Comparator.comparingDouble(g -> g.getAdventurers().stream()
                            .mapToInt(a -> a.getAge())
                            .average()
                            .getAsDouble())) // Converts to double instead of Double
                            .forEach(g -> {
                                double avgAge = g.getAdventurers().stream()
                                        .mapToInt(a -> a.getAge())
                                        .average()
                                        .getAsDouble();
                                System.out.println(g.getName() + ": Age " + avgAge); // Prints guilds with average age
                            });
                    break;
                case 5: // Skill-wise Adventurer count map
                    Map<Skill, Adventurer> skillMap =  guilds.stream()
                        .flatMap(g -> (g.getAdventurers().stream()))
                        .flatMap(a -> a.getSkills().stream()
                        .map(skill -> new AbstractMap.SimpleEntry<>(skill, a)))
                            .collect(Collectors.toMap(
                                    Map.Entry::getKey, // Skill is set to key
                                    Map.Entry::getValue, // Adventurer is set to value
                            (oldAdv, newAdv) -> newAdv)); // Replaces previous adventurer with skill
                    skillMap.forEach((skill, adventurer) -> System.out.println(skill + ": " + adventurer));
                    break;
                case 6: // Bonus gold event
                    filterAdventurers(guilds, adventurer -> adventurer.getGoldEarned() < 1000) // Adventurers with <1000 gold
                            .forEach(a -> {
                                a.setGoldEarned(a.getGoldEarned() * 1.2); // Gold x 1.2
                                System.out.println(a);
                            });
                    break;
            }
        }
    }
}