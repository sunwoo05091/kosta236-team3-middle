package kosta.domain;

import java.io.Serializable;

public class Receiver implements Serializable {
	
	private int rc_seq;			// 수신순서
	private int dc_no;			// 문서번호
	private int e_no;			// 사원번호
	
	public Receiver() {}

	public Receiver(int rc_seq, int dc_no, int e_no) {
		super();
		this.rc_seq = rc_seq;
		this.dc_no = dc_no;
		this.e_no = e_no;
	}

	public int getRc_seq() {
		return rc_seq;
	}

	public void setRc_seq(int rc_seq) {
		this.rc_seq = rc_seq;
	}

	public int getDc_no() {
		return dc_no;
	}

	public void setDc_no(int dc_no) {
		this.dc_no = dc_no;
	}

	public int getE_no() {
		return e_no;
	}

	public void setE_no(int e_no) {
		this.e_no = e_no;
	}

	@Override
	public String toString() {
		return "Receiver [rc_seq=" + rc_seq + ", dc_no=" + dc_no + ", e_no=" + e_no + "]";
	}

	
	
}
