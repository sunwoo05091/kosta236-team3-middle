package kosta.domain;

import java.io.Serializable;

public class Referrer implements Serializable{
	
	private int rf_seq;			// 참조순서
	private int dc_no;			// 문서번호
	private int e_no;			// 사원번호
	
	public Referrer() {}

	public Referrer(int rf_seq, int dc_no, int e_no) {
		super();
		this.rf_seq = rf_seq;
		this.dc_no = dc_no;
		this.e_no = e_no;
	}

	public int getRf_seq() {
		return rf_seq;
	}

	public void setRf_seq(int rf_seq) {
		this.rf_seq = rf_seq;
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
		return "Referrer [rf_seq=" + rf_seq + ", dc_no=" + dc_no + ", e_no=" + e_no + "]";
	}
	

}
