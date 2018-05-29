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
 * 集团信息类
 * @author souls
 *
 */
@Controller
@RequestMapping("/wlkgroup")
public class WlkGroupInfoController extends BaseController{

	/**
	 * CMIOT_API2013-集团用户数查询
	 * @return
	 */
	@RequestMapping(value = "/groupuserinfo")
	@ResponseBody
    public JSONArray groupuserinfo(@RequestBody CardInfoBean cardInfoBean){
		String jsonStr = "";
		String functionName = "groupuserinfo";
		cardInfoBean.setEbid("0001000000039");
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
//		return JSONArray.fromObject("{\"status\":\"0\",\"message\":\"正确\",\"result\":[{\"total\":\"3000\"}]}");
    }
	
	/**
	 * CMIOT_API2022-欠费停机用户批量查询
	 * @param pageSize	必须为大于等于 1 且小于等于 20 的整数
	 * @param pageNum	必须传入大于 0 的整数
	 * @return
	 * 欠费停机用户查询结果-arrearageUserInfo;
	 * 总计异常用户数-total;
	 * 当前请求页面用户数量-userInfos;
	 * 用户卡号-msisdn;
	 * 异常状态，欠费停机用户状态包括: 02-停机且停机原因为欠费停机-status;
	 * 当前查询日期，日期格式为YYYYMMDD-currentDate,statusDate;
	 */
	@RequestMapping(value = "/arrearageuserinfo")
	@ResponseBody
    public JSONArray arrearageuserinfo(@RequestBody CardInfoBean cardInfoBean){
		String jsonStr = "";
		String functionName = "arrearageuserinfo";
		cardInfoBean.setEbid("0001000000328");
		String url1 = HttpUrlConnectionUtil.getUrl(cardInfoBean, functionName, "pageSize=" + cardInfoBean.getPageSize() + "&pageNum=" + cardInfoBean.getPageNum());
		//JSONArray res = HttpUrlConnectionUtil.doPost(url1, jsonStr);
//		return JSONArray.fromObject("{\"status\":\"0\",\"message\":\"正确\",\"result\":[{\"arrearageUserInfo\":{\"total\":\"2\",\"userInfos\":["
//				+ "{\"msisdn\":\"xxx\",\"status\":\"02\",\"currentDate\":\"20151228\",\"statusDate\":\"20130828\"},"
//				+ "{\"msisdn\":\"xxx\",\"status\":\"02\",\"currentDate\":\"20151228\",\"statusDate\":\"20130828\"}"
//				+ "]}}]}");
		return JSONArray.fromObject(HttpUrlConnectionUtil.doPost(url1, jsonStr));
    }
	
}
