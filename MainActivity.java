package curso.android.controles_personalizados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import javax.sql.DataSource;

import curso.android.BaseDatos.RuteroDataSource;
import curso.android.controles.ControlLogin;
import curso.android.interfaces.OnLoginListener;

public class MainActivity extends AppCompatActivity {
        //Código de envio
        public final static int ADD_REQUEST_CODE = 1;

        //Atributos para datos
        private ControlLogin ctlLogin;
        private Button btnTrabajo;
        private Button btnTarea;
        private Button btnInformes;
        private RuteroDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CREAR NUEVO OBJETO RUTERODATASOURCE
        dataSource = new RuteroDataSource(this);

        ctlLogin = (ControlLogin) findViewById(R.id.CtlLogin);
        ctlLogin.setListener(new OnLoginListener() {
            @Override
            public void Onlogin(String usuario, String password) {
                if (usuario.equals("demo") && password.equals("demo")){

                    ctlLogin.setMensaje("Login Correcto");
                    setContentView(R.layout.menu_rutero);

                    btnTrabajo = (Button) findViewById(R.id.btnTrabajo);
                    btnTrabajo.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            setContentView(R.layout.planificar_trabajo);
                        }
                    });

                    btnTarea = (Button) findViewById(R.id.btnTarea);
                    btnTarea.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            setContentView(R.layout.tareas);
                        }
                    });

                    btnInformes = (Button) findViewById(R.id.btnInforme);
                    btnInformes.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            setContentView(R.layout.informes);
                        }
                    });


                }else{
                    ctlLogin.setMensaje("Login Incorrecto");
                }
            }
        });
    }

}
