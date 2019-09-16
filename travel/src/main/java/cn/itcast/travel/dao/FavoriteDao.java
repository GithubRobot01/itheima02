package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;

public interface FavoriteDao {
    Favorite isFavorite(int rid,int uid);

    int findCountByRid(int rid);

    void addFavorite(int rid, int uid);
}
