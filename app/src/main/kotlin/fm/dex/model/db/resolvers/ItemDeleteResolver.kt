package fm.dex.model.db.resolvers

import com.pushtorefresh.storio.sqlite.StorIOSQLite
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResolver
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResult
import fm.dex.model.entities.Item
import fm.dex.model.db.tables.ItemTable

class ItemDeleteResolver : DeleteResolver<Item>() {

    override fun performDelete(storIOSQLite: StorIOSQLite, item: Item): DeleteResult {
        storIOSQLite
                .delete()
                .`object`(item)
                .prepare()
                .executeAsBlocking();
        return DeleteResult.newInstance(1, ItemTable.TABLE_NAME)
    }
}