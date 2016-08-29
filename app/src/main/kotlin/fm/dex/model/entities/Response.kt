package fm.dex.model.entity

import fm.dex.model.entities.Channel
import fm.dex.model.entities.Item

/**
 * https://raw.githubusercontent.com/dexfm/dexfm.github.io/master/api/feeds.json
 */
data class Response(
        val channel: Channel,
        val items: List<Item>
)
