package curso.android.controles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by CltControl on 16/07/2016.
 *  Se crean 4 metodos para la clase ExtendedEditText
 */
public class ExtendedEditText extends EditText{
    private Paint p1, p2;
    private float escala;


    public ExtendedEditText(Context context) {
        super(context);
        inicializacion();
    }

    public ExtendedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        inicializacion();
    }



    public ExtendedEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Dibujamos el fondo negro del contador
        canvas.drawRect(this.getWidth()-30*escala,5*escala,this.getWidth()-5*escala,20*escala,p1);

        //Dibujamos el numero de caracteres sobre eel contador
        canvas.drawText(""+this.getText().toString().length(), this.getWidth()-28*escala,17*escala,p2);
    }
    private void inicializacion() {
        p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p1.setColor(Color.BLACK);
        p1.setStyle(Paint.Style.FILL);

        p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setColor(Color.WHITE);
        p2.setTextSize(20);

        escala = getResources().getDisplayMetrics().density;
    }

}
