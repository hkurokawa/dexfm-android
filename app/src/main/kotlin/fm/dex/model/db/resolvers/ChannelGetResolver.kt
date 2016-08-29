package fm.dex.model.db.resolvers

import android.database.Cursor
import com.pushtorefresh.storio.sqlite.operations.get.DefaultGetResolver
import fm.dex.model.db.tables.ChannelTable
import fm.dex.model.entities.Channel

class ChannelGetResolver : DefaultGetResolver<Channel>() {

    override fun mapFromCursor(cursor: Cursor): Channel {
        return Channel(
                title = cursor.getString(cursor.getColumnIndexOrThrow(ChannelTable.TITLE)),
                description = cursor.getString(cursor.getColumnIndexOrThrow(ChannelTable.DESCRIPTION)),
                link = cursor.getString(cursor.getColumnIndexOrThrow(ChannelTable.LINK)),
                rss = cursor.getString(cursor.getColumnIndexOrThrow(ChannelTable.RSS)),
                thumbnail = cursor.getString(cursor.getColumnIndexOrThrow(ChannelTable.THUMBNAIL)),
                keywords = cursor.getString(cursor.getColumnIndexOrThrow(ChannelTable.KEYWORDS))
        )
    }
}
