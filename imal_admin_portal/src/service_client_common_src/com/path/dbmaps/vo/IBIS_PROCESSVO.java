package com.path.dbmaps.vo;

public class IBIS_PROCESSVO extends IBIS_PROCESSVOKey {
    private String PERIODICAL_PROCESS;

    private String POSTING;

    private String APP_NAME;

    private String USER_ID;

    private String MACHINE_ID;

    public String getPERIODICAL_PROCESS() {
        return PERIODICAL_PROCESS;
    }

    public void setPERIODICAL_PROCESS(String PERIODICAL_PROCESS) {
        this.PERIODICAL_PROCESS = PERIODICAL_PROCESS == null ? null : PERIODICAL_PROCESS.trim();
    }

    public String getPOSTING() {
        return POSTING;
    }

    public void setPOSTING(String POSTING) {
        this.POSTING = POSTING == null ? null : POSTING.trim();
    }

    public String getAPP_NAME() {
        return APP_NAME;
    }

    public void setAPP_NAME(String APP_NAME) {
        this.APP_NAME = APP_NAME == null ? null : APP_NAME.trim();
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID == null ? null : USER_ID.trim();
    }

    public String getMACHINE_ID() {
        return MACHINE_ID;
    }

    public void setMACHINE_ID(String MACHINE_ID) {
        this.MACHINE_ID = MACHINE_ID == null ? null : MACHINE_ID.trim();
    }
}