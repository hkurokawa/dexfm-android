package fm.dex.model.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Unique;

import java.util.Date;
import java.util.List;

@Entity
public final class Item {

    @Id
    private long id;

    @NotNull
    @Unique
    private String title;

    @NotNull
    private String subTitle;

    @NotNull
    private String description;

    @NotNull
    private String link;

    @NotNull
    private Date pubDate;

    @ToMany(referencedJoinProperty = "id")
    private List<Contributor> contributor;

    @NotNull
    private String duration;

    @NotNull
    private long fileSize;

    @NotNull
    private String enclosure;
}
