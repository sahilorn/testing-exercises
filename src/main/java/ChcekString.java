public class ChcekString {

     public String generateString(int A, int B)
    {
        StringBuilder solutionString = new StringBuilder();
        while (0 < A || 0 < B)
        {

            if (A < B)
            {
                B--;
                solutionString.append('b');
                if (0 < B--)
                {
                    solutionString.append('b');
                }
                if (0 < A--)
                {
                    solutionString.append('a');
                }
            }

            else if (B < A)
            {
                A--;
                solutionString.append('a');
                if (0 < A--)
                {
                    solutionString.append('a');
                }
                if (0 < B--)
                {
                    solutionString.append('b');
                }
            }
            else
            {
                A--;
                solutionString.append('a');
                B--;
                solutionString.append('b');
            }
        }
        return solutionString.toString();
    }

    public static void main(String[] args)
    {
        int A = 1, B = 3;
        ChcekString ck = new ChcekString();
        System.out.println(ck.generateString(A,B));
    }
}


