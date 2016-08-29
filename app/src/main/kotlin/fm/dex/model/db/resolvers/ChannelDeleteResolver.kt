package fm.dex.model.db.resolvers

import com.pushtorefresh.storio.sqlite.StorIOSQLite
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResolver
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResult
import fm.dex.model.db.tables.ChannelTable
import fm.dex.model.entities.Channel

class ChannelDeleteResolver : DeleteResolver<Channel>() {

    override fun performDelete(storIOSQLite: StorIOSQLite, channel: Channel): DeleteResult {
        storIOSQLite
                .delete()
                .`object`(channel)
                .prepare()
                .executeAsBlocking();
        return DeleteResult.newInstance(1, ChannelTable.TABLE_NAME)
    }
}