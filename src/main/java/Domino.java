public class Domino {

    private int leftValue;
    private int rightValue;

    public Domino(int leftValue, int rightValue) {
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    public int getLeftValue() {
        return leftValue;
    }

    public int getRightValue() {
        return rightValue;
    }

    public static void main(String[] args) {
        // This creates the Array
        Domino[] dominos = new Domino[] {
                new Domino(4, 3),
                new Domino(3, 4),
                new Domino(1, 2),
                new Domino(2, 3),
                new Domino(6, 5),
                new Domino(4, 5)
        };
        // This part Loops and matchs left and right values
        Domino previous = null;

        for (Domino current : dominos) {
            if (previous != null) {
                if (current.getLeftValue() != previous.getRightValue()) {
                    try {
                        throw new Exception("Illegal");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            previous = current;
        }

        /*for (Domino current : dominos) {
            if (previous != null) {
                if (current.getLeftValue() != previous.getRightValue()) {
                    System.out.println("[" + previous.getLeftValue() + " " + previous.getRightValue()
                            + "][" + current.getLeftValue() + " " + current.getRightValue() + "] is illegal");
                } else {
                    System.out.println("[" + previous.getLeftValue() + " " + previous.getRightValue()
                            + "][" + current.getLeftValue() + " " + current.getRightValue() + "] is legal");
                }
            }
            previous = current;
        }*/
    }

}
