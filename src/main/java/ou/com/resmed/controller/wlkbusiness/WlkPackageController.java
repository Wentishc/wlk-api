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
 * 套餐类
 * @author souls
 *
 */
@Controller
@RequestMapping("/wlkpackage")
public class WlkPackageController extends BaseController{

	/**
	 * CMIOT_API2037-物联卡资费套餐查询 
	 * @return
	 * 物联网专网卡号-msisdn;
	 * 集成电路卡识别码，IC 卡的唯一识别号码-iccid;
	 * 国际移动用户识别码-imsi;
	 * 套餐信息-prodinfos;
	 * 套餐资费编号-prodid;
	 * SIM卡套餐名称-prodname;
	 * 套餐生效/失效时间-prodinstefftime/prodinstexptime
	 */
	@RequestMapping(value = "/querycardprodinfod")
	@ResponseBody
    public JSONArray querycardprodinfod(@RequestBody CardInfoBean cardInfoBean){
		String jsonStr = "";
		String functionName = "querycardprodinfo";
		cardInfoBean.setEbid("0001000000264");
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
//		return JSONArray.fromObject("{\"message\": \"正确\",\"result\": ["
//				+ "{\"iccid\": \"898602B2221340000878\",\"imsi\": \"460040260900788\",\"msisdn\": \"1064828139459\","
//				+ "\"prodinfos\": ["
//				+ "{\"prodid\": \"I00010100061\",\"prodinstefftime\": \"2016-08-01 00:00:00\",\"prodinstexptime\": \" 2099-12-31 23:59:59\",\"prodname\": \"GPRS 中小流量新 3 元套餐\"},"
//				+ "{\"prodid\": \"I00010100031\",\"prodinstefftime\": \"2016-08-01 00:00:00\",\"prodinstexptime\": \" 2099-12-31 23:59:59\",\"prodname\": \"沉默测试套餐\"}"
//				+ "]}],\"status\": \"0\"}");
    }
	
}
