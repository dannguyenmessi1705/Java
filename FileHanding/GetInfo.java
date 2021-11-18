package FileHanding;

import java.io.File;

class GetInfo {
    public static void main(String[]args) {
        File myfile = new File("C:\\Users\\Admin\\Documents\\codeJAVA\\Project1\\src\\FileHanding\\CreatFile.txt");
        if(myfile.exists()){
            System.out.println("Ten file: "+myfile.getName());
            System.out.println("Duong dan: "+myfile.getAbsolutePath());
            System.out.println("Co the ghi file: "+myfile.canWrite());
            System.out.println("Co the doc file: "+myfile.canRead());
            System.out.println("Kich thuoc File: "+myfile.length());
        }
        else{
            System.out.println("File khong ton tai.") ;
        }
    }    
}
