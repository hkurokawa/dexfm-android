package fm.dex.model.db.resolvers

import com.pushtorefresh.storio.sqlite.StorIOSQLite
import com.pushtorefresh.storio.sqlite.operations.put.PutResolver
import com.pushtorefresh.storio.sqlite.operations.put.PutResult
import fm.dex.model.entities.Contributor
import fm.dex.model.db.tables.ContributorTable

class ContributorPutResolver : PutResolver<Contributor>() {

    override fun performPut(storIOSQLite: StorIOSQLite, contributor: Contributor): PutResult {
        storIOSQLite
                .put()
                .`object`(contributor)
                .prepare()
                .executeAsBlocking()
        return PutResult.newUpdateResult(1, ContributorTable.TABLE_NAME);
    }
}
