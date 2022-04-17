package kr.co.mlec.board.vo;

public class BoardVO {
	private int comNo;
	private String id;
	private String comTitle;
	private String comContent;
	private int comLikeCnt;
	private String regDate;
	private int viewCnt;
	private int groupNo;
	private int reNo;
	private int reLevel;
	
	
	
	public BoardVO(int comNo, String id, String comTitle, String comContent, int comLikeCnt, String regDate,
			int viewCnt) {
		super();
		this.comNo = comNo;
		this.id = id;
		this.comTitle = comTitle;
		this.comContent = comContent;
		this.comLikeCnt = comLikeCnt;
		this.regDate = regDate;
		this.viewCnt = viewCnt;
	}


	public BoardVO(int groupNo, int reNo, int reLevel) {
		super();
		this.groupNo = groupNo;
		this.reNo = reNo;
		this.reLevel = reLevel;
	}

	
	
	
	

	public int getReNo() {
		return reNo;
	}


	public void setReNo(int reNo) {
		this.reNo = reNo;
	}


	public int getReLevel() {
		return reLevel;
	}


	public void setReLevel(int reLevel) {
		this.reLevel = reLevel;
	}


	public BoardVO(int comNo, String id, String comTitle, String comContent, int comLikeCnt, String regDate,
			int viewCnt, int groupNo, int reNo, int reLevel) {
		super();
		this.comNo = comNo;
		this.id = id;
		this.comTitle = comTitle;
		this.comContent = comContent;
		this.comLikeCnt = comLikeCnt;
		this.regDate = regDate;
		this.viewCnt = viewCnt;
		this.groupNo = groupNo;
		this.reNo = reNo;
		this.reLevel = reLevel;
	}

	
	public BoardVO( String id, String comTitle, String comContent, int viewCnt,
			String regDate, int comLikeCnt) {
		super();
		
		this.id = id;
		this.comTitle = comTitle;
		this.comContent = comContent;
		this.viewCnt = viewCnt;
		this.regDate = regDate;
		this.comLikeCnt = comLikeCnt;
	}
	
	
	
	

	// alt + shift +s => c
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BoardVO(int comNo, String id, String comTitle, String comContent, int comLikeCnt, String regDate,
			int viewCnt, int groupNo) {
		super();
		this.comNo = comNo;
		this.id = id;
		this.comTitle = comTitle;
		this.comContent = comContent;
		this.comLikeCnt = comLikeCnt;
		this.regDate = regDate;
		this.viewCnt = viewCnt;
		this.groupNo = groupNo;
	}


	public BoardVO(String id, String comTitle, String comContent, int groupNo) {
		super();
		this.id = id;
		this.comTitle = comTitle;
		this.comContent = comContent;
		this.groupNo = groupNo;
	}


	public BoardVO(int comNo, String id, String comTitle, String comContent, int viewCnt, String regDate) {
		super();
		this.comNo = comNo;
		this.id = id;
		this.comTitle = comTitle;
		this.comContent = comContent;
		this.viewCnt = viewCnt;
		this.regDate = regDate;
	}
	


	public BoardVO(int comNo, String id, String comTitle, String comContent, String regDate, int viewCnt) {
		super();
		this.comNo = comNo;
		this.id = id;
		this.comTitle = comTitle;
		this.comContent = comContent;
		this.regDate = regDate;
		this.viewCnt = viewCnt;
	}

	
	
	

	public BoardVO(String id, String comTitle, String comContent) {
		super();
		this.id = id;
		this.comTitle = comTitle;
		this.comContent = comContent;
	}


	public BoardVO(int comNo, String id, String comTitle, String regDate) {
		super();
		this.comNo = comNo;
		this.id = id;
		this.comTitle = comTitle;
		this.regDate = regDate;
	}

	
	
	
	
	
	

	@Override
	public String toString() {
		return "BoardVO [comNo=" + comNo + ", id=" + id + ", comTitle=" + comTitle + ", comContent=" + comContent
				+ ", comLikeCnt=" + comLikeCnt + ", regDate=" + regDate + ", viewCnt=" + viewCnt + ", groupNo="
				+ groupNo + ", reNo=" + reNo + ", reLevel=" + reLevel + "]";
	}


	public int getComNo() {
		return comNo;
	}


	public void setComNo(int comNo) {
		this.comNo = comNo;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getComTitle() {
		return comTitle;
	}


	public void setComTitle(String comTitle) {
		this.comTitle = comTitle;
	}


	public String getComContent() {
		return comContent;
	}


	public void setComContent(String comContent) {
		this.comContent = comContent;
	}


	public int getComLikeCnt() {
		return comLikeCnt;
	}


	public void setComLikeCnt(int comLikeCnt) {
		this.comLikeCnt = comLikeCnt;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public int getViewCnt() {
		return viewCnt;
	}


	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}


	public int getGroupNo() {
		return groupNo;
	}


	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}



	
}
