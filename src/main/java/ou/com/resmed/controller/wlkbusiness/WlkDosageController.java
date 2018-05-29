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
 * 用量类
 * @author souls
 *
 */
@Controller
@RequestMapping("/wlkdosage")
public class WlkDosageController extends BaseController{

	/**
	 * CMIOT_API2005-用户当月 GPRS 查询
	 * @return
	 * total_gprs_用户当月使用的总的 GPRS 流量（单位：KB）
	 */
	@RequestMapping(value = "/gprsusedinfosingle")
	@ResponseBody
    public JSONArray gprsusedinfosingle(@RequestBody CardInfoBean cardInfoBean){
		String jsonStr = "";
		String functionName = "gprsusedinfosingle";
		cardInfoBean.setEbid("0001000000012");
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
		//return JSONArray.fromObject("{\"status\":\"0\",\"message\":\"正确\",\"result\":[{\"total_gprs\":\"3000\"}]}");
    }
	
	/**
	 * CMIOT_API2009-短信批量查询
	 * 集团客户可以查询所属物联卡近期短信使用情况，批量查询多个用户、指定日期的短信使用量（仅支持查询最近 7 天中某一天的数据）
	 * @return
	 */
	@RequestMapping(value = "/batchsmsusedbydate")
	@ResponseBody
    public JSONArray batchsmsusedbydate(@RequestBody CardInfoBean cardInfoBean){
		String jsonStr = "";
		String functionName = "batchsmsusedbydate";
		cardInfoBean.setEbid("0001000000026");
		String url = "";
		if(cardInfoBean.getMsisdn() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "msisdn=" + cardInfoBean.getMsisdn() + "&query_date=" + cardInfoBean.getQueryDate());
		}else if(cardInfoBean.getIccid() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "iccid=" + cardInfoBean.getIccid() + "&query_date=" + cardInfoBean.getQueryDate());
		}else if(cardInfoBean.getImsi() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "imsi=" + cardInfoBean.getImsi() + "&query_date=" + cardInfoBean.getQueryDate());
		}
		return JSONArray.fromObject(HttpUrlConnectionUtil.doPost(url, jsonStr));
		//JSONArray res = HttpUrlConnectionUtil.doPost(url1, jsonStr);
//		return JSONArray.fromObject("{\"message\": \"正确\",\"result\": ["
//				+ "{\"ICCID\": \"898602B2221340000878\",\"IMSI\": \"460040260900788\",\"MSISDN\": \"1064826090232\",\"SMS\": \"0\"},"
//				+ "{\"ICCID\": \"898602B2221340000878\",\"IMSI\": \"460040260900788\",\"MSISDN\": \"1064826029898\",\"SMS\": \"0\"},"
//				+ "{\"ICCID\": \"898602B2221340000878\",\"IMSI\": \"460040260900788\",\"MSISDN\": \"1064826029896\",\"SMS\": \"0\"},"
//				+ "{\"ICCID\": \"898602B2221340000878\",\"IMSI\": \"460040260900788\",\"MSISDN\": \"1064826090209\",\"SMS\": \"0\"},"
//				+ "{\"ICCID\": \"898602B2221340000878\",\"IMSI\": \"460040260900788\",\"MSISDN\": \"1064826090283\",\"SMS\": \"0\"},"
//				+ "{\"ICCID\": \"898602B2221340000878\",\"IMSI\": \"460040260900788\",\"MSISDN\": \"1064826090212\",\"SMS\": \"0\"},"
//				+ "{\"ICCID\": \"898602B2221340000878\",\"IMSI\": \"460040260900788\",\"MSISDN\": \"1064826090284\",\"SMS\": \"0\"}"
//				+ "],\"status\": \"0\"}");
    }
	
	/**
	 * CMIOT_API2010-流量信息批量查询
	 * 集团客户可以查询所属物联卡近期 GPRS 流量使用情况，批量查询多个用户、指定日期的 GPRS 使用量（仅支持查询最近 7 天中某一天的数据）。
	 * @return
	 */
	@RequestMapping(value = "/batchgprsusedbydate")
	@ResponseBody
    public JSONArray batchgprsusedbydate(@RequestBody CardInfoBean cardInfoBean){
		String jsonStr = "";
		String functionName = "batchgprsusedbydate";
		cardInfoBean.setEbid("0001000000027");
		String url = "";
		if(cardInfoBean.getMsisdn() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "msisdns=" + cardInfoBean.getMsisdn() + "&query_date=" + cardInfoBean.getQueryDate());
		}else if(cardInfoBean.getIccid() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "iccids=" + cardInfoBean.getIccid() + "&query_date=" + cardInfoBean.getQueryDate());
		}else if(cardInfoBean.getImsi() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "imsis=" + cardInfoBean.getImsi() + "&query_date=" + cardInfoBean.getQueryDate());
		}
		return JSONArray.fromObject(HttpUrlConnectionUtil.doPost(url, jsonStr));
		//JSONArray res = HttpUrlConnectionUtil.doPost(url1, jsonStr);
//		return JSONArray.fromObject("{\"message\": \"正确\",\"result\": ["
//				+ "{\"GPRS\": \"0\",\"ICCID\": \"898602B2221340000878\",\"IMSI\": \"460040260900788\",\"MSISDN\": \"1064826090232\"},"
//				+ "{\"GPRS\": \"0\",\"ICCID\": \"898602B2221340000878\",\"IMSI\": \"460040260900788\",\"MSISDN\": \"1064826029898\"},"
//				+ "{\"GPRS\": \"0\",\"ICCID\": \"898602B2221340000878\",\"IMSI\": \"460040260900788\",\"MSISDN\": \"1064826029896\"},"
//				+ "{\"GPRS\": \"0\",\"ICCID\": \"898602B2221340000878\",\"IMSI\": \"460040260900788\",\"MSISDN\": \"1064826090209\"},"
//				+ "{\"GPRS\": \"0\",\"ICCID\": \"898602B2221340000878\",\"IMSI\": \"460040260900788\",\"MSISDN\": \"1064826090283\"},"
//				+ "{\"GPRS\": \"0\",\"ICCID\": \"898602B2221340000878\",\"IMSI\": \"460040260900788\",\"MSISDN\": \"1064826090212\"},"
//				+ "{\"GPRS\": \"0\",\"ICCID\": \"898602B2221340000878\",\"IMSI\": \"460040260900788\",\"MSISDN\": \"1064826090284\"}"
//				+ "],\"status\": \"0\"}");
    }
	
	/**
	 * CMIOT_API2012-用户当月短信查询
	 * @return
	 * sms_用户当月使用的短信数（条）
	 */
	@RequestMapping(value = "/smsusedinfosingle")
	@ResponseBody
    public JSONArray smsusedinfosingle(@RequestBody CardInfoBean cardInfoBean){
		String jsonStr = "";
		String functionName = "smsusedinfosingle";
		cardInfoBean.setEbid("0001000000036");
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
		//return JSONArray.fromObject("{\"status\":\"0\",\"message\":\"正确\",\"result\":[{\"sms\":\"3000\"}]}");
    }
	
	/**
	 * CMIOT_API2014-用户短信使用查询
	 * 集团客户可以查询所属物联卡某一天的短信使用情况（该时间点最晚比实时晚一天）。
	 * @return
	 */
	@RequestMapping(value = "/smsusedbydate")
	@ResponseBody
    public JSONArray smsusedbydate(@RequestBody CardInfoBean cardInfoBean){
		String jsonStr = "";
		String functionName = "smsusedbydate";
		cardInfoBean.setEbid("0001000000040");
		String url = "";
		if(cardInfoBean.getMsisdn() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "msisdn=" + cardInfoBean.getMsisdn() + "&query_date=" + cardInfoBean.getQueryDate());
		}else if(cardInfoBean.getIccid() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "iccid=" + cardInfoBean.getIccid() + "&query_date=" + cardInfoBean.getQueryDate());
		}else if(cardInfoBean.getImsi() != null){
			url = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "imsi=" + cardInfoBean.getImsi() + "&query_date=" + cardInfoBean.getQueryDate());
		}
		return JSONArray.fromObject(HttpUrlConnectionUtil.doPost(url, jsonStr));
		//JSONArray res = HttpUrlConnectionUtil.doPost(url1, jsonStr);
//		return JSONArray.fromObject("{\"status\":\"0\",\"message\":\"正确\",\"result\":[{\"sms\":\"3000\"}]}");
    }
	
	/**
	 * CMIOT_API2020-套餐内 GPRS 流量使用情况实时查询 (集团客户)
	 * 集团客户可查询所属物联卡当月套餐内 GPRS 流量使用情况。
	 * @return
	 * 套餐内 GPRS 流量使用情况查询结果-gprs;
	 * 套餐 ID-prodid;
	 * 产品实例 ID-prodinstid;
	 * 套餐名称-prodname;套餐总量（单位：MB）-total;
	 * 套餐使用量（单位：KB）-used;
	 * 套餐剩余量（单位：KB）-left;
	 */
	@RequestMapping(value = "/gprsrealtimeinfo")
	@ResponseBody
    public JSONArray gprsrealtimeinfo(@RequestBody CardInfoBean cardInfoBean){
		String jsonStr = "";
		String functionName = "gprsrealtimeinfo";
		cardInfoBean.setEbid("0001000000083");
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
//		return JSONArray.fromObject("{\"message\":\"正确\",\"result\":["
//				+ "{\"gprs\": [{\"left\": \"57793\",\"prodid\": \"910000000050475490\","
//				+ "\"prodinstid\":\"545111321220\",\"prodname\": \"GPRS 中小流量新 10 元套餐\",\"total\": \"70.0\",\"used\": \"13887\"}]}"
//				+ "],\"status\":\"0\"}");
    }
	
	
}




























