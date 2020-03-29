package com.beauhou.admin.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * Created by xujingfeng on 2017/4/1.
 */
@Service
public class RefreshRouteService {

    @Autowired
    ApplicationEventPublisher publisher;

}
