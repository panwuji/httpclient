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
	 * ���ͷ���url
	 */
	private String modelImgUrl;
	/**
	 * Ʒ��logoͼƬurl
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
