/**
 * 
 */
package com.path.vo.common.additionalfield;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.vo.BaseVO;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * AdditionalFieldCO.java used to
 */
public class AdditionalFieldCO extends BaseVO implements Serializable
{
    private String ADD_STRING1;
    private String ADD_STRING2;
    private String ADD_STRING3;
    private String ADD_STRING4;
    private String ADD_STRING5;
    private String ADD_STRING6;
    private String ADD_STRING7;
    private String ADD_STRING8;
    private String ADD_STRING9;
    private String ADD_STRING10;
    private String ADD_STRING11;
    private String ADD_STRING12;
    private String ADD_STRING13;
    private String ADD_STRING14;
    private String ADD_STRING15;
    
    private Date ADD_DATE1;
    private Date ADD_DATE2;
    private Date ADD_DATE3;
    private Date ADD_DATE4;
    private Date ADD_DATE5;
    
    private BigDecimal ADD_NUMBER1;
    private BigDecimal ADD_NUMBER2;
    private BigDecimal ADD_NUMBER3;
    private BigDecimal ADD_NUMBER4;
    private BigDecimal ADD_NUMBER5;
    
    private BigDecimal SMART_OPTION1;
    private BigDecimal SMART_OPTION2;
    private BigDecimal SMART_OPTION3;
    private BigDecimal SMART_OPTION4;
    private BigDecimal SMART_OPTION5;
    
    private BigDecimal SMART_OPTION_TEXT1;
    private BigDecimal SMART_OPTION_TEXT2;
    private BigDecimal SMART_OPTION_TEXT3;
    private BigDecimal SMART_OPTION_TEXT4;
    private BigDecimal SMART_OPTION_TEXT5;
    private BigDecimal SMART_OPTION_TEXT6;
    private BigDecimal SMART_OPTION_TEXT7;
    private BigDecimal SMART_OPTION_TEXT8;
    private BigDecimal SMART_OPTION_TEXT9;
    private BigDecimal SMART_OPTION_TEXT10;
    private BigDecimal SMART_OPTION_TEXT11;
    private BigDecimal SMART_OPTION_TEXT12;
    private BigDecimal SMART_OPTION_TEXT13;
    private BigDecimal SMART_OPTION_TEXT14;
    private BigDecimal SMART_OPTION_TEXT15;
    
    private String SMART_TEXT_DESC1;
    private String SMART_TEXT_DESC2;
    private String SMART_TEXT_DESC3;
    private String SMART_TEXT_DESC4;
    private String SMART_TEXT_DESC5;
    private String SMART_TEXT_DESC6;
    private String SMART_TEXT_DESC7;
    private String SMART_TEXT_DESC8;
    private String SMART_TEXT_DESC9;
    private String SMART_TEXT_DESC10;
    private String SMART_TEXT_DESC11;
    private String SMART_TEXT_DESC12;
    private String SMART_TEXT_DESC13;
    private String SMART_TEXT_DESC14;
    private String SMART_TEXT_DESC15;
    
    
    
    
    private String SMART_DESC1;
    private String SMART_DESC2;
    private String SMART_DESC3;
    private String SMART_DESC4;
    private String SMART_DESC5;
    
    private String USECIF_NUMBER1;
    private String USECIF_NUMBER2;
    private String USECIF_NUMBER3;
    private String USECIF_NUMBER4;
    private String USECIF_NUMBER5;
    
    private String USEDEAL_STRING1;
    private String USEDEAL_STRING1_DESC;
    
    private Boolean loadPage = false;
    
    //Flag to load the headers for additional String , additional Numbers and additional Date
    //If one or more fields has defined then the flag will set as true from the action
    private Boolean isAddString = false;
    private Boolean isAddNumber = false;
    private Boolean isAddDate = false;
    /**
     * @return the aDD_STRING1
     */
    public String getADD_STRING1()
    {
        return ADD_STRING1;
    }
    /**
     * @param aDDSTRING1 the aDD_STRING1 to set
     */
    public void setADD_STRING1(String aDDSTRING1)
    {
        ADD_STRING1 = aDDSTRING1;
    }
    /**
     * @return the aDD_STRING2
     */
    public String getADD_STRING2()
    {
        return ADD_STRING2;
    }
    /**
     * @param aDDSTRING2 the aDD_STRING2 to set
     */
    public void setADD_STRING2(String aDDSTRING2)
    {
        ADD_STRING2 = aDDSTRING2;
    }
    /**
     * @return the aDD_STRING3
     */
    public String getADD_STRING3()
    {
        return ADD_STRING3;
    }
    /**
     * @param aDDSTRING3 the aDD_STRING3 to set
     */
    public void setADD_STRING3(String aDDSTRING3)
    {
        ADD_STRING3 = aDDSTRING3;
    }
    /**
     * @return the aDD_STRING4
     */
    public String getADD_STRING4()
    {
        return ADD_STRING4;
    }
    /**
     * @param aDDSTRING4 the aDD_STRING4 to set
     */
    public void setADD_STRING4(String aDDSTRING4)
    {
        ADD_STRING4 = aDDSTRING4;
    }
    /**
     * @return the aDD_STRING5
     */
    public String getADD_STRING5()
    {
        return ADD_STRING5;
    }
    /**
     * @param aDDSTRING5 the aDD_STRING5 to set
     */
    public void setADD_STRING5(String aDDSTRING5)
    {
        ADD_STRING5 = aDDSTRING5;
    }
    /**
     * @return the aDD_STRING6
     */
    public String getADD_STRING6()
    {
        return ADD_STRING6;
    }
    /**
     * @param aDDSTRING6 the aDD_STRING6 to set
     */
    public void setADD_STRING6(String aDDSTRING6)
    {
        ADD_STRING6 = aDDSTRING6;
    }
    /**
     * @return the aDD_STRING7
     */
    public String getADD_STRING7()
    {
        return ADD_STRING7;
    }
    /**
     * @param aDDSTRING7 the aDD_STRING7 to set
     */
    public void setADD_STRING7(String aDDSTRING7)
    {
        ADD_STRING7 = aDDSTRING7;
    }
    /**
     * @return the aDD_STRING8
     */
    public String getADD_STRING8()
    {
        return ADD_STRING8;
    }
    /**
     * @param aDDSTRING8 the aDD_STRING8 to set
     */
    public void setADD_STRING8(String aDDSTRING8)
    {
        ADD_STRING8 = aDDSTRING8;
    }
    /**
     * @return the aDD_STRING9
     */
    public String getADD_STRING9()
    {
        return ADD_STRING9;
    }
    /**
     * @param aDDSTRING9 the aDD_STRING9 to set
     */
    public void setADD_STRING9(String aDDSTRING9)
    {
        ADD_STRING9 = aDDSTRING9;
    }
    /**
     * @return the aDD_STRING10
     */
    public String getADD_STRING10()
    {
        return ADD_STRING10;
    }
    /**
     * @param aDDSTRING10 the aDD_STRING10 to set
     */
    public void setADD_STRING10(String aDDSTRING10)
    {
        ADD_STRING10 = aDDSTRING10;
    }
    /**
     * @return the aDD_STRING11
     */
    public String getADD_STRING11()
    {
        return ADD_STRING11;
    }
    /**
     * @param aDDSTRING11 the aDD_STRING11 to set
     */
    public void setADD_STRING11(String aDDSTRING11)
    {
        ADD_STRING11 = aDDSTRING11;
    }
    /**
     * @return the aDD_STRING12
     */
    public String getADD_STRING12()
    {
        return ADD_STRING12;
    }
    /**
     * @param aDDSTRING12 the aDD_STRING12 to set
     */
    public void setADD_STRING12(String aDDSTRING12)
    {
        ADD_STRING12 = aDDSTRING12;
    }
    /**
     * @return the aDD_STRING13
     */
    public String getADD_STRING13()
    {
        return ADD_STRING13;
    }
    /**
     * @param aDDSTRING13 the aDD_STRING13 to set
     */
    public void setADD_STRING13(String aDDSTRING13)
    {
        ADD_STRING13 = aDDSTRING13;
    }
    /**
     * @return the aDD_STRING14
     */
    public String getADD_STRING14()
    {
        return ADD_STRING14;
    }
    /**
     * @param aDDSTRING14 the aDD_STRING14 to set
     */
    public void setADD_STRING14(String aDDSTRING14)
    {
        ADD_STRING14 = aDDSTRING14;
    }
    /**
     * @return the aDD_STRING15
     */
    public String getADD_STRING15()
    {
        return ADD_STRING15;
    }
    /**
     * @param aDDSTRING15 the aDD_STRING15 to set
     */
    public void setADD_STRING15(String aDDSTRING15)
    {
        ADD_STRING15 = aDDSTRING15;
    }
    /**
     * @return the aDD_DATE1
     */
    public Date getADD_DATE1()
    {
        return ADD_DATE1;
    }
    /**
     * @param aDDDATE1 the aDD_DATE1 to set
     */
    public void setADD_DATE1(Date aDDDATE1)
    {
        ADD_DATE1 = aDDDATE1;
    }
    /**
     * @return the aDD_DATE2
     */
    public Date getADD_DATE2()
    {
        return ADD_DATE2;
    }
    /**
     * @param aDDDATE2 the aDD_DATE2 to set
     */
    public void setADD_DATE2(Date aDDDATE2)
    {
        ADD_DATE2 = aDDDATE2;
    }
    /**
     * @return the aDD_DATE3
     */
    public Date getADD_DATE3()
    {
        return ADD_DATE3;
    }
    /**
     * @param aDDDATE3 the aDD_DATE3 to set
     */
    public void setADD_DATE3(Date aDDDATE3)
    {
        ADD_DATE3 = aDDDATE3;
    }
    /**
     * @return the aDD_DATE4
     */
    public Date getADD_DATE4()
    {
        return ADD_DATE4;
    }
    /**
     * @param aDDDATE4 the aDD_DATE4 to set
     */
    public void setADD_DATE4(Date aDDDATE4)
    {
        ADD_DATE4 = aDDDATE4;
    }
    /**
     * @return the aDD_DATE5
     */
    public Date getADD_DATE5()
    {
        return ADD_DATE5;
    }
    /**
     * @param aDDDATE5 the aDD_DATE5 to set
     */
    public void setADD_DATE5(Date aDDDATE5)
    {
        ADD_DATE5 = aDDDATE5;
    }
    /**
     * @return the aDD_NUMBER1
     */
    public BigDecimal getADD_NUMBER1()
    {
        return ADD_NUMBER1;
    }
    /**
     * @param aDDNUMBER1 the aDD_NUMBER1 to set
     */
    public void setADD_NUMBER1(BigDecimal aDDNUMBER1)
    {
        ADD_NUMBER1 = aDDNUMBER1;
    }
    /**
     * @return the aDD_NUMBER2
     */
    public BigDecimal getADD_NUMBER2()
    {
        return ADD_NUMBER2;
    }
    /**
     * @param aDDNUMBER2 the aDD_NUMBER2 to set
     */
    public void setADD_NUMBER2(BigDecimal aDDNUMBER2)
    {
        ADD_NUMBER2 = aDDNUMBER2;
    }
    /**
     * @return the aDD_NUMBER3
     */
    public BigDecimal getADD_NUMBER3()
    {
        return ADD_NUMBER3;
    }
    /**
     * @param aDDNUMBER3 the aDD_NUMBER3 to set
     */
    public void setADD_NUMBER3(BigDecimal aDDNUMBER3)
    {
        ADD_NUMBER3 = aDDNUMBER3;
    }
    /**
     * @return the aDD_NUMBER4
     */
    public BigDecimal getADD_NUMBER4()
    {
        return ADD_NUMBER4;
    }
    /**
     * @param aDDNUMBER4 the aDD_NUMBER4 to set
     */
    public void setADD_NUMBER4(BigDecimal aDDNUMBER4)
    {
        ADD_NUMBER4 = aDDNUMBER4;
    }
    /**
     * @return the aDD_NUMBER5
     */
    public BigDecimal getADD_NUMBER5()
    {
        return ADD_NUMBER5;
    }
    /**
     * @param aDDNUMBER5 the aDD_NUMBER5 to set
     */
    public void setADD_NUMBER5(BigDecimal aDDNUMBER5)
    {
        ADD_NUMBER5 = aDDNUMBER5;
    }
    /**
     * @return the loadPage
     */
    public Boolean getLoadPage()
    {
        return loadPage;
    }
    /**
     * @param loadPage the loadPage to set
     */
    public void setLoadPage(Boolean loadPage)
    {
        this.loadPage = loadPage;
    }
    /**
     * @return the sMART_OPTION1
     */
    public BigDecimal getSMART_OPTION1()
    {
        return SMART_OPTION1;
    }
    /**
     * @param sMARTOPTION1 the sMART_OPTION1 to set
     */
    public void setSMART_OPTION1(BigDecimal sMARTOPTION1)
    {
        SMART_OPTION1 = sMARTOPTION1;
    }
    /**
     * @return the sMART_OPTION2
     */
    public BigDecimal getSMART_OPTION2()
    {
        return SMART_OPTION2;
    }
    /**
     * @param sMARTOPTION2 the sMART_OPTION2 to set
     */
    public void setSMART_OPTION2(BigDecimal sMARTOPTION2)
    {
        SMART_OPTION2 = sMARTOPTION2;
    }
    /**
     * @return the sMART_OPTION3
     */
    public BigDecimal getSMART_OPTION3()
    {
        return SMART_OPTION3;
    }
    /**
     * @param sMARTOPTION3 the sMART_OPTION3 to set
     */
    public void setSMART_OPTION3(BigDecimal sMARTOPTION3)
    {
        SMART_OPTION3 = sMARTOPTION3;
    }
    /**
     * @return the sMART_OPTION4
     */
    public BigDecimal getSMART_OPTION4()
    {
        return SMART_OPTION4;
    }
    /**
     * @param sMARTOPTION4 the sMART_OPTION4 to set
     */
    public void setSMART_OPTION4(BigDecimal sMARTOPTION4)
    {
        SMART_OPTION4 = sMARTOPTION4;
    }
    /**
     * @return the sMART_OPTION5
     */
    public BigDecimal getSMART_OPTION5()
    {
        return SMART_OPTION5;
    }
    /**
     * @param sMARTOPTION5 the sMART_OPTION5 to set
     */
    public void setSMART_OPTION5(BigDecimal sMARTOPTION5)
    {
        SMART_OPTION5 = sMARTOPTION5;
    }
    /**
     * @return the sMART_DESC1
     */
    public String getSMART_DESC1()
    {
        return SMART_DESC1;
    }
    /**
     * @param sMARTDESC1 the sMART_DESC1 to set
     */
    public void setSMART_DESC1(String sMARTDESC1)
    {
        SMART_DESC1 = sMARTDESC1;
    }
    /**
     * @return the sMART_DESC2
     */
    public String getSMART_DESC2()
    {
        return SMART_DESC2;
    }
    /**
     * @param sMARTDESC2 the sMART_DESC2 to set
     */
    public void setSMART_DESC2(String sMARTDESC2)
    {
        SMART_DESC2 = sMARTDESC2;
    }
    /**
     * @return the sMART_DESC3
     */
    public String getSMART_DESC3()
    {
        return SMART_DESC3;
    }
    /**
     * @param sMARTDESC3 the sMART_DESC3 to set
     */
    public void setSMART_DESC3(String sMARTDESC3)
    {
        SMART_DESC3 = sMARTDESC3;
    }
    /**
     * @return the sMART_DESC4
     */
    public String getSMART_DESC4()
    {
        return SMART_DESC4;
    }
    /**
     * @param sMARTDESC4 the sMART_DESC4 to set
     */
    public void setSMART_DESC4(String sMARTDESC4)
    {
        SMART_DESC4 = sMARTDESC4;
    }
    /**
     * @return the sMART_DESC5
     */
    public String getSMART_DESC5()
    {
        return SMART_DESC5;
    }
    /**
     * @param sMARTDESC5 the sMART_DESC5 to set
     */
    public void setSMART_DESC5(String sMARTDESC5)
    {
        SMART_DESC5 = sMARTDESC5;
    }
    /**
     * @return the uSECIF_NUMBER1
     */
    public String getUSECIF_NUMBER1()
    {
        return USECIF_NUMBER1;
    }
    /**
     * @param uSECIFNUMBER1 the uSECIF_NUMBER1 to set
     */
    public void setUSECIF_NUMBER1(String uSECIFNUMBER1)
    {
        USECIF_NUMBER1 = uSECIFNUMBER1;
    }
    /**
     * @return the uSECIF_NUMBER2
     */
    public String getUSECIF_NUMBER2()
    {
        return USECIF_NUMBER2;
    }
    /**
     * @param uSECIFNUMBER2 the uSECIF_NUMBER2 to set
     */
    public void setUSECIF_NUMBER2(String uSECIFNUMBER2)
    {
        USECIF_NUMBER2 = uSECIFNUMBER2;
    }
    /**
     * @return the uSECIF_NUMBER3
     */
    public String getUSECIF_NUMBER3()
    {
        return USECIF_NUMBER3;
    }
    /**
     * @param uSECIFNUMBER3 the uSECIF_NUMBER3 to set
     */
    public void setUSECIF_NUMBER3(String uSECIFNUMBER3)
    {
        USECIF_NUMBER3 = uSECIFNUMBER3;
    }
    /**
     * @return the uSECIF_NUMBER4
     */
    public String getUSECIF_NUMBER4()
    {
        return USECIF_NUMBER4;
    }
    /**
     * @param uSECIFNUMBER4 the uSECIF_NUMBER4 to set
     */
    public void setUSECIF_NUMBER4(String uSECIFNUMBER4)
    {
        USECIF_NUMBER4 = uSECIFNUMBER4;
    }
    /**
     * @return the uSECIF_NUMBER5
     */
    public String getUSECIF_NUMBER5()
    {
        return USECIF_NUMBER5;
    }
    /**
     * @param uSECIFNUMBER5 the uSECIF_NUMBER5 to set
     */
    public void setUSECIF_NUMBER5(String uSECIFNUMBER5)
    {
        USECIF_NUMBER5 = uSECIFNUMBER5;
    }
    /**
     * @return the uSEDEAL_STRING1
     */
    public String getUSEDEAL_STRING1()
    {
        return USEDEAL_STRING1;
    }
    /**
     * @param uSEDEALSTRING1 the uSEDEAL_STRING1 to set
     */
    public void setUSEDEAL_STRING1(String uSEDEALSTRING1)
    {
        USEDEAL_STRING1 = uSEDEALSTRING1;
    }
    /**
     * @return the uSEDEAL_STRING1_DESC
     */
    public String getUSEDEAL_STRING1_DESC()
    {
        return USEDEAL_STRING1_DESC;
    }
    /**
     * @param uSEDEALSTRING1DESC the uSEDEAL_STRING1_DESC to set
     */
    public void setUSEDEAL_STRING1_DESC(String uSEDEALSTRING1DESC)
    {
        USEDEAL_STRING1_DESC = uSEDEALSTRING1DESC;
    }
    /**
     * @return the isAddString
     */
    public Boolean getIsAddString()
    {
        return isAddString;
    }
    /**
     * @param isAddString the isAddString to set
     */
    public void setIsAddString(Boolean isAddString)
    {
        this.isAddString = isAddString;
    }
    /**
     * @return the isAddNumber
     */
    public Boolean getIsAddNumber()
    {
        return isAddNumber;
    }
    /**
     * @param isAddNumber the isAddNumber to set
     */
    public void setIsAddNumber(Boolean isAddNumber)
    {
        this.isAddNumber = isAddNumber;
    }
    /**
     * @return the isAddDate
     */
    public Boolean getIsAddDate()
    {
        return isAddDate;
    }
    /**
     * @param isAddDate the isAddDate to set
     */
    public void setIsAddDate(Boolean isAddDate)
    {
        this.isAddDate = isAddDate;
    }
    /**
     * @return the sMART_OPTION_TEXT1
     */
    public BigDecimal getSMART_OPTION_TEXT1()
    {
        return SMART_OPTION_TEXT1;
    }
    /**
     * @param sMARTOPTIONTEXT1 the sMART_OPTION_TEXT1 to set
     */
    public void setSMART_OPTION_TEXT1(BigDecimal sMARTOPTIONTEXT1)
    {
        SMART_OPTION_TEXT1 = sMARTOPTIONTEXT1;
    }
    /**
     * @return the sMART_OPTION_TEXT2
     */
    public BigDecimal getSMART_OPTION_TEXT2()
    {
        return SMART_OPTION_TEXT2;
    }
    /**
     * @param sMARTOPTIONTEXT2 the sMART_OPTION_TEXT2 to set
     */
    public void setSMART_OPTION_TEXT2(BigDecimal sMARTOPTIONTEXT2)
    {
        SMART_OPTION_TEXT2 = sMARTOPTIONTEXT2;
    }
    /**
     * @return the sMART_OPTION_TEXT3
     */
    public BigDecimal getSMART_OPTION_TEXT3()
    {
        return SMART_OPTION_TEXT3;
    }
    /**
     * @param sMARTOPTIONTEXT3 the sMART_OPTION_TEXT3 to set
     */
    public void setSMART_OPTION_TEXT3(BigDecimal sMARTOPTIONTEXT3)
    {
        SMART_OPTION_TEXT3 = sMARTOPTIONTEXT3;
    }
    /**
     * @return the sMART_OPTION_TEXT4
     */
    public BigDecimal getSMART_OPTION_TEXT4()
    {
        return SMART_OPTION_TEXT4;
    }
    /**
     * @param sMARTOPTIONTEXT4 the sMART_OPTION_TEXT4 to set
     */
    public void setSMART_OPTION_TEXT4(BigDecimal sMARTOPTIONTEXT4)
    {
        SMART_OPTION_TEXT4 = sMARTOPTIONTEXT4;
    }
    /**
     * @return the sMART_OPTION_TEXT5
     */
    public BigDecimal getSMART_OPTION_TEXT5()
    {
        return SMART_OPTION_TEXT5;
    }
    /**
     * @param sMARTOPTIONTEXT5 the sMART_OPTION_TEXT5 to set
     */
    public void setSMART_OPTION_TEXT5(BigDecimal sMARTOPTIONTEXT5)
    {
        SMART_OPTION_TEXT5 = sMARTOPTIONTEXT5;
    }
    /**
     * @return the sMART_OPTION_TEXT6
     */
    public BigDecimal getSMART_OPTION_TEXT6()
    {
        return SMART_OPTION_TEXT6;
    }
    /**
     * @param sMARTOPTIONTEXT6 the sMART_OPTION_TEXT6 to set
     */
    public void setSMART_OPTION_TEXT6(BigDecimal sMARTOPTIONTEXT6)
    {
        SMART_OPTION_TEXT6 = sMARTOPTIONTEXT6;
    }
    /**
     * @return the sMART_OPTION_TEXT7
     */
    public BigDecimal getSMART_OPTION_TEXT7()
    {
        return SMART_OPTION_TEXT7;
    }
    /**
     * @param sMARTOPTIONTEXT7 the sMART_OPTION_TEXT7 to set
     */
    public void setSMART_OPTION_TEXT7(BigDecimal sMARTOPTIONTEXT7)
    {
        SMART_OPTION_TEXT7 = sMARTOPTIONTEXT7;
    }
    /**
     * @return the sMART_OPTION_TEXT8
     */
    public BigDecimal getSMART_OPTION_TEXT8()
    {
        return SMART_OPTION_TEXT8;
    }
    /**
     * @param sMARTOPTIONTEXT8 the sMART_OPTION_TEXT8 to set
     */
    public void setSMART_OPTION_TEXT8(BigDecimal sMARTOPTIONTEXT8)
    {
        SMART_OPTION_TEXT8 = sMARTOPTIONTEXT8;
    }
    /**
     * @return the sMART_OPTION_TEXT9
     */
    public BigDecimal getSMART_OPTION_TEXT9()
    {
        return SMART_OPTION_TEXT9;
    }
    /**
     * @param sMARTOPTIONTEXT9 the sMART_OPTION_TEXT9 to set
     */
    public void setSMART_OPTION_TEXT9(BigDecimal sMARTOPTIONTEXT9)
    {
        SMART_OPTION_TEXT9 = sMARTOPTIONTEXT9;
    }
    /**
     * @return the sMART_OPTION_TEXT10
     */
    public BigDecimal getSMART_OPTION_TEXT10()
    {
        return SMART_OPTION_TEXT10;
    }
    /**
     * @param sMARTOPTIONTEXT10 the sMART_OPTION_TEXT10 to set
     */
    public void setSMART_OPTION_TEXT10(BigDecimal sMARTOPTIONTEXT10)
    {
        SMART_OPTION_TEXT10 = sMARTOPTIONTEXT10;
    }
    /**
     * @return the sMART_OPTION_TEXT11
     */
    public BigDecimal getSMART_OPTION_TEXT11()
    {
        return SMART_OPTION_TEXT11;
    }
    /**
     * @param sMARTOPTIONTEXT11 the sMART_OPTION_TEXT11 to set
     */
    public void setSMART_OPTION_TEXT11(BigDecimal sMARTOPTIONTEXT11)
    {
        SMART_OPTION_TEXT11 = sMARTOPTIONTEXT11;
    }
    /**
     * @return the sMART_OPTION_TEXT12
     */
    public BigDecimal getSMART_OPTION_TEXT12()
    {
        return SMART_OPTION_TEXT12;
    }
    /**
     * @param sMARTOPTIONTEXT12 the sMART_OPTION_TEXT12 to set
     */
    public void setSMART_OPTION_TEXT12(BigDecimal sMARTOPTIONTEXT12)
    {
        SMART_OPTION_TEXT12 = sMARTOPTIONTEXT12;
    }
    /**
     * @return the sMART_OPTION_TEXT13
     */
    public BigDecimal getSMART_OPTION_TEXT13()
    {
        return SMART_OPTION_TEXT13;
    }
    /**
     * @param sMARTOPTIONTEXT13 the sMART_OPTION_TEXT13 to set
     */
    public void setSMART_OPTION_TEXT13(BigDecimal sMARTOPTIONTEXT13)
    {
        SMART_OPTION_TEXT13 = sMARTOPTIONTEXT13;
    }
    /**
     * @return the sMART_OPTION_TEXT14
     */
    public BigDecimal getSMART_OPTION_TEXT14()
    {
        return SMART_OPTION_TEXT14;
    }
    /**
     * @param sMARTOPTIONTEXT14 the sMART_OPTION_TEXT14 to set
     */
    public void setSMART_OPTION_TEXT14(BigDecimal sMARTOPTIONTEXT14)
    {
        SMART_OPTION_TEXT14 = sMARTOPTIONTEXT14;
    }
    /**
     * @return the sMART_OPTION_TEXT15
     */
    public BigDecimal getSMART_OPTION_TEXT15()
    {
        return SMART_OPTION_TEXT15;
    }
    /**
     * @param sMARTOPTIONTEXT15 the sMART_OPTION_TEXT15 to set
     */
    public void setSMART_OPTION_TEXT15(BigDecimal sMARTOPTIONTEXT15)
    {
        SMART_OPTION_TEXT15 = sMARTOPTIONTEXT15;
    }
    /**
     * @return the sMART_TEXT_DESC1
     */
    public String getSMART_TEXT_DESC1()
    {
        return SMART_TEXT_DESC1;
    }
    /**
     * @param sMARTTEXTDESC1 the sMART_TEXT_DESC1 to set
     */
    public void setSMART_TEXT_DESC1(String sMARTTEXTDESC1)
    {
        SMART_TEXT_DESC1 = sMARTTEXTDESC1;
    }
    /**
     * @return the sMART_TEXT_DESC2
     */
    public String getSMART_TEXT_DESC2()
    {
        return SMART_TEXT_DESC2;
    }
    /**
     * @param sMARTTEXTDESC2 the sMART_TEXT_DESC2 to set
     */
    public void setSMART_TEXT_DESC2(String sMARTTEXTDESC2)
    {
        SMART_TEXT_DESC2 = sMARTTEXTDESC2;
    }
    /**
     * @return the sMART_TEXT_DESC3
     */
    public String getSMART_TEXT_DESC3()
    {
        return SMART_TEXT_DESC3;
    }
    /**
     * @param sMARTTEXTDESC3 the sMART_TEXT_DESC3 to set
     */
    public void setSMART_TEXT_DESC3(String sMARTTEXTDESC3)
    {
        SMART_TEXT_DESC3 = sMARTTEXTDESC3;
    }
    /**
     * @return the sMART_TEXT_DESC4
     */
    public String getSMART_TEXT_DESC4()
    {
        return SMART_TEXT_DESC4;
    }
    /**
     * @param sMARTTEXTDESC4 the sMART_TEXT_DESC4 to set
     */
    public void setSMART_TEXT_DESC4(String sMARTTEXTDESC4)
    {
        SMART_TEXT_DESC4 = sMARTTEXTDESC4;
    }
    /**
     * @return the sMART_TEXT_DESC5
     */
    public String getSMART_TEXT_DESC5()
    {
        return SMART_TEXT_DESC5;
    }
    /**
     * @param sMARTTEXTDESC5 the sMART_TEXT_DESC5 to set
     */
    public void setSMART_TEXT_DESC5(String sMARTTEXTDESC5)
    {
        SMART_TEXT_DESC5 = sMARTTEXTDESC5;
    }
    /**
     * @return the sMART_TEXT_DESC6
     */
    public String getSMART_TEXT_DESC6()
    {
        return SMART_TEXT_DESC6;
    }
    /**
     * @param sMARTTEXTDESC6 the sMART_TEXT_DESC6 to set
     */
    public void setSMART_TEXT_DESC6(String sMARTTEXTDESC6)
    {
        SMART_TEXT_DESC6 = sMARTTEXTDESC6;
    }
    /**
     * @return the sMART_TEXT_DESC7
     */
    public String getSMART_TEXT_DESC7()
    {
        return SMART_TEXT_DESC7;
    }
    /**
     * @param sMARTTEXTDESC7 the sMART_TEXT_DESC7 to set
     */
    public void setSMART_TEXT_DESC7(String sMARTTEXTDESC7)
    {
        SMART_TEXT_DESC7 = sMARTTEXTDESC7;
    }
    /**
     * @return the sMART_TEXT_DESC8
     */
    public String getSMART_TEXT_DESC8()
    {
        return SMART_TEXT_DESC8;
    }
    /**
     * @param sMARTTEXTDESC8 the sMART_TEXT_DESC8 to set
     */
    public void setSMART_TEXT_DESC8(String sMARTTEXTDESC8)
    {
        SMART_TEXT_DESC8 = sMARTTEXTDESC8;
    }
    /**
     * @return the sMART_TEXT_DESC9
     */
    public String getSMART_TEXT_DESC9()
    {
        return SMART_TEXT_DESC9;
    }
    /**
     * @param sMARTTEXTDESC9 the sMART_TEXT_DESC9 to set
     */
    public void setSMART_TEXT_DESC9(String sMARTTEXTDESC9)
    {
        SMART_TEXT_DESC9 = sMARTTEXTDESC9;
    }
    /**
     * @return the sMART_TEXT_DESC10
     */
    public String getSMART_TEXT_DESC10()
    {
        return SMART_TEXT_DESC10;
    }
    /**
     * @param sMARTTEXTDESC10 the sMART_TEXT_DESC10 to set
     */
    public void setSMART_TEXT_DESC10(String sMARTTEXTDESC10)
    {
        SMART_TEXT_DESC10 = sMARTTEXTDESC10;
    }
    /**
     * @return the sMART_TEXT_DESC11
     */
    public String getSMART_TEXT_DESC11()
    {
        return SMART_TEXT_DESC11;
    }
    /**
     * @param sMARTTEXTDESC11 the sMART_TEXT_DESC11 to set
     */
    public void setSMART_TEXT_DESC11(String sMARTTEXTDESC11)
    {
        SMART_TEXT_DESC11 = sMARTTEXTDESC11;
    }
    /**
     * @return the sMART_TEXT_DESC12
     */
    public String getSMART_TEXT_DESC12()
    {
        return SMART_TEXT_DESC12;
    }
    /**
     * @param sMARTTEXTDESC12 the sMART_TEXT_DESC12 to set
     */
    public void setSMART_TEXT_DESC12(String sMARTTEXTDESC12)
    {
        SMART_TEXT_DESC12 = sMARTTEXTDESC12;
    }
    /**
     * @return the sMART_TEXT_DESC13
     */
    public String getSMART_TEXT_DESC13()
    {
        return SMART_TEXT_DESC13;
    }
    /**
     * @param sMARTTEXTDESC13 the sMART_TEXT_DESC13 to set
     */
    public void setSMART_TEXT_DESC13(String sMARTTEXTDESC13)
    {
        SMART_TEXT_DESC13 = sMARTTEXTDESC13;
    }
    /**
     * @return the sMART_TEXT_DESC14
     */
    public String getSMART_TEXT_DESC14()
    {
        return SMART_TEXT_DESC14;
    }
    /**
     * @param sMARTTEXTDESC14 the sMART_TEXT_DESC14 to set
     */
    public void setSMART_TEXT_DESC14(String sMARTTEXTDESC14)
    {
        SMART_TEXT_DESC14 = sMARTTEXTDESC14;
    }
    /**
     * @return the sMART_TEXT_DESC15
     */
    public String getSMART_TEXT_DESC15()
    {
        return SMART_TEXT_DESC15;
    }
    /**
     * @param sMARTTEXTDESC15 the sMART_TEXT_DESC15 to set
     */
    public void setSMART_TEXT_DESC15(String sMARTTEXTDESC15)
    {
        SMART_TEXT_DESC15 = sMARTTEXTDESC15;
    }
}
