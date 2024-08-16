package commons;

import java.io.File;

public class GlobalContants {
	// Sever url: dev/testing/staging/product
	// Database: dev/Testing/staging/product
	// timeout:short/long
	// username: pass
	public static final String DEV_USER_URL = "https://demo.nopcommerce.com/";
	public static final String DEV_ADMIN_URL = "https://admin-demo.nopcommerce.com/login?ReturnUrl=/admin/";
	public static final String DEV_BANK_GURU_LOG_IN ="https://demo.guru99.com/v4/";
	public static final String DEV_BANK_GURU_REGISTER ="https://demo.guru99.com/";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final String DEV_ADMIN_USERNAME = "admin@yourstore.com";
	public static final String DEV_ADMIN_PASSWORD = "admin";
	public static final String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "downloadFiles" +File.separator;
	public static final String JAVA_VERSION = System.getProperty("java.version");
 	
}
