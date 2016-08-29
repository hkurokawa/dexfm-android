package fm.dex.model.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import fm.dex.model.DB_NAME
import fm.dex.model.db.tables.ChannelTable
import fm.dex.model.db.tables.ContributorTable
import fm.dex.model.db.tables.ItemTable

class DbOpenHelper : SQLiteOpenHelper {

    constructor(context: Context) : super(context, DB_NAME, null, 1) {
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(ChannelTable.getCreateTableQuery())
        db.execSQL(ItemTable.getCreateTableQuery())
        db.execSQL(ContributorTable.getCreateTableQuery())
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // no impl
    }
}
