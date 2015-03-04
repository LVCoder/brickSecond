package com.pmi.brick.aoth2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.provider.OAuth2Request;

import com.pmi.brick.web.NewPaswordController;

public class VKOAuth2Details  {
    public static final String clientId="4760386";
    public static final String clientSecret="fm6rYRXm6q2WSs14f5wr";
    public static final String accessTokenUri="https://api.vk.com/oauth/access_token";
    public static final String scope="email";
    public static final String userAuthorizationUri="https://oauth.vk.com/authorize";
    public static final String redirectUri="http://localhost:8080/brick/vklogincode";
    public static final String display="page";
    public static final String methodUri="https://api.vk.com/method/";
}
