import Http from '@/utils/http'

export default class  Authentication{

    getAllApplicationInfo(){

        return Http.get("beauhou/zuulConfig/getAllServiceInfo");
    }

    getAllOauthDetails(){

        return Http.get("beauhou/oauth/oauth/queryOauthDetails");
    }
}
