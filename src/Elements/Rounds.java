package Elements;

public class Rounds {
    private RoundsDefinition rounds;

    public Rounds() {
        rounds = new RoundsDefinition();
    }

    public int getNumberOfRounds() {
        return this.rounds.getRoundList().size();
    }

    public RoundDefinition getRoundDefinition(int round) {
        return this.rounds.getRoundList().get(round);
    }
}
