package fm.dex.model.db.resolvers

import com.pushtorefresh.storio.sqlite.StorIOSQLite
import com.pushtorefresh.storio.sqlite.operations.put.PutResolver
import com.pushtorefresh.storio.sqlite.operations.put.PutResult
import fm.dex.model.db.tables.ChannelTable
import fm.dex.model.entities.Channel

class ChannelPutResolver : PutResolver<Channel>() {

    override fun performPut(storIOSQLite: StorIOSQLite, channel: Channel): PutResult {
        storIOSQLite
                .put()
                .`object`(channel)
                .prepare()
                .executeAsBlocking()
        return PutResult.newUpdateResult(1, ChannelTable.TABLE_NAME);
    }
}
