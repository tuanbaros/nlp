package app.nlp.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import app.nlp.models.SearchResult;

/**
 * Created by tuannt on 28/11/2016.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "SeachDB";

    // Books table name
    private static final String TABLE_SEARCHS = "searchs";

    // Books Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_SECTION = "section";
    private static final String KEY_CONTENT = "content";
    private static final String KEY_LINE = "line";

    private static final String[] COLUMNS = {KEY_ID, KEY_SECTION, KEY_CONTENT, KEY_LINE};

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_SEARCH_TABLE = "CREATE TABLE searchs ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "section TEXT, "+
                "content TEXT, " +
                "line INTEGER )";
        db.execSQL(CREATE_SEARCH_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS searchs");

        // create fresh books table
        this.onCreate(db);
    }

    public void addResult(SearchResult searchResult) {
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_SECTION, searchResult.getSection());
        values.put(KEY_CONTENT, searchResult.getContent());
        values.put(KEY_LINE, searchResult.getLine());

        // 3. insert
        db.insert(TABLE_SEARCHS, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }

    public SearchResult getResult(int id){

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_SEARCHS, // a. table
                        COLUMNS, // b. column names
                        " id = ?", // c. selections
                        new String[] { String.valueOf(id) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build search object
        SearchResult result = new SearchResult();
        result.setSection(cursor.getString(1));
        result.setContent(cursor.getString(2));
        result.setLine(cursor.getInt(3));

        // 5. return search
        return result;
    }

    // Get All Books
    public ArrayList<SearchResult> getAllResults() {
        ArrayList<SearchResult> results = new ArrayList<>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_SEARCHS;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build search and add it to list
        SearchResult result = null;
        if (cursor.moveToFirst()) {
            do {
                result = new SearchResult();
                result.setSection(cursor.getString(1));
                result.setContent(cursor.getString(2));
                result.setLine(cursor.getInt(3));

                // Add book to books
                results.add(result);
            } while (cursor.moveToNext());
        }

        // return results
        return results;
    }


}
