package fm.dex.model.db.tables

class ContributorTable {

    companion object {
        const val TABLE_NAME = "contributors"

        const val ID = "_id"

        const val NAME = "name"

        fun getCreateTableQuery() =
                "CREATE TABLE $TABLE_NAME (" +
                        "$ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                        "$NAME TEXT NOT NULL);"
    }
}
