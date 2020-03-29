import Http from '@/utils/http'

export  default class ZuulRouter {
    queryAllZuulRouter(param){
        return Http.get("beauhou/zuulConfig/queryAllZuulRouter", param);
    }
}
