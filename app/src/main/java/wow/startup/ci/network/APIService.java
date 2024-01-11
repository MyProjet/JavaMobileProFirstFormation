package wow.startup.ci.network;

import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.POST;
import wow.startup.ci.model.APIResponse;
import wow.startup.ci.model.RegisterBody;


public interface APIService {
    @POST("register")
    Call<APIResponse> register(@Body RegisterBody registerBody);
}
