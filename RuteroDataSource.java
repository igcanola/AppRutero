package curso.android.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by ingrid on 25/07/2016.
 */
public class RuteroDataSource {

    //Meta información de la base de datos

    public static final String RUTERO_TABLE_NAME = "tblUsuario";
    public static final String STRING_TYPE = "text";
    public static final String INT_TYPE = "integer";

    //Campos de la tabla Usuario
    public static class ColumnUsuario{
        public static final String ID_USUARIO = BaseColumns._ID;
        public static final String NOMBRE = "Nombre";
        public static final String CLAVE = "Clave";
        public static final String ROL = "Rol";
        public static final String CORREO = "Correo";
        public static final String ESTADO = "Estado";
    }

    //Script de Creacion de la tabla Usuario
    public static final String CREATE_USUARIO_SCRIPT = "CREATE TABLE  " + RUTERO_TABLE_NAME
            + "(" + ColumnUsuario.ID_USUARIO + " " + INT_TYPE + " PRIMARY KEY AUTOINCREMENT, " +
            ColumnUsuario.NOMBRE+" "+STRING_TYPE+ " NOT NULL," +
            ColumnUsuario.CLAVE+" "+STRING_TYPE+ " NOT NULL," +
            ColumnUsuario.ROL+" "+STRING_TYPE+ " NOT NULL," +
            ColumnUsuario.CORREO+" "+STRING_TYPE+ " NOT NULL," +
            ColumnUsuario.ESTADO+" "+STRING_TYPE+ " NOT NULL)";

    //Script de insercion

    public static final String INSERT_USUARIOS_SCRIPT =
            "insert into "+RUTERO_TABLE_NAME+" values(null, 'Ingrid Cañola', '123456', 'Admin','igcanola@espol.edu.ec','A')";


    private BaseDatosRutero openHelper;
    private SQLiteDatabase database;

    public RuteroDataSource(Context context){
        //instancia hacia la base de datos
        openHelper = new BaseDatosRutero(context);
        database = openHelper.getWritableDatabase();
    }

}
