package line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q4 {
	public static void main(String[] args) throws IOException {
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int n = Integer.parseInt(br.readLine());
            HashMap<String, String> map = new HashMap<String, String>();
            for (int i = 0; i < n; i++) {
                final StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                String method = tokenizer.nextToken();
                String url = tokenizer.nextToken();
                String body = "";
                if (tokenizer.hasMoreTokens()) {
                    body = tokenizer.nextToken();
                }
                if(method.equals("GET")) {
                	url = url.substring(url.indexOf("/data"));
                }
                else if(method.equals("POST")) {
                	if(body.equals("")) {
                		map.put(url, "");
                	}else {
                		body = body.substring(body.indexOf("=")+1);
                		map.put(url,body);
                	}
                }
            }
        }
    }
}
