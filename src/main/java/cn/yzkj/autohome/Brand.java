package cn.yzkj.autohome;

public class Brand {
	
	private int brandId;
	
	private String name;
	
	private int type;

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", name=" + name + ", type=" + type + "]";
	}

}
