package com.beauhou.authentication.service;

import com.beauhou.authentication.eo.OauthClientDetails;

import java.util.List;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/26 0026 20:50
 */
public interface OauthDetailsService {

    List<OauthClientDetails> queryOauthDetails();

    void  addOauthDetails(OauthClientDetails details);

    void  updateOauthDetails(OauthClientDetails details);
}
