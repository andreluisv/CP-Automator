import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Pair{
  String first;
  String second;
  public Pair(String x, String y){
  	this.first=x;
  	this.second=y;
  }
}

class Main{

	private String CP_PATH;
	
	public Main(String path){this.CP_PATH = path+"/";};

	ArrayList<Pair> map;

	public String getContent(File file){
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(file));
			String ret = "";
			String line = reader.readLine();
			while(line!=null){
				ret += line + System.lineSeparator();
				line = reader.readLine();
			}
			return ret;
		}catch(IOException e){e.printStackTrace();}
		finally{try{reader.close();}catch(IOException e){e.printStackTrace();}}
		return "";
	}

	public void listFilesForFolder(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
		    if (fileEntry.isDirectory()) {
		        listFilesForFolder(fileEntry);
		    } else {
		        this.map.add(new Pair(fileEntry.getName(), this.getContent(fileEntry)));
		    }
		}
	}

	public void fetchFiles(){
		this.map = new ArrayList<Pair>();
		final File folder = new File(this.CP_PATH+"algorithms");
		this.listFilesForFolder(folder);
	}
	
	public Pair chooseAlgorithm(){
	 	Scanner in = new Scanner(System.in);
		
		while(true){
			System.out.print("Search for: ");
			String input = in.next(); input=input.toLowerCase();
			ArrayList<Pair> matches = new ArrayList<Pair>();
			for (int i = 0; i < map.size(); i++){
				if (map.get(i).first.toLowerCase().contains(input)){
					matches.add(map.get(i));
				}
			}
			
			int sz = matches.size();
			
			if (sz==0){
				System.out.println("Couldn\'t match to any known algorithm, please try again.");
			}else if (sz==1){
				System.out.printf("Found match (%s). Is that what you\'re looking for? (y/n)   ", matches.get(0).first);
				String ans = in.next();
				if (ans.equals("y")) return matches.get(0);
			}else{
				System.out.println("Found more than one option:");
				
				for (int i = 0; i < sz; i++){
					System.out.printf("%d - %s\n", i, matches.get(i).first);
				}
				
				System.out.print("Type the option\'s index or -1 to continue searching: ");
				int i = in.nextInt();
				if (i<0 || i>= sz) continue;
				return matches.get(i);
			}
		
		}
	}
	
	public void run (String[] args){
		fetchFiles();
		Pair content = this.chooseAlgorithm();
		File maincpp = new File(this.CP_PATH+"main.cpp");
		FileWriter writer = null;
		try{
			String oldcpp = getContent(maincpp);
			
			String flag = "PASTEFLAG";
            String newcpp = oldcpp.replace(flag, flag+"\n"+"//"+content.first+"\n"+content.second);
            
			writer = new FileWriter(maincpp);
			writer.write(newcpp);
		}catch(IOException e){e.printStackTrace();}
		finally{try{writer.close();}catch(IOException e){e.printStackTrace();}}
        
		System.out.println("Done");
	}
	
	public static void main (String[] args){
		try
		{
			Main obj = new Main(System.getenv("CP_PATH"));
			obj.run (args);
		}
		catch (Exception e)
		{
			e.printStackTrace ();
		}
	}
}
