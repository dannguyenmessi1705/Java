package FileHanding;

import java.io.FileWriter;
import java.io.IOException;

class WriteFile {
    public static void main(String[]args) {
        try{
            FileWriter myfile = new FileWriter("C:\\Users\\Admin\\Documents\\codeJAVA\\Project1\\src\\FileHanding\\CreatFile.txt");
            myfile.write("Đây là văn bản được tạo bởi code JAVA");
            System.out.println("Goobye");
            myfile.close();
    }
        catch(IOException ex){
            System.out.println("Some errors occurred");
            ex.printStackTrace();
        }
}
}
