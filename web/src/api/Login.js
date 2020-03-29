import Http from '@/utils/http'

export default class login {

    constructor() {}
//?grant_type=password&client_id=user-client&client_secret=123456&username=test&password=test
    login(param){
        return Http.post("/oauth/token",param);
    }

    test(){
        return Http.get("author-business/Authentication/authorClientDetailsByPage?current=1&size=1")
    }
}
