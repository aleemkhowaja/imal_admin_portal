package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CHQ_OBJECTVO extends CHQ_OBJECTVOKey {
    /**
     * This field corresponds to the database column CHQ_OBJECT.MICR_LINE
     */
    private String MICR_LINE;

    /**
     * This field corresponds to the database column CHQ_OBJECT.KEY_CODE
     */
    private String KEY_CODE;

    /**
     * This field corresponds to the database column CHQ_OBJECT.CTS_TRS_BR
     */
    private BigDecimal CTS_TRS_BR;

    /**
     * This field corresponds to the database column CHQ_OBJECT.CTS_TRS_NO
     */
    private BigDecimal CTS_TRS_NO;

    /**
     * This field corresponds to the database column CHQ_OBJECT.CTS_TRS_TYPE
     */
    private String CTS_TRS_TYPE;

    /**
     * This field corresponds to the database column CHQ_OBJECT.CTS_CB_IND
     */
    private String CTS_CB_IND;

    /**
     * This field corresponds to the database column CHQ_OBJECT.DATE_CHQ_PHYS_RECEIV
     */
    private Date DATE_CHQ_PHYS_RECEIV;

    /**
     * This field corresponds to the database column CHQ_OBJECT.PHYS_RECEIV_BY
     */
    private String PHYS_RECEIV_BY;

    /**
     * This field corresponds to the database column CHQ_OBJECT.ACC_NO
     */
    private String ACC_NO;

    /**
     * This field corresponds to the database column CHQ_OBJECT.BANK_BRANCH
     */
    private String BANK_BRANCH;

    /**
     * This field corresponds to the database column CHQ_OBJECT.BANK_CODE
     */
    private String BANK_CODE;

    /**
     * This field corresponds to the database column CHQ_OBJECT.CHQ_KEY
     */
    private String CHQ_KEY;

    /**
     * This field corresponds to the database column CHQ_OBJECT.CHQ_NUM
     */
    private String CHQ_NUM;

    /**
     * This field corresponds to the database column CHQ_OBJECT.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column CHQ_OBJECT.DATE_CREATED
     */
    private Date DATE_CREATED;

    /**
     * This field corresponds to the database column CHQ_OBJECT.DATE_DELETED
     */
    private Date DATE_DELETED;

    /**
     * This field corresponds to the database column CHQ_OBJECT.DATE_LINKED
     */
    private Date DATE_LINKED;

    /**
     * This field corresponds to the database column CHQ_OBJECT.DATE_UNLINKED
     */
    private Date DATE_UNLINKED;

    /**
     * This field corresponds to the database column CHQ_OBJECT.DELETED_BY
     */
    private String DELETED_BY;

    /**
     * This field corresponds to the database column CHQ_OBJECT.LINKED_BY
     */
    private String LINKED_BY;

    /**
     * This field corresponds to the database column CHQ_OBJECT.STATUS
     */
    private String STATUS;

    /**
     * This field corresponds to the database column CHQ_OBJECT.UNLINKED_BY
     */
    private String UNLINKED_BY;
    
    /**
     * This field corresponds to the database column CHQ_OBJECT.CHQ_LOCATION
     */
    private String CHQ_LOCATION;
    
    /**
     * This field corresponds to the database column CHQ_OBJECT.KEY_REFERENCE
     */
    private String KEY_REFERENCE;
    
    /**
     * This field corresponds to the database column CHQ_OBJECT.SCANNER_PKCS_KEY_LOCATION
     */
    private String SCANNER_PKCS_KEY_LOCATION;
    
    /**
     * This field corresponds to the database column CHQ_OBJECT.SCANNER_PRIVATE_KEY_LOCATION
     */
    private String SCANNER_PRIVATE_KEY_LOCATION;
    
    /**
     * This field corresponds to the database column CHQ_OBJECT.SCANNER_PUBLIC_KEY_LOCATION
     */
    private String SCANNER_PUBLIC_KEY_LOCATION;
    
    /**
     * This field corresponds to the database column CHQ_OBJECT.SIGNATURE_FILE
     */
    private String SIGNATURE_FILE ;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHQ_OBJECT.MICR_LINE
     *
     * @return the value of CHQ_OBJECT.MICR_LINE
     */
    public String getMICR_LINE() {
        return MICR_LINE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHQ_OBJECT.MICR_LINE
     *
     * @param MICR_LINE the value for CHQ_OBJECT.MICR_LINE
     */
    public void setMICR_LINE(String MICR_LINE) {
        this.MICR_LINE = MICR_LINE == null ? null : MICR_LINE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHQ_OBJECT.KEY_CODE
     *
     * @return the value of CHQ_OBJECT.KEY_CODE
     */
    public String getKEY_CODE() {
        return KEY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHQ_OBJECT.KEY_CODE
     *
     * @param KEY_CODE the value for CHQ_OBJECT.KEY_CODE
     */
    public void setKEY_CODE(String KEY_CODE) {
        this.KEY_CODE = KEY_CODE == null ? null : KEY_CODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHQ_OBJECT.CTS_TRS_BR
     *
     * @return the value of CHQ_OBJECT.CTS_TRS_BR
     */
    public BigDecimal getCTS_TRS_BR() {
        return CTS_TRS_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHQ_OBJECT.CTS_TRS_BR
     *
     * @param CTS_TRS_BR the value for CHQ_OBJECT.CTS_TRS_BR
     */
    public void setCTS_TRS_BR(BigDecimal CTS_TRS_BR) {
        this.CTS_TRS_BR = CTS_TRS_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHQ_OBJECT.CTS_TRS_NO
     *
     * @return the value of CHQ_OBJECT.CTS_TRS_NO
     */
    public BigDecimal getCTS_TRS_NO() {
        return CTS_TRS_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHQ_OBJECT.CTS_TRS_NO
     *
     * @param CTS_TRS_NO the value for CHQ_OBJECT.CTS_TRS_NO
     */
    public void setCTS_TRS_NO(BigDecimal CTS_TRS_NO) {
        this.CTS_TRS_NO = CTS_TRS_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHQ_OBJECT.CTS_TRS_TYPE
     *
     * @return the value of CHQ_OBJECT.CTS_TRS_TYPE
     */
    public String getCTS_TRS_TYPE() {
        return CTS_TRS_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHQ_OBJECT.CTS_TRS_TYPE
     *
     * @param CTS_TRS_TYPE the value for CHQ_OBJECT.CTS_TRS_TYPE
     */
    public void setCTS_TRS_TYPE(String CTS_TRS_TYPE) {
        this.CTS_TRS_TYPE = CTS_TRS_TYPE == null ? null : CTS_TRS_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHQ_OBJECT.CTS_CB_IND
     *
     * @return the value of CHQ_OBJECT.CTS_CB_IND
     */
    public String getCTS_CB_IND() {
        return CTS_CB_IND;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHQ_OBJECT.CTS_CB_IND
     *
     * @param CTS_CB_IND the value for CHQ_OBJECT.CTS_CB_IND
     */
    public void setCTS_CB_IND(String CTS_CB_IND) {
        this.CTS_CB_IND = CTS_CB_IND == null ? null : CTS_CB_IND.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHQ_OBJECT.DATE_CHQ_PHYS_RECEIV
     *
     * @return the value of CHQ_OBJECT.DATE_CHQ_PHYS_RECEIV
     */
    public Date getDATE_CHQ_PHYS_RECEIV() {
        return DATE_CHQ_PHYS_RECEIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHQ_OBJECT.DATE_CHQ_PHYS_RECEIV
     *
     * @param DATE_CHQ_PHYS_RECEIV the value for CHQ_OBJECT.DATE_CHQ_PHYS_RECEIV
     */
    public void setDATE_CHQ_PHYS_RECEIV(Date DATE_CHQ_PHYS_RECEIV) {
        this.DATE_CHQ_PHYS_RECEIV = DATE_CHQ_PHYS_RECEIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHQ_OBJECT.PHYS_RECEIV_BY
     *
     * @return the value of CHQ_OBJECT.PHYS_RECEIV_BY
     */
    public String getPHYS_RECEIV_BY() {
        return PHYS_RECEIV_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHQ_OBJECT.PHYS_RECEIV_BY
     *
     * @param PHYS_RECEIV_BY the value for CHQ_OBJECT.PHYS_RECEIV_BY
     */
    public void setPHYS_RECEIV_BY(String PHYS_RECEIV_BY) {
        this.PHYS_RECEIV_BY = PHYS_RECEIV_BY == null ? null : PHYS_RECEIV_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHQ_OBJECT.ACC_NO
     *
     * @return the value of CHQ_OBJECT.ACC_NO
     */
    public String getACC_NO() {
        return ACC_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHQ_OBJECT.ACC_NO
     *
     * @param ACC_NO the value for CHQ_OBJECT.ACC_NO
     */
    public void setACC_NO(String ACC_NO) {
        this.ACC_NO = ACC_NO == null ? null : ACC_NO.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHQ_OBJECT.BANK_BRANCH
     *
     * @return the value of CHQ_OBJECT.BANK_BRANCH
     */
    public String getBANK_BRANCH() {
        return BANK_BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHQ_OBJECT.BANK_BRANCH
     *
     * @param BANK_BRANCH the value for CHQ_OBJECT.BANK_BRANCH
     */
    public void setBANK_BRANCH(String BANK_BRANCH) {
        this.BANK_BRANCH = BANK_BRANCH == null ? null : BANK_BRANCH.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHQ_OBJECT.BANK_CODE
     *
     * @return the value of CHQ_OBJECT.BANK_CODE
     */
    public String getBANK_CODE() {
        return BANK_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHQ_OBJECT.BANK_CODE
     *
     * @param BANK_CODE the value for CHQ_OBJECT.BANK_CODE
     */
    public void setBANK_CODE(String BANK_CODE) {
        this.BANK_CODE = BANK_CODE == null ? null : BANK_CODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHQ_OBJECT.CHQ_KEY
     *
     * @return the value of CHQ_OBJECT.CHQ_KEY
     */
    public String getCHQ_KEY() {
        return CHQ_KEY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHQ_OBJECT.CHQ_KEY
     *
     * @param CHQ_KEY the value for CHQ_OBJECT.CHQ_KEY
     */
    public void setCHQ_KEY(String CHQ_KEY) {
        this.CHQ_KEY = CHQ_KEY == null ? null : CHQ_KEY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHQ_OBJECT.CHQ_NUM
     *
     * @return the value of CHQ_OBJECT.CHQ_NUM
     */
    public String getCHQ_NUM() {
        return CHQ_NUM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHQ_OBJECT.CHQ_NUM
     *
     * @param CHQ_NUM the value for CHQ_OBJECT.CHQ_NUM
     */
    public void setCHQ_NUM(String CHQ_NUM) {
        this.CHQ_NUM = CHQ_NUM == null ? null : CHQ_NUM.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHQ_OBJECT.CREATED_BY
     *
     * @return the value of CHQ_OBJECT.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHQ_OBJECT.CREATED_BY
     *
     * @param CREATED_BY the value for CHQ_OBJECT.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHQ_OBJECT.DATE_CREATED
     *
     * @return the value of CHQ_OBJECT.DATE_CREATED
     */
    public Date getDATE_CREATED() {
        return DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHQ_OBJECT.DATE_CREATED
     *
     * @param DATE_CREATED the value for CHQ_OBJECT.DATE_CREATED
     */
    public void setDATE_CREATED(Date DATE_CREATED) {
        this.DATE_CREATED = DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHQ_OBJECT.DATE_DELETED
     *
     * @return the value of CHQ_OBJECT.DATE_DELETED
     */
    public Date getDATE_DELETED() {
        return DATE_DELETED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHQ_OBJECT.DATE_DELETED
     *
     * @param DATE_DELETED the value for CHQ_OBJECT.DATE_DELETED
     */
    public void setDATE_DELETED(Date DATE_DELETED) {
        this.DATE_DELETED = DATE_DELETED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHQ_OBJECT.DATE_LINKED
     *
     * @return the value of CHQ_OBJECT.DATE_LINKED
     */
    public Date getDATE_LINKED() {
        return DATE_LINKED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHQ_OBJECT.DATE_LINKED
     *
     * @param DATE_LINKED the value for CHQ_OBJECT.DATE_LINKED
     */
    public void setDATE_LINKED(Date DATE_LINKED) {
        this.DATE_LINKED = DATE_LINKED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHQ_OBJECT.DATE_UNLINKED
     *
     * @return the value of CHQ_OBJECT.DATE_UNLINKED
     */
    public Date getDATE_UNLINKED() {
        return DATE_UNLINKED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHQ_OBJECT.DATE_UNLINKED
     *
     * @param DATE_UNLINKED the value for CHQ_OBJECT.DATE_UNLINKED
     */
    public void setDATE_UNLINKED(Date DATE_UNLINKED) {
        this.DATE_UNLINKED = DATE_UNLINKED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHQ_OBJECT.DELETED_BY
     *
     * @return the value of CHQ_OBJECT.DELETED_BY
     */
    public String getDELETED_BY() {
        return DELETED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHQ_OBJECT.DELETED_BY
     *
     * @param DELETED_BY the value for CHQ_OBJECT.DELETED_BY
     */
    public void setDELETED_BY(String DELETED_BY) {
        this.DELETED_BY = DELETED_BY == null ? null : DELETED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHQ_OBJECT.LINKED_BY
     *
     * @return the value of CHQ_OBJECT.LINKED_BY
     */
    public String getLINKED_BY() {
        return LINKED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHQ_OBJECT.LINKED_BY
     *
     * @param LINKED_BY the value for CHQ_OBJECT.LINKED_BY
     */
    public void setLINKED_BY(String LINKED_BY) {
        this.LINKED_BY = LINKED_BY == null ? null : LINKED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHQ_OBJECT.STATUS
     *
     * @return the value of CHQ_OBJECT.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHQ_OBJECT.STATUS
     *
     * @param STATUS the value for CHQ_OBJECT.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHQ_OBJECT.UNLINKED_BY
     *
     * @return the value of CHQ_OBJECT.UNLINKED_BY
     */
    public String getUNLINKED_BY() {
        return UNLINKED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHQ_OBJECT.UNLINKED_BY
     *
     * @param UNLINKED_BY the value for CHQ_OBJECT.UNLINKED_BY
     */
    public void setUNLINKED_BY(String UNLINKED_BY) {
        this.UNLINKED_BY = UNLINKED_BY == null ? null : UNLINKED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHQ_OBJECT.CHQ_LOCATION
     *
     * @return the value of CHQ_OBJECT.CHQ_LOCATION
     */
	public String getCHQ_LOCATION() {
		return CHQ_LOCATION;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHQ_OBJECT.CHQ_LOCATION
     *
     * @param UNLINKED_BY the value for CHQ_OBJECT.CHQ_LOCATION
     */
	public void setCHQ_LOCATION(String cHQ_LOCATION) {
		CHQ_LOCATION = cHQ_LOCATION;
	}

	public String getKEY_REFERENCE() {
		return KEY_REFERENCE;
	}

	public void setKEY_REFERENCE(String kEY_REFERENCE) {
		KEY_REFERENCE = kEY_REFERENCE;
	}

	public String getSCANNER_PKCS_KEY_LOCATION() {
		return SCANNER_PKCS_KEY_LOCATION;
	}

	public void setSCANNER_PKCS_KEY_LOCATION(String sCANNER_PKCS_KEY_LOCATION) {
		SCANNER_PKCS_KEY_LOCATION = sCANNER_PKCS_KEY_LOCATION;
	}

	public String getSCANNER_PRIVATE_KEY_LOCATION() {
		return SCANNER_PRIVATE_KEY_LOCATION;
	}

	public void setSCANNER_PRIVATE_KEY_LOCATION(String sCANNER_PRIVATE_KEY_LOCATION) {
		SCANNER_PRIVATE_KEY_LOCATION = sCANNER_PRIVATE_KEY_LOCATION;
	}

	public String getSCANNER_PUBLIC_KEY_LOCATION() {
		return SCANNER_PUBLIC_KEY_LOCATION;
	}

	public void setSCANNER_PUBLIC_KEY_LOCATION(String sCANNER_PUBLIC_KEY_LOCATION) {
		SCANNER_PUBLIC_KEY_LOCATION = sCANNER_PUBLIC_KEY_LOCATION;
	}

	public String getSIGNATURE_FILE() {
		return SIGNATURE_FILE;
	}

	public void setSIGNATURE_FILE(String sIGNATURE_FILE) {
		SIGNATURE_FILE = sIGNATURE_FILE;
	}
    
    
}