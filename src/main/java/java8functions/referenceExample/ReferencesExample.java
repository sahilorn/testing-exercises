package java8functions.referenceExample;

import java.lang.ref.WeakReference;

public class ReferencesExample {

    private static class GFG{

        int x;

        public GFG(int i) {
            this.x = i;
        }


        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }
    }

    public static void main(String[] args) {
         GFG gfg = new GFG(1);
        System.out.println(gfg.getX());

        WeakReference<GFG> weakReference = new WeakReference<>(gfg);

        gfg = null;

        gfg = weakReference.get();

        System.out.println(gfg.getX());

    }
}
