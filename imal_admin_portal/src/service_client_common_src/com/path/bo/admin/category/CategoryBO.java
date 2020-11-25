package com.path.bo.admin.category;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.admin.category.CategorySC;

public interface CategoryBO
{
    public List returnCategoryList(CategorySC categorySC) throws BaseException;

    public int returnCategoryCount(CategorySC categorySC) throws BaseException;

}
