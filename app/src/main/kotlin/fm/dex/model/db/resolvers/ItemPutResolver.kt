package fm.dex.model.db.resolvers

import com.pushtorefresh.storio.sqlite.StorIOSQLite
import com.pushtorefresh.storio.sqlite.operations.put.PutResolver
import com.pushtorefresh.storio.sqlite.operations.put.PutResult
import fm.dex.model.entities.Item
import fm.dex.model.db.tables.ItemTable

class ItemPutResolver : PutResolver<Item>() {

    override fun performPut(storIOSQLite: StorIOSQLite, item: Item): PutResult {
        storIOSQLite
                .put()
                .`object`(item)
                .prepare()
                .executeAsBlocking()
        return PutResult.newUpdateResult(1, ItemTable.TABLE_NAME);
    }
}
