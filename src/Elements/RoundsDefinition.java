package Elements;

import java.util.ArrayList;
import java.util.List;

public class RoundsDefinition {
    List<RoundDefinition> roundList = new ArrayList<RoundDefinition>();

    public RoundsDefinition() {


        roundList.add(
                new RoundDefinition(
                        25,
                        11,
                        13,
                        1
                ).setBlocks(this.getThirdRound())
        );
        roundList.add(
                new RoundDefinition(
                        40,
                        5,
                        10,
                        1
                ).setBlocks(this.getFirstRound())
        );

        roundList.add(
                new RoundDefinition(
                        40,
                        5,
                        10,
                        1
                ).setBlocks(this.getSecoondRound())
        );
    }

    private char[][] getFirstRound() {
        char[][] array = {
                {'m', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'm'},
                {'m', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'm'},
                {'m', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'm'},
                {'m', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'm'},
                {'m', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'm'},
        };
        return array;
    }

    private char[][] getSecoondRound() {
        char[][] array = {
                {'m', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'm'},
                {'e', 'e', 'm', 'm', 'm', 'm', 'm', 'm', 'e', 'e'},
                {'e', 'e', 'm', 'm', 'm', 'm', 'm', 'm', 'e', 'e'},
                {'e', 'e', 'm', 'm', 'm', 'm', 'm', 'm', 'e', 'e'},
                {'m', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'm'},
        };
        return array;
    }

    private char[][] getThirdRound() {
        char[][] array = {
                {'e', 'e', 'e', 'e', 'r', 'e', 'e', 'e', 'r', 'e', 'e', 'e', 'e'},
                {'e', 'e', 'e', 'r', 'r', 'r', 'e', 'r', 'r', 'r', 'e', 'e', 'e'},
                {'e', 'e', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'e', 'e'},
                {'e', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'e'},
                {'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r'},
                {'e', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'e'},
                {'e', 'e', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'e', 'e'},
                {'e', 'e', 'e', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'e', 'e', 'e'},
                {'e', 'e', 'e', 'e', 'r', 'r', 'r', 'r', 'r', 'e', 'e', 'e', 'e'},
                {'e', 'e', 'e', 'e', 'e', 'r', 'r', 'r', 'e', 'e', 'e', 'e', 'e'},
                {'e', 'e', 'e', 'e', 'e', 'e', 'r', 'e', 'e', 'e', 'e', 'e', 'e'},
        };
        return array;
    }

    private char[][] getFourthRound() {
        char[][] array = {
                {'m', 'm', 'r'},

        };
        return array;
    }

    public List<RoundDefinition> getRoundList() {
        return roundList;
    }
}
