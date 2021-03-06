package com.path.dbmaps.vo;

public class DF_FILE_MISC_SQLVO extends DF_FILE_MISC_SQLVOKey {
    /**
     * This field corresponds to the database column DF_FILE_MISC_SQL.BF_AF_FLAG
     */
    private String BF_AF_FLAG;

    /**
     * This field corresponds to the database column DF_FILE_MISC_SQL.ALLOW_STOP_EXEC
     */
    private String ALLOW_STOP_EXEC;

    /**
     * This field corresponds to the database column DF_FILE_MISC_SQL.EXEC_BY_DEFAULT
     */
    private String EXEC_BY_DEFAULT;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DF_FILE_MISC_SQL.BF_AF_FLAG
     *
     * @return the value of DF_FILE_MISC_SQL.BF_AF_FLAG
     */
    public String getBF_AF_FLAG() {
        return BF_AF_FLAG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DF_FILE_MISC_SQL.BF_AF_FLAG
     *
     * @param BF_AF_FLAG the value for DF_FILE_MISC_SQL.BF_AF_FLAG
     */
    public void setBF_AF_FLAG(String BF_AF_FLAG) {
        this.BF_AF_FLAG = BF_AF_FLAG == null ? null : BF_AF_FLAG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DF_FILE_MISC_SQL.ALLOW_STOP_EXEC
     *
     * @return the value of DF_FILE_MISC_SQL.ALLOW_STOP_EXEC
     */
    public String getALLOW_STOP_EXEC() {
        return ALLOW_STOP_EXEC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DF_FILE_MISC_SQL.ALLOW_STOP_EXEC
     *
     * @param ALLOW_STOP_EXEC the value for DF_FILE_MISC_SQL.ALLOW_STOP_EXEC
     */
    public void setALLOW_STOP_EXEC(String ALLOW_STOP_EXEC) {
        this.ALLOW_STOP_EXEC = ALLOW_STOP_EXEC == null ? null : ALLOW_STOP_EXEC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DF_FILE_MISC_SQL.EXEC_BY_DEFAULT
     *
     * @return the value of DF_FILE_MISC_SQL.EXEC_BY_DEFAULT
     */
    public String getEXEC_BY_DEFAULT() {
        return EXEC_BY_DEFAULT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DF_FILE_MISC_SQL.EXEC_BY_DEFAULT
     *
     * @param EXEC_BY_DEFAULT the value for DF_FILE_MISC_SQL.EXEC_BY_DEFAULT
     */
    public void setEXEC_BY_DEFAULT(String EXEC_BY_DEFAULT) {
        this.EXEC_BY_DEFAULT = EXEC_BY_DEFAULT == null ? null : EXEC_BY_DEFAULT.trim();
    }
}