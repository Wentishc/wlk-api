package ou.com.resmed.controller.wlkbusiness;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import ou.com.resmed.util.DataEnum.CardInfoType;
import ou.com.resmed.beans.CardInfoBean;
import ou.com.resmed.controller.BaseController;
import ou.com.resmed.util.HttpUrlConnectionUtil;

/**
 * 用户类
 * @author souls
 *
 */
@Controller
@RequestMapping("/wlkuser")
public class WlkUserController extends BaseController {

	/**
	 * CMIOT_API2001-在线信息实时查询
	 * @return
	 */
	@RequestMapping(value = "/gprsrealsingle")
	@ResponseBody
	public JSONArray gprsrealsingle(@RequestBody CardInfoBean cardInfoBean) {
		String jsonStr = "";
		String functionName = "gprsrealsingle";
		cardInfoBean.setEbid("0001000000008");
		String url = "";
		if(cardInfoBean.getMsisdn() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "msisdn=" + cardInfoBean.getMsisdn());			
		}else if(cardInfoBean.getIccid() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "iccid=" + cardInfoBean.getIccid());			
		}else if(cardInfoBean.getImsi() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "imsi=" + cardInfoBean.getImsi());			
		}
//		{"status":"0","message":"正确","result":[{"APN":"cmmtm","IP":"10.56.129.64","GPRSSTATUS":"00","RAT":"2"}]}
		return JSONArray.fromObject(HttpUrlConnectionUtil.doPost(url, jsonStr));
	}

	/**
	 * CMIOT_API2002-用户状态信息实时查询
	 * @return
	 */
	@RequestMapping(value = "/userstatusrealsingle")
	@ResponseBody
	public JSONArray userstatusrealsingle(@RequestBody CardInfoBean cardInfoBean) {
		String jsonStr = "";
		String functionName = "userstatusrealsingle";
		cardInfoBean.setEbid("0001000000009");
		String url = "";
		if(cardInfoBean.getMsisdn() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "msisdn=" + cardInfoBean.getMsisdn());			
		}else if(cardInfoBean.getIccid() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "iccid=" + cardInfoBean.getIccid());			
		}else if(cardInfoBean.getImsi() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "imsi=" + cardInfoBean.getImsi());			
		}
//		JSONArray res = HttpUrlConnectionUtil.doPost(url1, jsonStr);
//		return JSONArray.fromObject("{\"status\":\"0\",\"message\":\"正确\",\"result\":[{\"STATUS\":\"00\"}]}");
		return JSONArray.fromObject(HttpUrlConnectionUtil.doPost(url, jsonStr));
	}

	/**
	 * CMIOT_API2003-码号信息查询
	 * @return
	 */
	@RequestMapping(value = "/cardinfo")
	@ResponseBody
    public JSONArray cardinfo(@RequestBody CardInfoBean cardInfoBean){
		String jsonStr = "";
		String functionName = "cardinfo";
		cardInfoBean.setEbid("0001000000010");
		String url = "";
		if(cardInfoBean.getMsisdn() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "card_info=" + cardInfoBean.getMsisdn() + "&type=" + CardInfoType.MSISDN.getKey());
		}else if(cardInfoBean.getIccid() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "card_info=" + cardInfoBean.getIccid() + "&type=" + CardInfoType.ICCID.getKey());
		}else if(cardInfoBean.getImsi() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "card_info=" + cardInfoBean.getImsi() + "&type=" + CardInfoType.IMSI.getKey());
		}
//		JSONArray res = HttpUrlConnectionUtil.doPost(url1, jsonStr);
//        return JSONArray.fromObject("{\"status\":\"0\",\"message\":\"正确\",\"result\":[{\"IMSI\":\"460040260908676\",\"MSISDN\":\"1064826090209\",\"ICCID\":\"898602B2221430000006\"}]}");
		return JSONArray.fromObject(HttpUrlConnectionUtil.doPost(url, jsonStr));
	}
	
	/**
	 * CMIOT_API2008-开关机信息实时查询
	 * @return
	 */
	@RequestMapping(value = "/onandoffrealsingle")
	@ResponseBody
    public JSONArray onandoffrealsingle(@RequestBody CardInfoBean cardInfoBean){
		String jsonStr = "";
		String functionName = "onandoffrealsingle";
		cardInfoBean.setEbid("0001000000025");
		String url = "";
		if(cardInfoBean.getMsisdn() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "msisdn=" + cardInfoBean.getMsisdn());
		}else if(cardInfoBean.getIccid() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "iccid=" + cardInfoBean.getIccid());
		}else if(cardInfoBean.getImsi() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "imsi=" + cardInfoBean.getImsi());
		}
//		JSONArray res = HttpUrlConnectionUtil.doPost(url1, jsonStr);
//        return JSONArray.fromObject("{\"status\":\"0\",\"message\":\"正确\",\"result\":[{\"STATUS\":\"0\"}]}");
		return JSONArray.fromObject(HttpUrlConnectionUtil.doPost(url, jsonStr));
	}
	
	/**
	 * CMIOT_API2029-物联卡多APN信息实时查询
	 * @return
	 */
	@RequestMapping(value = "/APNquery")
	@ResponseBody
    public JSONArray APNquery(){
		//TODO 接口文档未包含
        return null;
	}

}
