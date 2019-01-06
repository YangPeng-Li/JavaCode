package collection.sortobject;



public class Song implements Comparable<Song> {

	String title;
	String artist;
	String rating;
	String bpm;
	/*
	 * �����ң���� ���Զ������� �ٿض���
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public String getTitle() {
		return title;
	}	
	public Song(String title) {
		super();
		this.title = title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	@Override
	public int compareTo(Song o) {
		return title.compareTo(o.getTitle());
	}
	@Override
	public String toString() {
		return   title ;
	}
	
}
