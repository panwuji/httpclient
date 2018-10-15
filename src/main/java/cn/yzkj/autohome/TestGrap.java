package cn.yzkj.autohome;

public class TestGrap {
	public static void main(String[] args) {
		
		
//		String str = HTTPUtil.HTTPGet("https://car.autohome.com.cn/#pvareaid=3311273");
		//∑√Œ url:https://car.autohome.com.cn/AsLeftMenu/As_LeftListNew.ashx?typeId=1%20&amp;brandId=0%20&amp;fctId=0%20&amp;seriesId=0
		String str = HTTPUtil.HTTPGet("https://car.autohome.com.cn/AsLeftMenu/As_LeftListNew.ashx?typeId=1%20&amp;brandId=0%20&amp;fctId=0%20&amp;seriesId=0");
		
//		JsoupUtil.getVehBrand(str);
		JsoupUtil.getVehBrand2(str);
	}
}
