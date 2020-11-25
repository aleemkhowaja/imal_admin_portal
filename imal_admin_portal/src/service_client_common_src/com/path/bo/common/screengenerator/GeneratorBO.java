/**
 * 
 */
package com.path.bo.common.screengenerator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.path.dbmaps.vo.IM_API_SECURITYVO;
import com.path.dbmaps.vo.IM_IMAL_APIVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.dynamicscreen.DynamicScreenCO;
import com.path.vo.common.screengenerator.DynScrTableColsCO;
import com.path.vo.common.screengenerator.DynScrTablesCO;
import com.path.vo.common.screengenerator.DynScreenQueryCO;
import com.path.vo.common.screengenerator.DynamicScreenCreatorCO;
import com.path.vo.common.screengenerator.DynamicScreenDetailsCO;
import com.path.vo.common.screengenerator.ScreenGeneratorSC;
import com.path.vo.generator.GeneratorSC;

/**
 * @author marwanmaddah
 *
 */
public interface GeneratorBO 
{
	public List dataToGenerate(GeneratorSC criteria) throws BaseException;
	public int generateTemplateCount(GeneratorSC criteria) throws BaseException;
	public List generateTemplateRecords(GeneratorSC criteria) throws BaseException;
//	public void updateLayout(ArrayList<DSN_TEMPLATE_DETAILSVO>lst  )throws BaseException;
	public void saveNew(DynamicScreenCreatorCO dynScreenCreatorCO) throws BaseException;
	public List destinationList(GeneratorSC criteria) throws BaseException;
	public List<DynamicScreenCreatorCO> returnScreenElementsData(ScreenGeneratorSC criteria) throws BaseException;
	public List<DynamicScreenCreatorCO> returnScreenElemDataRun(ScreenGeneratorSC criteria) throws BaseException;
	public DynamicScreenCreatorCO returnScreenMainInfo(ScreenGeneratorSC criteria) throws BaseException;
	public void update(DynamicScreenCreatorCO dynScreenCreatorCO) throws BaseException;
	public void delete(DynamicScreenCreatorCO dynScreenCreatorCO) throws BaseException;
	/**
	 * 
	 * @author marwanmaddah
	 * @date   Feb 17, 2016
	 * @param dynScreenQueryCO
	 * @return
	 * @throws BaseException List
	 *
	 */
	public DynScreenQueryCO checkQueryValidation(DynScreenQueryCO dynScreenQueryCO) throws BaseException;
	/**
	 * Check if a field is linked by customized screens
	 * @param dynScreenCreatorCO
	 * @return
	 * @throws BaseException
	 */
	public String checkCustomizedLinks(DynamicScreenCreatorCO dynScreenCreatorCO) throws BaseException;
	public void checkImportedFileProperties(List<String> propertiesLst,List<BigDecimal> btnInternalSrc,List<BigDecimal> btnGlobalActSrc,CommonLibSC criteria) throws BaseException;
	
	/**
	 * Used to check if the typed Table name is already exists in the database or not
	 * in case is already exist and exception will be handled to block the process.
	 * @param criteria
	 * @throws BaseException
	 */
	public void checkTableName(ScreenGeneratorSC criteria) throws BaseException;
	/**
	 * Used to check if the typed Table name is already exists in the database or not
	 * in case is already exist it will return integer.
	 * @param criteria
	 * @throws BaseException
	 */
	public int checkTableNameExisting(ScreenGeneratorSC criteria) throws BaseException;
	public void generateDynScrTable(DynScrTablesCO dynScrTablesCO) throws BaseException;
	/**
	 * used to return the information that are related to the selected table and load them inside the Maint screen
	 * @param criteria
	 * @return
	 * @throws BaseException
	 */
	public DynScrTablesCO returnSelectedTableData(ScreenGeneratorSC criteria) throws BaseException;
	
	/**
	 * used to delete the dynamic table created
	 * @param DynamicScreenCreatorCO
	 * @return
	 * @throws BaseException
	 */
	public void deleteDynScrTable(DynamicScreenCreatorCO dynScreenCreatorCO) throws BaseException;
	
	
	/**
	 * used to retrieve the dynamic tables columns information 
	 * @param  
	 * @return DynScrTableColsCO
	 * @throws BaseException
	 */
	public List<DynScrTableColsCO> returnDynTableCols(ScreenGeneratorSC criteria) throws BaseException;
	
	/**
	 * used to generate dynamic table when importing dynamic screen
	 * @param  
	 * @return BigDecimal
	 * @throws BaseException
	 */
	public DynScrTablesCO importDynScrTable(List<DynScrTablesCO> dynScrTablesCO,DynamicScreenCreatorCO dynScreenCreatorCO) throws BaseException;
	/**
	 * used to export dynamic table cols
	 * @param  
	 * @return BigDecimal
	 * @throws BaseException
	 */
	public List<DynScrTableColsCO> returnExportedDynTablesCols(ScreenGeneratorSC criteria) throws BaseException;
	/**
	 * [TP#1074196] - Dynamic Screen Dynamic Table Ability to update Column Characteristics Visibility, Description
	 * @description This function used to add/update Dynamic Screen Table Columns Definition
	 * @createdBy Sajjad Soomro
	 * 
	 * @param listToAdd
	 * @param listToModidy
	 * @param dynScrTablesCO
	 * @param screenGeneratorSC
	 * @throws BaseException
	 */
	public void updateDynScrTable(List<DynScrTableColsCO> listToAdd, List<DynScrTableColsCO> listToModify, DynScrTablesCO dynScrTablesCO, ScreenGeneratorSC screenGeneratorSC) throws BaseException;
	
	/**
	 * Used to save dynamic screen details
	 * @param dynScreenCreatorCO
	 * @throws BaseException
	 */
	public void saveDynamicScreenDetails(DynamicScreenCreatorCO dynScreenCreatorCO) throws BaseException;
	
	public void updateDynScreenDet(DynamicScreenDetailsCO dynamicScreenDetailsCO) throws BaseException;
	
	public Map<String, DynamicScreenCO> returnParamsDataType(DynScreenQueryCO dynScreenQueryCO) throws BaseException;
	/** @author Muhammad.Asif 
	 * used to load IM_IMAL_APIVO
	 * @param  IM_IMAL_APIVO
	 * @return IM_IMAL_APIVO
	 * @throws BaseException
	 */
	public IM_IMAL_APIVO  returnIMAL_API_Details(IM_IMAL_APIVO iM_IMAL_APIVO) throws BaseException;
	/** @author Muhammad.Asif 
	 * used to load default parameters
	 * @param  ScreenGeneratorSC
	 * @return List<DynamicScreenCreatorCO>
	 * @throws BaseException
	 */
	public List<DynamicScreenCreatorCO> returnOperationDefaultParameter(ScreenGeneratorSC criteria) throws BaseException;
	/** @author Muhammad.Asif 
	 * used to load IM_API_SECURITYVO
	 * @param  IM_API_SECURITYVO
	 * @return IM_API_SECURITYVO
	 * @throws BaseException
	 */
	public IM_API_SECURITYVO returnIM_API_SECURITYVO(IM_API_SECURITYVO im_API_SECURITYVO) throws BaseException;
	
	/** @author Muhammad.Asif 
	 * Method used to check and create table for reset webservice 
	 * @param  DynamicScreenCreatorCO
	 * @return 
	 * @throws BaseException
	 */
	public void createTableRestWebservice(DynamicScreenCreatorCO dynScreenCreatorCO) throws BaseException;
	/** @author Muhammad.Asif 
	 * Method used to delete existing table for rest webservice 
	 * @param  ScreenGeneratorSC
	 * @return 
	 * @throws BaseException
	 */
	public void deleteDataRestWebservice(ScreenGeneratorSC sc)  throws BaseException;
	/** @author Muhammad.Asif 
	 * Method used to Insert data into table for rest webservice 
	 * @param  ScreenGeneratorSC 
	 * @return 
	 * @throws BaseException
	 */
	public void insertDataRestWebservice(ScreenGeneratorSC sc) throws BaseException;
	/** @author Muhammad.Asif 
	 * Method used to truncate table for rest webservice 
	 * @param  ScreenGeneratorSC 
	 * @return 
	 * @throws BaseException
	 */
	public void truncateTableRestWebservice(ScreenGeneratorSC criteria) throws BaseException;
	/** @author Muhammad.Asif 
	 * Method used to create table for rest webservice 
	 * @param  ScreenGeneratorSC 
	 * @return 
	 * @throws BaseException
	 */
	public void createTableRestWebservice(ScreenGeneratorSC criteria) throws BaseException;
	/** @author Muhammad.Asif 
	 * Method used to check is table exists or not  for rest webservice 
	 * @param  String 
	 * @return Integer
	 * @throws BaseException
	 */
	public Integer checkIfTableExists(String value) throws BaseException;
        /**
	 * TP#1081060 used to return query colum names
	 * @param String theQuery
	 * @return Map<String,String>
	 * @throws BaseException
	 */
	public Map<String,Map<String,String>> returnGridColNames(String theQuery) throws BaseException;
	/**
	 * TP#1081060 used to return query params
	 * @param dynScreenQueryCO
	 * @return DynScreenQueryCO
	 * @throws BaseException
	 */
	public DynScreenQueryCO returnQueryParams( DynScreenQueryCO dynScreenQueryCO) throws BaseException; 

}
