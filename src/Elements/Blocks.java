package Elements;

import Dimensions.Rectangle;
import Dimensions.Point;

import java.awt.*;


public class Blocks {
    private int blockHeight;
    private int numberOfXBlock;
    private int numberOfYBlock;
    private int border;
    /**
     * odstęp w pikselach między blokami w pionie i poziomie  oraz od bandy
     */
    private Rectangle blockShape;
    private RoundDefinition round;
    Block[][] listOfBlocks;


    /**
     * do zrobienia na razie prosto na podstawie zmiennych docelowo jakoś inaczej będzie
     * liczenie wielkości bloków i uzupełnianie tablicy
     *
     */




    Blocks(RoundDefinition round) {
        this.round = round;
        this.blockHeight = round.getBlockHeight();
        this.numberOfYBlock = round.getNumberOfYBlock();
        this.numberOfXBlock = round.getNumberOfXBlock();
        this.border = round.getBorder();
        this.listOfBlocks = new Block[this.numberOfYBlock][this.numberOfXBlock];
        blockShape = new Rectangle(
                (990 - (border) * (numberOfXBlock + 1)) / numberOfXBlock,
                blockHeight
        );
        System.out.println(this.numberOfXBlock + ' ' + this.numberOfYBlock);
        for (int i = 0; i < listOfBlocks.length; i++) {
            for (int j = 0; j < listOfBlocks[i].length; j++) {
                Point point = new Point(
                        border * (j + 1) + j * blockShape.getSizeX(),
                        (i + 1) * border + blockShape.getSizeY() * i
                );
                listOfBlocks[i][j] = BlockFactory.create(round.getBlocks(i, j), point, blockShape);
            }
        }
    }


    public int getNumberOfXBlock() {
        return numberOfXBlock;
    }

    public int getNumberOfYBlock() {
        return numberOfYBlock;
    }

    public Rectangle getBlockShape() {
        return blockShape;
    }


    public void drawMe(Graphics2D g) {

        for (int i = 0; i < listOfBlocks.length; i++)
            for (int j = 0; j < listOfBlocks[i].length; j++) {
                if (!listOfBlocks[i][j].deleted)
                    listOfBlocks[i][j].drawMe(g);
                else
                    listOfBlocks[i][j].drawBonusBox(g);
            }

    }

}
