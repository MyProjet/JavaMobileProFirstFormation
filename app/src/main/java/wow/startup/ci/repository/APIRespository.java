package wow.startup.ci.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wow.startup.ci.model.APIResponse;
import wow.startup.ci.model.RegisterBody;
import wow.startup.ci.network.APIService;

public class APIRespository {
    private APIService  apiService;

    public APIRespository(APIService apiService) {
        this.apiService = apiService;
    }

    public LiveData<APIResponse> register(RegisterBody registerBody){
        MutableLiveData<APIResponse> data = new MutableLiveData<>();
        this.apiService.register(registerBody).enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                Log.i("Response: ",response.toString());
                if(response.isSuccessful()){
                    Log.i("api response", response.body().toString());
                    data.setValue(new APIResponse(response.body().getMessage(), response.code()));
                }
                if(response.code() == 400){
                    //og.i("BAD RESPONSE", response.body().toString());
                    data.setValue(new APIResponse("Phone number abready registered",response.code()));
                }
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                Log.i("API ERROR",t.toString());
            }
        });
        return  data;
    }
}
