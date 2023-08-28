package FileHanding;

import java.io.File;
import java.io.IOException;

class CreatFile {
    public static void main(String[]args) {
        // Nên dùng try..catch đê tránh 1 số lỗi khi tạo File
        try{
            File myfile = new File("C:\\Users\\Admin\\Documents\\codeJAVA\\Project1\\src\\FileHanding\\CreatFile.txt");
            if(myfile.createNewFile()){
                System.out.println("File created: "+ myfile.getName());
            }
            else{
                System.out.println("File already exists");
            }
        }
        catch (IOException ex){
            System.out.println("Some errors has occured.");
            ex.getStackTrace(); // tìm phương thức bị lỗi
        }
    }    
    
}
