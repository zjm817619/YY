package com.tarena.yy.entity;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by tarena on 2017/7/11.
 */

public class UserEntity extends BmobUser{
    BmobFile photo;
    public UserEntity(BmobFile photo) {
        this.photo = photo;
    }

    public UserEntity() {
    }

    public BmobFile getPhoto() {
        return photo;
    }

    public void setPhoto(BmobFile photo) {
        this.photo = photo;
    }
}
