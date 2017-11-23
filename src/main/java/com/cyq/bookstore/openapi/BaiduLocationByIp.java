package com.cyq.bookstore.openapi;

import java.net.HttpURLConnection;
import java.net.URL;

public class BaiduLocationByIp {

	public static void main(String[] args) {

	}

	public void getConnection(String url) {
		URL connectionUrl = null;
		try {
			connectionUrl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) connectionUrl.openConnection();
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.connect();
			//connection.get
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
