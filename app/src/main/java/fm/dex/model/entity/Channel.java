package fm.dex.model.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.NotNull;

@Entity
public final class Channel {

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private String link;

    @NotNull
    private String rss;

    @NotNull
    private String thumbnail;

    @NotNull
    private String keywords;
}
