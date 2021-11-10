package Elements;

public class RoundDefinition {
    private int blockHeight;
    private int numberOfXBlock;
    private int numberOfYBlock;
    private int border;
    char[][] blocks;

    public RoundDefinition(int blockHeight, int numberOfYBlock, int numberOfXBlock, int border) {
        this.blockHeight = blockHeight;
        this.numberOfXBlock = numberOfXBlock;
        this.numberOfYBlock = numberOfYBlock;
        this.border = border;
        this.blocks = new char[this.numberOfXBlock][this.numberOfYBlock];
    }

    public int getBlockHeight() {
        return blockHeight;
    }

    public void setBlockHeight(int blockHeight) {
        this.blockHeight = blockHeight;
    }

    public int getNumberOfXBlock() {
        return numberOfXBlock;
    }

    public void setNumberOfXBlock(int numberOfXBlock) {
        this.numberOfXBlock = numberOfXBlock;
    }

    public int getNumberOfYBlock() {
        return numberOfYBlock;
    }

    public void setNumberOfYBlock(int numberOfYBlock) {
        this.numberOfYBlock = numberOfYBlock;
    }

    public int getBorder() {
        return border;
    }

    public void setBorder(int border) {
        this.border = border;
    }

    public char getBlocks(int i, int j) {
        return blocks[i][j];
    }

    public RoundDefinition setBlocks(char[][] blocks) {
        this.blocks = blocks;
        return this;
    }
}
