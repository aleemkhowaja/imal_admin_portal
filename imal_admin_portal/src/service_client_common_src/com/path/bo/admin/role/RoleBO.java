package com.path.bo.admin.role;

import java.util.List;

import com.path.dbmaps.vo.S_ROLEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.admin.role.RoleSC;

public interface RoleBO
{
    /**
     * returns list of roles from s_role
     * @param roleSC
     * @return
     * @throws BaseException
     */
    List returnRolesList(RoleSC roleSC) throws BaseException;

    /**
     * returns count of roles 
     * @param roleSC
     * @return
     * @throws BaseException
     */
    int returnRolesCount(RoleSC roleSC) throws BaseException;
    
    /**
     * returns role main info 
     * @param roleSC
     * @return
     * @throws BaseException
     */
    S_ROLEVO returnRole(RoleSC roleSC) throws BaseException;
}
