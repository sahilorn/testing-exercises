package fareye;

public class TestingSolution {

    public static void main(String[] args) {
        int N = 1000;
        for (int i = 1; i < N; i++) {
//            if(i<=10){
//                System.out.println(i);
//            }else if(i<=99){
//                int tensDigit = i/10;
//                int singleDigit = i%10;
//                if(Math.abs((tensDigit-singleDigit)) == 1){
//                    System.out.println(i);
//                }

            if (i <= 999) {
                int hd = i / 100;
                int td = (i % 100) / 10;
                int sd = i % 10;
                System.out.println("");
                if (Math.max(Math.abs(hd - td), Math.abs(td - sd)) == 1) {
                    System.out.println(i);
                }
            }
        }

    }

}
