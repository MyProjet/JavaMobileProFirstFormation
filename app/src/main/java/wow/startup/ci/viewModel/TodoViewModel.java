package wow.startup.ci.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import wow.startup.ci.model.Todo;
import wow.startup.ci.network.TodoService;
import wow.startup.ci.repository.TodoRepository;

public class TodoViewModel extends ViewModel {
    private TodoRepository todoRepository;

    public TodoViewModel() {

    }

    public  void init(TodoService todoService){
        this.todoRepository = new TodoRepository(todoService);
    }


    public LiveData<Todo> getTodoList(){
        return this.todoRepository.getAllTodoList();
    }
}
