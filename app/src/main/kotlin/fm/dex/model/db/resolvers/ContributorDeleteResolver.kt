package fm.dex.model.db.resolvers

import com.pushtorefresh.storio.sqlite.StorIOSQLite
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResolver
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResult
import fm.dex.model.entities.Contributor
import fm.dex.model.db.tables.ContributorTable

class ContributorDeleteResolver : DeleteResolver<Contributor>() {

    override fun performDelete(storIOSQLite: StorIOSQLite, contributor: Contributor): DeleteResult {
        storIOSQLite
                .delete()
                .`object`(contributor)
                .prepare()
                .executeAsBlocking();
        return DeleteResult.newInstance(1, ContributorTable.TABLE_NAME)
    }
}