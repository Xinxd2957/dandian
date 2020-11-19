package com.system.demo.repository.Login;


        import com.alibaba.fastjson.JSON;
        import com.alibaba.fastjson.JSONObject;
        import com.system.demo.common.utils.OkHttpClientRequest;
        import okhttp3.Response;
        import org.springframework.stereotype.Repository;

        import java.io.IOException;
        import java.util.HashMap;
        import java.util.Map;

@Repository
public class LoginThirdRepository {



    /**
     * 获取token
     */
    public Response getToken(String username,String password) throws IOException {

        String url ="http://183.250.155.111:8125/rest/thirdlogin/token?username="
                +username+"&password="+password;

        JSONObject json = new JSONObject();


        Response response = OkHttpClientRequest.postForm(url,json.toJSONString());

        return  response;
    }



    /**
     * 获取登录
     */
    public Response login(String username,String token) throws IOException {

        String url ="http://183.250.155.111:8125/rest/thirdlogin/sso?username="
                +username+"&token="+token+"&redirect_url="+"/portal/daylight/index";

        Response response = OkHttpClientRequest.get(url);

        return  response;
    }
}
