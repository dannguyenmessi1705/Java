package FileHanding;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ReadFile {
    public static void main(String[] args) {
        try{
        File myfile = new File("C:\\Users\\Admin\\Documents\\codeJAVA\\Project1\\src\\FileHanding\\CreatFile.txt");
        Scanner read = new Scanner(myfile);
        while(read.hasNextLine()){
            String kytu = read.nextLine();
            System.out.println(kytu);

        }
        read.close();
    }
    catch (FileNotFoundException ex){
        System.out.println("Some errors ocurred");
        ex.printStackTrace();
    }
    }    
}
