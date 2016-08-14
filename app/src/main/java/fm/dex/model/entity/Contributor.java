package fm.dex.model.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

@Entity
public final class Contributor {

    @Id(autoincrement = true)
    private long id;

    @Unique
    private String name;
}
