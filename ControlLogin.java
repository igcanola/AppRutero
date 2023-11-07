package curso.android.controles;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import curso.android.controles_personalizados.R;
import curso.android.interfaces.OnLoginListener;

/**
 * Created by CltControl on 16/07/2016.
 */
public class ControlLogin extends LinearLayout {

    private EditText txtUsuario, txtPassword;
    private Button btnLogin;
    private TextView lblMensaje;

    public void setListener(OnLoginListener listener) {
        this.listener = listener;
    }

    private OnLoginListener listener;

    public ControlLogin(Context context) {
        super(context);
    }

    public ControlLogin(Context context, AttributeSet attrs) {
        super(context, attrs);
        inicializar();
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ControlLogin);
        String textoBoton = a.getString(R.styleable.ControlLogin_login_text);

        btnLogin.setText(textoBoton);
        a.recycle();
    }

    private void inicializar() {
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.control_login,this,true);

        txtUsuario = (EditText)findViewById(R.id.txtUsuario);
        txtPassword= (EditText)findViewById(R.id.txtClave);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        lblMensaje=(TextView)findViewById(R.id.lblMensaje);

        asignarEventos();
    }

    private void asignarEventos() {
        btnLogin.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                listener.Onlogin(txtUsuario.getText().toString(),txtPassword.getText().toString());
            }
        });
    }

    public void setMensaje(String mensaje){
        lblMensaje.setText(mensaje);
    }
}



























