package kosta.domain;

import java.io.Serializable;

public class Schedule implements Serializable{
	private int s_no; //스케쥴 번호
	private String s_title; //제목
	private String s_contents; //내용
	private String s_type; //글종류
	private String s_startday;
	private String s_finishday;
	private String s_date;//작성일
	private int e_no; //사원번호
	
	public Schedule(){}

	public Schedule(int s_no, String s_title, String s_contents, String s_type, String s_startday, String s_finishday,
			String s_date, int e_no) {
		super();
		this.s_no = s_no;
		this.s_title = s_title;
		this.s_contents = s_contents;
		this.s_type = s_type;
		this.s_startday = s_startday;
		this.s_finishday = s_finishday;
		this.s_date = s_date;
		this.e_no = e_no;
	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public String getS_title() {
		return s_title;
	}

	public void setS_title(String s_title) {
		this.s_title = s_title;
	}

	public String getS_contents() {
		return s_contents;
	}

	public void setS_contents(String s_contents) {
		this.s_contents = s_contents;
	}

	public String getS_type() {
		return s_type;
	}

	public void setS_type(String s_type) {
		this.s_type = s_type;
	}

	public String getS_startday() {
		return s_startday;
	}

	public void setS_startday(String s_startday) {
		this.s_startday = s_startday;
	}

	public String getS_finishday() {
		return s_finishday;
	}

	public void setS_finishday(String s_finishday) {
		this.s_finishday = s_finishday;
	}

	public String getS_date() {
		return s_date;
	}

	public void setS_date(String s_date) {
		this.s_date = s_date;
	}

	public int getE_no() {
		return e_no;
	}

	public void setE_no(int e_no) {
		this.e_no = e_no;
	}
	
	
	
}
