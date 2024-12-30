package com.musk.web.enums.role;

import lombok.Getter;

import java.util.Arrays;

/**
 * ClassName: RoleInfoEnums
 * @Description:
 * @author
 * @date 2024年12月30日
 */
@Getter
public enum RoleInfoEnums {

    ADMIN(1,"ADMIN","管理员"),
    GENERAL(2,"GENERAL","普通用户"),

    ;


    private Integer id ;
    private String code ;
    private String desc ;

    RoleInfoEnums(Integer id,String code,String desc ){
        this.id = id;
        this.code = code;
        this.desc = desc;
    }

    public static  RoleInfoEnums getRoleInfoEnumsByRoleId(Integer roleId){
        return Arrays.stream(RoleInfoEnums.values()).filter(k->k.getId().equals(roleId)).findFirst().get();
    }

}
