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
	 * 车系访问url
	 */
	private String serieLinkUrl;
	/**
	 * 品牌logo图片url
	 */
	private String logoImgUrl;
	/**
	 * 在售车系访问url
	 */
	private String onSaleLinkUrl;
	/**
	 * 停售车系访问url
	 */
	private String offSaleLinkUrl;
	/**
	 * 将售车系访问url
	 */
	private String willSaleLinkUrl;

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

	public String getLogoImgUrl() {
		return logoImgUrl;
	}

	public void setLogoImgUrl(String logoImgUrl) {
		this.logoImgUrl = logoImgUrl;
	}

	public String getSerieLinkUrl() {
		return serieLinkUrl;
	}

	public void setSerieLinkUrl(String serieLinkUrl) {
		this.serieLinkUrl = serieLinkUrl;
	}

	public String getOnSaleLinkUrl() {
		return onSaleLinkUrl;
	}

	public void setOnSaleLinkUrl(String onSaleLinkUrl) {
		this.onSaleLinkUrl = onSaleLinkUrl;
	}

	public String getOffSaleLinkUrl() {
		return offSaleLinkUrl;
	}

	public void setOffSaleLinkUrl(String offSaleLinkUrl) {
		this.offSaleLinkUrl = offSaleLinkUrl;
	}

	public String getWillSaleLinkUrl() {
		return willSaleLinkUrl;
	}

	public void setWillSaleLinkUrl(String willSaleLinkUrl) {
		this.willSaleLinkUrl = willSaleLinkUrl;
	}

}
