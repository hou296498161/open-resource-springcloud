package base;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/6 0006 14:33
 */
@Data
@NoArgsConstructor
public class Respond {

    private int code;
    private String message;
    private Object data;

    public Respond(RespondEnum re) {
        this.code = re.getCode();
        this.message = re.getMessage();
    }


    public Respond(RespondEnum re, Object data) {
        this.code = re.getCode();
        this.message = re.getMessage();
        this.data = data;
    }

    public Respond(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
