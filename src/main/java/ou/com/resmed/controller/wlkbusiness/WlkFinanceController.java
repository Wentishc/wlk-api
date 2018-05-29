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
 * 财务类
 * @author souls
 *
 */
@Controller
@RequestMapping("/wlkfinance")
public class WlkFinanceController extends BaseController{

	/**
	 * CMIOT_API2011-用户余额信息实时查询
	 * @return
	 */
	@RequestMapping(value = "/balancerealsingle")
	@ResponseBody
    public JSONArray balancerealsingle(@RequestBody CardInfoBean cardInfoBean){
		String jsonStr = "";
		String functionName = "balancerealsingle";
		cardInfoBean.setEbid("0001000000035");
		String url = "";
		if(cardInfoBean.getMsisdn() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "msisdn=" + cardInfoBean.getMsisdn());			
		}else if(cardInfoBean.getIccid() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "iccid=" + cardInfoBean.getIccid());			
		}else if(cardInfoBean.getImsi() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "imsi=" + cardInfoBean.getImsi());			
		}
		return JSONArray.fromObject(HttpUrlConnectionUtil.doPost(url, jsonStr));
		//JSONArray res = HttpUrlConnectionUtil.doPost(url1, jsonStr);
//		return JSONArray.fromObject("{\"status\":\"0\",\"message\":\"正确\",\"result\":[{\"balance\":\"3000\"}]}");
    }
	
}
