public class Prim {
    public static void main(String[] args) {
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verxs=data.length;
        int[][] weight = new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}
        };
        MGragh mGragh=new MGragh(verxs);
        MinTree minTree=new MinTree(mGragh,verxs,data,weight);
        minTree.prim(0);
    }
}


class MinTree {
    MGragh mGragh;
    boolean[] is_check;

    public MinTree(MGragh mGragh, int verxs, char[] data, int[][] weight) {
        this.mGragh = mGragh;
        this.is_check = new boolean[verxs];
        for (int i = 0; i < verxs; i++) {
            this.mGragh.data[i] = data[i];
            for (int j = 0; j < verxs; j++) {
                mGragh.weight[i][j] = weight[i][j];
            }
        }
    }

//    public void prim(int index) {
//        is_check[index] = true;
//        int h1 = -1, h2 = -1;
//        int min_load = 10000;
//        for (int k = 1; k < mGragh.verxs; k++) {
//            for (int i = 0; i < mGragh.data.length; i++) {
//                for (int j = 0; j < mGragh.data.length; j++) {
//                    if (is_check[i] && !is_check[j] && mGragh.weight[i][j] < min_load) {
//                        min_load = mGragh.weight[i][j];
//                        h1 = i;
//                        h2 = j;
//                    }
//                }
//            }
//            System.out.println("路<" + mGragh.data[h1] + "," + mGragh.data[h2] + ">权值" + min_load);
//            is_check[h2] = true;
//            min_load = 10000;
//        }
//    }
public void prim(int index) {
    is_check[index] = true;
    int h1 = -1, h2 = -1;
    int min_load = 10000;
    for (int k = 1; k < mGragh.verxs; k++) {
        for (int i = 0; i < mGragh.data.length; i++) {
            if (is_check[i]) {
                for (int j = 0; j < mGragh.data.length; j++) {
                    if (!is_check[j] && mGragh.weight[i][j] < min_load) {
                        min_load = mGragh.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
        }
        System.out.println("路<" + mGragh.data[h1] + "," + mGragh.data[h2] + ">权值" + min_load);
        is_check[h2] = true;
        min_load = 10000;
    }
}
}

    class MGragh {
        int verxs;
        char[] data;
        int[][] weight;

        public MGragh(int verxs) {
            this.verxs = verxs;
            data = new char[verxs];
            weight = new int[verxs][verxs];
        }

    }