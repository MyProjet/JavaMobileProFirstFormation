package wow.startup.ci.network;

import retrofit2.Call;
import retrofit2.http.GET;
import wow.startup.ci.model.Todo;

public interface TodoService {
    @GET("todos/1")
    Call<Todo> getAllTodos();
}
