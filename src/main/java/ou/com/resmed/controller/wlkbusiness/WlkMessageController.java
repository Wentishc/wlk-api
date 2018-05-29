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
 * 短信类
 * @author souls
 *
 */
@Controller
@RequestMapping("/wlkmessage")
public class WlkMessageController extends BaseController{

	/**
	 * CMIOT_API4001-短信状态重置
	 * @return
	 */
	@RequestMapping(value = "/smsstatusreset")
	@ResponseBody
    public JSONArray smsstatusreset(@RequestBody CardInfoBean cardInfoBean){
		String jsonStr = "";
		String functionName = "smsstatusreset";
		cardInfoBean.setEbid("0001000000034");
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
//		return JSONArray.fromObject("{\"status\": \"0\",\"message\": \"正确\",\"result\": [{\"status\": \"0\"}]}");
    }
	
}
