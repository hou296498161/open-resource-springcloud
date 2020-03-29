package com.beauhou.authentication.server;


import com.beauhou.authentication.eo.OauthClientDetails;

import java.util.List;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/6 0006 13:41
 */
public interface AuthenticationServer {

    OauthClientDetails getOauthClientDetailsByClientId(String clientId);

    void saveOauthClientDetails(OauthClientDetails oauthClientDetails);

    void removeOauthClientDetails(OauthClientDetails oauthClientDetails);

    void updateOauthClientDetails(OauthClientDetails oauthClientDetails);

    List<OauthClientDetails> getAllOauthClientDetails();

    List<OauthClientDetails> getPageOauthClientDetails(Integer current, Integer size, OauthClientDetails details);
}
