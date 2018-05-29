package ou.com.resmed.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ou.com.resmed.beans.CardInfoBean;
import ou.com.resmed.beans.CommonBean;

@Component
public class HttpUrlConnectionUtil {

	@Autowired
	public CommonBean commonBean;
	
	public static HttpUrlConnectionUtil commonBeans;
	
	@PostConstruct
    public void init() {
		commonBeans = this;
    }
	
	
    public static String doPost(String urlPath, String paramStr) {
    	HttpURLConnection httpURLConnection = null;  
        String result = null;  
        try {  
            httpURLConnection = (HttpURLConnection) new URL(urlPath).openConnection();  
            httpURLConnection.setRequestMethod("POST");  
            //Content-type字母区分大小写，特别注意  
            httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");  
            httpURLConnection.setDoOutput(true);  
            httpURLConnection.setUseCaches(false);  
            httpURLConnection.setConnectTimeout(30000);  
            httpURLConnection.connect();  
            //获取输出流对象，把请求参数发送打服务器接口  
            OutputStream outputStream = httpURLConnection.getOutputStream();  
            outputStream.write(paramStr.getBytes("utf-8"));  
            outputStream.flush();  
            //获取服务器返回数据流  
            InputStream inputStream = httpURLConnection.getInputStream();  
            if (httpURLConnection.getResponseCode() == 200) {  
                // 内存流对象  
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();  
                byte[] data = new byte[1024];  
                int len = 0;  
                while ((len = inputStream.read(data)) != -1) {  
                    byteArrayOutputStream.write(data, 0, len);  
                }  
                result = new String(byteArrayOutputStream.toByteArray(), "utf-8");  
            } else {  
                //此处写入请求失败操作  
            }  
            inputStream.close();  
            outputStream.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        System.out.println("[" + result + "]");
        return "[" + result + "]"; 
    }
    
	public static String getUrl(CardInfoBean cardInfoBean,String functionName,String queryParam){
		String appId = commonBeans.commonBean.getAppid();
		String passWord = commonBeans.commonBean.getPasswd();
		String transId = getTransId();
		String token = DigestUtils.sha256Hex(commonBeans.commonBean.getAppid() + commonBeans.commonBean.getPasswd() + transId);
		System.out.println(appId);
		System.out.println(passWord);
		System.out.println(transId);
		System.out.println(token);
		String urlPath = commonBeans.commonBean.getWlkBaseUrl() + functionName
				+ "?appid=" + appId
				+ "&transid=" + transId
				+ "&ebid=" + cardInfoBean.getEbid()
				+ "&token=" + token
				+ "&" + queryParam;
		System.out.println(urlPath);
		return urlPath;
	}
    
	public static String getTransId(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = sdf.format(new Date());
		int randNum = (int)(89999999*Math.random()+10000000);
		String transId = commonBeans.commonBean.getAppid() + time + randNum;
		return transId;
	}

}
