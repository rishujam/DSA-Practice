public class Candy {

    public static void main(String[] args) {
        //t1
        int[] i1 = new int[3];
        i1[0] = 1; //1
        i1[1] = 2; //
        i1[2] = 2;
        System.out.print(candy(i1));
    }

    public static int candy(int[] ratings) {
        int noOfCandy = 0;
        for(int i = 0; i < ratings.length; i++) {
            noOfCandy++;
            if(i + 1 == ratings.length) {
                if(ratings[i] > ratings[i - 1]) {
                    noOfCandy++;
                }
            } else {
                if(ratings[i] > ratings[i + 1] || (i - 1 >=0 && ratings[i] > ratings[i - 1])) {
                    noOfCandy++;
                }
            }
        }
        return noOfCandy;
    }

}
