package com.yzkj.base;
/**
 * ����Ʒ�����ݶ���
 * @author panwuji
 *
 */
public class VehBrand {
	/**
	 * ����
	 */
	private int id;
	/**
	 * Ʒ������
	 */
	private String name;
	/**
	 * Ʒ�ƶ�Ӧ��������
	 */
	private int type;
	/**
	 * ��ϵ����url
	 */
	private String serieLinkUrl;
	/**
	 * Ʒ��logoͼƬurl
	 */
	private String logoImgUrl;
	/**
	 * ���۳�ϵ����url
	 */
	private String onSaleLinkUrl;
	/**
	 * ͣ�۳�ϵ����url
	 */
	private String offSaleLinkUrl;
	/**
	 * ���۳�ϵ����url
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
