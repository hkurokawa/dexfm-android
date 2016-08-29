package fm.dex.model.db.resolvers

import android.database.Cursor
import com.pushtorefresh.storio.sqlite.operations.get.DefaultGetResolver
import fm.dex.model.entities.Contributor
import fm.dex.model.db.tables.ContributorTable

class ContributorGetResolver : DefaultGetResolver<Contributor>() {

    override fun mapFromCursor(cursor: Cursor): Contributor {
        return Contributor(
                id = cursor.getLong(cursor.getColumnIndexOrThrow(ContributorTable.ID)),
                name = cursor.getString(cursor.getColumnIndexOrThrow(ContributorTable.NAME))
        )
    }
}
