package fm.dex.model.db.tables

class ChannelTable {

    companion object {
        const val TABLE_NAME = "channels"

        const val TITLE = "title"

        const val DESCRIPTION = "description"

        const val LINK = "link"

        const val RSS = "rss"

        const val THUMBNAIL = "thumbnail"

        const val KEYWORDS = "keywords"

        fun getCreateTableQuery() =
                "CREATE TABLE $TABLE_NAME (" +
                        "$TITLE  TEXT NOT NULL," +
                        "$DESCRIPTION  TEXT NOT NULL," +
                        "$LINK TEXT NOT NULL," +
                        "$RSS TEXT NOT NULL," +
                        "$THUMBNAIL TEXT NOT NULL," +
                        "$KEYWORDS TEXT NOT NULL);"
    }
}
