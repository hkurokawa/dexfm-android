package fm.dex.model.db.resolvers

import android.database.Cursor
import com.pushtorefresh.storio.sqlite.operations.get.DefaultGetResolver
import fm.dex.model.entities.Item
import fm.dex.model.db.tables.ItemTable

class ItemGetResolver : DefaultGetResolver<Item>() {

    override fun mapFromCursor(cursor: Cursor): Item {
        return Item(
                title = cursor.getString(cursor.getColumnIndexOrThrow(ItemTable.TITLE)),
                subTitle = cursor.getString(cursor.getColumnIndexOrThrow(ItemTable.SUBTITLE)),
                description = cursor.getString(cursor.getColumnIndexOrThrow(ItemTable.DESCRIPTION)),
                link = cursor.getString(cursor.getColumnIndexOrThrow(ItemTable.LINK)),
                pubDate = cursor.getString(cursor.getColumnIndexOrThrow(ItemTable.PUBDATE)),
                contributorsId = cursor.getString(cursor.getColumnIndexOrThrow(ItemTable.CONTRIBUTORS_ID)),
                duration = cursor.getString(cursor.getColumnIndexOrThrow(ItemTable.DURATION)),
                fileSize = cursor.getLong(cursor.getColumnIndexOrThrow(ItemTable.FILE_SIZE)),
                enclosure = cursor.getString(cursor.getColumnIndexOrThrow(ItemTable.ENCLOSURE))
        )
    }
}
