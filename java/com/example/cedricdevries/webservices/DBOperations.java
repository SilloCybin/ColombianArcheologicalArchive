package com.example.cedricdevries.webservices;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBOperations {

    public static final String LOGTAG = "COMP_MNGMNT_SYS";

    private SQLiteOpenHelper dbhandler;
    private SQLiteDatabase database;
    private int foundDuplicate;

    public DBOperations(Context context) {
        dbhandler = new DBHandler(context);
    }

    public void open() {
        Log.i(LOGTAG, "Database Opened");
        database = dbhandler.getWritableDatabase();
    }

    public void close() {
        Log.i(LOGTAG, "Database Closed");
        dbhandler.close();
    }


    // _Company_Methods______________________________________________________________________________________________________


    private static final String[] allColumns_elementstable = {
            DBHandler.COLUMN_ID,
            DBHandler.COLUMN_PARQUE,
            DBHandler.COLUMN_TIPO,
            DBHandler.COLUMN_NOMBRE,
            DBHandler.COLUMN_DESCRIPCION,
            DBHandler.COLUMN_UBICACION,
            DBHandler.COLUMN_DATOS_HISTORICOS,
            DBHandler.COLUMN_DIMENSIONES,
            DBHandler.COLUMN_TECNICA,
            DBHandler.COLUMN_DATOS_BIBLIOGRAFICOS
    };

    public int selectCount(){

        String query = "SELECT * FROM elements";

        Cursor cursor = database.rawQuery(query, null);

        return cursor.getCount();
    }

    public ArcheologicalElement addArcheologicalElement(ArcheologicalElement element) {

        ContentValues values = new ContentValues();

        values.put(DBHandler.COLUMN_PARQUE, element.getParque_arqueologico());
        values.put(DBHandler.COLUMN_TIPO, element.getElemento_arqueologico());
        values.put(DBHandler.COLUMN_NOMBRE, element.getNombre_elemento_arqueologico());
        values.put(DBHandler.COLUMN_DESCRIPCION, element.getDescripcion());
        values.put(DBHandler.COLUMN_UBICACION, element.getUbicacion_actual_dentro_del_parque());
        values.put(DBHandler.COLUMN_DATOS_HISTORICOS, element.getDatos_historicos());
        values.put(DBHandler.COLUMN_DIMENSIONES, element.getDimensiones_visibles());
        values.put(DBHandler.COLUMN_TECNICA, element.getTecnica_de_elaboracion());
        values.put(DBHandler.COLUMN_DATOS_BIBLIOGRAFICOS, element.getDatos_bibliograficos());

        long insertid = database.insert(DBHandler.TABLE_ELEMENTS, null, values);
        element.setID(insertid);

        return element;
    }

    public ArcheologicalElement getArcheologicalElement(long id) {

        Cursor cursor = database.query(DBHandler.TABLE_ELEMENTS, allColumns_elementstable, DBHandler.COLUMN_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        ArcheologicalElement archElmnt = new ArcheologicalElement();

        archElmnt.setID(cursor.getLong(cursor.getColumnIndex(DBHandler.COLUMN_ID)));
        archElmnt.setParque_arqueologico(cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_PARQUE)));
        archElmnt.setElemento_arqueologico(cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_TIPO)));
        archElmnt.setNombre_elemento_arqueologico(cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_NOMBRE)));
        archElmnt.setDescripcion(cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_DESCRIPCION)));
        archElmnt.setUbicacion_actual_dentro_del_parque(cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_UBICACION)));
        archElmnt.setDatos_historicos(cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_DATOS_HISTORICOS)));
        archElmnt.setDimensiones_visibles(cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_DIMENSIONES)));
        archElmnt.setTecnica_de_elaboracion(cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_TECNICA)));
        archElmnt.setDatos_bibliograficos(cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_DATOS_BIBLIOGRAFICOS)));


        return archElmnt;
    }

    public List<ShortArcheologicalElement> getAllArcheologicalElementsShort() {

        Cursor cursor = database.query(DBHandler.TABLE_ELEMENTS, allColumns_elementstable, null, null, null, null, null);
        List<ShortArcheologicalElement> elements = new ArrayList<>();
        List<ShortArcheologicalElement> uniqueElements = new ArrayList<>();

        Log.d("count", Integer.toString(selectCount()));

        if (cursor.getCount() > 0) {

            try {

                while (cursor.moveToNext()) {

                    ShortArcheologicalElement archElmnt = new ShortArcheologicalElement();

                    archElmnt.setID(cursor.getLong(cursor.getColumnIndex(DBHandler.COLUMN_ID)));
                    archElmnt.setParqueArqueologico(cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_PARQUE)));
                    archElmnt.setTipo(cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_TIPO)));
                    archElmnt.setNombre(cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_NOMBRE)));

                    if (archElmnt.getNombre() != null) {
                        elements.add(archElmnt);
                    }

                }
            } finally {
                cursor.close();
            }

            Log.d("1115", "out of cursor loop");
        }

        return elements;
    }

    public List<ShortArcheologicalElement> getArcheologicalElementsByType(String type){

        Cursor cursor = database.query(DBHandler.TABLE_ELEMENTS, allColumns_elementstable, DBHandler.COLUMN_TIPO + "=? " , new String[]{type}, null, null, null);

        List<ShortArcheologicalElement> companies = new ArrayList<>();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {

                ShortArcheologicalElement archElmnt = new ShortArcheologicalElement();

                archElmnt.setID(cursor.getLong(cursor.getColumnIndex(DBHandler.COLUMN_ID)));
                archElmnt.setParqueArqueologico(cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_PARQUE)));
                archElmnt.setTipo(cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_TIPO)));
                archElmnt.setNombre(cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_NOMBRE)));

                companies.add(archElmnt);
            }
        }

        return companies;
    }

    public List<ShortArcheologicalElement> getArcheologicalElementsByPark(String park){

        Cursor cursor = database.query(DBHandler.TABLE_ELEMENTS, allColumns_elementstable, DBHandler.COLUMN_TIPO + "=? " , new String[]{park}, null, null, null);

        List<ShortArcheologicalElement> companies = new ArrayList<>();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {

                ShortArcheologicalElement archElmnt = new ShortArcheologicalElement();

                archElmnt.setID(cursor.getLong(cursor.getColumnIndex(DBHandler.COLUMN_ID)));
                archElmnt.setParqueArqueologico(cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_PARQUE)));
                archElmnt.setTipo(cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_TIPO)));
                archElmnt.setNombre(cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_NOMBRE)));

                companies.add(archElmnt);
            }
        }

        return companies;
    }

    public List<ShortArcheologicalElement> getArcheologicalElementsByTypeAndPark(String type, String park){

        Cursor cursor = database.query(DBHandler.TABLE_ELEMENTS, allColumns_elementstable, DBHandler.COLUMN_TIPO + "=? AND " + DBHandler.COLUMN_PARQUE + "=?" , new String[]{type, park}, null, null, null);

        List<ShortArcheologicalElement> companies = new ArrayList<>();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {

                ShortArcheologicalElement archElmnt = new ShortArcheologicalElement();

                archElmnt.setID(cursor.getLong(cursor.getColumnIndex(DBHandler.COLUMN_ID)));
                archElmnt.setParqueArqueologico(cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_PARQUE)));
                archElmnt.setTipo(cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_TIPO)));
                archElmnt.setNombre(cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_NOMBRE)));

                companies.add(archElmnt);
            }
        }

        return companies;
    }
}
