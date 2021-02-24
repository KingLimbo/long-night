/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.entity.po;

import com.limbo.practice.core.base.BaseBO;
import lombok.Getter;
import lombok.Setter;
/**
*
* @ProjectName: long-night
* @PackageName: com.limbo.practice.base.entity.po
* @ClassName: SysUserPo
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: limbo
* @Date: 2021-02-20 09:56:19
* @Modifier: limbo
* @ModifiedDate: 2021-02-20 09:56:19
*
* version V1.0
*/
@Getter
@Setter
public class SysUserPo extends BaseBO{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    /**
     * 登录账号
     * db_column: login_account
     */
    private String loginAccount;

    /**
     * 登录密码
     * db_column: login_pass
     */
    private String loginPass;

    /**
     * 密码盐
     * db_column: login_salt
     */
    private String loginSalt;

    /**
     * 昵称
     * db_column: user_name
     */
    private String userName;

    /**
     * 头像
     * db_column: user_head
     */
    private String userHead;

    /**
     * 手机
     * db_column: user_phone
     */
    private String userPhone;

    /**
     * 邮箱
     * db_column: user_email
     */
    private String userEmail;

    /**
     * 性别 说明：1 表示男，0 表示女
     * db_column: user_sex
     */
    private Boolean userSex;

    /**
     * 用户类型 说明：1 系统管理员 ，0 普通用户
     * db_column: user_type
     */
    private Boolean userType;

    /**
     * 是否已锁定 说明：1 表示已锁定，0 表示未锁定
     * db_column: is_locked
     */
    private Boolean locked;

    public SysUserPo(){
        super();
    }

    public SysUserPo(Long id, String loginAccount, String loginPass, String loginSalt, String userName, String userHead, String userPhone, String userEmail, Boolean userSex, Boolean userType, Boolean locked, Boolean deleted, java.util.Date gmtCreate, java.util.Date gmtModified){
        super(id, deleted, gmtCreate, gmtModified);
        this.loginAccount = loginAccount;
        this.loginPass = loginPass;
        this.loginSalt = loginSalt;
        this.userName = userName;
        this.userHead = userHead;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userSex = userSex;
        this.userType = userType;
        this.locked = locked;
    }

}
