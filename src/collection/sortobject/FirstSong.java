package collection.sortobject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.log4j.Logger;


//CompletableFuture 
public class FirstSong {
	
	private static Logger logger = Logger.getLogger(FirstSong.class);
	public static void main(String[] args) {
		
		logger.info("开始打印");
		new FirstSong().go();
		
	}

	public void go()
	{
		getSongs();
		System.out.println("比较前"+songList);
		Collections.sort(songList);
		System.out.println("比较后"+songList);
		
	}
	
	 @SuppressWarnings("resource")
	void getSongs()
	{
		try {
			File f = new File ("Songlist.txt");
			BufferedReader reader = new  BufferedReader (new FileReader(f));
			String line = null;
				while((line = reader.readLine()) !=null)
				{
					addSong(line);
					//System.out.println("line-----"+line);
				}
		}  
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	
	public  void addSong (String lineToParse)
	{
		 int indexOf = lineToParse.indexOf("/");
		 String songName = lineToParse.substring(0, indexOf);
		 Song sn = new Song(songName);
		 songList.add(sn);
	}
	 ArrayList <Song> songList = new ArrayList<Song>();
	
	
}
