package kosta.domain;

import java.io.Serializable;

public class Approver implements Serializable {
	
	private int ap_seq;					// 결재순서
	private int dc_no;						// 문서번호
	private boolean ap_check;		// 결재유무
	private String ap_date;			// 결재일
	private int e_no;						// 사원번호
	
	public Approver() {}

	public Approver(int ap_seq, int dc_no, boolean ap_check, String ap_date, int e_no) {
		super();
		this.ap_seq = ap_seq;
		this.dc_no = dc_no;
		this.ap_check = ap_check;
		this.ap_date = ap_date;
		this.e_no = e_no;
	}

	public int getAp_seq() {
		return ap_seq;
	}

	public void setAp_seq(int ap_seq) {
		this.ap_seq = ap_seq;
	}

	public int getDc_no() {
		return dc_no;
	}

	public void setDc_no(int dc_no) {
		this.dc_no = dc_no;
	}

	public boolean isAp_check() {
		return ap_check;
	}

	public void setAp_check(boolean ap_check) {
		this.ap_check = ap_check;
	}

	public String getAp_date() {
		return ap_date;
	}

	public void setAp_date(String ap_date) {
		this.ap_date = ap_date;
	}

	public int getE_no() {
		return e_no;
	}

	public void setE_no(int e_no) {
		this.e_no = e_no;
	}

	@Override
	public String toString() {
		return "Approver [ap_seq=" + ap_seq + ", dc_no=" + dc_no + ", ap_check=" + ap_check + ", ap_date=" + ap_date
				+ ", e_no=" + e_no + "]";
	}
	
	
	
}
