package notepad;
import java.io.*;

import javax.swing.JOptionPane;
public class methods {

	
	@SuppressWarnings({ "finally", "resource" })
	public static String openfile(String Dosya_yolu){
		File veri =new File(Dosya_yolu);
		char veriler[]=new char[(int)veri.length()];
		String readed = null;
		try {
			FileReader read = new FileReader(veri);
			read.read(veriler);
			String okunan =new String(veriler);
			readed =okunan;
			
		} catch (FileNotFoundException e) {
			//JOptionPane.showMessageDialog(null, "Dosya Bulunamadý", "HATA", 0);
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			return readed;	
		}	
	}
	
	public static boolean CreateFile(String Dosya_yolu){
		File veri =new File(Dosya_yolu);
			try {
				veri.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return veri.exists();
	}
	
	public boolean delete(String Dosya_yolu){
		File veri =new File(Dosya_yolu);
		veri.delete();
		return veri.exists();
	}
	public static void filewrite(String Dosya_Yolu,String write){
		try {
			FileWriter writer=new FileWriter(Dosya_Yolu);
			writer.write(write);
			writer.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
}
