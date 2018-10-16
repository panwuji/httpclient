package com.yzkj.base;
/**
 * 车辆品牌数据对象
 * @author panwuji
 *
 */
public class VehBrand {
	/**
	 * 主键
	 */
	private int id;
	/**
	 * 品牌名称
	 */
	private String name;
	/**
	 * 品牌对应车型总数
	 */
	private int type;
	/**
	 * 车型访问url
	 */
	private String modelImgUrl;
	/**
	 * 品牌logo图片url
	 */
	private String logoImgUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getModelImgUrl() {
		return modelImgUrl;
	}

	public void setModelImgUrl(String modelImgUrl) {
		this.modelImgUrl = modelImgUrl;
	}

	public String getLogoImgUrl() {
		return logoImgUrl;
	}

	public void setLogoImgUrl(String logoImgUrl) {
		this.logoImgUrl = logoImgUrl;
	}

	@Override
	public String toString() {
		return "VehBrand [id=" + id + ", name=" + name + ", type=" + type + ", modelImgUrl=" + modelImgUrl
				+ ", logoImgUrl=" + logoImgUrl + "]";
	}
	
}
