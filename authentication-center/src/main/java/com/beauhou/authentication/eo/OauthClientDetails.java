package com.beauhou.authentication.eo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/26 0026 20:34
 */
@TableName("oauth_client_details")
@Data
public class OauthClientDetails  implements Serializable {

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

    private Integer autoapprove;
}
