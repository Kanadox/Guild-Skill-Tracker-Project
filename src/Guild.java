import java.util.List;

public class Guild implements Comparable<Guild> {
    private String name;
    private List<Adventurer> adventurers;

    public Guild(String name, List<Adventurer> adventurers) {
        this.name = name;
        this.adventurers = adventurers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty())
            this.name = name;
    }

    public List<Adventurer> getAdventurers() {
        return adventurers;
    }

    public void setAdventurers(List<Adventurer> adventurers) {
        this.adventurers = adventurers;
    }

    @Override
    public String toString() {
        return "Guild{" +
                "name='" + name + '\'' +
                ", adventurers=" + adventurers +
                '}';
    }

    @Override
    public int compareTo(Guild guild) {
        return this.name.compareTo(guild.name);
    }
}
