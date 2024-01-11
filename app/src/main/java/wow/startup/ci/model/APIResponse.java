package wow.startup.ci.model;

public class APIResponse {
    private  String message;
    private Integer statusCode;

    public APIResponse(String message,Integer statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "APIResponse{" +
                "message='" + message + '\'' +
                '}';
    }

    public Boolean isSuccess(){
        return statusCode == 201;
    }
}
