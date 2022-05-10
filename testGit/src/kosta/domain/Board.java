package kosta.domain;

import java.io.Serializable;

public class Board implements Serializable{
	private int b_no; //글번호
	private String b_title;//글제목
	private String b_contents;//글내용
	private String b_fname;//파일이름
	private String b_date;//작성일
	private String b_category;//카테고리
	private int b_fin;//상단고정상태
	private int e_no;//사원번호
	
	public Board() {}

	public Board(int b_no, String b_title, String b_contents, String b_fname, String b_date, String b_category,
			int b_fin, int e_no) {
		super();
		this.b_no = b_no;
		this.b_title = b_title;
		this.b_contents = b_contents;
		this.b_fname = b_fname;
		this.b_date = b_date;
		this.b_category = b_category;
		this.b_fin = b_fin;
		this.e_no = e_no;
	}

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_contents() {
		return b_contents;
	}

	public void setB_contents(String b_contents) {
		this.b_contents = b_contents;
	}

	public String getB_fname() {
		return b_fname;
	}

	public void setB_fname(String b_fname) {
		this.b_fname = b_fname;
	}

	public String getB_date() {
		return b_date;
	}

	public void setB_date(String b_date) {
		this.b_date = b_date;
	}

	public String getB_category() {
		return b_category;
	}

	public void setB_category(String b_category) {
		this.b_category = b_category;
	}

	public int getB_fin() {
		return b_fin;
	}

	public void setB_fin(int b_fin) {
		this.b_fin = b_fin;
	}

	public int getE_no() {
		return e_no;
	}

	public void setE_no(int e_no) {
		this.e_no = e_no;
	}

	@Override
	public String toString() {
		return "Board [b_no=" + b_no + ", b_title=" + b_title + ", b_contents=" + b_contents + ", b_fname=" + b_fname
				+ ", b_date=" + b_date + ", b_category=" + b_category + ", b_fin=" + b_fin + ", e_no=" + e_no + "]";
	}
	
	
	
}
