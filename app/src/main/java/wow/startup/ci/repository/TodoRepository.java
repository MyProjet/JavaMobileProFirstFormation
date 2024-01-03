package wow.startup.ci.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wow.startup.ci.model.Todo;
import wow.startup.ci.network.TodoService;

public class TodoRepository {
    private TodoService todoService;

    public TodoRepository(TodoService todoService) {
        this.todoService = todoService;
    }

    public LiveData<Todo> getAllTodoList(){
        String test = "";
        MutableLiveData<Todo> todolist = new  MutableLiveData<>();
        this.todoService.getAllTodos().enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
//                Log.i("API","Request Ok");
//                Log.i("API",response.body().toString());

                if(response.code() == 200 || response.code() == 304){
                    todolist.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                Log.i("ERROR","Request Nok");
            }
        });

        return  todolist;
    }
}
