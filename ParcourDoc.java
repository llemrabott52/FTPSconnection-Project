import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParcourDoc{

	public static void main(String args[]) throws IOException {
		 boolean bName;
		    File repertoire = new File("C:\\Users\\stadigital\\Documents\\");
		File[] files=repertoire.listFiles();
		for(int i = 0; i <= files.length ; i++){
			String fileName = files[i].getName();
			Pattern uName = Pattern.compile("[a-zA-Z0-9_.+-]+\\.java");
			Matcher mUname = uName.matcher(fileName);
			bName = mUname.matches();
			if (bName) {
				System.out.println(mUname.group());
			}
		}
	}


}
