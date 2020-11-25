package com.path.dbmaps.vo;

import java.util.Date;

public class DMS_USER_MAPVO extends DMS_USER_MAPVOKey {
    /**
     * This field corresponds to the database column DMS_USER_MAP.DMS_USER_ID
     */
    private String DMS_USER_ID;

    /**
     * This field corresponds to the database column DMS_USER_MAP.DMS_USER_PWD
     */
    private String DMS_USER_PWD;
    
    /**
     * This field corresponds to the database column DMS_USER_MAP.NAME_ARABIC
     */
    private String NAME_ARABIC;
    
    /**
     * This field corresponds to the database column DMS_USER_MAP.NAME_ENGLISH
     */
    private String NAME_ENGLISH;
    
    private Date DATE_UPDATED;
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_USER_MAP.DMS_USER_ID
     *
     * @return the value of DMS_USER_MAP.DMS_USER_ID
     */
    public String getDMS_USER_ID() {
        return DMS_USER_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_USER_MAP.DMS_USER_ID
     *
     * @param DMS_USER_ID the value for DMS_USER_MAP.DMS_USER_ID
     */
    public void setDMS_USER_ID(String DMS_USER_ID) {
        this.DMS_USER_ID = DMS_USER_ID == null ? null : DMS_USER_ID.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_USER_MAP.DMS_USER_PWD
     *
     * @return the value of DMS_USER_MAP.DMS_USER_PWD
     */
    public String getDMS_USER_PWD() {
        return DMS_USER_PWD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_USER_MAP.DMS_USER_PWD
     *
     * @param DMS_USER_PWD the value for DMS_USER_MAP.DMS_USER_PWD
     */
    public void setDMS_USER_PWD(String DMS_USER_PWD) {
        this.DMS_USER_PWD = DMS_USER_PWD == null ? null : DMS_USER_PWD.trim();
    }

		
		public Date getDATE_UPDATED()
		{
			return DATE_UPDATED;
		}

		
		public void setDATE_UPDATED(Date dATE_UPDATED)
		{
			DATE_UPDATED = dATE_UPDATED;
		}

		
		public String getNAME_ARABIC()
		{
			return NAME_ARABIC;
		}

		
		public void setNAME_ARABIC(String nAME_ARABIC)
		{
			NAME_ARABIC = nAME_ARABIC == null ? null : nAME_ARABIC.trim();
		}

		
		public String getNAME_ENGLISH()
		{
			return NAME_ENGLISH;
		}

		
		public void setNAME_ENGLISH(String nAME_ENGLISH)
		{
			NAME_ENGLISH = nAME_ENGLISH == null ? null : nAME_ENGLISH.trim();
		}
}