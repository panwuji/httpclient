package com.yzkj.base;

import java.util.List;

public class SerieModelMapper {
	
	private String serieName;
	
	private List<String> modelList;

	public String getSerieName() {
		return serieName;
	}

	public void setSerieName(String serieName) {
		this.serieName = serieName;
	}

	public List<String> getModelList() {
		return modelList;
	}

	public void setModelList(List<String> modelList) {
		this.modelList = modelList;
	}

	@Override
	public String toString() {
		return "SerieModelMapper [serieName=" + serieName + ", modelList=" + modelList + "]";
	}
	
}
