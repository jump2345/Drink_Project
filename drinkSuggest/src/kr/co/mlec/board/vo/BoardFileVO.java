package kr.co.mlec.board.vo;

public class BoardFileVO {

	private int no;
	private int comNo;
	private String fileOriName;
	private String fileSaveName;
	private int fileSize;
	
	public BoardFileVO() {
			}

	public BoardFileVO(int no, int comNo, String fileOriName, String fileSaveName, int fileSize) {
		super();
		this.no = no;
		this.comNo = comNo;
		this.fileOriName = fileOriName;
		this.fileSaveName = fileSaveName;
		this.fileSize = fileSize;
	}

	
	@Override
	public String toString() {
		return "BoardReplyFileVO [no=" + no + ", comNo=" + comNo + ", fileOriName=" + fileOriName + ", fileSaveName="
				+ fileSaveName + ", fileSize=" + fileSize + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getComNo() {
		return comNo;
	}

	public void setComNo(int comNo) {
		this.comNo = comNo;
	}

	public String getFileOriName() {
		return fileOriName;
	}

	public void setFileOriName(String fileOriName) {
		this.fileOriName = fileOriName;
	}

	public String getFileSaveName() {
		return fileSaveName;
	}

	public void setFileSaveName(String fileSaveName) {
		this.fileSaveName = fileSaveName;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	
}
