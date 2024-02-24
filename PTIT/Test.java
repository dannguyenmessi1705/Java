package PTIT;

class Test {
    public static int[] quiz(int[] num, int target){
        int [] out = new int[2];
        for (int i = 0; i < num.length; i++){
            for (int j = i+1; j < num.length; j++){
                if (num[i] + num[j] == target){
                    out[0] = i;
                    out[1] = j;
                    return out;
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[] num = {2, 7, 11, 15};
        int target = 9;
        int[] out = quiz(num, target);
        System.out.println(out[0] + " " + out[1]);
    }
}
