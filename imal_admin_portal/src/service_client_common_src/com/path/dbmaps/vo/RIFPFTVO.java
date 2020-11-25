package com.path.dbmaps.vo;

public class RIFPFTVO extends RIFPFTVOKey {
    /**
     * This field corresponds to the database column RIFPFT.BRIEF_DESC_ENG
     */
    private String BRIEF_DESC_ENG;

    /**
     * This field corresponds to the database column RIFPFT.LONG_DESC_ENG
     */
    private String LONG_DESC_ENG;

    /**
     * This field corresponds to the database column RIFPFT.BRIEF_DESC_ARAB
     */
    private String BRIEF_DESC_ARAB;

    /**
     * This field corresponds to the database column RIFPFT.LONG_DESC_ARAB
     */
    private String LONG_DESC_ARAB;
    
    /**
     * This field corresponds to the database column RIFPFT.LONG_DESC_ARAB
     */
    private String SPECIAL_POOL;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RIFPFT.BRIEF_DESC_ENG
     *
     * @return the value of RIFPFT.BRIEF_DESC_ENG
     */
    public String getBRIEF_DESC_ENG() {
        return BRIEF_DESC_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RIFPFT.BRIEF_DESC_ENG
     *
     * @param BRIEF_DESC_ENG the value for RIFPFT.BRIEF_DESC_ENG
     */
    public void setBRIEF_DESC_ENG(String BRIEF_DESC_ENG) {
        this.BRIEF_DESC_ENG = BRIEF_DESC_ENG == null ? null : BRIEF_DESC_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RIFPFT.LONG_DESC_ENG
     *
     * @return the value of RIFPFT.LONG_DESC_ENG
     */
    public String getLONG_DESC_ENG() {
        return LONG_DESC_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RIFPFT.LONG_DESC_ENG
     *
     * @param LONG_DESC_ENG the value for RIFPFT.LONG_DESC_ENG
     */
    public void setLONG_DESC_ENG(String LONG_DESC_ENG) {
        this.LONG_DESC_ENG = LONG_DESC_ENG == null ? null : LONG_DESC_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RIFPFT.BRIEF_DESC_ARAB
     *
     * @return the value of RIFPFT.BRIEF_DESC_ARAB
     */
    public String getBRIEF_DESC_ARAB() {
        return BRIEF_DESC_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RIFPFT.BRIEF_DESC_ARAB
     *
     * @param BRIEF_DESC_ARAB the value for RIFPFT.BRIEF_DESC_ARAB
     */
    public void setBRIEF_DESC_ARAB(String BRIEF_DESC_ARAB) {
        this.BRIEF_DESC_ARAB = BRIEF_DESC_ARAB == null ? null : BRIEF_DESC_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RIFPFT.LONG_DESC_ARAB
     *
     * @return the value of RIFPFT.LONG_DESC_ARAB
     */
    public String getLONG_DESC_ARAB() {
        return LONG_DESC_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RIFPFT.LONG_DESC_ARAB
     *
     * @param LONG_DESC_ARAB the value for RIFPFT.LONG_DESC_ARAB
     */
    public void setLONG_DESC_ARAB(String LONG_DESC_ARAB) {
        this.LONG_DESC_ARAB = LONG_DESC_ARAB == null ? null : LONG_DESC_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RIFPFT.SPECIAL_POOL
     *
     * @return the value of RIFPFT.SPECIAL_POOL
     */
	public String getSPECIAL_POOL() {
		return SPECIAL_POOL;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RIFPFT.SPECIALPOOL
     *
     * @param SPECIALPOOL the value for RIFPFT.SPECIALPOOL
     */
	public void setSPECIAL_POOL(String SPECIALPOOL) {
		SPECIAL_POOL = SPECIALPOOL;
	}
}