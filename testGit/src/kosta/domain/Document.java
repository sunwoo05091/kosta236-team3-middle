package kosta.domain;

import java.io.Serializable;

public class Document implements Serializable{

		private int dc_no;						// 문서번호
		private String dc_title;				// 제목
		private String dc_contents;		// 내용
		private String dc_fname;			// 첨부파일명
		private String dc_date;			// 문서작성일
		private String dc_state;			// 문서상태
		private int e_no;						// 사원번호
		
		private String grade;				// 직급
		private String name;					// 이름
		private String d_name;			// 부서
		
		public Document() {}

		public Document(int dc_no, String dc_title, String dc_contents, String dc_fname, String dc_date,
				String dc_state, int e_no, String grade, String name, String d_name) {
			super();
			this.dc_no = dc_no;
			this.dc_title = dc_title;
			this.dc_contents = dc_contents;
			this.dc_fname = dc_fname;
			this.dc_date = dc_date;
			this.dc_state = dc_state;
			this.e_no = e_no;
			this.grade = grade;
			this.name = name;
			this.d_name = d_name;
		}

		public int getDc_no() {
			return dc_no;
		}

		public void setDc_no(int dc_no) {
			this.dc_no = dc_no;
		}

		public String getDc_title() {
			return dc_title;
		}

		public void setDc_title(String dc_title) {
			this.dc_title = dc_title;
		}

		public String getDc_contents() {
			return dc_contents;
		}

		public void setDc_contents(String dc_contents) {
			this.dc_contents = dc_contents;
		}

		public String getDc_fname() {
			return dc_fname;
		}

		public void setDc_fname(String dc_fname) {
			this.dc_fname = dc_fname;
		}

		public String getDc_date() {
			return dc_date;
		}

		public void setDc_date(String dc_date) {
			this.dc_date = dc_date;
		}

		public String getDc_state() {
			return dc_state;
		}

		public void setDc_state(String dc_state) {
			this.dc_state = dc_state;
		}

		public int getE_no() {
			return e_no;
		}

		public void setE_no(int e_no) {
			this.e_no = e_no;
		}

		public String getGrade() {
			return grade;
		}

		public void setGrade(String grade) {
			this.grade = grade;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getD_name() {
			return d_name;
		}

		public void setD_name(String d_name) {
			this.d_name = d_name;
		}

		@Override
		public String toString() {
			return "Document [dc_no=" + dc_no + ", dc_title=" + dc_title + ", dc_contents=" + dc_contents
					+ ", dc_fname=" + dc_fname + ", dc_date=" + dc_date + ", dc_state=" + dc_state + ", e_no=" + e_no
					+ ", grade=" + grade + ", name=" + name + ", d_name=" + d_name + "]";
		}

}
