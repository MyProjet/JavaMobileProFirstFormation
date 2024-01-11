package wow.startup.ci.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import wow.startup.ci.model.APIResponse;
import wow.startup.ci.model.RegisterBody;
import wow.startup.ci.network.APIService;
import wow.startup.ci.repository.APIRespository;

public class APIViewModel  extends ViewModel {
    private APIRespository apiRespository;


    public void init(APIService apiService) {
        this.apiRespository = new APIRespository(apiService);
    }

    public LiveData<APIResponse> register(RegisterBody registerBody) {
        return this.apiRespository.register(registerBody);
    }
}
