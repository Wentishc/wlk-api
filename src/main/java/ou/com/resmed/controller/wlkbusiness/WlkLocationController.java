package ou.com.resmed.controller.wlkbusiness;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import ou.com.resmed.beans.CardInfoBean;
import ou.com.resmed.controller.BaseController;
import ou.com.resmed.util.HttpUrlConnectionUtil;

/**
 * 位置定位类
 * @author souls
 *
 */
@Controller
@RequestMapping("/wlklocation")
public class WlkLocationController extends BaseController{

	/**
	 * CMIOT_API 2109-物联卡区域位置查询
	 * 查询该卡当前所在的区域位置信息（区号）
	 * @return
	 * 城市区号-areaCode
	 */
	@RequestMapping(value = "/location_area")
	@ResponseBody
    public JSONArray location_area(@RequestBody CardInfoBean cardInfoBean){
		String jsonStr = "";
		String functionName = "location_area";
		cardInfoBean.setEbid("0001000000459");
		String url = "";
		if(cardInfoBean.getMsisdn() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "msisdn=" + cardInfoBean.getMsisdn());			
		}else if(cardInfoBean.getIccid() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "iccid=" + cardInfoBean.getIccid());			
		}else if(cardInfoBean.getImsi() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "imsi=" + cardInfoBean.getImsi());			
		}
		return JSONArray.fromObject(HttpUrlConnectionUtil.doPost(url, jsonStr));
		//JSONArray res = HttpUrlConnectionUtil.doPost(url1, paramStr);
//		return JSONArray.fromObject("{\"status\": \"0\",\"message\": \"正确\",\"result\": ["
//				+ "{\"msisdn\": \"1064826090110\",\"iccid\": \"898602B2221430000006\",\"imsi\": \"460040260908676\",\" areaCode \": \"023\"}"
//				+ "]}");
    }
	
}
