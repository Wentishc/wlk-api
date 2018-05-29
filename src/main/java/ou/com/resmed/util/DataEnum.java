package ou.com.resmed.util;

public class DataEnum {

	public static enum GprsStatus {
		outLine("00", "离线"), onLine("01", "在线");
		private final String key;
		private final String value;
		private GprsStatus(String key, String value) {this.key = key;this.value = value;}
		public String getKey() {return key;}
		public String getValue() {return value;}
	}
	
	public static enum UserRat {
		_3G("1","2G"), _2G("2","2G"),_4G("6","4G及其他");
		private final String key;
		private final String value;
		private UserRat(String key, String value) {this.key = key;this.value = value;}
		public String getKey() {return key;}
		public String getValue() {return value;}
	}
	
	public static enum UserStatus {
		NORMAL("00","正常"), SINGLESHUTDOWN("01","单向停机"),SHUTDOWN("02","停机"),
		WAITDELETE("03","预销号"),DELETE("04","销号"),PASS("05","过户"),SLEEP("06","休眠"),
		WAITACTIVE("07","待激活"),NOTEXIST("99","号码不存在");
		private final String key;
		private final String value;
		private UserStatus(String key, String value) {this.key = key;this.value = value;}
		public String getKey() {return key;}
		public String getValue() {return value;}
	}
	
	public static enum CardInfoType {
		MSISDN("0","msisdn"), IMSI("1","imsi"),ICCID("2","iccid");
		private final String key;
		private final String value;
		private CardInfoType(String key, String value) {this.key = key;this.value = value;}
		public String getKey() {return key;}
		public String getValue() {return value;}
	}

	public static enum MachineStatus {
		MSISDN("0","关机"), IMSI("1","开机");
		private final String key;
		private final String value;
		private MachineStatus(String key, String value) {this.key = key;this.value = value;}
		public String getKey() {return key;}
		public String getValue() {return value;}
	}
	
	public static enum SmsResetStatus {
		SUCCESS("0","重置成功"), FAIL("100","短信重置刷新失败");
		private final String key;
		private final String value;
		private SmsResetStatus(String key, String value) {this.key = key;this.value = value;}
		public String getKey() {return key;}
		public String getValue() {return value;}
	}

}
