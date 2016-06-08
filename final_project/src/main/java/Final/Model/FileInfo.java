package Final.Model;

import com.sun.jmx.snmp.Timestamp;

public class FileInfo {
	private int file_number;
	private String id;
	private String title;
	private Timestamp modify_date;
	private String path;
	
	public int getFile_number() {
		return file_number;
	}
	public void setFile_number(int file_number) {
		this.file_number = file_number;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getModify_date() {
		return modify_date;
	}
	public void setModify_date(Timestamp modify_date) {
		this.modify_date = modify_date;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
