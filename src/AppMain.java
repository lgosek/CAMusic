public class AppMain {
    static void printCA(int[] grid){
        for (int el: grid) {
            if(el == 0)
                System.out.print("   ");
            else
                System.out.print(" 1 ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        CA ca = new CA(97);
//        12 - 1 dźwięk, 134, 105
        MusicInterpreter music = new MusicInterpreter();

        for(int i=0; i< 30; i++){
            AppMain.printCA(ca.getGrid());
            music.addChord(ca.getNonZeroIndexes());
            ca.updateCAState();
        }
        music.saveScore();
    }
}
