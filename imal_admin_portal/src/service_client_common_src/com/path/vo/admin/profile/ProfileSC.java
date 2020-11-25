package com.path.vo.admin.profile;

import com.path.struts2.lib.common.GridParamsSC;

public class ProfileSC extends GridParamsSC
{
	
 
 private String progRef;
 private String profileId;

public String getProgRef()
{
	return progRef;
}

public void setProgRef(String progRef)
{
	this.progRef = progRef;
}

public String getProfileId()
{
	return profileId;
}

public void setProfileId(String profileId)
{
	this.profileId = profileId;
}
 
}
