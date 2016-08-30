package fm.dex.model.db.tables

class ItemTable {

    companion object {
        const val TABLE_NAME = "items"

        const val TITLE = "title"

        const val SUBTITLE = "subtitle"

        const val DESCRIPTION = "description"

        const val LINK = "link"

        const val PUBDATE = "pubdate"

        const val CONTRIBUTORS_ID = "contributors_id"

        const val DURATION = "duration"

        const val FILE_SIZE = "filesize"

        const val ENCLOSURE = "enclosure"

        fun getCreateTableQuery() =
                "CREATE TABLE $TABLE_NAME (" +
                        "$TITLE TEXT NOT NULL," +
                        "$SUBTITLE TEXT NOT NULL," +
                        "$DESCRIPTION TEXT NOT NULL," +
                        "$LINK TEXT NOT NULL," +
                        "$PUBDATE TEXT NOT NULL," +
                        "$CONTRIBUTORS_ID TEXT NOT NULL," +
                        "$DURATION TEXT NOT NULL," +
                        "$FILE_SIZE INTEGER NOT NULL," +
                        "$ENCLOSURE TEXT NOT NULL);"
    }
}
