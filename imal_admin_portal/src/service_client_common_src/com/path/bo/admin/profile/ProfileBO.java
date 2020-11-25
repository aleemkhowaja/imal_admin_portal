package com.path.bo.admin.profile;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.admin.profile.ProfileSC;
 

public interface ProfileBO
{
	public List getProfileList(ProfileSC profileSC) throws BaseException;

	public int getProfileCount(ProfileSC profileSC) throws BaseException;
	
	public List getOptList(ProfileSC profileSC) throws BaseException;
}
