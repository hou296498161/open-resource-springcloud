package base;

/**
 * 创建controller的基类
 * @author beauhou
 * @version 1.0
 * @date 2020/3/6 0006 14:49
 */
public abstract class BaseController {
    public Respond buildSuccess(){
        return new Respond(RespondEnum.SUCCESS);

    }
    public Respond buildSuccess(String msg){
        return new Respond(RespondEnum.SUCCESS,msg);
    }

    public Respond buildFail(){
        return new Respond(RespondEnum.FAILURE);
    }
    public Respond buildFail(String msg){
        return new Respond(RespondEnum.FAILURE,msg);
    }
}
