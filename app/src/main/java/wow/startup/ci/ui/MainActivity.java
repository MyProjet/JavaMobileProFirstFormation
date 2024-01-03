package wow.startup.ci.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import wow.startup.ci.R;
import wow.startup.ci.model.Todo;
import wow.startup.ci.network.RectrofilClient;
import wow.startup.ci.network.TodoService;
import wow.startup.ci.repository.TodoRepository;
import wow.startup.ci.viewModel.TodoViewModel;

public class MainActivity extends AppCompatActivity {

    private  String code = "";
    Drawable point_background_solid, boardered_point_background;

    private TodoViewModel todoViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_frag_login);

        point_background_solid = getResources().getDrawable(R.drawable.point_background_solid);
        boardered_point_background = getResources().getDrawable(R.drawable.boardered_point_background);


        //initialiser notre viewModel
        todoViewModel =  new ViewModelProvider(this).get(TodoViewModel.class);
        todoViewModel.init(RectrofilClient.getInstance().create(TodoService.class));

        //ecouter le changement de donnée
        todoViewModel.getTodoList().observe(this, new Observer<Todo>() {
            @Override
            public void onChanged(Todo todo) {
                Log.i("Res: ", todo.toString());
            }
        });


    }

    public void handlePadBtnClicked(View view){
            Button button = (Button) view;
            String  numberClicked = button.getText().toString();
            code = code + numberClicked;
            Log.i("I","code" + code);

            //Remplissage cercle
            setCodePoint();


            if(code.length() == 4) {
                Log.i("I","Auth Req");

                boolean isAuth = false;
                if(isAuth){

                }else{
                    Toast.makeText(MainActivity.this,"Auth echoué",Toast.LENGTH_SHORT).show();
                    handleCodeReset();
                }
            }

    }

    private  void setCodePoint(){
        LinearLayout point_layout = findViewById(R.id.point_layout);
        for (int i = 0; i < 4 ; i++){
            if(i <= code.length() - 1){
                point_layout.getChildAt(i).setBackground(point_background_solid);
            }else {
                point_layout.getChildAt(i).setBackground(boardered_point_background);
            }

        }
    }

    private  void handleCodeReset(){
        if(!code.isEmpty()){
            code = "";
            setCodePoint();
        }
    }

    public void handlePadDeleteClick(View view){
        if(!code.isEmpty()){
            code = code.substring(0,code.length() - 1);
            setCodePoint();
        }
    }
}