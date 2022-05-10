package kosta.domain;

import java.io.Serializable;

public class MeetingRoom implements Serializable{
	private int mr_no;
	private String mr_name;
	private int mr_personnel;
	
	public MeetingRoom() {}

	public MeetingRoom(int mr_no, String mr_name, int mr_personnel) {
		super();
		this.mr_no = mr_no;
		this.mr_name = mr_name;
		this.mr_personnel = mr_personnel;
	}

	public int getMr_no() {
		return mr_no;
	}

	public void setMr_no(int mr_no) {
		this.mr_no = mr_no;
	}

	public String getMr_name() {
		return mr_name;
	}

	public void setMr_name(String mr_name) {
		this.mr_name = mr_name;
	}

	public int getMr_personnel() {
		return mr_personnel;
	}

	public void setMr_personnel(int mr_personnel) {
		this.mr_personnel = mr_personnel;
	}

	
	
	
	
	
}
