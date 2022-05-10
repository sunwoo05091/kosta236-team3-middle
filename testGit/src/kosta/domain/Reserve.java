package kosta.domain;

public class Reserve {
	private int	r_no;
	private String r_date;
	private String r_starttime;
	private String r_endtime;
	private String meetingtitle;
	private int mr_no;
	private int e_no;
	private MeetingRoom meetingRoom;
	
	public Reserve() {}

	public Reserve(int r_no, String r_date, String r_starttime, String r_endtime, String meetingtitle, int mr_no,
			int e_no, MeetingRoom meetingRoom) {
		super();
		this.r_no = r_no;
		this.r_date = r_date;
		this.r_starttime = r_starttime;
		this.r_endtime = r_endtime;
		this.meetingtitle = meetingtitle;
		this.mr_no = mr_no;
		this.e_no = e_no;
		this.meetingRoom = meetingRoom;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public String getR_date() {
		return r_date;
	}

	public void setR_date(String r_date) {
		this.r_date = r_date;
	}

	public String getR_starttime() {
		return r_starttime;
	}

	public void setR_starttime(String r_starttime) {
		this.r_starttime = r_starttime;
	}

	public String getR_endtime() {
		return r_endtime;
	}

	public void setR_endtime(String r_endtime) {
		this.r_endtime = r_endtime;
	}

	public String getMeetingtitle() {
		return meetingtitle;
	}

	public void setMeetingtitle(String meetingtitle) {
		this.meetingtitle = meetingtitle;
	}

	public int getMr_no() {
		return mr_no;
	}

	public void setMr_no(int mr_no) {
		this.mr_no = mr_no;
	}

	public int getE_no() {
		return e_no;
	}

	public void setE_no(int e_no) {
		this.e_no = e_no;
	}

	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

	

	
	


	
	
}
