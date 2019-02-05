package com.example.cedricdevries.webservices;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ArchElmts.db";
    private static final int DATABASE_VERSION = 1;

    public DBHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static final String TABLE_ELEMENTS = "elements";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_PARQUE = "parque";
    public static final String COLUMN_TIPO = "tipo";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_DESCRIPCION = "descripcion";
    public static final String COLUMN_UBICACION = "ubicacion";
    public static final String COLUMN_DATOS_HISTORICOS = "dato_historicos";
    public static final String COLUMN_DIMENSIONES = "dimensiones";
    public static final String COLUMN_TECNICA = "tecnica";
    public static final String COLUMN_DATOS_BIBLIOGRAFICOS = "datos_bibliograficos";

    private static final String TABLE_ELEMENTS_CREATE =
            "CREATE TABLE " + TABLE_ELEMENTS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_PARQUE + " TEXT, " +
                    COLUMN_TIPO + " TEXT, " +
                    COLUMN_NOMBRE + " TEXT, " +
                    COLUMN_DESCRIPCION + " TEXT, " +
                    COLUMN_UBICACION + " TEXT, " +
                    COLUMN_DATOS_HISTORICOS + " TEXT, " +
                    COLUMN_DIMENSIONES + " TEXT, " +
                    COLUMN_TECNICA + " TEXT, " +
                    COLUMN_DATOS_BIBLIOGRAFICOS + " TEXT " +
                    ")";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_ELEMENTS);
        db.execSQL(TABLE_ELEMENTS_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_ELEMENTS);
        db.execSQL(TABLE_ELEMENTS_CREATE);
    }

}
