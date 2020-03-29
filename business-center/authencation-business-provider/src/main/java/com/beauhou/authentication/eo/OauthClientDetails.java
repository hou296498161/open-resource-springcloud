package com.beauhou.authentication.eo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 *
 * @author beauhou
 * @version 1.0
 * @date 2020/3/6 0006 11:22
 *
 */
@Data
@TableName("OAUTH_CLIENT_DETAILS")
public class OauthClientDetails {

    private String clientId;

    private String resourceIds;

    private String clientSecret;

    private String scope;

    private String authorizedGrantTypes;

    private String webServerRedirectUri;

    private String authorities;

    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    private String additionalInformation;

    private String autoapprove;
}
