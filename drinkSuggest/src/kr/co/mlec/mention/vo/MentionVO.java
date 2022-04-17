package kr.co.mlec.mention.vo;

public class MentionVO {
	
	private int mentionNo; 
	private int commentNo;
	private String mentionId;
	private String regDate;
	private int mentionParent;
	private String mentionContent;
	private int mentionLevel; //댓글-답변글 깊이
	
	
	public MentionVO(int mentionNo, int commentNo, String mentionId, String regDate, int mentionParent,
			String mentionContent, int mentionLevel) {
		super();
		this.mentionNo = mentionNo;
		this.commentNo = commentNo;
		this.mentionId = mentionId;
		this.regDate = regDate;
		this.mentionParent = mentionParent;
		this.mentionContent = mentionContent;
		this.mentionLevel = mentionLevel;
	}
	
	
	public MentionVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getMentionNo() {
		return mentionNo;
	}
	public void setMentionNo(int mentionNo) {
		this.mentionNo = mentionNo;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getMentionId() {
		return mentionId;
	}
	public void setMentionId(String mentionId) {
		this.mentionId = mentionId;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getMentionParent() {
		return mentionParent;
	}
	public void setMentionParent(int mentionParent) {
		this.mentionParent = mentionParent;
	}
	public String getMentionContent() {
		return mentionContent;
	}
	public void setMentionContent(String mentionContent) {
		this.mentionContent = mentionContent;
	}
	public int getMentionLevel() {
		return mentionLevel;
	}
	public void setMentionLevel(int mentionLevel) {
		this.mentionLevel = mentionLevel;
	}
	@Override
	public String toString() {
		return "MentionVO [mentionNo=" + mentionNo + ", commentNo=" + commentNo + ", mentionId=" + mentionId
				+ ", regDate=" + regDate + ", mentionParent=" + mentionParent + ", mentionContent=" + mentionContent
				+ ", mentionLevel=" + mentionLevel + "]";
	}
	
	

}
