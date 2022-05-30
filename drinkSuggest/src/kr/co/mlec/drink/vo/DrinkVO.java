package kr.co.mlec.drink.vo;

public class DrinkVO {

	private String dk_name;
	private String dk_f1;
	private String dk_f2;
	private String dk_f3;
	private String dk_f4;
	private String dk_f5;
	private String dk_f6;
	private String dk_f7;
	private String dk_f8;
	private String dk_f9;
	private String dk_f10;
	private String dk_store;
	private String dk_price;
	
	public DrinkVO() {
	}

	

	public DrinkVO(String dk_name, String dk_f1, String dk_f2, String dk_f3, String dk_f4, String dk_f5, String dk_f6,
			String dk_f7, String dk_f8, String dk_f9, String dk_f10, String dk_price) {
		super();
		this.dk_name = dk_name;
		this.dk_f1 = dk_f1;
		this.dk_f2 = dk_f2;
		this.dk_f3 = dk_f3;
		this.dk_f4 = dk_f4;
		this.dk_f5 = dk_f5;
		this.dk_f6 = dk_f6;
		this.dk_f7 = dk_f7;
		this.dk_f8 = dk_f8;
		this.dk_f9 = dk_f9;
		this.dk_f10 = dk_f10;
		this.dk_price = dk_price;
	}

	public DrinkVO(String dk_name, String dk_store, String dk_price) {
		super();
		this.dk_name = dk_name;
		this.dk_store = dk_store;
		this.dk_price = dk_price;
	}



	public DrinkVO(String dk_name, String dk_f1, String dk_f2, String dk_f3, String dk_f4, String dk_f5, String dk_f6,
			String dk_f7, String dk_f8, String dk_f9, String dk_f10, String dk_store, String dk_price) {
		super();
		this.dk_name = dk_name;
		this.dk_f1 = dk_f1;
		this.dk_f2 = dk_f2;
		this.dk_f3 = dk_f3;
		this.dk_f4 = dk_f4;
		this.dk_f5 = dk_f5;
		this.dk_f6 = dk_f6;
		this.dk_f7 = dk_f7;
		this.dk_f8 = dk_f8;
		this.dk_f9 = dk_f9;
		this.dk_f10 = dk_f10;
		this.dk_store = dk_store;
		this.dk_price = dk_price;
	}

	public String getDk_name() {
		return dk_name;
	}

	public void setDk_name(String dk_name) {
		this.dk_name = dk_name;
	}

	public String getDk_f1() {
		return dk_f1;
	}

	public void setDk_f1(String dk_f1) {
		this.dk_f1 = dk_f1;
	}

	public String getDk_f2() {
		return dk_f2;
	}

	public void setDk_f2(String dk_f2) {
		this.dk_f2 = dk_f2;
	}

	public String getDk_f3() {
		return dk_f3;
	}

	public void setDk_f3(String dk_f3) {
		this.dk_f3 = dk_f3;
	}

	public String getDk_f4() {
		return dk_f4;
	}

	public void setDk_f4(String dk_f4) {
		this.dk_f4 = dk_f4;
	}

	public String getDk_f5() {
		return dk_f5;
	}

	public void setDk_f5(String dk_f5) {
		this.dk_f5 = dk_f5;
	}

	public String getDk_f6() {
		return dk_f6;
	}

	public void setDk_f6(String dk_f6) {
		this.dk_f6 = dk_f6;
	}

	public String getDk_f7() {
		return dk_f7;
	}

	public void setDk_f7(String dk_f7) {
		this.dk_f7 = dk_f7;
	}

	public String getDk_f8() {
		return dk_f8;
	}

	public void setDk_f8(String dk_f8) {
		this.dk_f8 = dk_f8;
	}

	public String getDk_f9() {
		return dk_f9;
	}

	public void setDk_f9(String dk_f9) {
		this.dk_f9 = dk_f9;
	}

	public String getDk_f10() {
		return dk_f10;
	}

	public void setDk_f10(String dk_f10) {
		this.dk_f10 = dk_f10;
	}

	public String getDk_store() {
		return dk_store;
	}

	public void setDk_store(String dk_store) {
		this.dk_store = dk_store;
	}

	public String getDk_price() {
		return dk_price;
	}

	

	public void setDk_price(String dk_price) {
		this.dk_price = dk_price;
	}



	@Override
	public String toString() {
		return "DrinkVO [dk_name=" + dk_name + ", dk_f1=" + dk_f1 + ", dk_f2=" + dk_f2 + ", dk_f3=" + dk_f3 + ", dk_f4="
				+ dk_f4 + ", dk_f5=" + dk_f5 + ", dk_f6=" + dk_f6 + ", dk_f7=" + dk_f7 + ", dk_f8=" + dk_f8 + ", dk_f9="
				+ dk_f9 + ", dk_f10=" + dk_f10 + ", dk_store=" + dk_store + ", dk_price=" + dk_price + "]";
	}



	}
