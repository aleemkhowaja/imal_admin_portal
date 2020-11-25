package com.path.bo.admin.branches;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.BRANCHESVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.admin.branches.BranchesSC;
import com.path.vo.core.trxmgnt.MICRSC;

public interface BranchesBO
{
    public List getBranchesList(BranchesSC branchesSC) throws BaseException;

    public int getBranchesCount(BranchesSC branchesSC) throws BaseException;

    public List getBranchesByUsrList(BranchesSC branchesSC) throws BaseException;

    public int getBranchesByUsrCount(BranchesSC branchesSC) throws BaseException;

    public BRANCHESVO getBranchesDetails(BRANCHESVO branchesVO) throws BaseException;

    public BRANCHESVO getBranchesByUsrDetails(BranchesSC branchesSC) throws BaseException;

    public Boolean checkBranchValidation(BranchesSC criteria) throws BaseException;

    public List getBranchesDestinationsLst(BranchesSC branchesSC) throws BaseException;

    public int getBranchesDestinationsLstCount(BranchesSC branchesSC) throws BaseException;

    public BRANCHESVO getBranchDescByCode(BranchesSC criteria) throws BaseException;

    public List<BigDecimal> getAllBranchId(BranchesSC criteria) throws BaseException;

    public List getBranchesListByCompCode(BranchesSC branchesSC) throws BaseException;

    public int getBranchesListCountByCompCode(BranchesSC branchesSC) throws BaseException;

    public BRANCHESVO getBranchDescByCodeAndPrefLang(BranchesSC criteria) throws BaseException;

    public BRANCHESVO checkBranchValidity(BranchesSC criteria) throws BaseException;

    public BigDecimal returnBranchCodeAIB(MICRSC micrSC) throws BaseException;

    public int getBranchesByCompCodeUnionAllBranchesCount(BranchesSC criteria) throws BaseException;

    public List getBranchesByCompCodeUnionAllBranches(BranchesSC criteria) throws BaseException;
    
    public int returnMultiHO (BranchesSC criteria) throws BaseException;
}
